package utils;

import java.io.*;

import java.util.*;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.*;

import org.springframework.util.*;

import play.*;
import base.*;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.regions.*;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;

public class AWSUtil {

    private AWSUtil() {
    }

    private static AmazonS3 s3 = null;
    
    private static String awsAccessKeyId = null;
    private static String awsSecretAccessKey = null;
    

    static {

        awsAccessKeyId = Play.application().configuration().getString("saiyo.aws.accesskeyid");
        awsSecretAccessKey = Play.application().configuration().getString("saiyo.aws.secretaccesskey");

        ClientConfiguration config = new ClientConfiguration();
        config.setProtocol(Protocol.HTTPS);
        s3 = new AmazonS3Client(new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey), config);
        Region target = Region.getRegion(Regions.AP_NORTHEAST_1);
        s3.setRegion(target);

    }

    // --> FIXME こいつを参考に、実際使えるutilsになるようコードを整えること
    public static void s3toLocal() throws IOException {

        GetObjectRequest request = new GetObjectRequest("ruby-mar-7",
                "watashi_multipartBody2692646130265522596asTemporaryFile_1395973692073.png");

        S3Object result = s3.getObject(request);
        try (InputStream is = result.getObjectContent()) {

            FileCopyUtils.copy(is, new FileOutputStream("/home/masafumi/output/bbbb.png"));

        }
    }
    public static String put2s3(File file) {

        long start = System.currentTimeMillis();
        String objectId = "watashi_" + file.getName() + "_" + start;
        Logger.info("!!!!start: " + start);
        Logger.info("!!!file-size[KB]: " + (file.length() / (1024d)));
        PutObjectRequest putRequest = new PutObjectRequest("ruby-mar-7", objectId + ".png", file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
        putRequest.setMetadata(objectMetadata);
        PutObjectResult response = s3.putObject(putRequest);
        Logger.debug(response.getServerSideEncryption());
        Logger.info("end: " + (System.currentTimeMillis() - start) / 1000d);

        return objectId;
    }
    public static String put2s3(String bucketName, String path, File file) {


        ClientConfiguration config = new ClientConfiguration();
        config.setProtocol(Protocol.HTTPS);
        AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey), config);
        Region target = Region.getRegion(Regions.AP_NORTHEAST_1);
        s3.setRegion(target);

        long start = System.currentTimeMillis();
        Logger.info("start: " + start);
        Logger.info("file-size[KB]: " + (file.length() / (1024d)));
        s3.putObject(bucketName, path, file);
        Logger.info("end: " + (System.currentTimeMillis() - start) / 1000d);

        return path;
    }
    // <-- TODO

    /**
     * SESを利用してメールを送信する.
     * @param from 送信元アドレス
     * @param to 送信先アドレス
     * @param subject 件名
     * @param body 本文
     */
    public static void sendEMail(String from, Collection<String> to, String subject, String body) {
        
        if (!Play.isProd()) {
            AppLogUtil.debug("本番モードではないため、メールは送信しません");
            AppLogUtil.debug("from:" + from);
            for (String element : to) {
                AppLogUtil.debug("to:" + element);
            }
            AppLogUtil.debug("subject:" + subject);
            AppLogUtil.debug("body:" + body);
            return;
        }
        
        try {
            AWSCredentials credentials = new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey);
            AmazonSimpleEmailService ses = new AmazonSimpleEmailServiceClient(credentials);
            ListVerifiedEmailAddressesResult result = ses.listVerifiedEmailAddresses();
            if (result.getVerifiedEmailAddresses().contains(from)) {
                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "aws");
                props.setProperty("mail.aws.user", awsAccessKeyId);
                props.setProperty("mail.aws.password", awsSecretAccessKey);
                Session session = Session.getInstance(props);
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                InternetAddress[] addresses = new InternetAddress[to.size()];
                int i = 0;
                for (String address : to) {
                    addresses[i++] = new InternetAddress(address);
                }
                message.addRecipients(Message.RecipientType.TO, addresses);
                message.setSubject(subject);
                message.setText(body);
                message.saveChanges();
                AWSJavaMailTransport transport = new AWSJavaMailTransport(session, null);
                try {
                    transport.connect();
                    transport.sendMessage(message, null);
                } finally {
                    transport.close();
                }
            } else {
                ses.verifyEmailAddress(new VerifyEmailAddressRequest().withEmailAddress(from));
            }
        } catch (MessagingException e) {
            throw new SaiyoException(e);
        }
    }
}

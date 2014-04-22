package utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ByteUtil {
	
	private ByteUtil() {}

	
	/**
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static byte[] readFileToByte(File file) {
		try {
		    byte[] b = new byte[1];
		    try (FileInputStream fis = new FileInputStream(file)) {
			    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				    while (fis.read(b) > 0) {
				        baos.write(b);
				    }
				    b = baos.toByteArray();
				    return b;		    	
			    }
		    }
			
		} catch (Exception e) {
			throw new RuntimeException("byte conversion error" ,e);
		}
	}
	
}

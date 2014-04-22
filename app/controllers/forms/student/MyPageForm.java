/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.forms.student;

import java.util.*;

import models.*;
import play.data.*;

/**
 * @author B05138
 */
public class MyPageForm {

    public static class Mypage {
        /** 姓 */
        public String firstName;

        /** 姓 */
        public String lastName;
    }

    public List<Prefectures> prefectures;
    public String test;
    public Form<Mypage> mypage;

    public MyPageForm(Form<Mypage> form) {
        this.mypage = form;
        this.test = "にゃにゃにゃ";
        this.prefectures = Prefectures.finder.all();
    }
}

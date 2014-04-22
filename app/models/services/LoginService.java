/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models.services;

import models.*;

import com.avaje.ebean.*;

/**
 * ログイン処理を提供するサービス.
 * @author A13413
 */
public class LoginService {
    public EntryUser findStudent(String email, String password) {
        ExpressionList<EntryUser> where = EntryUser.finder.where();
        return where.conjunction().add(Expr.eq("email", email)).add(Expr.eq("password", password))
                .add(Expr.eq("delflag", false)).findUnique();
    }
}

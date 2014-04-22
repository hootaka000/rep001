/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.student;

import models.*;
import play.i18n.*;
import play.mvc.*;
import base.*;

/**
 * 学生のエントリ情報に関するコントローラ.
 * @author A13413
 */
public class Entry extends StudentSecuredController {
    @SaiyoAcl
    public static Result confirmUnsubscribe() {
        return ok(views.html.student.entry.unsubscribe.render());
    }

    @SaiyoAcl(roles = SaiyoRoles.NEW_GRADUATE)
    public static Result unsubscribe() {
        String id = session(Application.SESSION_ENTRY_USER_ID);
        if (id != null) {
            session().remove(Application.SESSION_ENTRY_USER_ID);
            // TODO EntryServiceクラスに移動する
            EntryUser entryUser = EntryUser.finder.byId(Long.parseLong(id));
            if (entryUser != null) {
                entryUser.delflag = true;
                entryUser.save();
            }
        }
        session(Application.COMPLETED_MESSAGE, Messages.get("message.completed.unsubscribe.message"));
        session(Application.NEXT_TEXT, Messages.get("message.completed.unsubscribe.next.text"));
        session(Application.NEXT_URL, routes.Application.index().url());
        return redirect(routes.Application.completed());
    }
}

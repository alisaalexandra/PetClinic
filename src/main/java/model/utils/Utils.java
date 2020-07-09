package model.utils;

import org.hibernate.Session;

public class Utils {

    public static void checkSession(Session session){
        if (session != null) {
            session.close();
        }
    }
}

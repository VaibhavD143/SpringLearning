package com.example.restful;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static final SessionFactory sessionfactory = (new SessionUtil()).getSessionFactory();

    public SessionFactory getSessionFactory(){
        return new Configuration().addAnnotatedClass(Employee.class).addAnnotatedClass(Account.class).buildSessionFactory();
    }
}

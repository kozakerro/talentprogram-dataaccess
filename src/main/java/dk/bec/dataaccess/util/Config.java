package dk.bec.dataaccess.util;

import dk.bec.dataaccess.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {
    public static SessionFactory configure() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Computer.class)
                .addAnnotatedClass(Assessment.class)
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
    }
}

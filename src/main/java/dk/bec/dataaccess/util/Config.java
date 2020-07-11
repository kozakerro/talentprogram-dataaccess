package dk.bec.dataaccess.util;

import dk.bec.dataaccess.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {
    public static SessionFactory configure() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}

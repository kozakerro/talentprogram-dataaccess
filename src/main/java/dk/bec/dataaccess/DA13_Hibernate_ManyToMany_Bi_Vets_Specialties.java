package dk.bec.dataaccess;

import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA13_Hibernate_ManyToMany_Bi_Vets_Specialties {

    public static void createSpecialtiesForVets() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}

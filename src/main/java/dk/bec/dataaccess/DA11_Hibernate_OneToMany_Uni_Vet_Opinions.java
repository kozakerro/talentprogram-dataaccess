package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Opinion;
import dk.bec.dataaccess.entity.Vet;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA11_Hibernate_OneToMany_Uni_Vet_Opinions {

    public static void createOpinionsForVet() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Vet vet = new Vet("Johny", "Norman");
            Opinion opinion1 = new Opinion("Very good vet!");
            Opinion opinion2 = new Opinion("Much appreciated specialist!");

            vet.addOpinion(opinion1);
            vet.addOpinion(opinion2);

            session.save(vet);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}

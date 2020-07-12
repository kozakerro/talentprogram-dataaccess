package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Specialty;
import dk.bec.dataaccess.entity.Vet;
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

            Vet vet1 = new Vet("Johny", "Norman");
            Vet vet2 = new Vet("John", "Pilgrim");

            Specialty specialty1 = new Specialty("cardiology");
            Specialty specialty2 = new Specialty("urology");

            specialty1.addVet(vet1);
            specialty1.addVet(vet2);
            specialty2.addVet(vet1);
            specialty2.addVet(vet2);

            session.save(specialty1);
            session.save(specialty2);

            System.out.println("Vets with Specialty #1: ");
            for(Vet v : specialty1.getVets()) {
                System.out.println(v.getFirstName() + " " + v.getLastName());
            }
            System.out.println("Vets with Specialty #2: ");
            for(Vet v : specialty2.getVets()) {
                System.out.println(v.getFirstName() + " " + v.getLastName());
            }

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}

package dk.bec.dataaccess;

import dk.bec.dataaccess.entity.Specialty;
import dk.bec.dataaccess.entity.Vet;
import dk.bec.dataaccess.util.Config;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DA12_Hibernate_ManyToMany_Vets_Specialties {

    public static void createSpecialtiesForVets() {
        SessionFactory factory = Config.configure();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Vet vet1 = new Vet("Johny", "Norman");
            Vet vet2 = new Vet("John", "Pilgrim");

            Specialty specialty1 = new Specialty("cardiology");
            Specialty specialty2 = new Specialty("urology");

            vet1.addSpecialty(specialty1);
            vet1.addSpecialty(specialty2);
            vet2.addSpecialty(specialty1);
            vet2.addSpecialty(specialty2);

            session.save(vet1);
            session.save(vet2);

            System.out.println("Specialties for Vet #1: ");
            for(Specialty s : vet1.getSpecialties()) {
                System.out.println(s.getName());
            }
            System.out.println("Specialties for Vet #2: ");
            for(Specialty s : vet2.getSpecialties()) {
                System.out.println(s.getName());
            }

            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
        } finally {
            factory.close();
        }
    }

}

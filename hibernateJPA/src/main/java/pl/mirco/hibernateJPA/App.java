package pl.mirco.hibernateJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.mirco.model.Uzytkownik;

/**
 * Hibernate JPA
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hibernate JPA" );
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Uzytkownik user = new Uzytkownik();
        user.setLogin("miro");
        entityManager.persist(user);
        user = new Uzytkownik();
        user.setLogin("Mirek");
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

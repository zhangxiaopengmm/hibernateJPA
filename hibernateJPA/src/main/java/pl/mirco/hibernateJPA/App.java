package pl.mirco.hibernateJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.mirco.model.Person;

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
        entityManager.persist( new Person());
        entityManager.persist( new Person());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

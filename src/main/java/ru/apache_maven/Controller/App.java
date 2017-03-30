package ru.apache_maven.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.apache_maven.Model.Address;
import ru.apache_maven.Model.UserDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Address address = new Address();
        address.setCity("Moscow");
        address.setHouse("1");
        address.setPinCode("1123213");
        address.setStreet("Gorky");

        Address address2 = new Address();
        address2.setCity("Moscow2");
        address2.setHouse("12");
        address2.setPinCode("22222sadasd");
        address2.setStreet("Gorky2");

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("First User");
        userDetails.getAddressList().add(address);
        userDetails.getAddressList().add(address2);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();

        /*userDetails =  null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = session.get(UserDetails.class, 1);
        System.out.println("user name is : " + userDetails.getUserName());*/

    }
}

package ru.apache_maven.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.apache_maven.Model.*;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserDetails user = session.get(UserDetails.class, 5L);
        user.setUserName("Updated us2er");

        session.getTransaction().commit();
        session.close();



        session = sessionFactory.openSession();
        session.beginTransaction();

        user.setUserName("New info");
        session.update(user);

        session.getTransaction().commit();
        session.close();
    }
}

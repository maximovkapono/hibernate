package ru.apache_maven.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.apache_maven.Model.UserDetails;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserDetails userDetails = session.get(UserDetails.class, 1L);

        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();

        UserDetails userDetails2 = session1.get(UserDetails.class, 1L);

        session1.getTransaction().commit();
        session1.close();


    }
}

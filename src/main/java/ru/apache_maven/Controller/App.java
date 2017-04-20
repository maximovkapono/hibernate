package ru.apache_maven.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.apache_maven.Model.*;

public class App 
{
    public static void main( String[] args )
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Steering Handle");

        FourWheeler porsche = new FourWheeler();
        porsche.setVehicleName("Porsche");
        porsche.setSteeringWheel("Steering wheel");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(vehicle);
        session.save(bike);
        session.save(porsche);
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
    }
}

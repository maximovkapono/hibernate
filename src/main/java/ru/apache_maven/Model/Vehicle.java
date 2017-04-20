package ru.apache_maven.Model;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String vehicleName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}

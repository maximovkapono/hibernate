package ru.apache_maven.Model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue()
    private int userId;

    private String userName;

    @ElementCollection
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"))
    @GenericGenerator(name = "increment", strategy = "increment")
    @CollectionId(columns = {@Column(name = "Address_id")}, generator = "increment", type = @Type(type = "long"))
    private Collection<Address> addressList = new ArrayList<Address>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }
}

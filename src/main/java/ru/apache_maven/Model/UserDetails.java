package ru.apache_maven.Model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId > :userId")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

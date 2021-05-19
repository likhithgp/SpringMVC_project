package com.stackroute.usermanagementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * This entity class is for user information
 */

/**@Data annotation to add getters and setters
 *@NoargsConstructor to add the no parameterized constructor
 * @AllArgsconstructor to add the parametrized constructor
 */

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @JsonIgnore
    private String password;
    @Column
    private String name;
    @Column
    private long mobileNo;

    public User(int id, String username, String password, String name, long mobileNo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }
}

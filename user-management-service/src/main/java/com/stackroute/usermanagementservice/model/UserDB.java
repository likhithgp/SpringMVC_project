package com.stackroute.usermanagementservice.model;

import lombok.*;

/**
 * This class is responsible for getting values from the user and passing them to User class to be inserted in database
 */
/**@Data annotation to add getters and setters
 *@NoargsConstructor to add the no parameterized constructor
 * @AllArgsconstructor to add the parametrized constructor
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserDB {
    private String username;
    private String password;
    private String name;
    private long mobileNo;

    public UserDB(String username, String password, String name, long mobileNo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public UserDB() {
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


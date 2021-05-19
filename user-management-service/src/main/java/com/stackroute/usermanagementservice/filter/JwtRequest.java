package com.stackroute.usermanagementservice.filter;


import lombok.Data;

import java.io.Serializable;

/**
 * This class is used to request token to the database
 */
/**@Data annotation to add getters and setters
 *@NoargsConstructor to add the no parameterized constructor
 * @AllArgsconstructor to add the parametrized constructor
 */

@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
    private String name;
    private long mobileNo;

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

    /** default constructor for JSON Parsing */
    public JwtRequest()
    {
    }

    public JwtRequest(String username, String password,String name,long mobileNo) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobileNo = mobileNo;
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

}

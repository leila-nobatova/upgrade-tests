package com.upgrade.users;

/**
 * Author: Leyla Nobatova
 * Created: 2019-08-15
 */
public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;

    }


}

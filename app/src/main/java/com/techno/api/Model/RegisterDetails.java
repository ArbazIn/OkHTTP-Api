package com.techno.api.Model;

/**
 * Created by arbaz on 29/6/16.
 */
public class RegisterDetails {

    public String first_name;
    public String last_name;
    public String email;
    public String password;

    public RegisterDetails(String fname, String lname, String email, String pass) {
        this.first_name = fname;
        this.last_name = lname;
        this.email = email;
        this.password = pass;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

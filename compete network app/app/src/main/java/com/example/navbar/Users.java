package com.example.navbar;

public class Users {
    String name, mail, pass, username, organisation, mobile;

    public Users(String name, String mail, String pass, String username, String mobile, String organisation) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
        this.username = username;
        this.mobile = mobile;
        this.organisation = organisation;
    }

    public Users(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
}

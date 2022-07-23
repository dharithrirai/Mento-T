package com.dharithri.mento_t;

public class user {
    private String Uid;
    private  String Name;
    private String Phno;
    private String Email;
    private String Password;

    public user(String uid, String name, String phno, String email,String password) {
        Uid = uid;
        Name = name;
        Phno = phno;
        Email = email;
        Password = password;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhno() {
        return Phno;
    }

    public void setPhno(String phno) {
        Phno = phno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

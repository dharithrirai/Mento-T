package com.dharithri.mento_t;


public class Users {
    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
//    private int usertype;
    private String Uid;
    private  String Name;
    private String Phno;
    private String Email;
    private String Usn;
    private String Password;


//    public int getUsertype() {
//        return usertype;
//    }
//
//    public void setUsertype(int usertype) {
//        this.usertype = usertype;
//    }

    public Users() {
    }

    public Users(String uid,String name,String usn, String phno, String email, String password , int usertype) {
//        usertype=usertype;
        Uid=uid;
        Name = name;
        Phno = phno;
        Email = email;
        Password = password;
        Usn=usn;

    }

    public String getUsn() {
        return Usn;
    }

    public void setUsn(String usn) {
        Usn = usn;
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

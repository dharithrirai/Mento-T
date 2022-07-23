package com.dharithri.mento_t;

public class Email {
    private String To;
    private String Date;
    private String Subject;
    private String Description;
    private String Uid;
    public Email()
    {}


    public Email(String date,String to,String subject, String description, String uid) {
        To=to;
        Date=date;
        Subject = subject;
        Description = description;
        Uid = uid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}

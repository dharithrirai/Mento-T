package com.dharithri.mento_t;

public class Meet {
    private String Title;
    private String Location;
    private String Description;
    private String Time;
    private String Date;
    private String Uid;

    public Meet(){

    }

    public Meet(String title, String location, String description, String time, String date, String uid) {
        Title = title;
        Location = location;
        Description = description;
        Time = time;
        Date = date;
        Uid = uid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}

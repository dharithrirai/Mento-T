package com.dharithri.mento_t;

public class Meets {
    private String Title;
    private String Location;
    private String Description;
    private String Uid;

    public Meets(){

    }

    public Meets(String title, String location, String description, String uid) {
        Title = title;
        Location = location;
        Description = description;
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

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}

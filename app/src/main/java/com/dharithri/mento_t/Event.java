package com.dharithri.mento_t;

public class Event {
    private String Teventname;
    private  String Teventyear;
    private String Teventprize;
    private String Nontecheventname;
    private String Nontecheventyear;
    private String Nontecheventprize;
    private String Uid;
    private String Name;

    public Event() {
    }


    public Event(String name,String teventname, String teventyear, String teventprize, String nontecheventname, String nontecheventyear, String nontecheventprize, String uid) {
        Teventname = teventname;
        Name=name;
        Teventyear = teventyear;
        Teventprize = teventprize;
        Nontecheventname = nontecheventname;
        Nontecheventyear = nontecheventyear;
        Nontecheventprize = nontecheventprize;
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTeventname() {
        return Teventname;
    }

    public void setTeventname(String teventname) {
        Teventname = teventname;
    }

    public String getTeventyear() {
        return Teventyear;
    }

    public void setTeventyear(String teventyear) {
        Teventyear = teventyear;
    }

    public String getTeventprize() {
        return Teventprize;
    }

    public void setTeventprize(String teventprize) {
        Teventprize = teventprize;
    }

    public String getNontecheventname() {
        return Nontecheventname;
    }

    public void setNontecheventname(String nontecheventname) {
        Nontecheventname = nontecheventname;
    }

    public String getNontecheventyear() {
        return Nontecheventyear;
    }

    public void setNontecheventyear(String nontecheventyear) {
        Nontecheventyear = nontecheventyear;
    }

    public String getNontecheventprize() {
        return Nontecheventprize;
    }

    public void setNontecheventprize(String nontecheventprize) {
        Nontecheventprize = nontecheventprize;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}

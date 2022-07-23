package com.dharithri.mento_t;

public class Subject1 {
    private String Math;
    private  String Chem;
    private String Cps;
    private String Eln;
    private String Mech;
    private String Chel;
    private String Cpl;
    private String  Uid;

    public Subject1(){

    }

    public Subject1(String math, String chem, String cps, String eln, String mech, String chel, String cpl, String uid) {
        Math = math;
        Chem = chem;
        Cps = cps;
        Eln = eln;
        Mech = mech;
        Chel = chel;
        Cpl = cpl;
        Uid = uid;
    }



    public String getMath() {
        return Math;
    }

    public void setMath(String math) {
        Math = math;
    }

    public String getChem() {
        return Chem;
    }

    public void setChem(String chem) {
        Chem = chem;
    }

    public String getCps() {
        return Cps;
    }

    public void setCps(String cps) {
        Cps = cps;
    }

    public String getEln() {
        return Eln;
    }

    public void setEln(String eln) {
        Eln = eln;
    }

    public String getMech() {
        return Mech;
    }

    public void setMech(String mech) {
        Mech = mech;
    }

    public String getChel() {
        return Chel;
    }

    public void setChel(String chel) {
        Chel = chel;
    }

    public String getCpl() {
        return Cpl;
    }

    public void setCpl(String cpl) {
        Cpl = cpl;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}
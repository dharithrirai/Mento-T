package com.dharithri.mento_t;

public class Subject {
    private String Math;
    private  String Phy;
    private String Ele;
    private String Eng;
    private String Cad;
    private String Phyl;
    private String Elel;
    private String  Uid;

    public Subject(String math, String phy, String ele, String eng, String cad, String phyl, String elel, String uid) {
        Math = math;
        Phy = phy;
        Ele = ele;
        Eng = eng;
        Cad = cad;
        Phyl = phyl;
        Elel = elel;
        Uid = uid;
    }

    public String getMath() {
        return Math;
    }

    public void setMath(String math) {
        Math = math;
    }

    public String getPhy() {
        return Phy;
    }

    public void setPhy(String phy) {
        Phy = phy;
    }

    public String getEle() {
        return Ele;
    }

    public void setEle(String ele) {
        Ele = ele;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        Eng = eng;
    }

    public String getCad() {
        return Cad;
    }

    public void setCad(String cad) {
        Cad = cad;
    }

    public String getPhyl() {
        return Phyl;
    }

    public void setPhyl(String phyl) {
        Phyl = phyl;
    }

    public String getElel() {
        return Elel;
    }

    public void setElel(String elel) {
        Elel = elel;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}

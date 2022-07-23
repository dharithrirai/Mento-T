package com.dharithri.mento_t;

public class TestModel {
    private String auth;
    private String Title;

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    private String Uid;
    public TestModel(){

    }

    public TestModel(String auth, String title,String uid) {
        this.auth = auth;
        Title = title;
        Uid=uid;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

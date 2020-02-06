package com.kouceng.yazlab3;

public class Upload {

    private String uName;
    private String uImageUrl;

    public Upload() {
    }

    public Upload(String uName, String uImageUrl) {

        if(uName.trim().equals("")){
            uName = "noname";
        }

        this.uName = uName;
        this.uImageUrl = uImageUrl;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuImageUrl() {
        return uImageUrl;
    }

    public void setuImageUrl(String uImageUrl) {
        this.uImageUrl = uImageUrl;
    }
}

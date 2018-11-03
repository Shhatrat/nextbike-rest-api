package com.shhatrat.nextbike.model.myApi;

public class MInfo {
    String description;
    String version;

    public MInfo(String description, String version) {
        this.description = description;
        this.version = version;
    }

    public MInfo(){
        this.description = "Api created by shhatrat";
        this.version = "0.1";
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }
}

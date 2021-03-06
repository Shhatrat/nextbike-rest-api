package com.shhatrat.nextbike.model.myApi;

public class MInfo {
    String description;
    String version;

    public MInfo(String description, String version) {
        this.description = description;
        this.version = version;
    }

    public MInfo(){
        this.description = "Api created by Shhatrat. Source: https://github.com/Shhatrat/nextbike-rest-api";
        this.version = "0.4";
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }
}

package com.example.app;

import java.net.URL;

public class DataModel {

    private String name;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DataModel(String name, String image) {
        this.name = name;
        this.image = image;
    }
}

package com.example.app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DentistDataModal {

    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    private String shortName;
    @SerializedName("image")
    @Expose
    private String image;
    private String totalCourses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(String totalCourses) {
        this.totalCourses = totalCourses;
    }

    public DentistDataModal(int id, String name, String shortName, String image, String totalCourses) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.image = image;
        this.totalCourses = totalCourses;
    }

    public DentistDataModal() {
    }
}

package com.example.app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DentistModal {

    private int status;
    private String message;
    @SerializedName("dentistdata")
    @Expose
    private List<DentistDataModal> dentistdata = new ArrayList<>();

    private int total;
    private int count;
    private int currentPage;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DentistDataModal> getDentistdata() {
        return dentistdata;
    }

    public void setDentistdata(List<DentistDataModal> dentistdata) {
        this.dentistdata = dentistdata;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public DentistModal(int status, String message, List<DentistDataModal> dentistdata, int total, int count, int currentPage) {
        this.status = status;
        this.message = message;
        this.dentistdata = dentistdata;
        this.total = total;
        this.count = count;
        this.currentPage = currentPage;
    }

    public DentistModal() {
    }
}

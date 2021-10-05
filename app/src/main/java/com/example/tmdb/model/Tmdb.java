package com.example.tmdb.model;

import java.util.ArrayList;
import java.util.List;

public class Tmdb {


    public Integer page;

    public List<TmdbMovie> results = null;

    public Integer total_pages;

    public Integer total_results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<TmdbMovie> getResults() {
        return results;
    }

    public void setResults(ArrayList<TmdbMovie> results) {
        this.results = results;
    }

    public void setResults(List<TmdbMovie> results) {
        this.results = results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }
}

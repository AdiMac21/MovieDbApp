package com.example.adrian.moviedbapp.Model;

/**
 * Created by Adrian on 11/15/2016.
 */

public class Movie {
    private String poster_path;
    private String original_title;
    private String overview;
    private String id;

    public String getBackdrop_path() {
        return poster_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.poster_path = backdrop_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}

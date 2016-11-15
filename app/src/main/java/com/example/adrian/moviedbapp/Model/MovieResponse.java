package com.example.adrian.moviedbapp.Model;

import java.util.ArrayList;

/**
 * Created by Adrian on 11/15/2016.
 */

public class MovieResponse {
    ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}

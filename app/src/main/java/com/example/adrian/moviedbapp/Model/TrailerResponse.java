package com.example.adrian.moviedbapp.Model;

import java.util.ArrayList;

/**
 * Created by Adrian on 11/23/2016.
 */

public class TrailerResponse {
    private ArrayList<Trailer> results;

    public ArrayList<Trailer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Trailer> results) {
        this.results = results;
    }
}

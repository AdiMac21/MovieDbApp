package com.example.adrian.moviedbapp.Model;

/**
 * Created by Adrian on 11/23/2016.
 */

public class Trailer {
    private String type;
    private String key;

    public String getName() {
        return type;
    }

    public void setName(String type) {
        this.type = type;
    }

    public String getId() {
        return key;
    }

    public void setId(String key) {
        this.key = key;
    }
}

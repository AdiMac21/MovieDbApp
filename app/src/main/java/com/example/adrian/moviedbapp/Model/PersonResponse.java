package com.example.adrian.moviedbapp.Model;

import java.util.ArrayList;

/**
 * Created by java2 on 11/17/2016.
 */

public class PersonResponse {
    ArrayList<Person> cast;

    public ArrayList<Person> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Person> cast) {
        this.cast = cast;
    }
}

package com.example.adrian.moviedbapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Adrian on 11/21/2016.
 */

public class BackdropResponse implements Serializable {
    private ArrayList<Backdrop> backdrops;

    public ArrayList<Backdrop> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(ArrayList<Backdrop> backdrops) {
        this.backdrops = backdrops;
    }
}

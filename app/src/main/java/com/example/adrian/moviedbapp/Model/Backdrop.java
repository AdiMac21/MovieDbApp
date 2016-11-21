package com.example.adrian.moviedbapp.Model;

import java.io.Serializable;

/**
 * Created by Adrian on 11/21/2016.
 */

public class Backdrop implements Serializable {
    private String file_path;

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}

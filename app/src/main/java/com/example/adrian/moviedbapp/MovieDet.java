package com.example.adrian.moviedbapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrian.moviedbapp.Model.Movie;
import com.squareup.picasso.Picasso;

public class MovieDet extends AppCompatActivity {
    private final String BASE_URL = "https://image.tmdb.org/t/p/w370_and_h556_bestv2";
    private TextView movieDet;
    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_det);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        linkUi();
        populate();
    }

    private void populate() {
        Intent intent = getIntent();

        Movie movie = (Movie) intent.getSerializableExtra("movie");
        Picasso.with(MovieDet.this).load(BASE_URL + movie.getPoster_path()).into(poster);
        movieDet.setText(movie.getOverview().toString());

    }

    private void linkUi() {
        poster = (ImageView) findViewById(R.id.im_pict);
        movieDet = (TextView) findViewById(R.id.tv_det);
    }
}

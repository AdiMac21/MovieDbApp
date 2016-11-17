package com.example.adrian.moviedbapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrian.moviedbapp.Adapters.AdapterPersons;
import com.example.adrian.moviedbapp.Model.Movie;
import com.example.adrian.moviedbapp.Model.Person;
import com.example.adrian.moviedbapp.Model.PersonResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDet extends AppCompatActivity {
    private final String API_KEY = "954cab043b53e5e975bf32c68a043746";
    private final String BASE_URL = "https://image.tmdb.org/t/p/w370_and_h556_bestv2";
    private TextView movieDet;
    private ImageView poster;
    private Movie movie;
    private ArrayList<Person> cast;
    private AdapterPersons adapterPersons;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_det);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        linkUi();
        populate();
        init();
    }

    private void populate() {
        Intent intent = getIntent();

        movie = (Movie) intent.getSerializableExtra("movie");
        Picasso.with(MovieDet.this).load(BASE_URL + movie.getPoster_path()).into(poster);
        movieDet.setText(movie.getOverview().toString());

    }

    private void linkUi() {
        poster = (ImageView) findViewById(R.id.im_pict);
        movieDet = (TextView) findViewById(R.id.tv_det);
        gridView= (GridView) findViewById(R.id.grid_view);
    }


    private void init() {
        RestClient.getApi().getCast(movie.getId(), API_KEY).enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                if (response.isSuccessful()) {
                    cast = (response.body().getCast());
                    adapterPersons = new AdapterPersons(MovieDet.this, cast);
                    gridView.setAdapter(adapterPersons);
                }
            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {

            }
        });

    }
}

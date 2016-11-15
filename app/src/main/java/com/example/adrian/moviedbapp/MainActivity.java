package com.example.adrian.moviedbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adrian.moviedbapp.Model.Movie;
import com.example.adrian.moviedbapp.Model.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    private void init() {
        RestClient.getApi().getMovies(2, "reputation").enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {

                    ArrayList<Movie> go = (response.body().getResults());
                    Adapter adapter = new Adapter(MainActivity.this, go);
                    gg.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }
}

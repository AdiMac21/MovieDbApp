package com.example.adrian.moviedbapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrian.moviedbapp.Adapters.RecyclePersons;
import com.example.adrian.moviedbapp.Model.Backdrop;
import com.example.adrian.moviedbapp.Model.BackdropResponse;
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
    private final String BASE_URL = "https://image.tmdb.org/t/p/original";
    private TextView movieDet;
    private ImageView poster;
    private Movie movie;
    private ArrayList<Person> cast;
    private View view;
    private RecyclerView recyclerView;
    private RecyclePersons adapter;
    private ArrayList<Backdrop> backdropss;
    private boolean moviedetBol = false;
    private ImageView trailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.movie_det);
        linkUi();
        populate();
        init();
        backdrops();
        listener();
    }

    private void listener() {
        poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDet.this, FragmentActivity.class);
                intent.putExtra("backdrops", backdropss);
                startActivity(intent);
            }
        });

        movieDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moviedetBol) {
                    movieDet.setMaxLines(1);
                    moviedetBol = false;
                } else {
                    movieDet.setMaxLines(Integer.MAX_VALUE);
                    moviedetBol = true;
                }
            }
        });
        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDet.this, Video.class);
                startActivity(intent);
            }
        });
    }

    private void backdrops() {
        RestClient.getApi().getBackdrops(movie.getId(), API_KEY).enqueue(new Callback<BackdropResponse>() {
            @Override
            public void onResponse(Call<BackdropResponse> call, Response<BackdropResponse> response) {
                if (response.isSuccessful()) {
                    backdropss = (response.body().getBackdrops());

                }
            }

            @Override
            public void onFailure(Call<BackdropResponse> call, Throwable t) {

            }
        });
    }

    private void populate() {
        Intent intent = getIntent();

        movie = (Movie) intent.getSerializableExtra("movie");
        Picasso.with(MovieDet.this).load(BASE_URL + movie.getBackdrop_path()).fit().centerCrop().into(poster);
        view.setBackgroundResource(R.drawable.gradient);
        movieDet.setText(movie.getOverview());


    }

    private void linkUi() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_crew);
        poster = (ImageView) findViewById(R.id.movie_backdrop);
        movieDet = (TextView) findViewById(R.id.tv_movie_desc);
        trailer = (ImageView) findViewById(R.id.trailer);
        view = findViewById(R.id.gradient);
    }


    private void init() {
        RestClient.getApi().getCast(movie.getId(), API_KEY).enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                if (response.isSuccessful()) {
                    cast = (response.body().getCast());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(MovieDet.this);
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    layoutManager.scrollToPosition(0);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    adapter = new RecyclePersons(MovieDet.this, cast);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                }
            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {

            }
        });

    }
}

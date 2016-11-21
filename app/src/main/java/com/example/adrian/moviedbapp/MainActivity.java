package com.example.adrian.moviedbapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.adrian.moviedbapp.Adapters.Adapter;
import com.example.adrian.moviedbapp.Model.Movie;
import com.example.adrian.moviedbapp.Model.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String API_KEY = "954cab043b53e5e975bf32c68a043746";
    private GridView gg;
    private ArrayList<Movie> go;
    private Adapter adapter;
    private int count=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        linkUi();
        init();
        setListener();
    }

    private void setListener() {
        gg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDet.class);
                intent.putExtra("movie", go.get(position));
                startActivity(intent);


            }
        });

        gg.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                System.out.println(firstVisibleItem + " " + visibleItemCount + " " + totalItemCount);

                if (firstVisibleItem + visibleItemCount > totalItemCount - 8 && totalItemCount != 0) {
                    RestClient.getApi().getMovies(API_KEY, "en-US", "popularity.desc", false, false, count).enqueue(new Callback<MovieResponse>() {
                        @Override
                        public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                            if (response.isSuccessful()) {

                                ArrayList<Movie> new_page = (response.body().getResults());
                                go.addAll(new_page);
                                adapter.notifyDataSetChanged();

                            }
                        }

                        @Override
                        public void onFailure(Call<MovieResponse> call, Throwable t) {

                        }
                    });
                    count++;
                    System.out.println(count);
                }
            }
        });
    }

    private void linkUi() {
        gg = (GridView) findViewById(R.id.activity_main);
    }


    private void init() {
        RestClient.getApi().getMovies(API_KEY, "en-US", "popularity.desc", false, false, 1).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {

                    go = (response.body().getResults());
                    adapter = new Adapter(MainActivity.this, go);
                    gg.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }
}

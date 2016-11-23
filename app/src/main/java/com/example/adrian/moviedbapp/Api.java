package com.example.adrian.moviedbapp;

/**
 * Created by Adrian on 11/15/2016.
 */


import com.example.adrian.moviedbapp.Model.BackdropResponse;
import com.example.adrian.moviedbapp.Model.MovieResponse;
import com.example.adrian.moviedbapp.Model.PersonResponse;
import com.example.adrian.moviedbapp.Model.TrailerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by java2 on 11/10/2016.
 */

public interface Api {


    @GET("discover/movie?")
    Call<MovieResponse> getMovies(@Query("api_key") String api_key, @Query("language") String language, @Query("sort_by") String sort_by, @Query("include_adult") boolean include_adult, @Query("include_video") boolean include_video, @Query("page") int page);

    @GET("movie/{movie_id}/credits?")
    Call<PersonResponse> getCast(@Path("movie_id") long id, @Query("api_key") String api_key);

    @GET("movie/{movie_id}/images")
    Call<BackdropResponse> getBackdrops(@Path("movie_id") long id, @Query("api_key") String api_key);

    @GET("movie/{movie_id}/videos")
    Call<TrailerResponse> getTrailer(@Path("movie_id") long id, @Query("api_key") String api_key);
}

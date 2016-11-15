package com.example.adrian.moviedbapp;


        import okhttp3.OkHttpClient;
        import okhttp3.logging.HttpLoggingInterceptor;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by java2 on 11/10/2016.
 */

public class RestClient {


    static Retrofit retrofit = null;
    private static Api api;
    private static HttpLoggingInterceptor interceptor;
    private static OkHttpClient client;
    private static String BASE_URL = "https://api.themoviedb.org/3/";

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(loginInterceptor()).build();
        }
        return retrofit;
    }

    public static Api getApi() {
        if (api == null) {
            api = getRetrofit().create(Api.class);
        }
        return api;
    }

    public static OkHttpClient loginInterceptor() {
        if (client == null) {
            interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        }
        return client;
    }


}
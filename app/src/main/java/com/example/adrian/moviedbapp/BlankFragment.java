package com.example.adrian.moviedbapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private final String BASE_LINK = "https://image.tmdb.org/t/p/original/";
    private ImageView poster;
    private String link;
    private Context context;


    public BlankFragment(Context context, String link) {
        this.context = context;
        this.link = link;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        poster = (ImageView) view.findViewById(R.id.image_poster);
        Picasso.with(context).load(BASE_LINK + link).fit().centerCrop().into(poster);


        return view;

    }


}

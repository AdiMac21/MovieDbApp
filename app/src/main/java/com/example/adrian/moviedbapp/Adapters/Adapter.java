package com.example.adrian.moviedbapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.adrian.moviedbapp.Model.Movie;
import com.example.adrian.moviedbapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Adrian on 11/16/2016.
 */

public class Adapter extends BaseAdapter {
    private final String BASE_URL = "https://image.tmdb.org/t/p/w370_and_h556_bestv2";
    private Context context;
    private ArrayList<Movie> movies;
    private LayoutInflater inflater;


    public Adapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;

    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movies.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cell_layout, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.iv_poster);
//            viewHolder.name = (TextView) convertView.findViewById(R.id.mov_name);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(BASE_URL + movies.get(position).getPoster_path()).placeholder(R.drawable.placeholder_movieimage).into(viewHolder.poster);
//        viewHolder.name.setText(movies.get(position).getOriginal_title().toString());
        return convertView;
    }

    private static class ViewHolder {
        ImageView poster;
//    TextView name;
    }
}

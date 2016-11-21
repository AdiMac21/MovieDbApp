package com.example.adrian.moviedbapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrian.moviedbapp.Model.Person;
import com.example.adrian.moviedbapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Adrian on 11/19/2016.
 */

public class RecyclePersons extends RecyclerView.Adapter
        <RecyclePersons.ListItemViewHolder> {
    private final String BASE_URL = "https://image.tmdb.org/t/p/w264_and_h264_bestv2";
    private Context context;
    private ArrayList<Person> cast;


    public RecyclePersons(Context context, ArrayList<Person> cast) {
        this.context = context;
        this.cast = cast;

    }


    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.cell_person,
                        parent,
                        false);
        return new ListItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.character.setText(cast.get(position).getCharacter());
        holder.name.setText(cast.get(position).getName());
        Picasso.with(context).load(BASE_URL + cast.get(position).getProfile_path()).fit().centerCrop().into(holder.face);
    }


    @Override
    public int getItemCount() {
        return cast.size();
    }

    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView character;
        ImageView face;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.person_name);
            character = (TextView) itemView.findViewById(R.id.person_character);
            face = (ImageView) itemView.findViewById(R.id.person_iv);
        }
    }
}

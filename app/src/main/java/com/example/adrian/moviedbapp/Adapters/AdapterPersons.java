package com.example.adrian.moviedbapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrian.moviedbapp.Model.Person;
import com.example.adrian.moviedbapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Adrian on 11/16/2016.
 */

public class AdapterPersons extends BaseAdapter {
    private final String BASE_URL = "https://image.tmdb.org/t/p/w132_and_h132_bestv2";
    private Context context;
    private ArrayList<Person> cast;
    private LayoutInflater inflater;


    public AdapterPersons(Context context, ArrayList<Person> cast) {
        this.context = context;
        this.cast = cast;

    }

    @Override
    public int getCount() {
        return cast.size();
    }

    @Override
    public Object getItem(int position) {
        return cast.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cell_person, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.face = (ImageView) convertView.findViewById(R.id.person_iv);
            viewHolder.name = (TextView) convertView.findViewById(R.id.person_name);
            viewHolder.character= (TextView) convertView.findViewById(R.id.person_character);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(BASE_URL + cast.get(position).getProfile_path()).into(viewHolder.face);
        viewHolder.name.setText(cast.get(position).getName().toString());
        viewHolder.character.setText("as "+cast.get(position).getCharacter().toString());
        return convertView;
    }

    private static class ViewHolder {
        ImageView face;
        TextView name;
        TextView character;
    }
}

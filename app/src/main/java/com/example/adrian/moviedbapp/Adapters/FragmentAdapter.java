package com.example.adrian.moviedbapp.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.adrian.moviedbapp.BlankFragment;
import com.example.adrian.moviedbapp.Model.Backdrop;

import java.util.ArrayList;

/**
 * Created by Adrian on 11/21/2016.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Backdrop> backdrops;
    private Context context;

    public FragmentAdapter(Context context, FragmentManager fm, ArrayList<Backdrop> backdrops) {
        super(fm);
        this.context = context;
        this.backdrops = backdrops;

    }

    @Override
    public Fragment getItem(int position) {
        return new BlankFragment(context, backdrops.get(position).getFile_path());
    }

    @Override
    public int getCount() {
        return backdrops.size();
    }
}

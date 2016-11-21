package com.example.adrian.moviedbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.adrian.moviedbapp.Adapters.FragmentAdapter;
import com.example.adrian.moviedbapp.Model.Backdrop;

import java.util.ArrayList;

public class FragmentActivity extends AppCompatActivity {
    private ArrayList<Backdrop> backdrops;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Intent intent = getIntent();
        backdrops = (ArrayList<Backdrop>) intent.getSerializableExtra("backdrops");
        pager = (ViewPager) findViewById(R.id.pager);
        FragmentAdapter adapter = new FragmentAdapter(FragmentActivity.this, getSupportFragmentManager(), backdrops);
        pager.setAdapter(adapter);
    }
}

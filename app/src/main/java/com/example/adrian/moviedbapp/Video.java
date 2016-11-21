package com.example.adrian.moviedbapp;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import android.widget.MediaController;
import android.widget.VideoView;


public class Video extends AppCompatActivity {
    private VideoView videoView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView = (VideoView) findViewById(R.id.video);
        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        videoView.setVideoURI(uri);


        MediaController mediaPlayer = new MediaController(Video.this);
        mediaPlayer.setAnchorView(videoView);
        videoView.setMediaController(mediaPlayer);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });

    }
}

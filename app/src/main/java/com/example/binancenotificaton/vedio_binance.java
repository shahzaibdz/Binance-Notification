package com.example.binancenotificaton;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.VideoView;

public class vedio_binance extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_binance);
        VideoView videoView = (VideoView) findViewById(R.id.binance_video);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.screen_binance);
        //MediaController mc = new MediaController(this);
        //mc.setAnchorView(videoView);
        //videoView.setMediaController(mc);
        videoView.start();
    }
}
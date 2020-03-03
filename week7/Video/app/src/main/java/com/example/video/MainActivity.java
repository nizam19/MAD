package com.example.video;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button play;
    VideoView vv;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        vv = findViewById(R.id.vv);
        mc = new MediaController(this);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid));
                    vv.setMediaController(mc);
                    mc.setAnchorView(vv);
                    vv.start();

            }
        });
    }
}

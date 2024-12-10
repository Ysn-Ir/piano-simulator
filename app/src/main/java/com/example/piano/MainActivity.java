package com.example.piano;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Button> btns = new ArrayList<>();
    private ArrayList<MediaPlayer> media = new ArrayList<>();
    static int target = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        media.add(MediaPlayer.create(this, R.raw.doo));
        media.add(MediaPlayer.create(this, R.raw.re));
        media.add(MediaPlayer.create(this, R.raw.mi));
        media.add(MediaPlayer.create(this, R.raw.fa));
        media.add(MediaPlayer.create(this, R.raw.sol));
        media.add(MediaPlayer.create(this, R.raw.la));
        media.add(MediaPlayer.create(this, R.raw.si));
        media.add(MediaPlayer.create(this, R.raw.aa));
        media.add(MediaPlayer.create(this, R.raw.bb));
        media.add(MediaPlayer.create(this, R.raw.cc));
        media.add(MediaPlayer.create(this, R.raw.dd));
        media.add(MediaPlayer.create(this, R.raw.gg));
        media.add(MediaPlayer.create(this, R.raw.ff));

        btns.add(findViewById(R.id.a));
        btns.add(findViewById(R.id.b));
        btns.add(findViewById(R.id.c));
        btns.add(findViewById(R.id.d));
        btns.add(findViewById(R.id.e));
        btns.add(findViewById(R.id.f));
        btns.add(findViewById(R.id.g));
        btns.add(findViewById(R.id.aa));
        btns.add(findViewById(R.id.bb));
        btns.add(findViewById(R.id.cc));
        btns.add(findViewById(R.id.dd));
        btns.add(findViewById(R.id.ee));
        btns.add(findViewById(R.id.ff));

        for (int i = 0; i < media.size(); i++) {
            final int index = i;
            btns.get(i).setOnClickListener(v -> {
                if (media.get(target).isPlaying()) {
                    media.get(target).pause();
                    media.get(target).seekTo(0);
                }
                target = index;
                media.get(target).start();
            });
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (MediaPlayer mp : media) {
            if (mp != null) {
                mp.release();
            }
        }
    }
}

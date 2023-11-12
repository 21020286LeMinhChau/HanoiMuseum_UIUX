package com.example.museum;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.museum.Trangchu.ViewPager2Adapter;

public class Audio extends AppCompatActivity {
    private ImageView imagePlayPause;
    private TextView textCurrentTime, textTotalDuration;
    private SeekBar playerSeekBar;
    private MediaPlayer mediaPlayer;
    private ViewPager2 viewPager2;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio);

        viewPager2 = findViewById(R.id.viewpager3);
        ViewPager2AudioAdapter viewPager2AudioAdapter = new ViewPager2AudioAdapter(this);
        viewPager2.setAdapter(viewPager2AudioAdapter);

        imagePlayPause = findViewById(R.id.imagePlayPause);
        textCurrentTime = findViewById(R.id.textCurrentTime);
        textTotalDuration= findViewById(R.id.textTotalDuration);
        playerSeekBar=findViewById(R.id.playerSeekBar);
        mediaPlayer = new MediaPlayer();
        playerSeekBar.setMax(100);
        imagePlayPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    imagePlayPause.setImageResource(R.drawable.pause);
                }
                else {
                    mediaPlayer.start();
                    imagePlayPause.setImageResource(R.drawable.play);
                    updateSeekBar();
                }
            }
        });
        prepareMediaPlayer();
        playerSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                SeekBar seekBar = (SeekBar) view;
                int playPosition = (mediaPlayer.getDuration()/100) * seekBar.getProgress();
                mediaPlayer.seekTo(playPosition);
                textCurrentTime.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));
                return false;
            }
        });
    }
    private void prepareMediaPlayer(){
        try{
            mediaPlayer.setDataSource("https://webaudioapi.com/samples/audio-tag/chrono.mp3"); // URL of music file
            mediaPlayer.prepare();
            textTotalDuration.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        } catch (Exception exception){
            Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private Runnable updater = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();;
            long currentDuration = mediaPlayer.getCurrentPosition();
            textCurrentTime.setText(milliSecondsToTimer(currentDuration));
        }
    };
    private void updateSeekBar(){
        if(mediaPlayer.isPlaying()){
            playerSeekBar.setProgress((int)(((float) mediaPlayer.getCurrentPosition()/mediaPlayer.getDuration())*100));
            handler.postDelayed(updater,1000);
        }
    }
    private String milliSecondsToTimer(long milliSeconds) {
        String timerString = "";
        String secondString;
        int hours = (int) (milliSeconds / (1000 * 60 * 60));
        int minutes = (int) (milliSeconds % (1000 * 60 * 60) / (1000 * 60));
        int seconds = (int) ((milliSeconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        if (hours > 0) {
            timerString = hours + ":";
        }
        if (seconds < 10) {
            secondString = "0" + seconds;
        } else {
            secondString = "" + seconds;
        }
        timerString = timerString + minutes + ":" + secondString;
        return timerString;
    }

}

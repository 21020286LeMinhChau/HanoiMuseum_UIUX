package com.example.museum.Audio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.museum.Khampha.Thamquan.HienVat;
import com.example.museum.Khampha.Thamquan.HienVatAdapter;
import com.example.museum.Khampha.ThongTinAll;
import com.example.museum.MainRun;
import com.example.museum.R;

import io.realm.mongodb.App;

public class Audio extends AppCompatActivity {
    private ImageView imagePlayPause;
    private TextView textCurrentTime, textTotalDuration;
    private SeekBar playerSeekBar;
    private MediaPlayer mediaPlayer;
    private ViewPager2 viewPager2;

    private Handler handler = new Handler();
    private MainRun mainRun;
    ImageButton button_h;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio);
//        View view = inflater.inflate(
//                R.layout.audio, container, false);
        viewPager2 = findViewById(R.id.viewpager3);
        ViewPager2AudioAdapter viewPager2AudioAdapter = new ViewPager2AudioAdapter(this);
        viewPager2.setAdapter(viewPager2AudioAdapter);

        imagePlayPause = findViewById(R.id.imagePlayPause);
        textCurrentTime = findViewById(R.id.textCurrentTime);
        textTotalDuration= findViewById(R.id.textTotalDuration);
        playerSeekBar= findViewById(R.id.playerSeekBar);
        mediaPlayer = new MediaPlayer();
        button_h = findViewById(R.id.imageButton3);
        button_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick: ") ;
                Intent intent = new Intent(Audio.this, MainRun.class);
                startActivity(intent);
            }
        });
        playerSeekBar.setMax(100);
        HienVat hienvat = new HienVat("Gốm chu đậu",
                "0:35",
                "Thời Lý", R.drawable.bat, "https://webaudioapi.com/samples/audio-tag/chrono.mp3");
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
        prepareMediaPlayer(hienvat);
        playerSeekBar.setOnTouchListener((view, motionEvent) -> {
            SeekBar seekBar = (SeekBar) view;
            int playPosition = (mediaPlayer.getDuration()/100) * seekBar.getProgress();
            mediaPlayer.seekTo(playPosition);
            textCurrentTime.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));
            return false;
        });

    }
    private void prepareMediaPlayer(HienVat hienVat){
        try{
            mediaPlayer.setDataSource(hienVat.getAudioSource()); // URL of music file
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
package com.example.layoutdemo.mediaplayerdemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.layoutdemo.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends AppCompatActivity {
    @BindView(R.id.videov_film)
    VideoView videovFilm;
    @BindView(R.id.btn_play)
    Button btnPlay;
    @BindView(R.id.btn_pause)
    Button btnPause;
    @BindView(R.id.btn_stop)
    Button btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        initVideoView();
    }

    public void initVideoView(){
        File file =new File(Environment.getExternalStorageDirectory(),"video.mp4");//将文件存放为file对象
        videovFilm.setVideoPath(file.getPath());//设置音频文件路径
    }
    @OnClick({R.id.btn_play, R.id.btn_pause, R.id.btn_stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                if(!videovFilm.isPlaying()){
                    videovFilm.start();
                }
                break;
            case R.id.btn_pause:
                if(videovFilm.isPlaying()){
                    videovFilm.pause();
                }
                break;
            case R.id.btn_stop:
                if(videovFilm.isPlaying()){
                    videovFilm.resume();
                }
                break;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(videovFilm!=null) {
            videovFilm.suspend();
        }
    }
}

package com.eyad.concentrationgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;
public class Main3Activity extends AppCompatActivity {

    private int size;
    private MatchImages matchImages;
    private TextView time;
    private int time_game;
    private Button[] buttonArray;
    private static final int[] idArray = {R.id.btn_img1, R.id.btn_img2, R.id.btn_img3, R.id.btn_img4,
            R.id.btn_img5, R.id.btn_img6, R.id.btn_img7, R.id.btn_img8, R.id.btn_img9, R.id.btn_img10,R.id.btn_img11,
            R.id.btn_img12, R.id.btn_img13, R.id.btn_img14, R.id.btn_img15, R.id.btn_img16, R.id.btn_img17,
            R.id.btn_img18, R.id.btn_img19, R.id.btn_img20, R.id.btn_img21, R.id.btn_img22, R.id.btn_img23,
            R.id.btn_img24, R.id.btn_img25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bund = getIntent().getExtras();
        int id = bund.getInt("id");
        switch (id) {
            case R.id.btn_Easy:
                this.size = 4;
                this.time_game = 30;
                setContentView(R.layout.activity_main3_easy);
                break;
            case R.id.btn_Medium:
                this.size = 16;
                this.time_game = 45;
                setContentView(R.layout.activity_main3_medium);
                break;
            case R.id.btn_Hard:
                this.size = 25;
                this.time_game = 60;
                setContentView(R.layout.activity_main3_hard);
                break;
        }
        matchImages = new MatchImages(this, size);
        TextView lblName = (TextView) findViewById(R.id.lbl_name);
        lblName.setText( bund.getString("name"));
        this.time = (TextView) findViewById(R.id.lbl_Time);
        MyCount counter = new MyCount(this.time_game* 1000,1000);
        counter.start();

        this.buttonArray = new Button[this.size];
        for(int i=0; i<this.size; i++){
            buttonArray[i] = (Button) findViewById(idArray[i]);
            buttonArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    matchImages.buttonPress(view);
                }
            });
        }
    }

    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            Toast.makeText(getApplicationContext(), "GAME OVER", Toast.LENGTH_SHORT).show();
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            time.setText("Left: " + millisUntilFinished/1000);
        }

    }

    }

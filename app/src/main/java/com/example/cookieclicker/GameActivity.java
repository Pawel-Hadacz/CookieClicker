package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    public static ArrayList<String> scores = new ArrayList<>();
    Chronometer timer;
    ImageButton setbackground;
    Button click, reset, ranking, hiddenRoom,skin;
    TextView score,lista,bonus;
    int points;
    int pointsToWin = 50;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        hiddenRoom = findViewById(R.id.hiddenBtn);
        reset = findViewById(R.id.tryAgainBtn);
        ranking = findViewById(R.id.rankingmoveBtn);
        skin = findViewById(R.id.skinBtn);
        click = findViewById(R.id.clickBtn);
        score = findViewById(R.id.scoreView);
        lista = findViewById(R.id.listView);
        bonus = findViewById(R.id.bonusText);
        timer = findViewById(R.id.timeCounter);
        setbackground =  findViewById(R.id.setBackBtn);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skin.setVisibility(View.INVISIBLE);
               // timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
                points++;
                String current = timer.getText().toString();
                String[] c = current.split(":");
                int min = Integer.parseInt(c[0]) * 60;
                int sec = Integer.parseInt(c[1]);
                int currentTimetoInt = sec + min;

                    if(currentTimetoInt <10 && currentTimetoInt > 7  && points>30 && points < (pointsToWin - 10)){
                        points = points + 4;
                        bonus.setText("EXTRA POINTS");
                        bonus.setVisibility(View.VISIBLE);

                    }else if(currentTimetoInt < 15 && points >  10 && points < (pointsToWin - 10)){
                        setbackground.setVisibility(View.VISIBLE);
                        setbackground.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                             setbackground.setBackgroundColor(ContextCompat.getColor(GameActivity.this,R.color.design_default_color_primary_dark));
                             setbackground.setVisibility(View.GONE);
                            }

                        });
                    }
                    else{
                        bonus.setVisibility(View.INVISIBLE);
                        bonus.setVisibility(View.INVISIBLE);
                    }
                    if(points > 40){
                        skin.setVisibility(View.VISIBLE);
                        skin.setOnClickListener(new View.OnClickListener() {

                            @Override

                            public void onClick(View v) {
                                Drawable img = getApplicationContext().getResources().getDrawable(R.mipmap.ic_launcher_foreground2);
                                img.setBounds(100,0,0,100);
                                click.setCompoundDrawables(img,null,img,null);

                            }

                        });
                    }
                if(currentTimetoInt <5 && points>10){
                    points = points + 4;
                    bonus.setText("EXTRA POINTS");
                    bonus.setVisibility(View.VISIBLE);

                }else{
                    bonus.setVisibility(View.INVISIBLE);
                }

                if(points >= (pointsToWin)){
                    click.setEnabled(false);
                    click.setVisibility(View.INVISIBLE);


                    scores.add(timer.getText().toString());
                    Collections.sort(scores);
                    lista.setText("YOUR TIME IS: " + timer.getText().toString());
                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.stop();
                    ranking.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                    reset.setEnabled(true);
                    ranking.setEnabled(true);
                }

                score.setText("Your score is: " + points);

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setBase(SystemClock.elapsedRealtime());
                timer.stop();
                timer.start();
                points=0;
                skin.setVisibility(View.INVISIBLE);
                bonus.setVisibility(View.INVISIBLE);
                click.setVisibility(View.VISIBLE);
                click.setEnabled(true);
                ranking.setEnabled(false);
                ranking.setVisibility(View.INVISIBLE);
                reset.setEnabled(false);
                reset.setVisibility(View.INVISIBLE);

            }
        });
        ranking.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.stop();
                timer.setBase(SystemClock.elapsedRealtime());
                Intent ranking = new Intent(GameActivity.this,RankingActivity.class);
                startActivity(ranking);
                }

        });
        hiddenRoom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent hidden = new Intent(GameActivity.this,HiddenRoomActivity.class);
                startActivity(hidden);
            }

        });



    }
}

package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    public static ArrayList<String> scores = new ArrayList<>();
    Chronometer timer;
    Button click, reset, ranking;
    TextView score,lista;
    int points;
    int pointsToWin = 50;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        reset = findViewById(R.id.tryAgainBtn);
        ranking = findViewById(R.id.rankingmoveBtn);
        click = findViewById(R.id.clickBtn);
        score = findViewById(R.id.scoreView);
        lista = findViewById(R.id.listView);
        timer = findViewById(R.id.timeCounter);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
                points++;

                if(points == (pointsToWin)){
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

    }
}

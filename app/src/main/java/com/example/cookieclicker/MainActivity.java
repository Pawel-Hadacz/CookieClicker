package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start,ranking,options,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=(Button) findViewById(R.id.clickBtn);
        ranking=(Button) findViewById(R.id.rankingBtn);
        options=(Button) findViewById(R.id.optionsBtn);
        exit=(Button) findViewById(R.id.exitBtn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(MainActivity.this,GameActivity.class);
                startActivity(startGame);
            }
        });
        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ranking = new Intent(MainActivity.this,RankingActivity.class);
                startActivity(ranking);
            }
        });
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickOptions = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(pickOptions);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
              System.exit(0);
            }
        });
    }



}

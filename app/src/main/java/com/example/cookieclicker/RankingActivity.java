package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    ListView bestScores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        bestScores= (ListView) findViewById(R.id.bestScoresView);
        ArrayAdapter adapter = new ArrayAdapter(RankingActivity.this,android.R.layout.simple_list_item_1,GameActivity.scores);
        bestScores.setAdapter(adapter);
    }
}

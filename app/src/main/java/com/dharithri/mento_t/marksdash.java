package com.dharithri.mento_t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;


public class marksdash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marksdash);
        Button sem1 = findViewById(R.id.sem1);
        Button sem2 = findViewById(R.id.sem2);
        Button sem3 = findViewById(R.id.sem4);
        Button sem4 = findViewById(R.id.sem3);
        Button sem5 = findViewById(R.id.sem5);
        Button sem6 = findViewById(R.id.sem6);
        Button sem7 = findViewById(R.id.sem7);
        Button sem8 = findViewById(R.id.sem8);


        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1BSXx-HNR40Vr8L3zLfld9yq1GX9AR_N3UJl8-6iRY0w/edit?usp=sharing");
            }
        });
        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1-LR8VF6LT-LxP04GLkPLh4YbfkqcMjf2trGvuSKkTjw/edit?usp=sharing");
            }
        });
        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1k-sptjgIjoupNgS9xhizp7t55Br9GKufM64XZnqmnQU/edit?usp=sharing");
            }
        });
        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1JJ9X1dt49Of633Mp7Cv2qZZmOQcbGhVYaI6WU7B9THw/edit?usp=sharing");
            }
        });
        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1oswvwBfP1NuzbG5VgEia-SNFgBI0bMzmhOfM5fn80pc/edit?usp=sharing");
            }
        });
        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1K5E-olOJk9R5OKQwM1nqkZRCwZEGbp65tsa8AgSyN7s/edit?usp=sharing");
            }
        });
        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1jrjaK-iv7K70XeQ4iMqPaHD-cZFw45_q7Z8yDY57paE/edit?usp=sharing");
            }
        });
        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link("https://docs.google.com/spreadsheets/d/1sy1UnrTHGoIrg-V_N3PV2BJrq0ems0-QTKObLHQQfbk/edit?usp=sharing");
            }
        });
    }
    private void link(String s){
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}


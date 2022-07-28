package com.example.realtimesensoriotrevisi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HalamanAwal extends AppCompatActivity {

    private Button tombolMonitoring, tombolCover, tombolAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_awal);

        tombolMonitoring = findViewById(R.id.buttonMonitoring);
        tombolCover = findViewById(R.id.buttonCover);
        tombolAbout = findViewById(R.id.buttonAbout);

        tombolMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        tombolCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Cover.class);
                startActivity(i);
            }
        });

        tombolAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),About.class);
                startActivity(i);
            }
        });
    }
}
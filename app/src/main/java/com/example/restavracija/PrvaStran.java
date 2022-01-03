package com.example.restavracija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrvaStran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prva_stran);

        Button s = findViewById(R.id.skeniraj);
        Button v = findViewById(R.id.vpis);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrvaStran.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
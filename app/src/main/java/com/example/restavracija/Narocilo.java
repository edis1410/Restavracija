package com.example.restavracija;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.restavracija.DBHelper;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Narocilo extends AppCompatActivity {
    String narocilo;
    DBHelper db;
    boolean x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narocilo);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        Bundle extras = getIntent().getExtras();
        int mizaID = extras.getInt("mizaID");

        Button d1 = findViewById(R.id.dodaj1);
        Button o1 = findViewById(R.id.odstrani1);
        TextView v1 = findViewById(R.id.kolicina1);
        final int[] i = {1};
        i[0] = Integer.parseInt(v1.getText().toString());

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (i[0] >= 0) {
                    i[0] += 1;
                    vrednost = String.valueOf(i[0]);
                    v1.setText(vrednost);
                }
            }
        });

        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (i[0] > 0) {
                    i[0] -= 1;
                    vrednost = String.valueOf(i[0]);
                    v1.setText(vrednost);
                }
            }
        });



        Button oddajNarocilo = findViewById(R.id.oddaj);
        db = new DBHelper(this);

        oddajNarocilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                narocilo = "";
                x = db.oddajNarocilo(mizaID+"",narocilo);
                if (x)
                    Toast.makeText(Narocilo.this, "Uspeh", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
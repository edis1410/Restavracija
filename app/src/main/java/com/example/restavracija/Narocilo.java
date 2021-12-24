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
        Button d2 = findViewById(R.id.dodaj2);
        Button o2 = findViewById(R.id.odstrani2);
        Button d3 = findViewById(R.id.dodaj3);
        Button o3 = findViewById(R.id.odstrani3);
        Button d4 = findViewById(R.id.dodaj4);
        Button o4 = findViewById(R.id.odstrani4);
        Button d5 = findViewById(R.id.dodaj5);
        Button o5 = findViewById(R.id.odstrani5);
        TextView v1 = findViewById(R.id.kolicina1);
        TextView v2 = findViewById(R.id.kolicina2);
        TextView v3 = findViewById(R.id.kolicina3);
        TextView v4 = findViewById(R.id.kolicina4);
        TextView v5 = findViewById(R.id.kolicina5);
        final int[] i = {1};
        i[0] = Integer.parseInt(v1.getText().toString());
        final int[] j = {1};
        j[0] = Integer.parseInt(v2.getText().toString());
        final int[] k = {1};
        k[0] = Integer.parseInt(v3.getText().toString());
        final int[] l = {1};
        l[0] = Integer.parseInt(v4.getText().toString());
        final int[] m = {1};
        m[0] = Integer.parseInt(v5.getText().toString());

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

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (j[0] >= 0) {
                    j[0] += 1;
                    vrednost = String.valueOf(j[0]);
                    v2.setText(vrednost);
                }
            }
        });
        o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (j[0] > 0) {
                    j[0] -= 1;
                    vrednost = String.valueOf(j[0]);
                    v2.setText(vrednost);
                }
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (k[0] >= 0) {
                    k[0] += 1;
                    vrednost = String.valueOf(k[0]);
                    v3.setText(vrednost);
                }
            }
        });
        o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (k[0] > 0) {
                    k[0] -= 1;
                    vrednost = String.valueOf(k[0]);
                    v3.setText(vrednost);
                }
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (l[0] >= 0) {
                    l[0] += 1;
                    vrednost = String.valueOf(l[0]);
                    v4.setText(vrednost);
                }
            }
        });
        o4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (l[0] > 0) {
                    l[0] -= 1;
                    vrednost = String.valueOf(l[0]);
                    v4.setText(vrednost);
                }
            }
        });

        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (m[0] >= 0) {
                    m[0] += 1;
                    vrednost = String.valueOf(m[0]);
                    v5.setText(vrednost);
                }
            }
        });
        o5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vrednost;
                if (m[0] > 0) {
                    m[0] -= 1;
                    vrednost = String.valueOf(m[0]);
                    v5.setText(vrednost);
                }
            }
        });


        Button oddajNarocilo = findViewById(R.id.oddaj);
        db = new DBHelper(this);

        oddajNarocilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                narocilo = "Izdelek 1: "+v1+" Izdelek 2: "+v2+" Izdelek 3: "+v3+" Izdelek 4: "+v4+" Izdelek 5: "+v5;
                x = db.oddajNarocilo(mizaID+"",narocilo);
                if (x)
                    Toast.makeText(Narocilo.this, "Uspeh", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
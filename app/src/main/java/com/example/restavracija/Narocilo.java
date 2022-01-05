package com.example.restavracija;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Narocilo extends AppCompatActivity {

    String narocilo = "";
    DBHelper db;
    boolean x;
    String mizaID;
    double skupno;
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
        mizaID = extras.getString("mizaID");


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
        TextView i1 = findViewById(R.id.izdelek1);
        TextView i2 = findViewById(R.id.izdelek2);
        TextView i3 = findViewById(R.id.izdelek3);
        TextView i4 = findViewById(R.id.izdelek4);
        TextView i5 = findViewById(R.id.izdelek5);
        final String[] c1 = i1.getText().toString().split(" ");
        final String[] c2 = i2.getText().toString().split(" ");
        final String[] c3 = i3.getText().toString().split(" ");
        final String[] c4 = i4.getText().toString().split(" ");
        final String[] c5 = i5.getText().toString().split(" ");
        ImageView s1 = findViewById(R.id.slika1);
        ImageView s2 = findViewById(R.id.slika2);
        ImageView s3 = findViewById(R.id.slika3);
        ImageView s4 = findViewById(R.id.slika4);
        ImageView s5 = findViewById(R.id.slika5);
        Button oddajNarocilo = findViewById(R.id.oddaj);
        ScrollView sv = findViewById(R.id.scroll);
        EditText opombe = findViewById(R.id.opombe);
        RadioButton gotovina = findViewById(R.id.gotovina);
        RadioButton kartica = findViewById(R.id.kartica);
        db = new DBHelper(this);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImmageShowPopupWindowClick(v, 1);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImmageShowPopupWindowClick(v, 2);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImmageShowPopupWindowClick(v, 3);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImmageShowPopupWindowClick(v, 4);
            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImmageShowPopupWindowClick(v, 5);
            }
        });

        d1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (i[0] >= 0) {
                    i[0] += 1;
                    vrednost = String.valueOf(i[0]);
                    v1.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");
                }
            }
        });
        o1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (i[0] > 0) {
                    i[0] -= 1;
                    vrednost = String.valueOf(i[0]);
                    v1.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (j[0] >= 0) {
                    j[0] += 1;
                    vrednost = String.valueOf(j[0]);
                    v2.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });
        o2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (j[0] > 0) {
                    j[0] -= 1;
                    vrednost = String.valueOf(j[0]);
                    v2.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (k[0] >= 0) {
                    k[0] += 1;
                    vrednost = String.valueOf(k[0]);
                    v3.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });
        o3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (k[0] > 0) {
                    k[0] -= 1;
                    vrednost = String.valueOf(k[0]);
                    v3.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (l[0] >= 0) {
                    l[0] += 1;
                    vrednost = String.valueOf(l[0]);
                    v4.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });
        o4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (l[0] > 0) {
                    l[0] -= 1;
                    vrednost = String.valueOf(l[0]);
                    v4.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });

        d5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (m[0] >= 0) {
                    m[0] += 1;
                    vrednost = String.valueOf(m[0]);
                    v5.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });
        o5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String vrednost;
                if (m[0] > 0) {
                    m[0] -= 1;
                    vrednost = String.valueOf(m[0]);
                    v5.setText(vrednost);
                    oddajNarocilo.setText( Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0 +"€ - Oddaj narocilo");

                }
            }
        });


        oddajNarocilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skupno = Math.round(( i[0]*Double.parseDouble(c1[2]) + j[0]*Double.parseDouble(c2[2]) + k[0]*Double.parseDouble(c3[2]) + l[0]*Double.parseDouble(c4[2]) + m[0]*Double.parseDouble(c5[2]) ) * 100.0) / 100.0;
                if (!v1.getText().equals("0"))
                    narocilo = c1[0] + ": " + v1.getText() + "  ";
                if (!v2.getText().equals("0"))
                    narocilo = narocilo + c2[0] + ": " + v2.getText() + "  ";
                if (!v3.getText().equals("0"))
                    narocilo = narocilo + c3[0] + ": " + v3.getText() + "  ";
                if (!v4.getText().equals("0"))
                    narocilo = narocilo + c4[0] + ": " + v4.getText() + "  ";
                if (!v5.getText().equals("0"))
                    narocilo = narocilo + c5[0] + ": " + v5.getText();
                narocilo = narocilo + "\nOpombe: " + opombe.getText() + " /";


                RadioGroup radioGroup = findViewById(R.id.group);
                RadioButton radioButton;

                int selectedId = radioGroup.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(selectedId);

                if (radioButton == null){
                    //sv.fullScroll(View.FOCUS_DOWN);
                    Toast.makeText(Narocilo.this,"Morate izbrati način plačila!" , Toast.LENGTH_SHORT).show();
                    narocilo = "";
                }
                else {
                    narocilo = narocilo + "\nNačin plačila: "+ radioButton.getText() + " ("+ skupno +"€)\n" ;
                    x = db.oddajNarocilo(mizaID, narocilo);
                    if (x)
                        Toast.makeText(Narocilo.this,"Usepešno oddano naročilo" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Narocilo.this, PrvaStran.class);
                    startActivity(intent);
                }

            }
        });

    }

    public void onImmageShowPopupWindowClick(View view, int i) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView;

        switch (i){
            case 1: popupView = inflater.inflate(R.layout.p1, null);break;
            case 2: popupView = inflater.inflate(R.layout.p2, null);break;
            case 3: popupView = inflater.inflate(R.layout.p3, null);break;
            case 4: popupView = inflater.inflate(R.layout.p4, null);break;
            case 5: popupView = inflater.inflate(R.layout.p5, null);break;
            default: popupView = inflater.inflate(R.layout.p1, null);
        }

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }




}
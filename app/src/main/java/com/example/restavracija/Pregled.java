package com.example.restavracija;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pregled extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregled);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        TextView v =  findViewById(R.id.view);
        Button b =  findViewById(R.id.brisi);

        DBHelper db = new DBHelper(this);
        Cursor res = db.getdata();
        if(res.getCount() == 0){
            Toast.makeText(Pregled.this,"NI naročil" , Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Številka mize :"+res.getString(0)+"\n");
            buffer.append("Naročilo :"+res.getString(1)+"\n");
        }

        v.setText(buffer.toString());

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletedata("1");

                db.deletedata("2");
                db.deletedata("3");
            }
        });

    }


}
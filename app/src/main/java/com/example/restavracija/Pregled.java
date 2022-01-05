package com.example.restavracija;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pregled extends AppCompatActivity {
    Spinner spin;
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

        Button b =  findViewById(R.id.brisi);
        spin = (Spinner) findViewById(R.id.spinner);

        DBHelper db = new DBHelper(this);

        setText(db);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletedata(spin.getSelectedItem().toString());
                setText(db);
            }
        });

    }

    void setText(DBHelper db){

        TextView v =  findViewById(R.id.view);
        Cursor res = db.getdata();
        if(res.getCount() == 0){
            v.setText("");
            Toast.makeText(Pregled.this,"NI naročil" , Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("------------------------------------\n");
            buffer.append("Številka mize: "+res.getString(0)+"\n");
            buffer.append("Naročilo: "+res.getString(1));
            buffer.append("------------------------------------\n");
        }

        v.setText(buffer.toString());

        Cursor IDs = db.getID();
        StringBuffer bufferID = new StringBuffer();
        while (IDs.moveToNext()){
            bufferID.append(IDs.getString(0)+" ");
        }

        String p[] = bufferID.toString().split(" ");
        ArrayAdapter<String> spinnerArrayAdapter;

        spinnerArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, p);
        spin.setAdapter(spinnerArrayAdapter);
    }
}
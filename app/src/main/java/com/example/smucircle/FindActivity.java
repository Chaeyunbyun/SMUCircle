package com.example.smucircle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindActivity extends AppCompatActivity {
    ArrayList arrayList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        arrayList = new ArrayList();
        arrayList.add("스포츠");
        arrayList.add("봉사");
        arrayList.add("예술");
        arrayList.add("종교");
        arrayList.add("기타");

        final String[] select_item= {""};



        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter
                (this, android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner.setAdapter(adapter);



        Button button= (Button)findViewById(R.id.button3);;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
                select_item[0] = String.valueOf(arrayList.get(arg2));
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (select_item[0].equals("스포츠")) {
                    Intent intent = new Intent(FindActivity.this, SportsActivity.class);
                    startActivity(intent);
                    finish();

                } else if (select_item[0].equals("봉사")) {
                    Intent intent = new Intent(FindActivity.this, VolunteerActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (select_item[0].equals("예술")) {
                    Intent intent = new Intent(FindActivity.this, ArtActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (select_item[0].equals("종교")) {
                    Intent intent = new Intent(FindActivity.this, ReligionActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (select_item[0].equals("기타")) {
                    Intent intent = new Intent(FindActivity.this, EtcActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }}
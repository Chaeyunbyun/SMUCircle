package com.example.smucircle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Button b = (Button) findViewById(R.id.button);
            Button b1= (Button)  findViewById(R.id.button2);
            b.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Intent intent = new Intent(
                                                 getApplicationContext(), // 현재 화면의 제어권자
                                                 FindActivity.class); // 다음 넘어갈 클래스 지정
                                         startActivity(intent); // 다음 화면으로 넘어간다
                                     }
                                 });
                 b1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(
                                getApplicationContext(), // 현재 화면의 제어권자
                                MyCircleActivity.class); // 다음 넘어갈 클래스 지정
                        startActivity(intent); // 다음 화면으로 넘어간다
                    }

            });
        }



    }

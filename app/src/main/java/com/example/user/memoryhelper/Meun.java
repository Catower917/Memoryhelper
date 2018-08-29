package com.example.user.memoryhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.user.memoryhelper.R.styleable.View;

public class Meun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meun);
    }

    public void onstart(View v) {
        Intent intent001 = new Intent(this, MainActivity.class);
        startActivity(intent001);
    }//시작버튼 MainActivity로 가기 (사진찍기)


    public void onll(View v) {
        Intent intent001 = new Intent(this, gall.class);
        startActivity(intent001);
    }//gall로가기




}






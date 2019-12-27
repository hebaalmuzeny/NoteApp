package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
    }
    public void btn_back1(View view) {
        Intent intent1 = new Intent(Sign.this, MainActivity.class);
        startActivity(intent1);
    }
    public void btn_forgot(View view){
        Intent in = new Intent(Sign.this, Forgotpass.class);
        startActivity(in);
    }
}

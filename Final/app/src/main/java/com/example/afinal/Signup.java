package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    EditText email, pass;
    Button signup;
    FirebaseAuth mFirebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void btn_back(View view) {
        Intent intent1 = new Intent(Signup.this, MainActivity.class);
        startActivity(intent1);
    }
}

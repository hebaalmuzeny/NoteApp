package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    EditText emailId, password;
    Button signUp;
    FirebaseAuth mFirebaseAuth;

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirebaseAuth = FirebaseAuth.getInstance();

        emailId = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        signUp = findViewById(R.id.signup);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mFirebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Signup.this, "created account is onComplete" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        if(!task.isSuccessful()){
                            Toast.makeText(Signup.this,"Authentication Falied" +task.getException(), Toast.LENGTH_SHORT).show();
                        }else{
                            startActivity(new Intent(Signup.this, Home.class));
                            finish();
                        }
                    }
                });//addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>()
            }
        });
    }


    public void btn_back(View view) {
        Intent intent1 = new Intent(Signup.this, MainActivity.class);
        startActivity(intent1);
    }

}
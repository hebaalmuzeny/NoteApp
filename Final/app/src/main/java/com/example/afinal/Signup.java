package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {

    EditText emailId, password;
    Button signUp;
    FirebaseAuth mFirebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        signUp = findViewById(R.id.signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = emailId.getText().toString();
                String psw = password.getText().toString();
                if (email1.isEmpty()) {
                    emailId.setError("please enter email ");
                    emailId.requestFocus();
                } else if (psw.isEmpty()) {
                    password.setError("please enter password");
                    password.requestFocus();
                } else if (!(email1.isEmpty() && psw.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email1, psw).addOnCompleteListener
                            (Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Signup.this, "Created account is not succeful, try again", Toast.LENGTH_SHORT).show();
                                    } else {
                                        startActivity(new Intent(Signup.this, Home.class));
                                    }
                                }
                            });
                } else {
                    Toast.makeText(Signup.this, "Created account is not succeful, try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
}

    public void btn_back(View view) {
        Intent intent1 = new Intent(Signup.this, MainActivity.class);
        startActivity(intent1);
    }
}

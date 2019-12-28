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
import com.google.android.gms.tasks.OnFailureListener;
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();

        if (user!=null)
        {
            Intent myintent = new Intent(Signup.this , Home.class);
            startActivity(myintent);
        }


        emailId = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        signUp = findViewById(R.id.signup);
        //signUp.setOnClickListener(new View.OnClickListener(v-> {
         //   doSignup(emailId.getText().toString() , password.getText().toString());
        });
        private void doSignup(String emailId, String password){
            mFirebaseAuth.createUserWithEmailAndPassword(emailId,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mFirebaseAuth.getCurrentUser();
                        String emailF = user.getEmail();
                        String uid = user.getUid();
                        Map<String, Object> data = new HashMap<>();
                        data.put("uid", uid);
                        data.put("email", emailF);
                        data.put("createdAt", new Date().getTime());

                        // FirebaseDatabase.getInstance().getReference().child("User").child(uid).setValue(data).addOnFailureListener(new OnFailureListener() {

                        //  })


                    }
                }
            }
        }

    public void btn_back(View view) {
        Intent intent1 = new Intent(Signup.this, MainActivity.class);
        startActivity(intent1);
    }
}

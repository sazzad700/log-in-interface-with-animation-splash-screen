package com.example.logininterfacewithfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.auth.User;

public class signup extends AppCompatActivity {

    TextInputEditText usename,email,password;
    Button button;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        
        button=findViewById(R.id.signupmainbutt);
        usename=findViewById(R.id.signupusername);
        email=findViewById(R.id.signupemailid);
        password=findViewById(R.id.signuppassid);
        progressBar=findViewById(R.id.progressbarid);

        
        
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegisterd();
            }
        });

    }

    private void userRegisterd() {

        String username=usename.getText().toString();
        String em=email.getText().toString();
        String pass=password.getText().toString();
        boolean b=false;

        if(username.isEmpty()){
            usename.setError("Please enter your username");
            usename.requestFocus();
            b=true;
        }
        if (em.isEmpty()  ){
            email.setError("Enter valid email");
            email.requestFocus();
            b=true;
        }

        if ( !Patterns.EMAIL_ADDRESS.matcher(em).matches() ){
            email.setError("Enter valid email");
            email.requestFocus();
            b=true;
        }

        if (pass.length()<6){
            password.setError("Enter password minimum 6");
            password.requestFocus();
            b=true;
        }

       if (b==false){
           progressBar.setVisibility(View.VISIBLE);
       }

       mAuth.createUserWithEmailAndPassword(em,pass)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       progressBar.setVisibility(View.GONE);
                       if (task.isSuccessful()){
                           Toast.makeText(getApplicationContext(),"Register is complete",Toast.LENGTH_SHORT).show();
                       }else {
                           Toast.makeText(getApplicationContext(),"Register is not complete",Toast.LENGTH_SHORT).show();
                       }
                   }
               });



    }
}
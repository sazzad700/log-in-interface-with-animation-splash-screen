package com.example.logininterfacewithfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity implements View.OnClickListener {

    Button go,forgetpass,signup;
    TextInputEditText usename,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //this for no toolbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //id finding
        go=findViewById(R.id.gobutid);
        forgetpass=findViewById(R.id.forgetbutid);
        signup=findViewById(R.id.signupid);
        usename =findViewById(R.id.usernameid);
        password=findViewById(R.id.usernameid);

        //set listener
        go.setOnClickListener(this);
        forgetpass.setOnClickListener(this);
        signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.signupid){
            Intent intent=new Intent(login.this, com.example.logininterfacewithfirebase.signup.class);
            startActivity(intent);

        }


    }
}
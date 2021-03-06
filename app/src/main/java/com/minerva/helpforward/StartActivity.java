package com.minerva.helpforward;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    Button startRegister;
    Button startLogin;

    ProgressBar Bar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startLogin = (Button) findViewById(R.id.start_login);
        startRegister = (Button) findViewById(R.id.start_register);

        Bar = (ProgressBar) findViewById(R.id.is_auth_bar);

        mAuth = FirebaseAuth.getInstance();

        Bar.setVisibility(View.VISIBLE);
        mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    Log.d("FB", "onAuthStateChanged: "+ firebaseAuth.getCurrentUser());
                    Bar.setVisibility(View.GONE);
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }else{
                    Bar.setVisibility(View.GONE);
                }
            }
        });

        startLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        startRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}
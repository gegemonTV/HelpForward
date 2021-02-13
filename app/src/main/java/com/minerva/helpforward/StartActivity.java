package com.minerva.helpforward;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button startRegister;
    Button startLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startLogin = (Button) findViewById(R.id.start_login);
        startRegister = (Button) findViewById(R.id.start_register);

        Context thisContext = this;

        startLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(thisContext, LoginActivity.class);
            }
        });
    }
}
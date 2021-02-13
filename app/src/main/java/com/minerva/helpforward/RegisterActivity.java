package com.minerva.helpforward;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText Email;
    EditText Nickname;
    EditText Password;
    Button RegisterButton;
    ProgressBar Bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirebaseAuth mAuth;

        Email = (EditText) findViewById(R.id.email_reg);
        Nickname = (EditText) findViewById(R.id.nickname_reg);
        Password = (EditText) findViewById(R.id.password_reg);
        RegisterButton = (Button) findViewById(R.id.register);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
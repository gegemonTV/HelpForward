package com.minerva.helpforward;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class LoginActivity extends AppCompatActivity {

    EditText Email;
    EditText Password;
    Button LogInButton;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LogInButton = (Button) findViewById(R.id.login);
        Email = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Context thisContext = this;

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Email.getText().equals("")){
                    Toast.makeText(thisContext, "Email не может быть пустым!", Toast.LENGTH_LONG).show();
                }else if (Password.getText().equals("")){
                    Toast.makeText(thisContext, "Пароль не может быть пустым!", Toast.LENGTH_LONG).show();
                } else {

                }
            }
        });
    }
}

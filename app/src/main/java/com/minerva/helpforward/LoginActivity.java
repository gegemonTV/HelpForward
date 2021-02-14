package com.minerva.helpforward;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText Email;
    EditText Password;
    Button LogInButton;
    ProgressBar Bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bar = (ProgressBar) findViewById(R.id.login_progress_bar);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        LogInButton = (Button) findViewById(R.id.login);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bar.setVisibility(View.VISIBLE);
                if (Email.getText().equals("")){
                    Toast.makeText(getApplicationContext(), "Email не может быть пустым!", Toast.LENGTH_LONG).show();
                    Bar.setVisibility(View.GONE);
                }else if (Password.getText().equals("")){
                    Toast.makeText(getApplicationContext(), "Пароль не может быть пустым!", Toast.LENGTH_LONG).show();
                    Bar.setVisibility(View.GONE);
                } else {
                    mAuth.signInWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Bar.setVisibility(View.GONE);
                                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            }else{
                                Toast.makeText(getApplicationContext(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                Bar.setVisibility(View.GONE);
                            }
                        }
                    });
                }
            }
        });
    }
}

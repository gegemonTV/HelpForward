package com.minerva.helpforward;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText Email;
    EditText Nickname;
    EditText Password;
    Button RegisterButton;
    ProgressBar Bar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        Email = (EditText) findViewById(R.id.email_reg);
        Nickname = (EditText) findViewById(R.id.nickname_reg);
        Password = (EditText) findViewById(R.id.password_reg);
        RegisterButton = (Button) findViewById(R.id.register);

        Bar = (ProgressBar) findViewById((R.id.register_bar));

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bar.setVisibility(View.VISIBLE);
                if (Email.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Email не может быть пустым!", Toast.LENGTH_LONG).show();
                    Bar.setVisibility(View.GONE);
                }else if (Password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Пароль не может быть пустым!", Toast.LENGTH_LONG).show();
                    Bar.setVisibility(View.GONE);
                } else if(Nickname.getText().toString().equals((""))){
                    Toast.makeText(getApplicationContext(), "Имя пользователя не может быть пустым!", Toast.LENGTH_LONG).show();
                    Bar.setVisibility(View.GONE);
                } else {
                    mAuth.createUserWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                task.getResult().getUser().updateProfile(new UserProfileChangeRequest.Builder().setDisplayName(Nickname.getText().toString()).build())
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    Log.d("OK", "COOL!");
                                                    DatabaseReference _ref = FirebaseDatabase.getInstance().getReference("users");
                                                    _ref.child(Nickname.getText().toString()).child("gems").setValue(0);
                                                    _ref.child(Nickname.getText().toString()).child("carma").setValue(0);
                                                    Bar.setVisibility(View.GONE);
                                                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "Registration failed.",
                                                            Toast.LENGTH_SHORT).show();
                                                    Bar.setVisibility(View.GONE);
                                                }
                                            }
                                        });
                            } else {
                                Toast.makeText(getApplicationContext(), "Registration failed.",
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
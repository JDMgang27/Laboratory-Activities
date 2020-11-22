package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class register extends AppCompatActivity {

    EditText inputUsername;
    EditText inputPassword;
    EditText inputEmail;
    Button btnReg;
    Button btnCancel;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputUsername= findViewById(R.id.inputUsername);
        inputPassword= findViewById(R.id.inputPass);
        inputEmail= findViewById(R.id.inputEmail);
        btnReg= findViewById(R.id.btnReg);
        btnCancel =findViewById(R.id.btncancel);

        preferences= getSharedPreferences("Userinfo",0);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userVal = inputUsername.getText().toString();
                String passVal = inputPassword.getText().toString();
                String emailVal = inputEmail.getText().toString();

                if (userVal.length() > 1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", userVal);
                    editor.putString("password", passVal);
                    editor.putString("email", emailVal);
                    editor.apply();
                    Toast.makeText(register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(register.this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Cancel = new Intent(register.this, MainActivity.class);
                startActivity(Cancel);
            }
        });
    }
}
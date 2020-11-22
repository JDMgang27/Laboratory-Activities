package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnLogin;
    Button btnRegister;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= findViewById(R.id.loginUsername);
        password= findViewById(R.id.loginPassword);
        btnLogin= findViewById(R.id.login);
        btnRegister= findViewById(R.id.register);

        preferences= getSharedPreferences("Userinfo",0);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userVal =username.getText().toString();
                String passVal =password.getText().toString();

                String regUser = preferences.getString("username", "");
                String regPass = preferences.getString("password", "");

                if (userVal.equals(regUser) && passVal.equals(regPass)){
                    Intent Display = new Intent(MainActivity.this, display.class);
                    startActivity(Display);
                }else{
                    Toast.makeText(MainActivity.this,"Username and Password Incorrect", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Register= new Intent(MainActivity.this, register.class);
                startActivity(Register);
            }
        });
    }
}
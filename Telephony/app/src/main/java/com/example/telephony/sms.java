package com.example.telephony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sms extends AppCompatActivity {

    EditText editNum, editMessage;
    Button btnSend, btnBack;
    TextView contact1, contact2, contact3, contact4, contact5;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editNum = findViewById(R.id.editNum);
        editMessage = findViewById(R.id.editMessage);
        contact1 = findViewById(R.id.contact1);
        contact2 = findViewById(R.id.contact2);
        contact3 = findViewById(R.id.contact3);
        contact4 = findViewById(R.id.contact4);
        contact5 = findViewById(R.id.contact5);


    }

    public void  btnBack (View view){
        Intent intentBack= new Intent(this, MainActivity.class);
        startActivity(intentBack);
    }

    public void btnSend(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            sendMessage();

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }
    }

    private void sendMessage() {
        String number, message;

        number = editNum.getText().toString().trim();
        message = editMessage.getText().toString().trim();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);

        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }



}


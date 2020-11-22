package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputId;
    EditText inputName;
    EditText inputAdd;
    Button btnInsert;
    Button btnDel;
    Button btnUpdate;
    Button btnView;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputId = findViewById(R.id.inputId);
        inputName = findViewById(R.id.inputName);
        inputAdd = findViewById(R.id.inputAdd);
        btnInsert = findViewById(R.id.btnInsert);
        btnDel = findViewById(R.id.btnDel);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnView = findViewById(R.id.btnView);
        db = new DBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext = inputId.getText() .toString();
                String nametext = inputName.getText() .toString();
                String addtext = inputAdd.getText() .toString();

             Boolean checkinsertdata = db.insertstudentdata(idtext,nametext,addtext);
             if (checkinsertdata==true)
                 Toast.makeText(MainActivity.this, "New Data was Inserted", Toast.LENGTH_SHORT).show();
             else
                 Toast.makeText(MainActivity.this, "New Data was not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext = inputId.getText() .toString();
                String nametext = inputName.getText() .toString();
                String addtext = inputAdd.getText() .toString();

                Boolean checkupdatedata = db.updatestudentdata(idtext,nametext,addtext);
                if (checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "Entry was Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entry not Updated", Toast.LENGTH_SHORT).show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext = inputId.getText() .toString();

                Boolean checkdeletedata = db.deletestudentdata(idtext);
                if (checkdeletedata==true)
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entry not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor view =db.getdata();
                if(view.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Data Available", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(view.moveToNext()){
                    buffer.append("Student ID :"+view.getString(0)+"\n");
                    buffer.append("Name :"+view.getString(1)+"\n");
                    buffer.append("Address :"+view.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Student Information");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
}
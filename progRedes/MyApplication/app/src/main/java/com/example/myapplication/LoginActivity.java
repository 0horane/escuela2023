package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {

    EditText mail;
    EditText pwd;
    Button loginbtn;

    Context tc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tc=this;

        mail = (EditText) findViewById(R.id.mailFIeld);
        pwd = (EditText) findViewById(R.id.pwdField);
        loginbtn = (Button) findViewById(R.id.buttonlog);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mail.getText().toString().contentEquals("crewmate@amogus.ar") && pwd.getText().toString().contentEquals("sus")){
                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(tc, "vien", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(tc, "incorredcti", Toast.LENGTH_LONG).show();

                }
            }
        });




    }
}
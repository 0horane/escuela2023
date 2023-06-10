package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calcButton;
    Button webButton;
    Button otraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcButton=(Button) findViewById(R.id.buttonCalc);
        otraButton=(Button) findViewById(R.id.buttonOtra);
        webButton=(Button) findViewById(R.id.buttonWeb);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), CalcActivity.class);
                startActivity(intent);
            }
        });


        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentweb=new Intent(Intent.ACTION_VIEW);
                intentweb.setData(Uri.parse("https://amogus.ar"));
                startActivity(intentweb);
            }
        });

        otraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), IDKActivity.class);
                startActivity(intent);
            }
        });

    }


}



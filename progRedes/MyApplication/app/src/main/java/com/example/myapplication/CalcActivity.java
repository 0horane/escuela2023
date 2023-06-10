
package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {


    EditText num1;
    EditText num2;
    Button sumarButton;
    Button restarButton;
    Button multiplicarButton;
    Button dividirButton;
    TextView resulttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        sumarButton = (Button) findViewById(R.id.sumarButton);
        restarButton = (Button) findViewById(R.id.restarButton);
        multiplicarButton = (Button) findViewById(R.id.multiplicarButton);
        dividirButton = (Button) findViewById(R.id.dividirButton);
        resulttxt = (TextView) findViewById(R.id.resultText);

        sumarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resulttxt.setText(String.valueOf(Float.parseFloat(num1.getText().toString())+Float.parseFloat(num2.getText().toString())));
            }
        });

        restarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resulttxt.setText(String.valueOf(Float.parseFloat(num1.getText().toString())-Float.parseFloat(num2.getText().toString())));
            }
        });

        multiplicarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resulttxt.setText(String.valueOf(Float.parseFloat(num1.getText().toString())*Float.parseFloat(num2.getText().toString())));
            }
        });

        dividirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resulttxt.setText(String.valueOf(Float.parseFloat(num1.getText().toString())/Float.parseFloat(num2.getText().toString())));
            }
        });

    }




}
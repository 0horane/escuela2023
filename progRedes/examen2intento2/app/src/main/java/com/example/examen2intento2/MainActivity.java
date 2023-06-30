package com.example.examen2intento2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ETpassword;
    private EditText ETusername;
    private TextView TVerror;
    private Button BTlogin;
    private Context ctx;
    int triesLeft=3;

    private static String CONTRASENIACORRECTA = "aBc12345";
    private static String USUARIOCORRECTO = "Gorje7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETpassword=findViewById(R.id.passwordTextview);
        ETusername=findViewById(R.id.usernameTextview);
        TVerror=findViewById(R.id.errorTextVew);
        BTlogin=findViewById(R.id.loginButton);
        ctx=this;


        BTlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario=ETusername.getText().toString();
                String contra=ETpassword.getText().toString();
                if (!(verificarCampo(usuario, 6) && verificarCampo(contra, 8))){
                    Toast toast= new Toast(ctx);
                    toast.setText("Nombre de usuario o contraseña no cumple con requisitos");
                    toast.show();
                    return;
                }
                if (usuario.contentEquals(USUARIOCORRECTO) && contra.contentEquals(CONTRASENIACORRECTA)){
                    Intent intent = new Intent(getApplicationContext(), ActivityCambioContrasenia.class);
                    startActivity(intent);
                } else {
                    triesLeft-=1;
                    if (triesLeft==0){
                        //BTlogin.setVisibility(View.INVISIBLE);
                        BTlogin.setEnabled(false);
                    }
                    TVerror.setText("Quedan " + String.valueOf(triesLeft)+ " intentos");
                    TVerror.setVisibility(View.VISIBLE);
                }


            }
        });

    }

    private Boolean verificarCampo(String campo, int minLongitud){
        if (campo.length()<minLongitud)
            return false;
        if (campo.contentEquals(campo.toLowerCase()))
            return false;
        for (int i=0;i<=9;i++){
            if (campo.contains(String.valueOf(i)))
                return true;
        }
        return false;
        //campo.toCharArray();
    }
}
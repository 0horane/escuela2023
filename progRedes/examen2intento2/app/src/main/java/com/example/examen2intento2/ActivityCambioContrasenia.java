package com.example.examen2intento2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityCambioContrasenia extends AppCompatActivity {

    Button submitbutton;
    EditText pwdfield1;
    EditText pwdfield2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_contrasenia);

        submitbutton = findViewById(R.id.sumbitButton);
        pwdfield1 = findViewById(R.id.RTpwd1);
        pwdfield2 = findViewById(R.id.ETpwd2);
        imageView = findViewById(R.id.imageView);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contra1=pwdfield1.getText().toString();
                String contra2=pwdfield2.getText().toString();
                if (!(verificarCampo(contra1, 8) && verificarCampo(contra2, 8))){
                    Toast toast= new Toast(getApplicationContext());
                    toast.setText("Nombre de usuario o contraseña no cumple con requisitos");
                    toast.show();
                    return;
                }
                if (pwdfield1.getText().toString().contentEquals(pwdfield2.getText().toString())){
                    imageView.setImageDrawable(getDrawable(R.drawable.happy));
                } else {
                    imageView.setImageDrawable(getDrawable(R.drawable.hmm));
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
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class IDKActivity extends AppCompatActivity implements SensorEventListener {

    Button calcButton;
    Button mainButton;
    TextView lightTXT;
    TextView accTXT;
    TextView distTXT;


    private SensorManager mSensorManager;
    private Sensor mSensorDist;
    private Sensor mSensorAcc;
    private Sensor mSensorLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idkactivity);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorDist = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorAcc = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mSensorManager.registerListener(this, mSensorDist, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mSensorAcc, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mSensorLight, SensorManager.SENSOR_DELAY_NORMAL);

        //ListView lv = (ListView) findViewById (R.id.lv);
        //List<Sensor> sensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        //lv.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1,  sensor));


        calcButton=(Button) findViewById(R.id.buttoncalc2);
        mainButton=(Button) findViewById(R.id.buttonmain2);
        lightTXT=(TextView) findViewById(R.id.lightTXT);
        distTXT=(TextView) findViewById(R.id.distTXT);
        accTXT=(TextView) findViewById(R.id.accTXT);



        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), CalcActivity.class);
                startActivity(intent);
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();

        // The sensorEvent object is reused across calls to onSensorChanged().
        // clone() gets a copy so the data doesn't change out from under us
        switch (sensorType) {
            case Sensor.TYPE_LIGHT:
                lightTXT.setText("Luz: "+String.valueOf(sensorEvent.values[0]));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                float[] tmp = sensorEvent.values.clone();
                accTXT.setText("Accelerometro:"+String.valueOf(tmp[0])+String.valueOf(tmp[1])+String.valueOf(tmp[2]));
                break;
            case Sensor.TYPE_PROXIMITY:
                distTXT.setText("Distancia: "+String.valueOf(sensorEvent.values[0]));
                break;
            default:
                return;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}








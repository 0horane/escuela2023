package com.example.requestejer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    RequestQueue mRequestQueue;
    StringRequest mStringRequest;
    JsonObjectRequest mJsonRequest;
    TextView resultContainer;

    String requestURL = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";

    Button requestButton;
    Button jsonRequestButton;

    LinearLayout containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestButton = findViewById(R.id.requestBtn);
        jsonRequestButton = findViewById(R.id.jsonRequestButton);
        resultContainer = findViewById(R.id.resultContainer);
        containerView = findViewById(R.id.linearLayout);


        mRequestQueue= Volley.newRequestQueue(this);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStringRequest = new StringRequest(Request.Method.GET, requestURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("d" , "recv request");
                        resultContainer.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("d" , "fail request");

                        Toast toast = Toast.makeText(getApplicationContext(), (CharSequence) "D:", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                mRequestQueue.add(mStringRequest);
            }
        });


        jsonRequestButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mJsonRequest = new JsonObjectRequest(Request.Method.GET, requestURL, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            for (Iterator key = response.keys(); key.hasNext();) {
                                Object name = null;
                                Object currentKey;
                                try {
                                    currentKey=key.next();
                                    name = response.get(currentKey.toString());

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                                addTextToListView(currentKey.toString());
                                addTextToListView(name.toString());
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    mRequestQueue.add(mJsonRequest);
                }
            }
        );




    }

    void addTextToListView(String text){
        TextView myTextView = new TextView(containerView.getContext());
        myTextView.setText(text);
        containerView.addView(myTextView);
    }

}
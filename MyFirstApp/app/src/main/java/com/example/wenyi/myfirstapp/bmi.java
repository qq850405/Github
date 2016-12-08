package com.example.wenyi.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class bmi extends AppCompatActivity {
    private EditText edWeight;
    private EditText edHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        edWeight =(EditText) findViewById(R.id.ed_weight);
        edHeight =(EditText) findViewById(R.id.ed_height);


    }


    public void bmi(View v){
        String w =edWeight.getText().toString();
        String h =edHeight.getText().toString();

        float weight =Float.parseFloat(w);
        float height =Float.parseFloat(h);
        float bmi =weight /(height*height);

        Toast.makeText(this,String.valueOf(bmi),Toast.LENGTH_LONG).show();


        new AlertDialog.Builder(this)
                .setMessage(bmi+" ")
                .setTitle("BMI")
                .setPositiveButton("OK",null)
                .setNeutralButton("Cancel",null)
                .show();
    }
}
    package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LogBtn = (Button) findViewById(R.id.LogBtn);
        Button SUBtn = (Button) findViewById(R.id.SUBtn);
        EditText ID, PW;
        ID = (EditText) findViewById(R.id.ID);
        PW = (EditText) findViewById(R.id.PW);
    }
}

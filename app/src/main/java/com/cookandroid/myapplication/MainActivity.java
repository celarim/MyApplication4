    package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        SUBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}

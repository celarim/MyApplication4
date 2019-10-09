package com.cookandroid.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button mksu = (Button) findViewById(R.id.MKSU);
        EditText mkid, mkpw, name, phone, address;
        mkid = (EditText) findViewById(R.id.MKID);
        mkpw = (EditText) findViewById(R.id.MKPW);
        name = (EditText)findViewById(R.id.Name);
        phone = (EditText) findViewById(R.id.Phone);
        address= (EditText) findViewById(R.id.Adrdess);

        mksu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }
}

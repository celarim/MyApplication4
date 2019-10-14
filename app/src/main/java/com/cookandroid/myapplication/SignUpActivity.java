package com.cookandroid.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.*;

public class SignUpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button ch = (Button) findViewById(R.id.check);
        Button mksu = (Button) findViewById(R.id.MKSU);
        final EditText mkid, mkpw, name, phone, address;
        mkid = (EditText) findViewById(R.id.MKID);
        mkpw = (EditText) findViewById(R.id.MKPW);
        name = (EditText)findViewById(R.id.Name);
        phone = (EditText) findViewById(R.id.Phone);
        address= (EditText) findViewById(R.id.Adrdess);
        final RadioGroup rg = findViewById(R.id.rg);

        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getFilesDir()+"/"+mkid.getText().toString()+".txt") ;
                if (!file.exists()){
                    mkid.setFocusable(false);
                    Toast.makeText(getApplicationContext(), "중복없음!",
                            Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getApplicationContext(), "중복, 다시입력!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        mksu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getFilesDir()+"/"+mkid.getText().toString()+".txt") ;

                if(!mkid.getText().toString().matches("") && !mkpw.getText().toString().matches("") && !file.exists() && rg.getCheckedRadioButtonId() == R.id.acp){
                    System.out.println(getFilesDir()+"/"+mkid.getText().toString()+".txt");
                    FileWriter fw = null ;
                    BufferedWriter bufwr = null;

                    try {
                        // open file.
                        fw = new FileWriter(file) ;
                        bufwr = new BufferedWriter(fw);

                        // write file.
                        bufwr.write(mkpw.getText().toString() + "\n");
                        bufwr.write(name.getText().toString());
                        bufwr.write(phone.getText().toString());
                        bufwr.write(address.getText().toString());

                        bufwr.close();
                        fw.close();

                        finish();

                    } catch (Exception e) {
                        e.printStackTrace() ;
                    }

                    // close file.
                    if (fw != null) {
                        // catch Exception here or throw.
                        try {
                            fw.close() ;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }



            }
        });
    }
}

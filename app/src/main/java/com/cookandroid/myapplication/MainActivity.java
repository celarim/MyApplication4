    package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button LogBtn = (Button) findViewById(R.id.LogBtn);
        Button SUBtn = (Button) findViewById(R.id.SUBtn);
        final EditText ID, PW;
        final TextView TV;
        ID = (EditText) findViewById(R.id.ID);
        PW = (EditText) findViewById(R.id.PW);
        TV = (TextView) findViewById(R.id.TV);

        SUBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SignUpActivity.class);
                startActivity(intent);
            }
        });
        LogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                File f = new File(getFilesDir()+"/"+ID.getText().toString()+".txt");
                if(f.exists()){
                    TV.setText(" ");
                    FileReader fr = null;
                    BufferedReader bufrd = null;
                    try {
                        // open file.
                        fr = new FileReader(f) ;
                        bufrd = new BufferedReader(fr) ;

                        // read 1 char from file.
                        String str = bufrd.readLine();

                        // close file.
                        bufrd.close() ;
                        fr.close() ;
                        boolean tmpt = str.equals(PW.getText().toString());
                        if (tmpt == true){
                            Intent intent = new Intent(getApplicationContext(),
                                    WorkActivity.class);
                            startActivity(intent);
                        }else{
                            TV.setText("비밀번호를 확인해주세요.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace() ;
                    }



                }
                else{
                    TV.setText("존재하지 않는 아이디 입니다. 회원가입해주세요.");
                }
            }
        });
    }
}

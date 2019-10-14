package com.cookandroid.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;

public class WorkActivity extends Activity {

    MediaPlayer m;

    Switch play;
    ImageView img1;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work);
        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        play = findViewById(R.id.PL);
        final RadioGroup music = findViewById(R.id.rgmusic);

        m = MediaPlayer.create(WorkActivity.this, R.raw.flower);

        music.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                             @Override
                                             public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                 play.setChecked(false);
                                                 m.stop();
                                                 if (music.getCheckedRadioButtonId() == R.id.FW){
                                                     img1.setVisibility(View.VISIBLE);
                                                     img2.setVisibility(View.INVISIBLE);
                                                 }else if(music.getCheckedRadioButtonId() == R.id.GI){
                                                     img2.setVisibility(View.VISIBLE);
                                                     img1.setVisibility(View.INVISIBLE);
                                                 }
                                             }
                                         });

                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (play.isChecked()) {
                            if (music.getCheckedRadioButtonId() == R.id.FW) {
                                m = MediaPlayer.create(WorkActivity.this, R.raw.flower);
                            } else if (music.getCheckedRadioButtonId() == R.id.GI) {
                                m = MediaPlayer.create(WorkActivity.this, R.raw.going);
                            }

                            m.start();
                        } else {
                            m.stop();
                            m.reset();
                        }
                    }
                });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(m != null){
            m.release();
            m = null;
        }
    }

}

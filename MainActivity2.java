package com.meaze.hashmao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageCover;
    TextView titleTv,descripTv;
    FloatingActionButton voice;
    TextToSpeech textToSpeech;

    public static String TITLE ="";
    public static String DESCRIPTION ="";
    public static Bitmap MYBITMAP =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageCover = findViewById(R.id.imageCover);
        titleTv = findViewById(R.id.titleTv);
        descripTv = findViewById(R.id.descripTv);
        voice = findViewById(R.id.voice);

        textToSpeech = new TextToSpeech(MainActivity2.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });

        titleTv.setText(TITLE);
        descripTv.setText(DESCRIPTION);

        if (MYBITMAP!=null) imageCover.setImageBitmap(MYBITMAP);

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text=descripTv.getText().toString();
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);



            }
        });




    }
}
package com.subaditya.encrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button shareBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        Intent intent=getIntent();
        String output= intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String type= intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        TextView textView=findViewById(R.id.tv_output);
        TextView codetype=findViewById(R.id.tv_codetype);
        textView.setText(output);
        codetype.setText(type);

        shareBtn=findViewById(R.id.share_btn);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, output);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent,null);
                startActivity(shareIntent);

            }
        });

    }

}
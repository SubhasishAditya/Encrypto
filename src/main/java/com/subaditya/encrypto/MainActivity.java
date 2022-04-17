package com.subaditya.encrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE ="Message " ;
    public static final String EXTRA_MESSAGE2 ="Message2 " ;
    private EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input=findViewById(R.id.et_input);
    }

    public void encrypt(View view) {
        String data=input.getText().toString();
        String value=" ";

        for (int i=0;i<data.length();i++){
            char ch=data.charAt(i);
            char ch2= (char) (ch-11);
             value=ch2+ value;
        }

        Intent intent = new Intent(this,Activity2.class);
        String output= value;
        String type="---Encrypted Text---";
        intent.putExtra(EXTRA_MESSAGE,output);
        intent.putExtra(EXTRA_MESSAGE2,type);
        startActivity(intent);
        System.out.print(output);

    }


    public void decrypt(View view) {

        String data=input.getText().toString();
        String value=" ";

        for (int i=0;i<data.length();i++){
            char ch=data.charAt(i);
            char ch2= (char) (ch+11);
            value=ch2+ value;
        }

        Intent intent = new Intent(this,Activity2.class);
        String output=value;
        String type="---Decrypted Text---";
        intent.putExtra(EXTRA_MESSAGE,output);
        intent.putExtra(EXTRA_MESSAGE2,type);
        startActivity(intent);
        System.out.print(output);

    }
}
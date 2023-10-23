package com.example.myapplication56;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bottonLogin= findViewById(R.id.button2);
        TextView helloUser = findViewById(R.id.textimg2);


        bottonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                helloUser.setText(R.string.newuserHello);

            }
        });
    }
}
package com.example.androidone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = findViewById(R.id.textView2);

        String message = getIntent().getStringExtra("mymessage");
        textView2.setText(message);
    }

    public void map(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}
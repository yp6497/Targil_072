package com.example.targil_072;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pitaron(View view) {
        Intent si=new Intent(this,pitaron.class);
        si.putExtra("a",12);
        startActivity(si);
    }
}
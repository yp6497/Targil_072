package com.example.targil_072;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String st1,st2,st3,x1,x2;
    TextView t1,t2;
    EditText ed1,ed2,ed3;
    float a,b,c;
    double ans1,ans2;
    //boolean isR=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
    }

    protected void OnActivityResult(int source, int good, @Nullable Intent data_back){
        if(data_back!=null){
            ans1=data_back.getDoubleExtra("a1",0);
            ans2=data_back.getDoubleExtra("a2",0);
            t1.setText("x1:"+ans1);
            t2.setText("x1:"+ans2);
        }

    }

    public void pitaron(View view) {

        st1 = ed1.getText().toString();
        st2 = ed2.getText().toString();
        st3 = ed3.getText().toString();
        if (st1.isEmpty() || st2.isEmpty() || st3.isEmpty()) {
            Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show();
        }
        else {
            a = Float.parseFloat(st1);
            b = Float.parseFloat(st2);
            c = Float.parseFloat(st3);
            Intent si = new Intent(this, pitaron.class);
            si.putExtra("a", a);
            si.putExtra("b", b);
            si.putExtra("c", c);
            startActivity(si);
        }
    }

    public void RandomN(View view) {
        Random rnd=new Random();
        a=(-100)+rnd.nextFloat()*(100-(-100));
        if(rnd.nextBoolean()) {
            a = a *-1;
        }
        b=(-100)+rnd.nextFloat()*(100-(-100));
        if(rnd.nextBoolean()) {
            b = b *-1;
        }
        c=(-100)+rnd.nextFloat()*(100-(-100));
        if(rnd.nextBoolean()) {
            c = c*-1;
        }

        ed1.setText(""+a);
        ed2.setText(""+b);
        ed3.setText(""+c);
    }
}
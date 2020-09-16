package com.example.targil_072;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class pitaron extends AppCompatActivity {

    float a,b,c,nos;
    double ans1,ans2;
    WebView wV;
    TextView t1,t2;
    String aS, bS, cS, url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitaron);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        wV=findViewById(R.id.wV);
        wV.getSettings().setJavaScriptEnabled(true);
        wV.setWebViewClient(new MyWebViewClient());

        pitaronn();
        hisov();

    }
    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView ww, String url) {
            ww.loadUrl(url);
            return true;
        }
    }

    private void hisov() {
        nos = (b * b) - 4 * a * c;
        if ((nos) < 0) {
            t1.setText("no answer");
            t2.setText("no answer");
        }
        else{
        ans1 = (-b - (Math.sqrt(nos))) / (2 * a);
        ans2 = (-b + (Math.sqrt(nos))) / (2 * a);
        t1.setText("x1=" + ans1);
        t2.setText("x2=" + ans2);
        }
    }

    public void pitaronn() {
        Intent gi=getIntent();
        a = gi.getFloatExtra("a", 1);
        b = gi.getFloatExtra("b", 1);
        c = gi.getFloatExtra("c", 1);
        aS = Float.toString(a);
        bS = Float.toString(b);
        cS = Float.toString(c);
        if (bS.isEmpty()) {
            url = "https://www.google.com/search?q=" + aS + "x%5E2%2B" + cS;
        } else if (cS.isEmpty()) {
            url = "https://www.google.com/search?q=" + aS + "x%5E2%2B" + bS + "x";
        }else if (bS.isEmpty() && cS.isEmpty()) {
            url = "https://www.google.com/search?q=" + aS + "x%5E2";
        }
        else {
            url = "https://www.google.com/search?q=" + aS + "x%5E2%2B" + bS + "x%2B"+cS;
        }
        wV.loadUrl(url);
    }

    public void returnn(View view) {
        Intent gi=getIntent();
        gi.putExtra("a1",ans1);
        gi.putExtra("a2",ans2);
        setResult(RESULT_OK,gi);
        finish();
    }
}
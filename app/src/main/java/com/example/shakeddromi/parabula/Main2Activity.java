package com.example.shakeddromi.parabula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    WebView wv;
    String stback;
    TextView anss1,anss2;
    double a,b,c,x1,x2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        wv=(WebView) findViewById(R.id.wv);
        anss1=(TextView) findViewById(R.id.anss1);
        anss2=(TextView) findViewById(R.id.anss2);

        wv.getSettings().setJavaScriptEnabled(true);
        String st="https://www.google.co.il/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=";
        Intent gi=getIntent();
        a=gi.getDoubleExtra("a",0);
        b=gi.getDoubleExtra("b",0);
        c=gi.getDoubleExtra("c",0);

        if((b*b-4*a*c)>=0) {
            if(Math.sqrt(b*b-4*a*c)==0) {
                x1=(-b)/(2*a);
                anss1.setText("x1="+x1);
                anss2.setText("");
                stback=anss1.getText().toString()+anss2.getText().toString();
                st=st+a+"x%5E2%2B"+b+"x%2B"+c;
                wv.loadUrl(st);
            }
            else {
                x1=(-b+Math.sqrt(b*b-4*a*c))/(2*a);
                anss1.setText("x1="+x1);
                x2=(-b-Math.sqrt(b*b-4*a*c))/(2*a);
                anss2.setText("x2="+x2);
                stback=anss1.getText().toString()+anss2.getText().toString();
                st=st + a + "x%5E2%2B" + b + "x%2B" + c + "&oq";
                wv.loadUrl(st);
            }
        }

        else {
            anss1.setText("there are no solutions");
            anss2.setText("");
            stback=anss1.getText().toString()+anss2.getText().toString();
        }
    }

    public void back(View view) {
        Intent si= new Intent(this,MainActivity.class);
        si.putExtra("st",stback);
        startActivity(si);
    }
}

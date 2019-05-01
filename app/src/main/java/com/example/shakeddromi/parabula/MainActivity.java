package com.example.shakeddromi.parabula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    TextView ans1,ans2;
    String st;
    double a,b,c,x;
    boolean bo=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        ans1=(TextView) findViewById(R.id.ans1);
        ans2=(TextView) findViewById(R.id.ans2);

        Intent gi=getIntent();
        ans1.setText("last answers: "+gi.getStringExtra("st"));
        if(gi.getStringExtra("st")==null) {
            ans1.setText("last answers:");
        }
    }

    public void solution(View view) {
        bo=true;
        st=et1.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
        else {
            a = Double.parseDouble(st);
        }
        st=et2.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
        else {
            b = Double.parseDouble(st);
        }
        st=et3.getText().toString();
        if(st.length()==0) {
            bo=false;
        }
        else {
            c = Double.parseDouble(st);
        }

        if(bo) {
            Intent si=new Intent(this,Main2Activity.class);
            si.putExtra("a",a);
            si.putExtra("b",b);
            si.putExtra("c",c);
            startActivity(si);
        }
        else {
            ans2.setText("try again...");
        }
    }

    public void erase(View view) {
        et1.setText("");
        et2.setText("");
        et3.setText("");
        ans2.setText("");
    }


    public void random(View view) {
        a=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            a=0-a;
        }
        et1.setText(""+a);
        b=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            b=0-b;
        }
        et2.setText(""+b);
        c=Math.random()*100;
        x=Math.random();
        if(x<0.5) {
            c=0-c;
        }
        et3.setText(""+c);
    }
}

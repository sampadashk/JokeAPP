package com.samiapps.kv.androidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String intentConst="intent_extra_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.andlib_main);
       TextView tv=(TextView)findViewById(R.id.disp_joke);
        Intent i=getIntent();
        String s=i.getStringExtra(MainActivity.intentConst);
        tv.setText(s);
    }
}

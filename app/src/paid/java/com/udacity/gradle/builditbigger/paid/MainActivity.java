package com.udacity.gradle.builditbigger.paid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.GCEJokeclass;
import android.app.ProgressDialog;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements GCEJokeclass.Callback{

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
    }
    public void jokeMethod(View view)
    {
        showDialog();
        new GCEJokeclass(this).execute();

    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
    @Override
    public void onFinished(String result) {
        hideDialog();
        Intent intent=new Intent(this, com.samiapps.kv.androidlib.MainActivity.class);
        intent.putExtra(com.samiapps.kv.androidlib.MainActivity.intentConst,result);
        startActivity(intent);

    }

}

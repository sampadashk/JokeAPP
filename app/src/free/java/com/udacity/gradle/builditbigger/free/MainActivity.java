package com.udacity.gradle.builditbigger.free;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.GCEJokeclass;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity implements GCEJokeclass.Callback {
    Button buttonjoke;
    InterstitialAd mItAd;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItAd = new InterstitialAd(this);
        mItAd.setAdUnitId(getResources().getString(R.string.institial_ad));


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdRequest adRequest1 = new AdRequest.Builder().build();
        mItAd.loadAd(adRequest1);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);    buttonjoke = (Button) findViewById(R.id.button_joke);
        buttonjoke.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View view) {
                                             if(mItAd.isLoaded()) {
                                                 mItAd.show();
                                                 mItAd.setAdListener(new AdListener() {
                                                     @Override
                                                     public void onAdClosed() {
                                                         pDialog.setMessage("Loading");
                                                         showDialog();
                                                         tellJoke();
                                                     }
                                                 });
                                             }
                                             else {
                                                 tellJoke();
                                             }}
                                     }
        );
        

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke() {
        new GCEJokeclass(this).execute();

        // Toast.makeText(this, JavaJokes.getJoke(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onFinished(String result) {
        hideDialog();
        Intent intent=new Intent(this, com.samiapps.kv.androidlib.MainActivity.class);
        intent.putExtra(com.samiapps.kv.androidlib.MainActivity.intentConst,result);
        startActivity(intent);

    }
}

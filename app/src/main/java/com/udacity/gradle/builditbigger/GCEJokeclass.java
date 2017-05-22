package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.kv.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by KV on 21/5/17.
 */

public class GCEJokeclass extends AsyncTask<Void,Void,String> {
    private static MyApi myApiService = null;
    private Callback callback;

    public interface Callback{
        void onFinished(String result);
    }

    public GCEJokeclass(Callback callback){
        this.callback = callback;
    }
    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokeproj.appspot.com/_ah/api/") ;//for preventing misuse of url https://joke-142409.appspot.com/_ah/api/

            myApiService = builder.build();
        }
        try {
            return myApiService.getJokeFromLib().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result) {
        if(result != null){
            callback.onFinished(result);
        }
    }
}

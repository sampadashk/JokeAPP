package com.samiapps.kv.jokeapp;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.GCEJokeclass;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;

/**CE
 * Created by KV on 23/5/17.
 */
@RunWith(AndroidJUnit4.class)
public class TestJokeFetch  {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        GCEJokeclass gce = new GCEJokeclass(new GCEJokeclass.Callback() {
            @Override
            public void onFinished(String result) {

            }
        });
        gce.execute();
        String joke = gce.get();
        assertNotNull(joke);
    }



    }


package com.maxi.waterpurifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread delayThread = new Thread(this);
        delayThread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        finish();
        startActivity(new Intent(this, NaviActivity.class));
    }
}

package com.gmail.jloveraulecia.appdein.Views;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.gmail.jloveraulecia.appdein.R;

public class MainActivity extends AppCompatActivity {

    private static final String ICON_ACTIVITY_TAG = MainActivity.class.getSimpleName();


    private void showLog(String text){

        Log.d(ICON_ACTIVITY_TAG, text);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){

        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        showLog("Activity created");
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent listIntent = new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(listIntent);
                finish();
            }
        },5000);
    }

    @Override

    protected void onRestart(){

        super.onRestart();//call to restart after onStop

        showLog("Activity restarted");

    }

    @Override

    protected void onStart() {

        super.onStart();//soon be visible

        showLog("Activity started");

    }

    @Override

    protected void onResume() {

        super.onResume();//visible

        showLog("Activity resumed");

    }

    @Override

    protected void onPause() {

        super.onPause();//invisible

        showLog("Activity paused");

    }

    @Override

    protected void onStop() {

        super.onStop();

        showLog("Activity stopped");

    }

    @Override

    protected void onDestroy() {

        super.onDestroy();

        showLog("Activity is being destroyed");

    }
}

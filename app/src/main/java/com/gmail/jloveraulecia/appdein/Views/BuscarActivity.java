package com.gmail.jloveraulecia.appdein.Views;

import android.content.Intent;
import android.os.Bundle;

import com.gmail.jloveraulecia.appdein.R;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

public class BuscarActivity extends AppCompatActivity {
    private static final String LIST_SEARCH_TAG = BuscarActivity.class.getSimpleName();

    private void showLog(String text){

        Log.d(LIST_SEARCH_TAG, text);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
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

        Intent ListIntent = new Intent(BuscarActivity.this, ListadoActivity.class);
        startActivity(ListIntent);
        finish();

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

package com.gmail.jloveraulecia.appdein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ListadoActivity extends AppCompatActivity {
    private static final String LIST_ACTIVITY_TAG = ListadoActivity.class.getSimpleName();
    private Button button;

    private void showLog(String text){

        Log.d(LIST_ACTIVITY_TAG, text);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormularioActivity();
            }
        });
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish()
        ;
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }
    public void openFormularioActivity(){
        Intent formIntent = new Intent(ListadoActivity.this, FormularioActivity.class);
        startActivity(formIntent);
        finish();
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

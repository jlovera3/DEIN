package com.gmail.jloveraulecia.appdein;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FormularioActivity extends AppCompatActivity {
    private static final String FORM_ACTIVITY_TAG = FormularioActivity.class.getSimpleName();
    private Button button;
    private Spinner mySpinner;
    private void showLog(String text){
        Log.d(FORM_ACTIVITY_TAG, text);
    }

    /* Solucion de Rafa
    TextInputEditText nombreEditText = (TextInputEditText) findViewById(R.id.nombreDeLaVariable);
    nombreEditText.setOnFocusChange(new View.onFocusChangedListenner);
    @Override
    public void onFocusChanged(View v, boolean hasFocus ){
        if(!=hasFocus){
            EditText et = (EditText);
            if(et.getText().toString()){
                TextInputLayout
                nombreInputLayout
            }else{

            }
        }
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        this.getSupportActionBar().setTitle("Formulario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartListadoActivity();
            }
        });
        mySpinner = (Spinner) findViewById(R.id.spinner);
        //aqui habria que hacer algo con el codigo para modificar el Spinner.
    }

    @Override
    public void onBackPressed(){
        Intent formIntent = new Intent(FormularioActivity.this, ListadoActivity.class);
        startActivity(formIntent);
        finish();
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }


    public void restartListadoActivity(){
        Intent ListIntent = new Intent(FormularioActivity.this, ListadoActivity.class);
        startActivity(ListIntent);
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

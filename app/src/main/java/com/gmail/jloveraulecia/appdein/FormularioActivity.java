package com.gmail.jloveraulecia.appdein;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity {

    private static final String FORM_ACTIVITY_TAG = FormularioActivity.class.getSimpleName();

    private String[] telefonos;
    private Button button;
    private Spinner mySpinner;
    private ImageButton bfecha;
    private EditText textFecha;
    private int dia;
    private int mes;
    private int ano;
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

        //Spinner
        mySpinner = (Spinner)findViewById(R.id.spinner) ;
        String [] opciones = {"Telefono 1", "Telefono 2","Telefono 3","..."};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        mySpinner.setAdapter(adapter);

        /*
        mySpinner = (Spinner) findViewById(R.id.spinner);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });*/

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartListadoActivity();
            }
        });
        TextInputEditText nombreEditText = (TextInputEditText) findViewById(R.id.editText2);
        nombreEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    Log.d("AppCRUD", et.getText().toString());
                    if (et.getText().toString().startsWith("rafa")) {
                        TextInputLayout nombreInputLayout = (TextInputLayout) findViewById(R.id.textInputNombre);
                        nombreInputLayout.setError("Nombre incorrecto");
                    } else {
                        TextInputLayout nombreInputLayout = (TextInputLayout) findViewById(R.id.textInputNombre);
                        nombreInputLayout.setError("");
                    }
                }
            }
        });
        TextInputEditText emailEditText = (TextInputEditText) findViewById(R.id.editText);
        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    Log.d("AppCRUD", et.getText().toString());
                    if (!et.getText().toString().contains("@")) {
                        TextInputLayout mailInputLayout = (TextInputLayout) findViewById(R.id.textInputEmail);
                        mailInputLayout.setError("Email tiene que tener @");
                    } else {
                        TextInputLayout mailInputLayout = (TextInputLayout) findViewById(R.id.textInputEmail);
                        mailInputLayout.setError("");
                    }
                }
            }
        });
        TextInputEditText contEditText = (TextInputEditText) findViewById(R.id.editText3);
        contEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    Log.d("AppCRUD", et.getText().toString());
                    if (et.getText().toString().length()<6) {
                        TextInputLayout contInputLayout = (TextInputLayout) findViewById(R.id.textInputContra);
                        contInputLayout.setError("Al menos 6 caracteres");
                    } else {
                        TextInputLayout contInputLayout = (TextInputLayout) findViewById(R.id.textInputContra);
                        contInputLayout.setError("");
                    }
                }
            }
        });


        bfecha = (ImageButton) findViewById((R.id.fechaButtom)) ;
        textFecha = (EditText)findViewById(R.id.editTextFecha) ;
        bfecha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Calendar c = Calendar.getInstance();
                dia = 1;
                mes = 1;
                ano = 1900;

                DatePickerDialog datePickerDialog = new DatePickerDialog(FormularioActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },dia,mes,ano);
                datePickerDialog.show();
            }
        });

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

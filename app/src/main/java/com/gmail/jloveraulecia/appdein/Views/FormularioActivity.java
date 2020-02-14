package com.gmail.jloveraulecia.appdein.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.gmail.jloveraulecia.appdein.Interfaces.FormularioInterface;
import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Presenter.FormularioPresenter;
import com.gmail.jloveraulecia.appdein.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity implements FormularioInterface.View {
    final private int CODE_READ_EXTERNAL_STORAGE_PERMISSION=123;
    public FormularioPresenter presentador;
    public static final int RESULT_GALLERY = 0;
    private Context myContext;

    private static final String FORM_ACTIVITY_TAG = FormularioActivity.class.getSimpleName();
    ConstraintLayout layout;
    private String[] telefonos;
    private Button button;
    private Spinner mySpinner;
    private ImageButton bfecha;
    private ImageButton bImagen;
    private EditText textFecha;
    private int dia;
    private int mes;
    private int ano;
    private void showLog(String text){
        Log.d(FORM_ACTIVITY_TAG, text);
    }

    //cosas que deberian ir en el presentador para abrir la galeria
    private static final int REQUEST_SELECT_IMAGE = 201;
    final String pathFotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/demoAndroidImages/";
    private Uri uri;

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
        layout=findViewById(R.id.Layout);

        presentador = new FormularioPresenter(this);
        myContext=this;

        //Spinner
        mySpinner = (Spinner)findViewById(R.id.spinner) ;
        String [] opciones = {"Telefono 1", "Telefono 2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        mySpinner.setAdapter(adapter);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //primero vemos si los datos están validados
                Person person=null;

                //segundo llamamos a registrar usuario o a editarlo
                presentador.registrarPersonSQL(myContext, person);

                //Mostramos un Toast si se ha añadido correctamente

                //tercero volvemos a la actividad listado PERO NO COMO VIENE ABAJO
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


        //Boton de acceso a la galería. Llama al presentador para que acceda a los permisos.
        bImagen = findViewById(R.id.imageButton);
        bImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador.onClickImage(myContext);
                selectPicture();
            }
        });


        //POR SI SE PASAN DATOS EN EL INTENT
        try{
            String user=getIntent().getStringExtra("user");
            String email=getIntent().getStringExtra("email");
            emailEditText.setText(email);
            nombreEditText.setText(user);
        }catch(Exception e){

        }

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
    public void setDatos(int id, String user, String email){
        TextInputEditText emailEditText = findViewById(R.id.editText);
        emailEditText.setText(email);

        TextInputEditText nombreEditText = findViewById(R.id.editText2);
        nombreEditText.setText(user);
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

    @Override
    public void lanzarError() {

    }

    @Override
    public void requestPermission() {
        ActivityCompat.requestPermissions(
                FormularioActivity.this,
                new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE},
                CODE_READ_EXTERNAL_STORAGE_PERMISSION);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        int resultado=0;
        switch (requestCode) {
            case CODE_READ_EXTERNAL_STORAGE_PERMISSION:
                resultado=presentador.resultPermission(grantResults[0]);
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        if(resultado==1){
            showLog("AAAAAAAAAAAAAAAAAAAAAAAA");
            Snackbar.make(layout, "Acceso a la galería denegado", Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void launchGallery() {

    }



    private void selectPicture(){
        // Se le pide al sistema una imagen del dispositivo
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, getResources().getString(R.string.choose_picture)),
                REQUEST_SELECT_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bmp=presentador.modifyImage(requestCode,resultCode,data, myContext);

        // Se carga el Bitmap en el ImageView
        ImageView imageView = findViewById(R.id.imageView);
        if(bmp!=null) {
            imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, 80, 80, false));
        }
    }
}

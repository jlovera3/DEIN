package com.gmail.jloveraulecia.appdein.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
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
import android.widget.Toast;

import com.gmail.jloveraulecia.appdein.Interfaces.FormularioInterface;
import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Presenter.FormularioPresenter;
import com.gmail.jloveraulecia.appdein.Presenter.SQlitePresenter;
import com.gmail.jloveraulecia.appdein.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity implements FormularioInterface.View {
    final private int CODE_READ_EXTERNAL_STORAGE_PERMISSION=123;
    public FormularioPresenter formPresentador;
    public static final int RESULT_GALLERY = 0;
    private Context myContext=this;

    private static final String FORM_ACTIVITY_TAG = FormularioActivity.class.getSimpleName();
    ConstraintLayout layout;
    private String[] telefonos;
    private EditText textFecha;
    private int dia;
    private int mes;
    private int ano;
    private TextInputEditText nombreEditText, emailEditText, contEditText;

    //cosas que deberian ir en el presentador para abrir la galeria
    private static final int REQUEST_SELECT_IMAGE = 201;
    final String pathFotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/demoAndroidImages/";
    private Uri uri;


    public boolean valido1, valido2, valido3;
    public String nombre, emai, cont;
    public Person person=new Person();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        this.getSupportActionBar().setTitle("Formulario");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        layout=findViewById(R.id.Layout);

        formPresentador = new FormularioPresenter(this);

        SQlitePresenter conn= new SQlitePresenter(this, "db_person", null, 1);

        //Spinner
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String [] opciones = {"Telefono 1", "Telefono 2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        mySpinner.setAdapter(adapter);

        //MÉTODO PARA INICIAR LISTENERS DE LOS EDITTEXT
        iniciarValidaciones();


        //POR SI SE PASAN DATOS EN EL INTENT
        try{
            int id=getIntent().getIntExtra("id",0);
            String user=getIntent().getStringExtra("user");
            String email=getIntent().getStringExtra("email");
            Log.d("PRUEBA", "nombre"+user+"email"+email);
            emailEditText.setText(email);
            nombreEditText.setText(user);
        }catch(Exception e){

        }

        //METODO PARA BOTÓN GUARDAR USUARIO

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //primero vemos si los datos están validados
                Person person=new Person();
                if(valido1 && valido2 && valido3){
                    ImageView imageView = findViewById(R.id.imageView);
                    person.setImage(imageView.toString());
                    if(person.getId()==null) {
                        //segundo llamamos a registrar usuario o a editarlo
                        formPresentador.registrarPerson(myContext, person);
                    }else{
                        formPresentador.actualizarPersonSQL(myContext, person);
                    }

                    //Mostramos un Toast si se ha añadido correctamente O HACEMOS UN METODO QUE SE LLAME DESDE PRESENTER

                    //tercero volvemos a la actividad listado PERO NO Con restartListadoActivity();
                    restartListadoActivity();

                }else{
                    //MOSTRAT UN TOAST QUE DIGA QUE LOS DATOS SON INCORRECTOS
                    Log.d("Validacion?"," "+valido1+", "+valido2+", "+valido3);
                    Toast.makeText(myContext, "Los datos no son válidos", Toast.LENGTH_SHORT).show();
                }
                //registrar(layout.getViewById(R.layout.activity_formulario));
            }
        });

    }

    private void iniciarValidaciones() {
        nombreEditText = (TextInputEditText) findViewById(R.id.editText2);
        nombreEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                TextInputLayout nombreInputLayout = (TextInputLayout) findViewById(R.id.textInputNombre);
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    valido1=person.setUser(et.toString());
                    if(valido1==false) {
                        nombreInputLayout.setError("Nombre vacío");
                    } else {
                        nombreInputLayout.setError("");
                    }
                }
            }
        });

        emailEditText = (TextInputEditText) findViewById(R.id.editText);
        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                TextInputLayout mailInputLayout = (TextInputLayout) findViewById(R.id.textInputEmail);
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    valido2=person.setEmail(et.getText().toString());
                    if (valido2==false) {
                        mailInputLayout.setError("Email tiene que tener @");
                    } else {
                        mailInputLayout.setError("");
                    }
                }
            }
        });

        contEditText = (TextInputEditText) findViewById(R.id.editText3);
        contEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                TextInputLayout contInputLayout = (TextInputLayout) findViewById(R.id.textInputContra);
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    valido3=person.setPassword(et.getText().toString());
                    if (valido3==false) {
                        contInputLayout.setError("Al menos 6 caracteres");
                    } else {
                        contInputLayout.setError("");
                        valido3=true;
                    }
                }
            }
        });



        ImageButton bfecha = (ImageButton) findViewById((R.id.fechaButtom));
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
        ImageButton bImagen = findViewById(R.id.imageButton);
        bImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formPresentador.onClickImage(myContext);
                selectPicture();
            }
        });


    }

    public void registrar(View view){
        SQlitePresenter admin= new SQlitePresenter(this, "db_person", null, 1);
        SQLiteDatabase db= admin.getWritableDatabase();

        nombre = nombreEditText.getText().toString();
        emai = emailEditText.getText().toString();
        cont = contEditText.getText().toString();

        if(valido1 && valido2 && valido3){
            ContentValues registro= new ContentValues();
            registro.put("usuario", nombre);
            registro.put("email", emai);
            registro.put("password", cont);
            db.insert("usuarios", null, registro);

            db.close();

            nombreEditText.setText("");
            emailEditText.setText("");
            contEditText.setText("");
            Toast.makeText(myContext, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(myContext, "Los datos no son válidos", Toast.LENGTH_SHORT).show();
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
                resultado=formPresentador.resultPermission(grantResults[0]);
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
        Bitmap bmp=formPresentador.modifyImage(requestCode,resultCode,data, myContext);

        // Se carga el Bitmap en el ImageView
        ImageView imageView = findViewById(R.id.imageView);
        if(bmp!=null) {
            imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, 80, 100, false));
            person.setImage(bmp.toString());
        }

    }

    private void showLog(String text){
        Log.d(FORM_ACTIVITY_TAG, text);
    }

    public void initWithParams(Person person){
        if(person!=null){
            try{
                emailEditText.setText(person.getEmail());
                nombreEditText.setText(person.getUser());
            }catch(Exception e){
                Log.d("Error", e.toString());
            }
        }
    }
}

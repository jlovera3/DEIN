package com.gmail.jloveraulecia.appdein.Views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
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
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.Presenter.FormularioPresenter;
import com.gmail.jloveraulecia.appdein.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity implements FormularioInterface.View {
    final private int CODE_READ_EXTERNAL_STORAGE_PERMISSION=123;
    public FormularioPresenter formPresentador;
    public static final int RESULT_GALLERY = 0;
    private Context myContext=this;
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;

    private static final String FORM_ACTIVITY_TAG = FormularioActivity.class.getSimpleName();
    ConstraintLayout layout;
    private String[] telefonos;
    private EditText textFecha;
    private int dia;
    private int mes;
    private int ano;
    private TextInputEditText nombreEditText, emailEditText, contEditText;
    private EditText tel1EditText, tel2EditText, fechaEditText;
    private ImageButton bImagen;

    //cosas que deberian ir en el presentador para abrir la galeria
    private static final int REQUEST_SELECT_IMAGE = 201;
    final String pathFotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/demoAndroidImages/";
    private Uri uri;


    public boolean valido1=true, valido2=true, valido3=true, valido4=true;
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

        //MÉTODO PARA INICIAR LISTENERS DE LOS EDITTEXT Y SUS VALIDACIONES
        iniciarValidaciones();

        //MÉTODO PARA INICIAR LISTENER DE BOTONES GUARDAR/ACTUALIZAR/ELIMINAR
        iniciarListenerBotones();

        //POR SI SE PASAN DATOS EN EL INTENT, SE RECIBEN ASI:
        try{
            int id=getIntent().getIntExtra("id",0);
            String user=getIntent().getStringExtra("user");
            String email=getIntent().getStringExtra("email");
            String password=getIntent().getStringExtra("password");
            int telef1=getIntent().getIntExtra("telef1",0);
            int telef2=getIntent().getIntExtra("telef2",0);
            String fecha=getIntent().getStringExtra("fecha");
            emailEditText.setText(user);
            nombreEditText.setText(email);
            contEditText.setText(password);
            tel1EditText = (EditText) findViewById(R.id.editText4);
            tel1EditText.setText(""+telef1);
            mySpinner.setAdapter(adapter);
            fechaEditText.setText(fecha);

            String image=getIntent().getStringExtra("image");
            byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ImageView iv1 = findViewById(R.id.imageView);
            iv1.setImageBitmap(decodedByte);

        }catch(Exception e){

        }




    }

    private void iniciarListenerBotones() {

        //METODO PARA BOTÓN GUARDAR USUARIO

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //primero vemos si los datos están validados
                Person person=new Person();
                if(valido1 && valido2 && valido3 ){
                    ImageView iv1 = findViewById(R.id.imageView);

                    iv1.buildDrawingCache();
                    Bitmap bitmap = iv1.getDrawingCache();
                    ByteArrayOutputStream stream=new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
                    byte[] image=stream.toByteArray();
                    String img_str = Base64.encodeToString(image, 0);

                    person.setImage(img_str);
                    person.setUser(nombreEditText.getText().toString());
                    person.setEmail(emailEditText.getText().toString());
                    person.setPassword(contEditText.getText().toString());
                    person.setFecha(textFecha.getText().toString());
                    /*try {
                        person.setTelef1(Integer.parseInt(tel1EditText.getText().toString()));
                    }catch (NullPointerException e){
                        Log.d(FORM_ACTIVITY_TAG, e.toString());
                    }*/
                    if(person.getId()==null) {
                        //segundo llamamos a registrar usuario o a editarlo
                        formPresentador.registrarPerson(myContext, person);
                    }

                    //Mostramos un Toast si se ha añadido correctamente O HACEMOS UN METODO QUE SE LLAME DESDE PRESENTER
                    Toast.makeText(myContext, "Introducido correctamente", Toast.LENGTH_SHORT).show();
                    //tercero volvemos a la actividad listado
                    restartListadoActivity();

                }else{
                    //MOSTRAT UN TOAST QUE DIGA QUE LOS DATOS SON INCORRECTOS
                    Log.d("Validacion?"," "+valido1+", "+valido2+", "+valido3);
                    Toast.makeText(myContext, "Los datos no son válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //LISTENER Y LLAMADA AL METODO UPDATE SI SE PULSA ACTULIZAR
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getIntExtra("id", 0) != 0) {
                    Person person = new Person();
                    int id = getIntent().getIntExtra("id", 0);
                    ArrayList<Person> people = formPresentador.getAllPerson(myContext);
                    for (int i = 0; i < people.size(); i++) {
                        if (id == people.get(i).getId()) {
                            person = people.get(i);
                        }
                    }

                    //vemos si los datos están validados
                    if (valido1 && valido2 && valido3) {
                        ImageView iv1 = findViewById(R.id.imageView);

                        iv1.buildDrawingCache();
                        Bitmap bitmap = iv1.getDrawingCache();
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
                        byte[] image = stream.toByteArray();
                        String img_str = Base64.encodeToString(image, 0);

                        person.setImage(img_str);
                        person.setUser(nombreEditText.getText().toString());
                        person.setEmail(emailEditText.getText().toString());
                        person.setPassword(contEditText.getText().toString());
                        person.setFecha(textFecha.getText().toString());
                        try {
                            person.setTelef1(Integer.parseInt(tel1EditText.getText().toString()));
                        }catch (NullPointerException e){
                            Log.d(FORM_ACTIVITY_TAG, "No se ha recogido el telefono por algun error");
                        }

                        formPresentador.actualizarPersonSQL(person, myContext);

                        //Mostramos un Toast si se ha añadido correctamente O HACEMOS UN METODO QUE SE LLAME DESDE PRESENTER
                        Toast.makeText(myContext, "Actualizado correctamente", Toast.LENGTH_SHORT).show();
                        //tercero volvemos a la actividad listado
                        restartListadoActivity();

                    } else {
                        //MOSTRAT UN TOAST QUE DIGA QUE LOS DATOS SON INCORRECTOS
                        Log.d("Validacion?", " " + valido1 + ", " + valido2 + ", " + valido3);
                        Toast.makeText(myContext, "Los datos no son válidos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(myContext, "No puedes actualizar un registro nuevo", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //LISTENER Y LLAMADA AL METODO DELETE SI SE PULSA ELIMINAR
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getIntent().getIntExtra("id", 0) != 0) {
                    Person person = new Person();
                    int id = getIntent().getIntExtra("id", 0);
                    ArrayList<Person> people = formPresentador.getAllPerson(myContext);
                    for (int i = 0; i < people.size(); i++) {
                        if (id == people.get(i).getId()) {
                            person = people.get(i);
                        }
                    }

                    try {
                        final Person finalPerson = person;
                        new AlertDialog.Builder(myContext)
                            .setTitle("ELIMINAR USUARIO")
                            .setMessage("¿Estás seguro que deseas eliminar este usuario?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                    //Lo elimina de la base de datos

                                    formPresentador.deletePersonSQL(finalPerson, myContext);
                                    Toast.makeText(myContext, "Elimniado correctamente", Toast.LENGTH_SHORT).show();
                                    //volvemos a la actividad listado
                                    restartListadoActivity();
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    }catch (NullPointerException e){
                        Log.d(FORM_ACTIVITY_TAG, e.toString());
                    }


                }else{
                    setFieldsToEmpty();
                }
            }
        });
    }

    private void setFieldsToEmpty() {
        emailEditText.setText("");
        nombreEditText.setText("");
        contEditText.setText("");
        tel1EditText.setText("");
    }


    private void iniciarValidaciones() {

        //Spinner
        mySpinner = (Spinner) findViewById(R.id.spinner);
        String [] opciones = {"Telefono1","Telefono2"};

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        mySpinner.setAdapter(adapter);


        nombreEditText = (TextInputEditText) findViewById(R.id.editText2);
        nombreEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                TextInputLayout nombreInputLayout = (TextInputLayout) findViewById(R.id.textInputNombre);
                if (!hasFocus) {
                    TextInputEditText et = (TextInputEditText) v;
                    valido1=person.setUser(et.getText().toString());
                    if(!valido1) {
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
                    if (!valido2) {
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
                    if (!valido3) {
                        contInputLayout.setError("Al menos 6 caracteres");
                    } else {
                        contInputLayout.setError("");
                        valido3=true;
                    }
                }
            }
        });
        tel1EditText = (EditText) findViewById(R.id.editText4);
        tel1EditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                TextInputLayout telefInputLayout = (TextInputLayout) findViewById(R.id.textInputTelef);
                if (!hasFocus) {
                    EditText et = (EditText) v;
                    valido4=person.setPassword(et.getText().toString());
                    if (!valido4) {
                        telefInputLayout.setError("Al menos 9 números");
                    } else {
                        telefInputLayout.setError("");
                        valido4=true;
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
                    @SuppressLint("SetTextI18n")
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
                formPresentador.onClickImage(myContext);
                selectPicture();
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
            imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, 80, 80, false));
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

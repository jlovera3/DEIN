package com.gmail.jloveraulecia.appdein.Presenter;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.gmail.jloveraulecia.appdein.Interfaces.FormularioInterface;
import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.R;
import com.gmail.jloveraulecia.appdein.Views.FormularioActivity;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class FormularioPresenter implements FormularioInterface.Presenter {
    private static final int REQUEST_SELECT_IMAGE = 201;
    final String pathFotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/demoAndroidImages/";
    private Uri uri;
    private FormularioInterface.View view;
    private PersonModel conn;


    public FormularioPresenter(FormularioInterface.View view){
        this.view=view;
    }

    @Override
    public void registrarPerson(Context context, Person person){
        conn= new PersonModel(context, "DBUsuarios", null, 1);
        conn.registrarPerson(context,person);
    }


    public void actualizarPersonSQL(Person person, Context myContext) {
        conn= new PersonModel(myContext, "DBUsuarios", null, 1);
        conn.actualizarPersonSQL(person, myContext);
    }


    public void deletePersonSQL(Person person, Context myContext) {
        conn= new PersonModel(myContext, "DBUsuarios", null, 1);
        conn.deletePersonSQL(person,myContext);
    }

    public ArrayList<Person> getAllPerson(Context myContext){
        conn= new PersonModel(myContext, "DBUsuarios", null, 1);
        return conn.getAllPerson(myContext);
    }


    @Override
    public void onFocusChange(FormularioInterface.View v, boolean hasFocus) {

    }

    @Override
    public void onClickImage(Context myContext) {
        int ReadPermission= ContextCompat.checkSelfPermission(myContext, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (ReadPermission != PackageManager.PERMISSION_GRANTED) {
            // Permiso denegado
            view.requestPermission();
        }else{
            view.launchGallery();
        }
    }

    @Override
    public int resultPermission(int resultado) {
        int result=0;
        if (resultado == PackageManager.PERMISSION_GRANTED) {
            // Permiso aceptado
            Log.d("appdein", "permiso aceptado");
        } else {
            // Permiso rechazado
            Log.d("appdein", "permiso rechazado");
            result=1;
        }
        return result;
    }

    @Override
    public Bitmap modifyImage(int requestCode, int resultCode, Intent data, Context myContext) {
        Bitmap bmp=null;
        switch (requestCode) {
            case (REQUEST_SELECT_IMAGE):
                if (resultCode == Activity.RESULT_OK) {
                    // Se carga la imagen desde un objeto Bitmap
                    Uri selectedImage = data.getData();
                    String selectedPath = selectedImage.getPath();

                    if (selectedPath != null) {
                        // Se leen los bytes de la imagen
                        InputStream imageStream = null;
                        try {
                            imageStream = myContext.getContentResolver().openInputStream(selectedImage);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        // Se transformam los bytes de la imagen a un Bitmap
                        bmp = BitmapFactory.decodeStream(imageStream);

                    }
                }
                break;
        }
        return bmp;
    }



}

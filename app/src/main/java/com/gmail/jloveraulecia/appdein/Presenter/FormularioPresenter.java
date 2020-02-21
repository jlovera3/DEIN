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
import com.gmail.jloveraulecia.appdein.R;
import com.gmail.jloveraulecia.appdein.Views.FormularioActivity;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class FormularioPresenter implements FormularioInterface.Presenter {
    private static final int REQUEST_SELECT_IMAGE = 201;
    final String pathFotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/demoAndroidImages/";
    private Uri uri;
    private FormularioInterface.View view;


    public FormularioPresenter(FormularioInterface.View view){
        this.view=view;
    }

    @Override
    public void registrarPerson(Context context, Person person){

        SQlitePresenter conn= new SQlitePresenter(context, "DBUsuarios", null, 1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put("nombre", person.getUser());
        values.put("email", person.getEmail());
        values.put("password", person.getPassword());
        values.put("telef1", person.getTelef1());
        values.put("telef2",person.getTelef2());
        values.put("image", person.getImage());

        db.insert("Usuarios", null, values);

        Toast.makeText(context, "Insertado correctamente", Toast.LENGTH_SHORT).show();

        db.close();
    }


    /*public void registrarPersonSQL(Context context, Person person){
        SQlitePresenter conn= new SQlitePresenter(context, "DBUsuarios", null, 1);
        SQLiteDatabase db=conn.getWritableDatabase();

        String insert="INSERT INTO Usuarios (nombre, email, password, telef1, telef2, image) VALUES" +
                " ('"+person.getUser()+"','"+person.getEmail()+"','"+person.getPassword()+"',"+person.getTelef1()+","+person.getTelef2()+",'"+person.getImage()+"');";

        db.execSQL(insert);

        db.close();
    }*/

    public void actualizarPersonSQL(Person person, Context myContext) {
        SQlitePresenter conexion= new SQlitePresenter(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conexion.getWritableDatabase();

        try {
            //Establecemos los campos-valores a actualizar
            ContentValues valores = new ContentValues();
            valores.put("nombre",person.getUser());
            valores.put("email", person.getEmail());
            valores.put("password", person.getPassword());
            valores.put("telef1", person.getTelef1());
            valores.put("image", person.getImage());

            //Actualizamos el registro en la base de datos
            db.update("Usuarios", valores, "id="+person.getId(), null);
            Log.d("Listado Presenter", "Actualizado correctamente a "+person.toString());
        }catch (SQLException e){
            Log.d("Listado_Presenter", "No se ha podido eliminar");
        }
        db.close();
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

    public void deletePersonSQL(Person person, Context myContext) {
        SQlitePresenter conexion= new SQlitePresenter(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conexion.getWritableDatabase();

        try {
            db.delete("Usuarios", "id=" + person.getId(), null);
            Log.d("Listado Presenter", "Eliminado correctamente a "+person.toString());
        }catch (SQLException e){
            Log.d("Listado_Presenter", "No se ha podido eliminar");
        }
        db.close();
    }


}

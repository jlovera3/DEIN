package com.gmail.jloveraulecia.appdein.Interfaces;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.core.content.ContextCompat;

import com.gmail.jloveraulecia.appdein.Models.Person;

public interface FormularioInterface {

    public interface View{
        void lanzarError();
        void requestPermission();
        void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);
        void launchGallery();
        void setDatos(int id, String user, String email);
    }

    public interface Presenter{
        void onFocusChange(View v, boolean hasFocus);
        void onClickImage(Context context);
        int resultPermission(int resultado);
        Bitmap modifyImage(int requestCode, int resultCode, Intent data, Context myContext);
        void registrarPerson(Context context, Person person);
    }
}
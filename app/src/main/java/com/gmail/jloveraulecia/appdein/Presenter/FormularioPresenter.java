package com.gmail.jloveraulecia.appdein.Presenter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.gmail.jloveraulecia.appdein.Interfaces.FormularioInterface;

public class FormularioPresenter implements FormularioInterface.Presenter {

    private FormularioInterface.View view;

    public FormularioPresenter(FormularioInterface.View view){
        this.view=view;
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
            //view.launchGallery();
        }
    }

    @Override
    public void resultPermission(int resultado) {
        if (resultado == PackageManager.PERMISSION_GRANTED) {
            // Permiso aceptado
            Log.d("appdein", "permiso aceptado");
            //view.launchGallery();
        } else {
            // Permiso rechazado
            Log.d("appdein", "permiso rechazado");
            //ESTO LO TENGO QUE IMPLEMENTAR YO CON SNACKBAR
            //view.showError("sin permisos no puedes entrar");
        }
    }
}

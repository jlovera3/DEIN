package com.gmail.jloveraulecia.appdein.Interfaces;


import android.content.Context;

import androidx.core.content.ContextCompat;

public interface FormularioInterface {

    public interface View{
        void lanzarError();
        void requestPermission();
        void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);
    }

    public interface Presenter{
        void onFocusChange(View v, boolean hasFocus);
        void onClickImage(Context context);
        void resultPermission(int resultado);
    }
}
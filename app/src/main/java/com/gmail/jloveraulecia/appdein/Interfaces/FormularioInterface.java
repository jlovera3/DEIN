package com.gmail.jloveraulecia.appdein.Interfaces;


public interface FormularioInterface {

    public interface View{
        void lanzarError();
    }

    public interface Presenter{
        void onFocusChange(View v, boolean hasFocus);
    }
}
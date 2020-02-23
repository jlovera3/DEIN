package com.gmail.jloveraulecia.appdein.Interfaces;

import android.content.Context;

public interface ListadoInterface {
    interface View{
        void lanzarFormulario();
        void lanzarBuscado();
        void lanzarFormularioBecauseRV(int id, String user, String e, String password, int telef1, int telef2,  String u, String fecha);

    }

    interface Presenter{
        void OnClickAdd();
        void OnClickSearch();
        int ChangeNumberOfUsers(Context context);
        void onClickRecyclerView(int id, String user, String email, String password, int telef1, int telef2, String image, String fecha);

    }
}
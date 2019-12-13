package com.gmail.jloveraulecia.appdein.Interfaces;

public interface ListadoInterface {
    interface View{
        void lanzarFormulario();
        void lanzarBuscado();
        void lanzarFormularioBecauseRV(int id,String e, String u);

    }

    interface Presenter{
        void OnClickAdd();
        void OnClickSearch();
        int ChangeNumberOfUsers();
        void onClickRecyclerView(int id, String user, String email);

    }
}
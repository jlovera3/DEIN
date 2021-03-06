package com.gmail.jloveraulecia.appdein.Presenter;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.gmail.jloveraulecia.appdein.Interfaces.ListadoInterface;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.Models.Person;

import java.util.ArrayList;

public class ListadoPresenter implements ListadoInterface.Presenter{
    private ListadoInterface.View view;
    private static PersonModel conn;

    public ListadoPresenter(ListadoInterface.View view){
        this.view = view;
    }

    @Override
    public void onClickRecyclerView(int id , String user, String email, String password, int telef1, int telef2, String image, String fecha) {
        view.lanzarFormularioBecauseRV(id, user, email, password, telef1, telef2, image, fecha);
    }


    @Override
    public void OnClickAdd(){
        view.lanzarFormulario();
    }

    //HAY QUE IMPLEMENTAR UN METODO QUE MUESTRE UN TOAST AL ELIMINAR UN ELEMENTO

    public ArrayList<Person> getAllPerson(Context context){
        conn=new PersonModel(context, "DBUsuarios", null, 1);
        ChangeNumberOfUsers(context);
        return conn.getAllPerson(context);
    }



    @Override
    public void OnClickSearch(){
        view.lanzarBuscado();
    }

    @Override
    public int ChangeNumberOfUsers(Context context) {
        return conn.getAllPerson(context).size();
    }

    /*public void insertarRegistrosPrueba(Context context) {
        conn= new PersonModel(context, "DBUsuarios", null, 1);
        SQLiteDatabase db =conn.getWritableDatabase();

        if(db != null){
            for(int i=1;i<6; i++) {
                String nombre = "UsuarioPrueba" + i;
                String mail = "gmail.com";
                String password="1234567";
                String image="";

                db.execSQL("INSERT INTO Usuarios (nombre, email, password, telef1, telef2, image) " +
                        "VALUES ('" + nombre + "', '"+nombre+"@"+ mail + "','" + password + "',900222333 ,800444555, '" + image + "')");
            }
        }
        db.close();
    }*/

    public void removeOne(Person person, Context context) {
        conn= new PersonModel(context, "DBUsuarios", null, 1);
        conn.removeOne(person,context);
    }

}
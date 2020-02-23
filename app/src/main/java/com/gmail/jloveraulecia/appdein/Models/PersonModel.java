package com.gmail.jloveraulecia.appdein.Models;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.gmail.jloveraulecia.appdein.Presenter.SQlitePresenter;

import java.util.ArrayList;

public class PersonModel {

    public PersonModel() {
    }

    public ArrayList<Person> getAllPerson(Context context){
        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        SQlitePresenter conexion= new SQlitePresenter(context, "DBUsuarios", null, 1);
        SQLiteDatabase db =conexion.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM Usuarios ", null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {

                Person p=new Person();

                int id= c.getInt(0);
                String nombre = c.getString(1);
                String email = c.getString(2);
                String pass=c.getString(3);
                int telef1=c.getInt(4);
                int telef2=c.getInt(5);
                if(!c.getString(6).equals("")) {
                    String image = c.getString(6);
                    p.setImage(image);
                }
                String fecha=c.getString(7);

                p.setId(id);
                p.setUser(nombre);
                p.setEmail(email);
                p.setPassword(pass);
                p.setTelef1(telef1);
                p.setTelef2(telef2);
                p.setFecha(fecha);


                lista.add(p);

            } while(c.moveToNext());
        }
        db.close();
        return lista;
    }


}



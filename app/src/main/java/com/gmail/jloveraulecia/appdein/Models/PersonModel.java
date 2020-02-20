package com.gmail.jloveraulecia.appdein.Models;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
                int id= c.getInt(0);
                String nombre = c.getString(1);
                String email = c.getString(2);

                Person p=new Person();
                p.setId(id);
                p.setUser(nombre);
                p.setEmail(email);
                lista.add(p);
            } while(c.moveToNext());
        }
        db.close();
        return lista;
    }

    public Person getPerson(String user) {
        return new Person();
    }

}

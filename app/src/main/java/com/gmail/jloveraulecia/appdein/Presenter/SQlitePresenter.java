package com.gmail.jloveraulecia.appdein.Presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.gmail.jloveraulecia.appdein.Models.Person;

import java.util.ArrayList;

public class SQlitePresenter extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE Usuarios(id INTEGER PRIMARY KEY, nombre TEXT, email TEXT, password TEXT, telef1 INTEGER, telef2 INTEGER, image BLOB)";

    public SQlitePresenter(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        //Se crea la nueva versión de la tabla
        onCreate(db);
    }

    public ArrayList<Person> getPersonById(Context context, String id) {

        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        SQlitePresenter conexion= new SQlitePresenter(context, "DBUsuarios", null, 1);
        SQLiteDatabase db =conexion.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM Usuarios where id="+id, null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {

                Person p=new Person();

                int id1= c.getInt(0);
                String nombre = c.getString(1);
                String email = c.getString(2);
                String pass=c.getString(3);
                int telef1=c.getInt(4);
                int telef2=c.getInt(5);
                if(!c.getString(6).equals("")) {
                    String image = c.getString(6);
                    p.setImage(image);
                }

                p.setId(id1);
                p.setUser(nombre);
                p.setEmail(email);
                p.setPassword(pass);
                p.setTelef1(telef1);
                p.setTelef2(telef2);

                lista.add(p);

            } while(c.moveToNext());
        }
        db.close();
        return lista;
    }

    public ArrayList<Person> getPersonByNombre(Context myContext, String nombre) {

        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        SQlitePresenter conexion= new SQlitePresenter(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conexion.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM Usuarios WHERE nombre LIKE '%"+nombre+"%'", null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {

                Person p=new Person();

                int id1= c.getInt(0);
                String nombre1 = c.getString(1);
                String email = c.getString(2);
                String pass=c.getString(3);
                int telef1=c.getInt(4);
                int telef2=c.getInt(5);
                if(!c.getString(6).equals("")) {
                    String image = c.getString(6);
                    p.setImage(image);
                }

                p.setId(id1);
                p.setUser(nombre1);
                p.setEmail(email);
                p.setPassword(pass);
                p.setTelef1(telef1);
                p.setTelef2(telef2);

                lista.add(p);

            } while(c.moveToNext());
        }
        db.close();
        return lista;
    }

    public ArrayList<Person> getPersonByEmail(Context myContext, String email) {
        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        SQlitePresenter conexion= new SQlitePresenter(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conexion.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM Usuarios where email like '%"+email+"%'", null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {

                Person p=new Person();

                int id1= c.getInt(0);
                String nombre1 = c.getString(1);
                String email1 = c.getString(2);
                String pass=c.getString(3);
                int telef1=c.getInt(4);
                int telef2=c.getInt(5);
                if(!c.getString(6).equals("")) {
                    String image = c.getString(6);
                    p.setImage(image);
                }

                p.setId(id1);
                p.setUser(nombre1);
                p.setEmail(email1);
                p.setPassword(pass);
                p.setTelef1(telef1);
                p.setTelef2(telef2);

                lista.add(p);

            } while(c.moveToNext());
        }
        db.close();
        return lista;
    }
}

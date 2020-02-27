package com.gmail.jloveraulecia.appdein.Models;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonModel extends SQLiteOpenHelper {
    public PersonModel conn=null;

    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE Usuarios(id INTEGER PRIMARY KEY, nombre TEXT, email TEXT, password TEXT, telef1 INTEGER, telef2 INTEGER, image BLOB, fecha TEXT)";

    public PersonModel(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
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


    public ArrayList<Person> getAllPerson(Context context){
        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        conn= new PersonModel(context, "DBUsuarios", null, 1);
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM Usuarios ", null);
        Log.d("GetAll", "Punto1");
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


    public void registrarPerson(Context context, Person person){
        conn= new PersonModel(context, "DBUsuarios", null, 1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put("nombre", person.getUser());
        values.put("email", person.getEmail());
        values.put("password", person.getPassword());
        values.put("telef1", person.getTelef1());
        values.put("telef2",person.getTelef2());
        values.put("image", person.getImage());

        db.insert("Usuarios", null, values);

        Toast.makeText(context, "Insertado correctamente", Toast.LENGTH_SHORT).show();

        db.close();
    }


    public void removeOne(Person person, Context context) {
        conn= new PersonModel(context, "DBUsuarios", null, 1);
        SQLiteDatabase db =conn.getWritableDatabase();

        try {
            db.delete("Usuarios", "id=" + person.getId(), null);
        }catch (SQLException e){
            Log.d("Modelo", "No se ha podido eliminar");
        }
        db.close();
    }

    public void actualizarPersonSQL(Person person, Context myContext) {
        conn= new PersonModel(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conn.getWritableDatabase();

        try {
            //Establecemos los campos-valores a actualizar
            ContentValues valores = new ContentValues();
            valores.put("nombre",person.getUser());
            valores.put("email", person.getEmail());
            valores.put("password", person.getPassword());
            valores.put("telef1", person.getTelef1());
            valores.put("image", person.getImage());

            //Actualizamos el registro en la base de datos
            db.update("Usuarios", valores, "id="+person.getId(), null);
            Log.d("Listado Presenter", "Actualizado correctamente a "+person.toString());
        }catch (SQLException e){
            Log.d("Listado_Presenter", "No se ha podido eliminar");
        }
        db.close();
    }


    public void deletePersonSQL(Person person, Context myContext) {
        conn= new PersonModel(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conn.getWritableDatabase();

        try {
            db.delete("Usuarios", "id=" + person.getId(), null);
            Log.d("Listado Presenter", "Eliminado correctamente a "+person.toString());
        }catch (SQLException e){
            Log.d("Listado_Presenter", "No se ha podido eliminar");
        }
        db.close();
    }


    public ArrayList<Person> getPersonById(Context context, String id) {

        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        conn= new PersonModel(context, "DBUsuarios", null, 1);
        SQLiteDatabase db =conn.getWritableDatabase();
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
                String fecha=c.getString(7);

                p.setId(id1);
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

    public ArrayList<Person> getPersonByNombre(Context myContext, String nombre) {

        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        conn= new PersonModel(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conn.getWritableDatabase();
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
                String fecha=c.getString(7);

                p.setId(id1);
                p.setUser(nombre1);
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

    public ArrayList<Person> getPersonByEmail(Context myContext, String email) {
        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        conn= new PersonModel(myContext, "DBUsuarios", null, 1);
        SQLiteDatabase db =conn.getWritableDatabase();
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
                String fecha=c.getString(7);

                p.setId(id1);
                p.setUser(nombre1);
                p.setEmail(email1);
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



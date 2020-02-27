package com.gmail.jloveraulecia.appdein.Presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.R;

import java.util.ArrayList;

public class BuscarPresenter extends AppCompatActivity {
    private PersonModel modelo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }


    public ArrayList<Person> getPersonById(Context context, String id) {

        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        modelo= new PersonModel(context, "DBUsuraios", null, 1);
        lista=modelo.getPersonById(context, id);
        return lista;
    }

    public ArrayList<Person> getPersonByNombre(Context myContext, String nombre) {

        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        modelo= new PersonModel(myContext, "DBUsuraios", null, 1);
        lista=modelo.getPersonByNombre(myContext, nombre);
        return lista;
    }

    public ArrayList<Person> getPersonByEmail(Context myContext, String email) {
        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos
        modelo= new PersonModel(myContext, "DBUsuraios", null, 1);
        lista=modelo.getPersonByEmail(myContext, email);
        return lista;
    }
}

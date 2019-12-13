package com.gmail.jloveraulecia.appdein.Presenter;


import android.widget.TextView;

import com.gmail.jloveraulecia.appdein.Interfaces.FormularioInterface;
import com.gmail.jloveraulecia.appdein.Interfaces.ListadoInterface;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Views.FormularioActivity;
import com.gmail.jloveraulecia.appdein.Views.ListadoActivity;

import java.util.ArrayList;

public class ListadoPresenter implements ListadoInterface.Presenter{
    private ListadoInterface.View view;
    private static PersonModel person;

    public ListadoPresenter(ListadoInterface.View view){
        this.view = view;
        person = new PersonModel();
    }

    @Override
    public void onClickRecyclerView(int id , String user, String email) {
        view.lanzarFormularioBecauseRV(id, user, email);
    }


    @Override
    public void OnClickAdd(){
        view.lanzarFormulario();
    }

    //HAY QUE IMPLEMENTAR UN METODO QUE MUESTRE UN TOAST AL ELIMINAR UN ELEMENTO

    public ArrayList<Person> getAllPerson(){
        ChangeNumberOfUsers();
        return person.getAllPerson();
    }

    public ArrayList<Person> getAllPersonMenos(int posicion){
        ChangeNumberOfUsers2();
        return person.getAllPersonMenos(posicion);
    }


    @Override
    public void OnClickSearch(){
        view.lanzarBuscado();
    }

    @Override
    public int ChangeNumberOfUsers() {
        return person.getAllPerson().size();
    }
    public int ChangeNumberOfUsers2() {
        return person.getAllPerson().size()-1;
    }

}
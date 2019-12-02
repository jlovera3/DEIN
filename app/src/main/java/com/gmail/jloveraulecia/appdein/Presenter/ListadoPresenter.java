package com.gmail.jloveraulecia.appdein.Presenter;


import android.widget.TextView;

import com.gmail.jloveraulecia.appdein.Interfaces.ListadoInterface;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.Models.Person;

import java.util.ArrayList;

public class ListadoPresenter implements ListadoInterface.Presenter{
    private ListadoInterface.View view;
    private static PersonModel person;

    public ListadoPresenter(ListadoInterface.View view){
        this.view = view;
        person = new PersonModel();
    }

    @Override
    public void onClickRecyclerView(int id) {
        view.lanzarFormularioBecauseRV(id);
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


    @Override
    public void OnClickSearch(){
        view.lanzarBuscado();
    }

    @Override
    public int ChangeNumberOfUsers() {
        return person.getAllPerson().size();
    }


}
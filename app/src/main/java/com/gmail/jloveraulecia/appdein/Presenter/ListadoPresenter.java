package com.gmail.jloveraulecia.appdein.Presenter;


import com.gmail.jloveraulecia.appdein.Interfaces.ListadoInterface;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.Models.Person;

import java.util.ArrayList;

public class ListadoPresenter implements ListadoInterface.Presenter{
    private ListadoInterface.View view;
    private PersonModel person;

    public ListadoPresenter(ListadoInterface.View view){
        this.view = view;
        person = new PersonModel();
    }

    @Override
    public void OnClickAdd(){
        view.lanzarFormulario();
    }

    @Override
    public ArrayList<Person> getAllPerson(){
        return person.getAllPerson();
    }

    public void OnClickSearch(){ view.lanzarBuscado();}


}
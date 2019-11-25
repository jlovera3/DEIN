package com.gmail.jloveraulecia.appdein.Interfaces;


import com.gmail.jloveraulecia.appdein.Models.Person;

import java.util.ArrayList;

public interface ListadoInterface {
    public interface View{
        void lanzarFormulario();
        void lanzarBuscado();
    }

    public interface Presenter{
        void OnClickAdd();
        void OnClickSearch();
        ArrayList<Person> getAllPerson();
    }
}
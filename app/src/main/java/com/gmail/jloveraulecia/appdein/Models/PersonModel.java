package com.gmail.jloveraulecia.appdein.Models;


import java.util.ArrayList;

public class PersonModel {

    public PersonModel() {
    }

    public ArrayList<Person> getAllPerson(){
        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos, temporalmente ponemos ejemplos
        lista.add(new Person(1, "Jaime Lovera", "jaimelovera@prueba.es" ));
        lista.add(new Person(2, "Marta Lovera", "martalovera@prueba.es"));
        lista.add(new Person(3, "Ana Lovera", "analovera@prueba.es"));

        return lista;
    }

    public Person getPerson(String user) {
        return new Person();
    }
}

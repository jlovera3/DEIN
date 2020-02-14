package com.gmail.jloveraulecia.appdein.Models;


import java.util.ArrayList;

public class PersonModel {

    public PersonModel() {
    }

    public ArrayList<Person> getAllPerson(){
        ArrayList<Person> lista=new ArrayList<>();
        //aqui iria la consulta a la base de datos

        return lista;
    }

    public ArrayList<Person> getAllPersonMenos(int posicion){
        ArrayList<Person> lista=getAllPerson();
        for(int i=0; i<lista.size();i++){
                if (lista.get(i).getId().equals(posicion)) {
                    lista.remove(i + 1);
                }

        }
        return lista;
    }
    public Person getPerson(String user) {
        return new Person();
    }

}

package com.gmail.jloveraulecia.appdein.Interfaces;


import com.gmail.jloveraulecia.appdein.Models.Person;

public interface ProfileInterface {

    public interface View {
        void loadDataUser(Person person);
    }

    public interface Presenter {
        void getDataUser(String user);
    }
}
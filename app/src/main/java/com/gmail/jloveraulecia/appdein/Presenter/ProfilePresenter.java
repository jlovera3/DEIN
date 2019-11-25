package com.gmail.jloveraulecia.appdein.Presenter;

import android.util.Log;

import com.gmail.jloveraulecia.appdein.Interfaces.ProfileInterface;
import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;

public class ProfilePresenter implements ProfileInterface.Presenter {

    private String TAG = "ProfilePresenter";
    private ProfileInterface.View view;
    private PersonModel people;

    public ProfilePresenter (ProfileInterface.View view) {
        this.view = view;
        people = new PersonModel();
    }

    @Override
    public void getDataUser(String user) {
        Log.d(TAG, "Llamando al modelo para recoger los datos de usuario...");
        Person person = people.getPerson(user);
        Log.d(TAG, "Llamando a la vista para cargar los datos de usuario...");
        view.loadDataUser(person);
    }
}

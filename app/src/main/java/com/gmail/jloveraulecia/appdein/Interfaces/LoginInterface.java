package com.gmail.jloveraulecia.appdein.Interfaces;

public interface LoginInterface {

    public interface View {
        void showError(String error);
        void hideError();
        void navigateToProfile(String user);
    }

    public interface Presenter {
        void onClickLogin(String user, String pass);
    }
}
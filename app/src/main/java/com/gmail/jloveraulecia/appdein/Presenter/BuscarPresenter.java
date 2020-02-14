package com.gmail.jloveraulecia.appdein.Presenter;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gmail.jloveraulecia.appdein.R;

public class BuscarPresenter extends AppCompatActivity {

    EditText campoId, campoEmail, campoUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }
}

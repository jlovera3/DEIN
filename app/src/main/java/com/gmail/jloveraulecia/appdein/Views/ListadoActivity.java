package com.gmail.jloveraulecia.appdein.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gmail.jloveraulecia.appdein.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ListadoActivity extends AppCompatActivity {
    private static final String LIST_ACTIVITY_TAG = ListadoActivity.class.getSimpleName();
    private Button button;

    private void showLog(String text){

        Log.d(LIST_ACTIVITY_TAG, text);

    }
    public void OnClickSearch(){ openBuscarActivity();}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.getSupportActionBar().setTitle("Listado");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        FloatingActionButton fab = findViewById(R.id.botonFlotante);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Abriendo actividad formulario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                openFormularioActivity();
            }
        });
/*
        ActionMenuItem  b=findViewById(R.id.action_buscar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Abriendo actividad buscar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                openBuscarActivity();
            }
        });*/
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish()
        ;
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return false;
    }
    public void openFormularioActivity(){
        Intent formIntent = new Intent(ListadoActivity.this, FormularioActivity.class);
        startActivity(formIntent);
        finish();
    }

    public void openBuscarActivity(){
        Intent formIntent = new Intent(ListadoActivity.this, BuscarActivity.class);
        startActivity(formIntent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    /*
    * Este método sirve para dar funcionalidad a las opciones del menu,
    * cada vez que el usuario pulse una opcion se ejecutara una de las siguientes.
    * Por ahora solo escribe el nombre de la opcion en la consola.
    * */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("ActionBar", "Nuevo!");
                return true;
            case R.id.action_buscar:
                Log.i("ActionBar", "Buscar!");;
                try{
                    Intent searchIntent = new Intent(ListadoActivity.this, BuscarActivity.class);
                    startActivity(searchIntent);
                    finish();
                }catch (Exception E){}
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");;
                try{
                    Intent aboutIntent = new Intent(ListadoActivity.this, AboutActivity.class);
                    startActivity(aboutIntent);
                    finish();
                }catch (Exception E){}
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onRestart(){

        super.onRestart();//call to restart after onStop

        showLog("Activity restarted");

    }

    @Override

    protected void onStart() {

        super.onStart();//soon be visible

        showLog("Activity started");

    }

    @Override

    protected void onResume() {

        super.onResume();//visible

        showLog("Activity resumed");

    }

    @Override

    protected void onPause() {

        super.onPause();//invisible

        showLog("Activity paused");

    }

    @Override

    protected void onStop() {

        super.onStop();

        showLog("Activity stopped");

    }

    @Override

    protected void onDestroy() {

        super.onDestroy();

        showLog("Activity is being destroyed");

    }


}

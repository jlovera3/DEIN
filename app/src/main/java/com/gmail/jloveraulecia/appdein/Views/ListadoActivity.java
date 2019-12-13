package com.gmail.jloveraulecia.appdein.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.jloveraulecia.appdein.Interfaces.ListadoInterface;
import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Presenter.ListadoPresenter;
import com.gmail.jloveraulecia.appdein.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity implements ListadoInterface.View{
    private static final String LIST_ACTIVITY_TAG = ListadoActivity.class.getSimpleName();
    private Button button;
    private RecyclerView listadoRecyclerView;
    private PersonAdapter adaptador;
    private ArrayList<Person> personList;
    private ListadoPresenter presenter;

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

        presenter = new ListadoPresenter(this);

        iniciarReciclerView();


    }

    public void iniciarReciclerView(){
        //Seguimos con el adaptador del click en usuarios
        listadoRecyclerView = findViewById(R.id.recyclerView);

        // Crea el Adaptador con los datos de la lista anterior
        personList = presenter.getAllPerson();
        adaptador = new PersonAdapter(personList);

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(listadoRecyclerView);
        // Asocia el Adaptador al RecyclerView
        listadoRecyclerView.setAdapter(adaptador);

        // Muestra el RecyclerView en vertical
        listadoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Accion al pulsar el elemento
                int position = listadoRecyclerView.getChildAdapterPosition(v);
                Log.d(LIST_ACTIVITY_TAG, "Click RV: " + personList.get(position).getId());
                presenter.onClickRecyclerView(personList.get(position).getId(),personList.get(position).getUser(), personList.get(position).getEmail());
            }
        });

        int a=presenter.ChangeNumberOfUsers();
        TextView t=(TextView) findViewById(R.id.textView5);
        t.setText("Numero de Usuarios: "+a);
    }

    public void refrescarReciclerView(int posicion){
        //Seguimos con el adaptador del click en usuarios
        listadoRecyclerView = findViewById(R.id.recyclerView);

        // Crea el Adaptador con los datos de la lista anterior
        personList = presenter.getAllPersonMenos(posicion);
        adaptador = new PersonAdapter(personList);

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(listadoRecyclerView);
        // Asocia el Adaptador al RecyclerView
        listadoRecyclerView.setAdapter(adaptador);

        // Muestra el RecyclerView en vertical
        listadoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Accion al pulsar el elemento
                int position = listadoRecyclerView.getChildAdapterPosition(v);
                Log.d(LIST_ACTIVITY_TAG, "Click RV: " + personList.get(position).getId());
                presenter.onClickRecyclerView(personList.get(position).getId(),personList.get(position).getUser(), personList.get(position).getEmail());
            }
        });

        int a=presenter.ChangeNumberOfUsers2();
        TextView t=(TextView) findViewById(R.id.textView5);
        t.setText("Numero de Usuarios: "+a);
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


    @Override
    public void lanzarFormulario() {
        
    }

    @Override
    public void lanzarBuscado() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    public void lanzarFormularioBecauseRV(int id, String email, String user) {
        Log.d(LIST_ACTIVITY_TAG, "Lanzando formulario desde RV...");

        if(id == -1) {
            // esto es launchForm() basicamente
            Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("email", email);
            intent.putExtra("user", user);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("email", email);
            intent.putExtra("user", user);
            //bundle
            //TODO bundle para encapsular el id y pasarselo al activity
            //TODO es un paquete en el que metemos variables cadena->valor cadena->valor
            //TODO empaquetamos el id y luego en el formulario activity en el oncreate recuperamos el id. Al final del oncreate mejor
            startActivity(intent);
        }
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback =new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            personList.remove(viewHolder.getAdapterPosition());
            refrescarReciclerView(viewHolder.getAdapterPosition());
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Eliminado Correctamente", Toast.LENGTH_LONG);

            toast1.show();
        }
    };

}

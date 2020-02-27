package com.gmail.jloveraulecia.appdein.Views;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.gmail.jloveraulecia.appdein.Models.Person;
import com.gmail.jloveraulecia.appdein.Models.PersonModel;
import com.gmail.jloveraulecia.appdein.Presenter.BuscarPresenter;
import com.gmail.jloveraulecia.appdein.R;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class BuscarActivity extends AppCompatActivity {
    private static final String LIST_SEARCH_TAG = BuscarActivity.class.getSimpleName();
    EditText campoId, campoEmail, campoUser;
    private BuscarPresenter presenter=new BuscarPresenter();
    private Context myContext;
    private Intent intent;
    BuscarPresenter conn;
    PersonModel model;

    private void showLog(String text){

        Log.d(LIST_SEARCH_TAG, text);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        conn=new BuscarPresenter();

        myContext=this;
        intent= new Intent(BuscarActivity.this, ListadoActivity.class);

        campoId= (EditText) findViewById(R.id.editTextId);
        campoEmail= (EditText) findViewById(R.id.editTextEmail);
        campoUser= (EditText) findViewById(R.id.editTextNombre);

        Button button= (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=null, nombre=null, id=null;
                boolean lleno1=false, lleno2=false, lleno3=false;
                //Compruebo que los campos no están vacíos
                if(!campoId.getText().toString().equals("")){
                    id=campoId.getText().toString();
                    lleno1=true;
                }
                if(!campoUser.getText().toString().equals("")) {
                    nombre = campoUser.getText().toString();
                    lleno2=true;
                }
                if(!campoEmail.getText().toString().equals("")) {
                    email = campoEmail.getText().toString();
                    lleno3=true;
                }
                Log.d("hola", ""+lleno1+","+lleno2+","+lleno3);

                ArrayList<Person> people=new ArrayList<>();
                if(lleno1 && !lleno2 && !lleno3){
                    people=conn.getPersonById(myContext,id);
                }else if(!lleno1 && lleno2 && !lleno3){
                    people=conn.getPersonByNombre(myContext, nombre);
                }else if(!lleno1 && !lleno2 && lleno3){
                    people=conn.getPersonByEmail(myContext, email);
                }

                Log.d("a ver...", ""+people.size());

                if(people.isEmpty()){
                    Toast.makeText(myContext, "No exiten registros asi!", Toast.LENGTH_SHORT).show();
                }else{
                    intent.putExtra("people", people);
                    restartListadoActivity();
                }
            }
        });


    }

    private void restartListadoActivity() {
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivityForResult(intent, 0);
    }
    public void consultar(){
        SQLiteDatabase db=model.getReadableDatabase();
        String[] parametros= {campoId.getText().toString()};
        String[] campos= {"Id", "Nombre", "Email"};

        try {
            Cursor cursor = db.query("usuarios", campos, "id" + "= ?", parametros, null, null, null);
            cursor.moveToFirst();
            campoId.setText(cursor.getInt(0));
            campoUser.setText(cursor.getString(1));
            campoEmail.setText(cursor.getString(2));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    public void limpiar(){
        campoId.setText("");
        campoUser.setText("");
        campoEmail.setText("");
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

package com.gmail.jloveraulecia.appdein.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.gmail.jloveraulecia.appdein.Presenter.BuscarPresenter;
import com.gmail.jloveraulecia.appdein.Presenter.SQlitePresenter;
import com.gmail.jloveraulecia.appdein.R;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarActivity extends AppCompatActivity {
    private static final String LIST_SEARCH_TAG = BuscarActivity.class.getSimpleName();
    EditText campoId, campoEmail, campoUser;
    private BuscarPresenter presenter;

    SQlitePresenter conn;

    private void showLog(String text){

        Log.d(LIST_SEARCH_TAG, text);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        conn=new SQlitePresenter(this, "db_person", null, 1);

        campoId= (EditText) findViewById(R.id.editTextId);
        campoEmail= (EditText) findViewById(R.id.editTextEmail);
        campoUser= (EditText) findViewById(R.id.editTextNombre);

        Button button= (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.button5:
                consultar();
                break;
        }
    }
    public void consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();
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

        Intent ListIntent = new Intent(BuscarActivity.this, ListadoActivity.class);
        startActivity(ListIntent);
        finish();

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

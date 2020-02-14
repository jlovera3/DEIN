package com.gmail.jloveraulecia.appdein.Presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQlitePresenter extends SQLiteOpenHelper {
    private static final String NOMBRE_DB="appdein.db";
    private static final int VERSION_DB=1;
    final String SENTENCIA_CREAR="CREATE TABLE person (id INTEGER, user TEXT, email TEXT, image BLOB)";

    public SQlitePresenter(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SENTENCIA_CREAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS person");
        onCreate(db);
    }

    public void agregarUsuarios(){
    }
}

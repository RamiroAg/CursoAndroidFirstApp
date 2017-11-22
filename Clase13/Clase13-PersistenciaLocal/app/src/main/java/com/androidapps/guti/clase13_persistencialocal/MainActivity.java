package com.androidapps.guti.clase13_persistencialocal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private MyOpenHelper oh;    //Los hago globales para que se puedan cerrar en el onDestroy()
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oh = new MyOpenHelper(this, "Personas.db3");

        db = oh.getWritableDatabase(); //Este objeto me permite realizar consultas para leer y escribir

        /*Cursor c;

        c = db.rawQuery("SELECT _id,nombre,edad FROM Personas WHERE _id=1",null);

        //Se puede iterar usando c.moveToNext() para ir trayendo varias rows
        if(c.moveToFirst()) //false si cursor vacío
        {

            long id = c.getLong(0); //Número de columna
            String nombre = c.getString(1);
            int edad = c.getInt(2);
            Log.d("db", "Persona. id:" + id + " nombre:" + nombre + " edad:" + edad);
        }
        c.close();
        db.close();
        oh.close();*/

        //Instancio DAO
        PersonaDAO personaDAO = new PersonaDAO(db);

        Persona p = personaDAO.getPersonaById(1);
        Log.d("Main Activity", "Nombre: " + p.getNombre() + " Edad: " + p.getEdad());

        Persona p2 = new Persona();
        p2.setNombre("Luke");
        p2.setEdad(30);
        personaDAO.save(p2);
    }
}

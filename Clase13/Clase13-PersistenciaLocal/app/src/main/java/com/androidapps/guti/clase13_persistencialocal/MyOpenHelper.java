package com.androidapps.guti.clase13_persistencialocal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
//Heredar para poder usar la api de SQLite en android
public class MyOpenHelper extends SQLiteOpenHelper
{
	//Esta clase chequea si la base de datos está creada
	private String  dbFilePath;
	private String  dbFileName;
	private Context context;
	
	private static final int DB_VERSION = 1;	//Se usa para poder actualizar la base de datos de los usuarios a la versión nueva
	//Esto evita borrar la tabla que ya tienen
	//Ante un cambio, con sólo cambiar el número, la app se da cuenta que está usando una BD vieja y ejecuta onUpgrade()

	//context => se le pasa el activity
	//name => nombre de la BD
	public MyOpenHelper(Context context, String name) 
	{
		super(context, name, null, DB_VERSION);

		// Obtengo path a la db para esta aplicacion
		dbFilePath = context.getDatabasePath(name).getAbsolutePath(); //devuelve "/data/data/package de la app/databases/", ya que harcodearlo no está bueno por si cambia el enrutamiento en futuras versiones de Android
		dbFilePath = dbFilePath.substring(0, dbFilePath.lastIndexOf("/")+1); //Nombre de la base
		
		this.context=context;
		this.dbFileName=name;
		
		checkDataBase(); // si no esta creada la db, la creo
	}

	
	 private void checkDataBase(){
		 
	    	SQLiteDatabase checkDB = null;
	 
	    	try{ //Si el archivo ya existe nunca entrará al catch
	    		String myPath = dbFilePath + dbFileName;//construyo el string con el path y el nombre completo
	    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);	 
	    	}catch(SQLiteException e){//Este bloque se ejecuta cuando falla el open al no existir el archivo
	    		// Error al abrir la db, no existe, entonces la creamos
	    		try {
	    			Log.d("helper","Copiando archivo desde assets");
	    			copyDataBase();
	    		} catch (IOException e2) { 
	    			Log.d("helper","Error copiando archivo desde assets");	    			
	    		}
	    	}	 
	    	
	    	if(checkDB != null){
	    		checkDB.close();	 
	    	}
	    }
	 
		private void copyDataBase() throws IOException
		{		
			File f = new File(dbFilePath);
			f.mkdirs(); // crea los directorios donde se guardara la db
			//Crea todas las carpetas del path que no existan
			
	    	//Obtenemos un InputStream del archivo que esta en assets
	    	InputStream myInput = context.getAssets().open(dbFileName); // getAssets() devuelve un assetManager
			//La raiz de open es la carpeta misma de Assets. Si la base está ahí, sólo va el nombre
	 
	    	// creamos el path del archivo de destino
	    	String outFileName = dbFilePath + dbFileName;
	 
	    	//Obtenemos un output stream para escribir en el path de destino
	    	OutputStream myOutput = new FileOutputStream(outFileName); //OutputStream tiene el método write()
			//Leo del inputStream y escribo en el outputStream
	 
	    	//copiamos los bytes del inputstream al outputstream
	    	//Esto se hace porque la carpeta Assets no se puede acceder desde un path
	    	byte[] buffer = new byte[1024];
	    	int length;
	    	while ((length = myInput.read(buffer))>0)
	    	{
	    		Log.d("helper","Copying "+length+" bytes");
	    		myOutput.write(buffer, 0, length);
	    	} 
	    	//Cerramos los streams
	    	myOutput.flush();
	    	myOutput.close();
	    	myInput.close(); 
	    }
		
		@Override
		public void onCreate(SQLiteDatabase db) 
		{
			//Método que se ejecutará para crear la base de datos
			//No usaremos onCreate porque no vamos a crear la BD desde código, sino que desde archivo ya creado
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
		{
			// Se ejecuta cuando hay un cambio de version
			//SwitchCase que pase por la migración de todas las versiones
		}
}

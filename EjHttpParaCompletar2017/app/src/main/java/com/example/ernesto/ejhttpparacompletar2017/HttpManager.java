package com.example.ernesto.ejhttpparacompletar2017;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager {

	private String url;
	private HttpURLConnection conn;		//Objeto asociado a la conexión

	public HttpManager(String url)
	{
		conn = crearHttpUrlConn(url);
	}

	public boolean isReady()
	{
		return conn!=null;
	}

	public String getStrDataByGET() throws IOException
	{
		byte[] bytes = getBytesDataByGET();
		return new String(bytes,"UTF-8"); //Conversión del byteArray a string
	}

	public byte[] getBytesDataByGET() throws IOException
	{
		conn.setRequestMethod("GET");

		//Estas dos líneas son bloqueantes, por eso van en thread
		conn.connect();
		int response = conn.getResponseCode();
		//------------------------------------

		Log.d("http", "Response code:" + response);
		if(response==200) {
			InputStream is = conn.getInputStream();	//Input stream => Permite leer
			return readFully(is);
		}
		else
			throw new IOException();
	}

	public String getStrDataByPOST(Uri.Builder postParams) throws IOException
	{
		byte[] bytes = getBytesDataByPOST(postParams);
		return new String(bytes,"UTF-8");
	}

	public byte[] getBytesDataByPOST(Uri.Builder postParams) throws IOException
	{
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		String query = postParams.build().getEncodedQuery();

		OutputStream os = conn.getOutputStream(); //Pido un outputString a la conexión para empezar a escribir
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
		writer.write(query);
		writer.flush();
		writer.close();
		os.close();

		int response = conn.getResponseCode();
		Log.d("http","Response code:"+response);
		if(response==200) {
			InputStream is = conn.getInputStream();
			return readFully(is);
		}
		else
			throw new IOException();
	}

	private byte[] readFully(InputStream inputStream) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();		//Array de bytes dinámico pensado para appendear los bytes que voy leyendo
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = inputStream.read(buffer)) != -1) {	//Lectura por partes del inputStream
			baos.write(buffer, 0, length);	//Voy escribiendo a medida que voy leyendo
		}
		inputStream.close();
		return baos.toByteArray();
	}


	//Devuelvo un objeto que me permite realizar cualquier tipo de request hacia la url recibida como parámetro
	private HttpURLConnection crearHttpUrlConn(String strUrl)
	{
		URL url = null;
		try {
			url = new URL(strUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setReadTimeout(10000 /* milliseconds */);
			urlConnection.setConnectTimeout(15000 /* milliseconds */);
			return  urlConnection;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package com.androidapps.guti.clase9_elementosvisuales;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by android on 24/10/17.
 */

public class GutiDialog extends DialogFragment{
    private DialogInterface.OnClickListener listener;

    public void setListener(DialogInterface.OnClickListener listener){ //No lo hago en el constructor porque tira warning
        this.listener = listener;
    }
    //Acá que va?
    //Rescribir un método similar a onCreate que se ejecutará al lanzar la pantalla y devuelva el dialog

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle b = getArguments();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());    //Recibe un objeto context, necesito el activity u otra cosa
        //Como es una clase que hereda de fragment, hay un método que devuelve una referencia del activity para pasar el context

        builder.setTitle(b.getString("title"));
        builder.setMessage(b.getString("message"));

        builder.setPositiveButton("Aceptar", listener); //This debe implementar el evento que usa para escuchar el click. Mi activity es OnClickListener
        //Si no tiene lístener, cada botón creado cierra la popup
        //Se pueden agregar diferentes tipos de botones
        //Si no tuviese botón, se sale con BACK
        builder.setCancelable(false); //No sale al presionar back (Acá no funciona esto)
        // Creamos el dialogo
        AlertDialog ad = builder.create();
        return ad;
    }
}

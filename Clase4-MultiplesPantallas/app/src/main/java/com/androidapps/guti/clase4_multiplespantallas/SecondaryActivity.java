package com.androidapps.guti.clase4_multiplespantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent(); //obtiene el intent que invocó la vista
        Bundle bundle = intent.getExtras();     //Objeto bundle contendrá la tabla clave-valor que guarda el intent

        TextView txt = (TextView)findViewById(R.id.textView);
        txt.setText(bundle.getString("textToShow"));

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText txt = (EditText)findViewById(R.id.editText2); //OJO, desde activity 2 puedo ver los controles de activity1
        txt.getText();

        Intent intent = new Intent();
        intent.putExtra("datoDeRetorno", txt.getText());

        setResult(RESULT_OK, intent);       //Result_Fist_User => a partir de este valor puedo definir mis estados

        finish();
    }
}

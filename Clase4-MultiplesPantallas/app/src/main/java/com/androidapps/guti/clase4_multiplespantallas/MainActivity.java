package com.androidapps.guti.clase4_multiplespantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) this.findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    public void onClickViejo(View view) {
        Log.d("Main Activity", "Click on button");

        EditText txt = (EditText)findViewById(R.id.editText);
        String textContent = txt.getText().toString();      //Valor que quiero transmitir a la otra Activity

        Intent intent = new Intent(this, SecondaryActivity.class);
        //new Intent(objeto context => se pasa directamente la vista actual,
        //objeto tipo class => acá va la clase de la activity que quiero invocar

        intent.putExtra("textToShow", textContent);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d("Main Activity", "Volvimos del activity 2 papu");
        if(requestCode == 0 && resultCode == RESULT_OK && intent != null) {
            Bundle bundle = intent.getExtras();
            String message = bundle.getString("datoDeRetorno");

            TextView txt = (TextView)findViewById(R.id.textView2);
            txt.setText(message);
        }
    }

    @Override
    public void onClick(View view) {
        Log.d("Main Activity", "Click on button");

        EditText txt = (EditText)findViewById(R.id.editText);
        String textContent = txt.getText().toString();      //Valor que quiero transmitir a la otra Activity

        Intent intent = new Intent(this, SecondaryActivity.class);
        //new Intent(objeto context => se pasa directamente la vista actual,
        //objeto tipo class => acá va la clase de la activity que quiero invocar

        intent.putExtra("textToShow", textContent);

        startActivityForResult(intent, 0); //Seteo el request code en 0
    }
}

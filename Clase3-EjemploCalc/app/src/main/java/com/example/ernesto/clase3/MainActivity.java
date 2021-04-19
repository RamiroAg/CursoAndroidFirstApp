package com.example.ernesto.clase3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
                            implements View.OnClickListener {

    private String numero;
    private int operador1;
    private int operador2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);

        Button btnAdd = (Button)findViewById(R.id.btnAdd);
        Button btnEq = (Button)findViewById(R.id.btnEqual);

        // conecto eventos
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnEq.setOnClickListener(this);

        numero="";
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        TextView txt = (TextView)findViewById(R.id.textView);

        switch(view.getId())
        {
            case R.id.btn1:
            {
                numero=numero+"1";


                break;
            }
            case R.id.btn2:
            {
                numero=numero+getString(R.string.texto_boton_dos);
                break;
            }
            case R.id.btnAdd:
            {
                operador1 = Integer.parseInt(numero);
                numero="";
                break;
            }
            case R.id.btnEqual:
            {
                operador2 = Integer.parseInt(numero);
                numero = String.valueOf(operador1+operador2);
                break;
            }
        }

        txt.setText(numero);
    }
}

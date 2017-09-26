package com.learning.ramiro.mvccalculator;

import android.view.View;
import android.widget.Button;
import java.util.List;

/**
 * Created by Ramiro on 25/9/2017.
 */

public class Controller  implements View.OnClickListener{
    private Model model;
    private ScreenManager screenManager;
    private StringBuilder inputNbr;


    public Controller(Model model, ScreenManager screenm)
    {
        this.model = model;
        this.screenManager = screenm;
        this.inputNbr = new StringBuilder();
    }

    public Double excecOperation(double factor1, double factor2, char operation){
        switch (operation){
            case '+': return factor1 + factor2;
                break;
            case '-': return factor1 - factor2;
                break;
            case '*': return factor1 * factor2;
                break;
            case '/': if (factor2 != 0) {
                return factor1 / factor2;
                break;
            }
            else
                return 0.0;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        if (screenManager.IsNumberButton(btn)){
            //Concatenar en campo de texto, almacenar en variable
            inputNbr.append(screenManager.GetButtonText(btn));
        }
        else {
            //Almacenar numero anterior en variable
            model.parameters.add(Double.parseDouble(inputNbr.toString()));
            inputNbr = new StringBuilder();
            if (screenManager.IsOperationButton(btn)){
                model.operation = screenManager.GetButtonText(btn).charAt(0);
            }
            else if (screenManager.IsEqualButton(btn)){
                //Ejecutar operaciòn
                //double total = excecOperation();
                //Mostrar operaciòn
                //Borrar cuenta
            }
        }
    }
}

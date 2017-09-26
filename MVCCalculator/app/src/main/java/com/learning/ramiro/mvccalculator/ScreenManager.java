package com.learning.ramiro.mvccalculator;

import android.app.Activity;
import android.widget.Button;

/**
 * Created by Ramiro on 25/9/2017.
 */

public class ScreenManager {

    private Activity ActivityMain;

    public ScreenManager(Activity activity) {
        ActivityMain = activity;
    }

    public int GetButtonNbr(Button btn){
        return Integer.parseInt(btn.getText().toString());
    }

    public String GetButtonText(Button btn){
        return btn.getText().toString();
    }

    public Boolean IsNumberButton(Button btn){
        return btn.getText() == "1"
                || btn.getText() == "2"
                || btn.getText() == "3"
                || btn.getText() == "4"
                || btn.getText() == "5"
                || btn.getText() == "6"
                || btn.getText() == "7"
                || btn.getText() == "8"
                || btn.getText() == "9"
                || btn.getText() == "0";
    }

    public Boolean IsOperationButton(Button btn){
        return GetButtonText(btn) == "+"
                || GetButtonText(btn) == "-"
                || GetButtonText(btn) == "*"
                || GetButtonText(btn) == "/";
    }

    public Boolean IsEqualButton(Button btn){
        return GetButtonText(btn) == "=";
    }
}

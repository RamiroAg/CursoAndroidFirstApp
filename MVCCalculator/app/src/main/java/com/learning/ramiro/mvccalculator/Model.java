package com.learning.ramiro.mvccalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramiro on 25/9/2017.
 */

public class Model {
    public Double number1;

    public Double number2;

    public char operation;

    public List<Double> parameters;

    public Model(){
        number1 = 0.0;
        number2 = 0.0;
        parameters = new ArrayList<Double>();
    }
}

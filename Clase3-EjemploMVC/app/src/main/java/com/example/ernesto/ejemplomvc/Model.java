package com.example.ernesto.ejemplomvc;

/**
 * Created by ernesto on 12/09/17.
 */

public class Model {

    private int counter;

    public Model()
    {
        counter=0;
    }

    public void add()
    {
        counter++;
    }

    public int getCounter()
    {
        return counter;
    }

}

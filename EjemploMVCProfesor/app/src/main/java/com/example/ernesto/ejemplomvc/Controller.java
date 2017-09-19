package com.example.ernesto.ejemplomvc;

import android.view.View;

/**
 * Created by ernesto on 12/09/17.
 */

public class Controller implements View.OnClickListener {

    private Model model;
    private ScreenManager screenm;

    public Controller(Model model, ScreenManager screenm)
    {
        this.model = model;
        this.screenm = screenm;
        this.screenm.setButtonListener(this);

        this.screenm.showNumber(model.getCounter());
    }

    @Override
    public void onClick(View view) {
        model.add();
        screenm.showNumber(model.getCounter());
    }
}

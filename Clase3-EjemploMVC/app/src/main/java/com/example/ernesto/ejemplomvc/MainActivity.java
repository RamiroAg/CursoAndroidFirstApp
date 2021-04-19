package com.example.ernesto.ejemplomvc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Model model = new Model();
        ScreenManager screenManager = new ScreenManager(this);

        Controller controller = new Controller(model,screenManager);

    }
}

package com.example.tomap.loginreal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

    }

    public void Switch(View View) {
        String button_text;
        button_text =((Button)View).getText().toString();

        if(button_text.equals("Back")) {

            Intent switchToHome = new Intent(this, Home.class);
            startActivity(switchToHome);

        }
    }
}



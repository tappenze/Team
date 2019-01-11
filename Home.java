package com.example.tomap.loginreal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

    }

    public void Switch(View View) {
        String button_text;
        button_text =((Button)View).getText().toString();

        if(button_text.equals("Search")) {

            Intent switchToSearch = new Intent(this, Search.class);
            startActivity(switchToSearch);

        }

        else if (button_text.equals("Profile")) {

            Intent switchToProfile = new Intent(this, Profile.class);
            startActivity(switchToProfile);

        }

        else if (button_text.equals("Settings")) {

            Intent switchToSettings = new Intent(this, Settings.class);
            startActivity(switchToSettings);

        }
    }
}

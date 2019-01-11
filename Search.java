package com.example.tomap.loginreal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class Search extends AppCompatActivity {

    public Button GoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Spinner myspinner1 = (Spinner) findViewById(R.id.Instrument);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Search.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Instrument));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner1.setAdapter(myAdapter1);

        Spinner myspinner2 = (Spinner) findViewById(R.id.Genre);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Search.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Genre));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner2.setAdapter(myAdapter2);

        Spinner myspinner3 = (Spinner) findViewById(R.id.Skill);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(Search.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Skill));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner3.setAdapter(myAdapter3);

        GoButton = (Button) findViewById(R.id.GoButton);
        GoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchResult();


            }
        });
    }

    public void Switch(View View) {
        String button_text;
        button_text =((Button)View).getText().toString();

        if(button_text.equals("Profile")) {

            Intent switchToProfile = new Intent(this, Profile.class);
            startActivity(switchToProfile);

        }

        else if (button_text.equals("Home")) {

            Intent switchToHome = new Intent(this, Home.class);
            startActivity(switchToHome);

        }
    }
    public void openSearchResult(){
        Intent intent = new Intent(this,SearchResult.class);
        startActivity(intent);



    }
}


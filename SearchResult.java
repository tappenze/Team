package com.example.tomap.loginreal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
    }

    public void Switch(View View) {
        String button_text;
        button_text =((Button)View).getText().toString();

        if(button_text.equals("Back")) {

            Intent switchToSearch = new Intent(this, Search.class);
            startActivity(switchToSearch);

        }
    }
}


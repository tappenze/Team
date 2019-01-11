package com.example.tomap.loginreal;

import android.content.ClipData;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class ProfileEdit extends Activity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    public EditText name; EditText age; String instrument; String genre; String skill;
    public FirebaseAuth firebaseauth;
    Spinner myspinner1;
    Spinner myspinner2;
    Spinner myspinner3;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        firebaseauth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        myspinner1 = (Spinner) findViewById(R.id.Instrument);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(ProfileEdit.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Instrument));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner1.setAdapter(myAdapter1);

        myspinner2 = (Spinner) findViewById(R.id.Genre);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(ProfileEdit.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Genre));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner2.setAdapter(myAdapter2);

        myspinner3 = (Spinner) findViewById(R.id.Skill);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(ProfileEdit.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Skill));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner3.setAdapter(myAdapter3);

    }


    public void userInfoSave(){
        name = (EditText) findViewById(R.id.EnterName);
        age = (EditText) findViewById(R.id.EnterAge);
        instrument = myspinner1.getSelectedItem().toString();
        genre = myspinner2.getSelectedItem().toString();
        skill = myspinner3.getSelectedItem().toString();
        String Name = name.getText().toString().trim();
        String Age = age.getText().toString().trim();
        String Instrument = instrument;
        String Genre = genre;
        String Skill = skill;

        FirebaseUser user = firebaseauth.getCurrentUser();

        UserInfo userInfo = new UserInfo(Name, Age, Instrument, Genre, Skill);

        ref.child(user.getUid()).setValue(userInfo);

        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();
    }

    public void Switch(View View) {
        String button_text;
        button_text =((Button)View).getText().toString();

        if(button_text.equals("Save")) {
            userInfoSave();
            Intent switchToProfile = new Intent(this, Profile.class);
            startActivity(switchToProfile);

        }

        else if (button_text.equals("Cancel")) {
            Intent switchToProfile = new Intent(this, Profile.class);
            startActivity(switchToProfile);

        }
    }

}

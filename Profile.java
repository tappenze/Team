package com.example.tomap.loginreal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    FirebaseAuth firebaseauth;
    FirebaseUser user = firebaseauth.getCurrentUser();

    TextView name;
    TextView age;
    TextView instrument;
    TextView genre;
    TextView skill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        firebaseauth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        name = findViewById(R.id.NameBox);
        RegisterName();
        age = findViewById(R.id.AgeBox);
        RegisterAge();
        instrument = findViewById(R.id.InstrumentBox);
        RegisterInstrument();
        genre = findViewById(R.id.GenreBox);
        RegisterGenre();
        skill = findViewById(R.id.SkillBox);
        RegisterSkill();

    }

    public void RegisterName() {

        name.setText(name.getText());

    }

    public void RegisterAge() {

        age.setText(age.getText());

    }

    public void RegisterInstrument() {

        instrument.setText(instrument.getText());

    }

    public void RegisterGenre() {

        genre.setText(genre.getText());

    }

    public void RegisterSkill() {

        skill.setText(skill.getText());

    }

    public void Switch(View View) {
        String button_text;
        button_text =((Button)View).getText().toString();

        if(button_text.equals("Search")) {

            Intent switchToSearch = new Intent(this, Search.class);
            startActivity(switchToSearch);

        }

        else if (button_text.equals("Home")) {

            Intent switchToHome = new Intent(this, Home.class);
            startActivity(switchToHome);

        }

        else if (button_text.equals("Edit")) {

            Intent switchToProfileEdit = new Intent(this, ProfileEdit.class);
            startActivity(switchToProfileEdit);

        }
    }
}


package com.example.tomap.loginreal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class LoginOrSignUp extends AppCompatActivity{

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");

    public EditText User;
    public EditText Password;
    public Button Login;
    public Button SignUp;

    public FirebaseAuth firebaseauth;

    public ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_sign_up);

        firebaseauth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        User = (EditText)findViewById(R.id.Email);
        Password = (EditText)findViewById(R.id.Password);
        Login = (Button)findViewById(R.id.Login);
        SignUp = (Button)findViewById(R.id.SignUp);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    public void openProfileEdit() {
        Intent switchToProfileEdit = new Intent(this, ProfileEdit.class);
        startActivity(switchToProfileEdit);
    }


    public void registerUser(){
        String email = User.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    ///////THIS IS WHERE WE WILL GO TO HOME SCREEN
                    Toast.makeText(LoginOrSignUp.this, "Success!", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();

                    FirebaseUser user = firebaseauth.getCurrentUser();

                    DatabaseReference usersRef = ref.child("usersInfo");
                    Map<String, UserInfo> users = new HashMap<>();
                    users.put(user.getUid(), new UserInfo(null, null, null, null, null));
                    usersRef.setValue(users);
                    openProfileEdit();

                }
                else{
                    Toast.makeText(LoginOrSignUp.this, "Username or password already in use", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }
            }
        });
    }

    public void openHome() {
        Intent switchToHome = new Intent(this, Home.class);
        startActivity(switchToHome);
    }

    public void loginUser(){
        String email = User.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging User In...");
        progressDialog.show();
        firebaseauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginOrSignUp.this, "Success!", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                    openHome();


                }
                else{
                    Toast.makeText(LoginOrSignUp.this, "Username or password false", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }
            }
        });
    }
}

package com.example.android.meandyou;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity  {

    EditText username;
    EditText password;

    public void UsersToChat(){
        Intent intent = new Intent(getApplicationContext(), userListActivity.class);
        startActivity(intent);
    }

    public void signUp(View view){

        if(username.getText().toString().equals("") || password.getText().toString().equals("")){
            Toast.makeText(this, "Username and Password is required!!", Toast.LENGTH_SHORT);
        }else {
            ParseUser parseUser = new ParseUser();
            parseUser.setUsername(username.getText().toString());
            parseUser.setPassword(password.getText().toString());

            parseUser.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        Log.i("Sign Up", "Successful ");
                        UsersToChat();
                    } else{
                        Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_SHORT);
                    }
                }
            });
        }
    }

    public void logIn(View view){
        ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null && e !=null){
                    Log.i("Log In", "Successful");
                    UsersToChat();
                } else {
                    Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_SHORT);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setCursorVisible(true);
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setCursorVisible(true);
            }
        });

    }
}

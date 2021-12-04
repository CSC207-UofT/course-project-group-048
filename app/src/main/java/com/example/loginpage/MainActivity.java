package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import nutrition.LoginSystem;
import nutrition.MyDBHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTxtUsername, edtTxtPassword;
    String username, password;
    MyDBHandler dbHandler;

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.loginButton) {
            if (edtTxtUsername.getText().toString().trim().length() == 0) {
                Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show();
            } else if (edtTxtPassword.getText().toString().trim().length() == 0) {
                Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            } else {
                username = edtTxtUsername.getText().toString();
                password = edtTxtPassword.getText().toString();

                //Check whether inputted username and password exist in the database of existing
                //users. If yes then log in the user. If not then display incorrect details message.
                LoginSystem loginSystem = new LoginSystem(dbHandler.GetLoginData());
                if (loginSystem.CheckUsernamePassword(username, password)){
                    Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
                    openHomePage();
                }
                else {
                    Toast.makeText(this, "Incorrect username or password...", Toast.LENGTH_SHORT).show();
                    edtTxtUsername.setText("");
                    edtTxtPassword.setText("");
                }
            }
        } else if (v.getId() == R.id.buttonCreateAcc) {
            Toast.makeText(this, "Please Enter All Information", Toast.LENGTH_LONG).show();
            openRegistrationForm();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        Button buttonCreateAcc = findViewById(R.id.buttonCreateAcc);
        buttonCreateAcc.setOnClickListener(this);

        edtTxtUsername = findViewById(R.id.edtTxtUsername);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);

        dbHandler = new MyDBHandler(this, null, null, 1);
    }

    public void openRegistrationForm() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void openHomePage() {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        startActivity(openTheHomePage);
    }

}

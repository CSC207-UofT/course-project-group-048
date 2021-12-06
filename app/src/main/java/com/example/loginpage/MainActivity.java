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
import nutrition.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTxtUsername, edtTxtPassword;
    String username, password;
    User user;

    @Override
    public void onClick(View v) {
        username = edtTxtUsername.getText().toString();
        password = edtTxtPassword.getText().toString();

        if(v.getId() == R.id.loginButton) {
            checkFields();
        } else if (v.getId() == R.id.buttonCreateAcc) {
            Toast.makeText(this, "Please Enter All Information",
                    Toast.LENGTH_LONG).show();
            openRegistrationForm();
        }
    }


    public void checkFields() {
        if (username.trim().length() == 0) {
            Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show();
        } else if (password.trim().length() == 0) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
        } else {
            handleLogin();
        }
    }

    public void handleLogin() {
        // Check whether inputted username and password exist in the database of existing
        // users. If yes, then log in the user. If not, then display "incorrect details" message.
        LoginSystem loginSystem = new LoginSystem(this);
        if (loginSystem.checkUsernamePassword(username, password)){
            Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
            user = loginSystem.getUser(username);
            openHomePage();
        }
        else {
            Toast.makeText(this, "Incorrect username or password...",
                    Toast.LENGTH_SHORT).show();
            edtTxtUsername.setText("");
            edtTxtPassword.setText("");
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

    }

    public void openRegistrationForm() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void openHomePage() {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        openTheHomePage.putExtra("user", user);
        startActivity(openTheHomePage);
    }

}

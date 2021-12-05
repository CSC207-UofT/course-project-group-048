package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import nutrition.LoginSystem;
import nutrition.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    String fullname, username, password, gender;
    Double height, weight;
    int age;
    boolean goal;

    private EditText edtTxtFullName, edtTxtUser, edtTxtPass, edtTxtHeight, edtTxtWeight, edtTxtAge;
    private RadioGroup radioGroupGender, radioGroupWeight;
    private RadioButton radioBtnMale, radioBtnFemale, radioBtnGain, radioBtnLose;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.registerBtn) {
            //Set private variables as per user inputted details.
            fullname = edtTxtFullName.getText().toString().trim();
            username = edtTxtUser.getText().toString().trim();
            password = edtTxtPass.getText().toString().trim();
            height = Double.parseDouble(edtTxtHeight.getText().toString().trim());
            weight = Double.parseDouble(edtTxtWeight.getText().toString().trim());
            age = Integer.parseInt(edtTxtAge.getText().toString().trim());

            checkAllFieldsAndSignUp();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        Button registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);
        setRadioButtons();

        edtTxtFullName = findViewById(R.id.edtTxtFullName);
        edtTxtUser = findViewById(R.id.edtTxtUser);
        edtTxtPass = findViewById(R.id.edtTxtPass);
        edtTxtHeight = findViewById(R.id.edtTxtHeight);
        edtTxtWeight = findViewById(R.id.edtTxtWeight);
        edtTxtAge = findViewById(R.id.edtTxtAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupWeight = findViewById(R.id.radioGroupWeight);
    }

    public void setRadioButtons() {
        setMaleButton();
        setFemaleButton();
        setGainWeightButton();
        setLoseWeightButton();
    }

    public void setMaleButton() {
        radioBtnMale = findViewById(R.id.radioBtnMale);
        radioBtnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "male"; //Sets gender to male if male button is clicked.
            }
        });
    }

    public void setFemaleButton() {
        radioBtnFemale = findViewById(R.id.radioBtnFemale);
        radioBtnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female"; //Sets gender to female if female button is clicked.
            }
        });
    }

    public void setGainWeightButton() {
        radioBtnGain = findViewById(R.id.radioBtnGain);
        radioBtnGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goal = true; // set goal to gain weight when gain weight button is clicked
            }
        });
    }

    public void setLoseWeightButton() {
        radioBtnLose = findViewById(R.id.radioBtnLose);
        radioBtnLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goal = false; // set goal to lose weight when lose weight button is clicked
            }
        });
    }


    public void openLoginPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void checkAllFieldsAndSignUp(){
        if(edtTxtFullName.getText().toString().trim().length() == 0){
            Toast.makeText(this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show();
        } else if (edtTxtUser.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please Enter a Username", Toast.LENGTH_SHORT).show();
        } else if (edtTxtPass.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please Enter a Password", Toast.LENGTH_SHORT).show();
        } else if(radioGroupGender.getCheckedRadioButtonId() == -1){ // no buttons are checked
            Toast.makeText(this, "Please Select Your Gender", Toast.LENGTH_SHORT).show();
        } else if (edtTxtHeight.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please Enter Your Height in cm", Toast.LENGTH_SHORT).show();
        } else if (edtTxtWeight.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please Enter Your Weight in kg", Toast.LENGTH_SHORT).show();
        } else if (edtTxtAge.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please Enter Your Age", Toast.LENGTH_SHORT).show();
        } else if (radioGroupWeight.getCheckedRadioButtonId() == -1) { // no buttons are checked
            Toast.makeText(this, "Please Select Your Goal", Toast.LENGTH_SHORT).show();
        } else {
            performSignUp();
        }

    }

    public void performSignUp(){
        LoginSystem loginSystem = new LoginSystem(this);

        if(loginSystem.checkUsernameExists(username)){
            Toast.makeText(this, "This username is taken. Please try another one.",
                    Toast.LENGTH_SHORT).show();
            edtTxtUser.setText("");
        }
        else {
            //Creates new user with the given details.
            User user = new User(fullname, username, password, gender, weight, height, age, goal);

            // Inserts user into database and open login page.
            loginSystem.RegisterUser(user);
            Toast.makeText(this, "Account Created! Please Enter Login Information",
                    Toast.LENGTH_SHORT).show();
            openLoginPage();
        }
    }
}
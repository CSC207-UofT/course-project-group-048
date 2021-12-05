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
import nutrition.MyDBHandler;
import nutrition.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    String fullname, username, password, gender;
    Double height, weight;
    int age;

    private EditText edtTxtFullName, edtTxtUser, edtTxtPass, edtTxtHeight, edtTxtWeight, edtTxtAge;
    private RadioGroup radioGroupGender, radioGroupWeight;
    private RadioButton radioBtnMale, radioBtnFemale, radioBtnGain, radioBtnLose;

    MyDBHandler dbHandler;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.registerBtn) {
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

                //Set private variables as per user inputted details.
                fullname = edtTxtFullName.getText().toString();
                username = edtTxtUser.getText().toString();
                password = edtTxtPass.getText().toString();
                height = Double.parseDouble(edtTxtHeight.getText().toString());
                weight = Double.parseDouble(edtTxtWeight.getText().toString());
                age = Integer.parseInt(edtTxtAge.getText().toString());

                //Retrieve all usernames and corresponding passwords to store in loginsystem class.
                LoginSystem loginSystem = new LoginSystem(dbHandler.GetLoginData());

                //Check whether username already exists. If it exists then ask the user to input a
                //new one. If not, create account with given details.
                if (loginSystem.GetUsernames().contains(username)){
                    Toast.makeText(this, "This username is taken. Please try another one.",
                            Toast.LENGTH_SHORT).show();
                    edtTxtUser.setText("");
                }
                else {
                    //Creates new user with the given details.
                    User user = new User(fullname, username, password, gender, weight, height, age);

                    // Inserts user into database and open login page.
                    dbHandler.addUser(user);
                    Toast.makeText(this, "Account Created! Please Enter Login Information",
                            Toast.LENGTH_SHORT).show();
                    openLoginPage();
                }

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        Button registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);

        edtTxtFullName = findViewById(R.id.edtTxtFullName);
        edtTxtUser = findViewById(R.id.edtTxtUser);
        edtTxtPass = findViewById(R.id.edtTxtPass);
        edtTxtHeight = findViewById(R.id.edtTxtHeight);
        edtTxtWeight = findViewById(R.id.edtTxtWeight);
        edtTxtAge = findViewById(R.id.edtTxtAge);

        radioBtnMale = findViewById(R.id.radioBtnMale);
        radioBtnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "male"; //Sets gender to male if male button is clicked.
            }
        });

        radioBtnFemale = findViewById(R.id.radioBtnFemale);
        radioBtnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female"; //Sets gender to female if female button is clicked.
            }
        });

        radioBtnGain = findViewById(R.id.radioBtnGain);
        radioBtnGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                goal = "gain weight"; // set goal to gain weight when gain weight button is clicked
            }
        });

        radioBtnLose = findViewById(R.id.radioBtnLose);
        radioBtnLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                goal = "lose weight"; // set goal to lose weight when lose weight button is clicked
            }
        });

        //Create database variable.
        dbHandler = new MyDBHandler(this, null, null, 1);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupWeight = findViewById(R.id.radioGroupWeight);
    }
    public void openLoginPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
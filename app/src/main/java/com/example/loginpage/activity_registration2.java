package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class activity_registration2 extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTxtFullName, edtTxtUser, edtTxtPass, edtTxtHeight, edtTxtWeight, edtTxtAge;
    private RadioGroup radioGroupGender;

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
            } else {
                Toast.makeText(this, "Account Created! Please Enter Login Information", Toast.LENGTH_SHORT).show();
                openLoginPage();
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

        radioGroupGender = findViewById(R.id.radioGroupGender);
    }
    public void openLoginPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
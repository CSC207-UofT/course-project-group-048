package drivers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.loginpage.R;

import controllers.LoginSystem;
import entities.User;
import entities.Utils;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    String fullName, username, password, gender, goal, heightString, weightString, ageString;
    int height, weight;
    int age;

    private EditText edtTxtFullName, edtTxtUser, edtTxtPass, edtTxtHeight, edtTxtWeight, edtTxtAge;
    private RadioGroup radioGroupGender, radioGroupWeight;

    /**
     * Actions to do when the activity begins. Creates
     * buttons and edit text objects.
     *
     * @param savedInstanceState the state of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setAllButtons();
        setEditTexts();
    }

    /**
     * Set up register button and radio buttons.
     */
    private void setAllButtons() {
        Button registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);
        setRadioButtons();
    }

    /**
     * Set up EditText objects to take in input from user.
     */
    public void setEditTexts() {
        edtTxtFullName = findViewById(R.id.edtTxtFullName);
        edtTxtUser = findViewById(R.id.edtTxtUser);
        edtTxtPass = findViewById(R.id.edtTxtPass);
        edtTxtHeight = findViewById(R.id.edtTxtHeight);
        edtTxtWeight = findViewById(R.id.edtTxtWeight);
        edtTxtAge = findViewById(R.id.edtTxtAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupWeight = findViewById(R.id.radioGroupWeight);
    }

    /**
     * Finds which part of the View was clicked. If this part is the register
     * button, then the user information is entered into the database.
     *
     * @param v the current View object
     */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.registerBtn) {
            //Set private variables as per user inputted details.
            fullName = edtTxtFullName.getText().toString().trim();
            username = edtTxtUser.getText().toString().trim();
            password = edtTxtPass.getText().toString().trim();
            heightString = edtTxtHeight.getText().toString().trim();
            weightString = edtTxtWeight.getText().toString().trim();
            ageString = edtTxtAge.getText().toString().trim();

            checkAllFieldsAndSignUp();
        }
    }

    private void setRadioButtons() {
        setMaleButton();
        setFemaleButton();
        setGainWeightButton();
        setLoseWeightButton();
    }

    /**
     * Set up the gender select male radio button to set gender
     * String to male.
     */
    private void setMaleButton() {
        RadioButton radioBtnMale = findViewById(R.id.radioBtnMale);
        radioBtnMale.setOnClickListener(v -> {
            gender = "male"; //Sets gender to male if male button is clicked.
        });
    }

    /**
     * Set up the gender select female radio button to set gender
     * String to female.
     */
    private void setFemaleButton() {
        RadioButton radioBtnFemale = findViewById(R.id.radioBtnFemale);
        radioBtnFemale.setOnClickListener(v -> {
            gender = "female"; //Sets gender to female if female button is clicked.
        });
    }

    /**
     * Set up the goal select gain weight radio button to set goal
     * String to gain.
     */
    private void setGainWeightButton() {
        RadioButton radioBtnGain = findViewById(R.id.radioBtnGain);
        radioBtnGain.setOnClickListener(v -> {
            goal = "gain"; // set goal to gain weight when gain weight button is clicked
        });
    }

    /**
     * Set up the lose select gain weight radio button to set goal
     * String to lose.
     */
    public void setLoseWeightButton() {
        RadioButton radioBtnLose = findViewById(R.id.radioBtnLose);
        radioBtnLose.setOnClickListener(v -> {
            goal = "lose"; // set goal to lose weight when lose weight button is clicked
        });
    }


    /**
     * Open the login page
     */
    public void openLoginPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Check all registration fields and create new user in the database.
     */
    public void checkAllFieldsAndSignUp(){
        // display appropriate Toast message based on corresponding missing information
        if (fullName.length() == 0){
            Toast.makeText(this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show();
        } else if (username.length() == 0) {
            Toast.makeText(this, "Please Enter a Username", Toast.LENGTH_SHORT).show();
        } else if (password.length() == 0) {
            Toast.makeText(this, "Please Enter a Password", Toast.LENGTH_SHORT).show();
        } else if (radioGroupGender.getCheckedRadioButtonId() == -1){ // no buttons are checked
            Toast.makeText(this, "Please Select Your Gender", Toast.LENGTH_SHORT).show();
        } else if (heightString.length() == 0) {
            Toast.makeText(this, "Please Enter Your Height in cm", Toast.LENGTH_SHORT).show();
        } else if (weightString.length() == 0) {
            Toast.makeText(this, "Please Enter Your Weight in kg", Toast.LENGTH_SHORT).show();
        } else if (ageString.length() == 0) {
            Toast.makeText(this, "Please Enter Your Age", Toast.LENGTH_SHORT).show();
        } else if (radioGroupWeight.getCheckedRadioButtonId() == -1) { // no buttons are checked
            Toast.makeText(this, "Please Select Your Goal", Toast.LENGTH_SHORT).show();
        } else {
            performSignUp();
        }

    }

    /**
     * Create a new user in the database.
     */
    public void performSignUp(){
        LoginSystem loginSystem = new LoginSystem(this);

        if(loginSystem.checkUsernameExists(username)){
            Toast.makeText(this, "This username is taken. Please try another one.",
                    Toast.LENGTH_SHORT).show();
            edtTxtUser.setText("");
        }
        else {
            //Creates new user with the given details.
            password = Utils.getHash(password);
            weight = Integer.parseInt(weightString);
            height = Integer.parseInt(heightString);
            age = Integer.parseInt(ageString);
            User user = new User(fullName, username, password, gender, weight, height, age, goal);

            // Inserts user into database and open login page.
            loginSystem.registerUser(user);
            Toast.makeText(this, "Account Created! Please Enter Login Information",
                    Toast.LENGTH_SHORT).show();
            openLoginPage();
        }
    }
}
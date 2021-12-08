package drivers.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginpage.R;

import controllers.LoginSystem;
import entities.User;
import usecases.LoginDataHandler;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    User user;
    LoginSystem system;
    String username, newGender, newGoal, newHeightString, newWeightString, newAgeString;
    int newHeight, newWeight, newAge;
    LoginDataHandler loginDatabase;

    private EditText edtTxtHeight, edtTxtWeight, edtTxtAge;
    private RadioGroup radioGroupGender, radioGroupWeight;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.updateBtn) {
            // Set private variables as per user inputted details.
            loginDatabase = new LoginDataHandler(this, null);
            newHeightString = edtTxtHeight.getText().toString().trim();
            newWeightString = edtTxtWeight.getText().toString().trim();
            newAgeString = edtTxtAge.getText().toString().trim();
            checkAllFields();
        }
    }

    public void checkAllFields() {
        if (newHeightString.length() == 0) {
            Toast.makeText(this, "Please Enter New Height", Toast.LENGTH_SHORT).show();
        } else if (newWeightString.length() == 0) {
            Toast.makeText(this, "Please Enter New Weight", Toast.LENGTH_SHORT).show();
        } else if (newAgeString.length() == 0) {
            Toast.makeText(this, "Please Enter New Age", Toast.LENGTH_SHORT).show();
        } else if (radioGroupGender.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "Please Select New Gender", Toast.LENGTH_SHORT).show();
        } else if (radioGroupWeight.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select New Goal", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Information Updated!", Toast.LENGTH_SHORT).show();
            updateFields();
            openHomePage();
        }
    }

    private void updateFields() {
        newHeight = Integer.parseInt(newHeightString);
        newWeight = Integer.parseInt(newWeightString);
        newAge = Integer.parseInt(newAgeString);

        System.out.println(newAge);

        loginDatabase.UpdateDetails(user.getUsername(), newHeight, newWeight, newAge, newGender, newGoal);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle extras = getIntent().getExtras();
        system = new LoginSystem(this);
        username = (String) extras.get("username");
        user = system.getUser(username);
        Button updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(this);
        setRadioButtons();

        edtTxtHeight = findViewById(R.id.edtTxtHeight2);
        edtTxtWeight = findViewById(R.id.edtTxtWeight2);
        edtTxtAge = findViewById(R.id.edtTxtAge2);
        radioGroupGender = findViewById(R.id.radioGroupGender2);
        radioGroupWeight = findViewById(R.id.radioGroupWeight2);

        TextView tv1 = findViewById(R.id.currentGenderText);
        TextView tv2 = findViewById(R.id.currentHeightText);
        TextView tv3 = findViewById(R.id.currentWeightText);
        TextView tv4 = findViewById(R.id.currentAgeText);
        TextView tv5 = findViewById(R.id.currentGoalText);

        String genderString = "Current Gender: " + user.getGender();
        String heightString = "Current Height: " + user.getHeight() + " cm";
        String weightString = "Current Weight: " + user.getWeight() + " kg";
        String ageString = "Current Age: " + user.getAge();
        String goalString = "Current Goal: " + user.getGoal() + " Weight";

        tv1.setText(genderString);
        tv2.setText(heightString);
        tv3.setText(weightString);
        tv4.setText(ageString);
        tv5.setText(goalString);
    }

    public void setRadioButtons() {
        setMaleButton();
        setFemaleButton();
        setGainWeightButton();
        setLoseWeightButton();
    }

    public void setMaleButton() {
        RadioButton radioBtnMale = findViewById(R.id.radioBtnMale2);
        radioBtnMale.setOnClickListener(v -> {
            newGender = "male"; //Sets gender to male if male button is clicked.
        });
    }

    public void setFemaleButton() {
        RadioButton radioBtnFemale = findViewById(R.id.radioBtnFemale2);
        radioBtnFemale.setOnClickListener(v -> {
            newGender = "female"; //Sets gender to female if female button is clicked.
        });
    }

    public void setGainWeightButton() {
        RadioButton radioBtnGain = findViewById(R.id.radioBtnGain2);
        radioBtnGain.setOnClickListener(v -> {
            newGoal = "gain"; // set goal to gain weight when gain weight button is clicked
        });
    }

    public void setLoseWeightButton() {
        RadioButton radioBtnLose = findViewById(R.id.radioBtnLose2);
        radioBtnLose.setOnClickListener(v -> {
            newGoal = "lose"; // set goal to lose weight when lose weight button is clicked
        });
    }

    public void openHomePage() {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        openTheHomePage.putExtra("username", username);
        startActivity(openTheHomePage);
    }

    public void openHomePage(View view) {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        openTheHomePage.putExtra("username", username);
        startActivity(openTheHomePage);
    }

    public void openProfilePage(View view) {
        // refresh the page
        finish();
        startActivity(getIntent());
    }

    public void openMealGeneratorPage(View view) {
        Intent openTheMealGeneratorPage = new Intent(this, MealGeneratorActivity.class);
        openTheMealGeneratorPage.putExtra("username", username);
        startActivity(openTheMealGeneratorPage);
    }
}

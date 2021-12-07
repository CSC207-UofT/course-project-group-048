package drivers;

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
import usecases.MyDBHandler;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    User user;
    LoginSystem system;
    String username, newGender, newGoal, newHeightString, newWeightString, newAgeString;
    int newHeight, newWeight, newAge;
    MyDBHandler dbHandler;

    private EditText edtTxtHeight, edtTxtWeight, edtTxtAge;
    private RadioGroup radioGroupGender, radioGroupWeight;
    private RadioButton radioBtnMale, radioBtnFemale, radioBtnGain, radioBtnLose;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.updateBtn) {
            // Set private variables as per user inputted details.
            dbHandler = new MyDBHandler(this, null, null, 1);
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

        dbHandler.UpdateDetails(user.getUsername(), newHeight, newWeight, newAge, newGender, newGoal);

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

        TextView tv1 = (TextView)findViewById(R.id.currentGenderText);
        TextView tv2 = (TextView)findViewById(R.id.currentHeightText);
        TextView tv3 = (TextView)findViewById(R.id.currentWeightText);
        TextView tv4 = (TextView)findViewById(R.id.currentAgeText);
        TextView tv5 = (TextView)findViewById(R.id.currentGoalText);

        tv1.setText("Current Gender: " + user.getGender());
        tv2.setText("Current Height: " + user.getHeight() + " cm");
        tv3.setText("Current Weight: " + user.getWeight() + " kg");
        tv4.setText("Current Age: " + user.getAge());
        tv5.setText("Current Goal: " + user.getGoal() + " Weight");
    }

    public void setRadioButtons() {
        setMaleButton();
        setFemaleButton();
        setGainWeightButton();
        setLoseWeightButton();
    }

    public void setMaleButton() {
        radioBtnMale = findViewById(R.id.radioBtnMale2);
        radioBtnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGender = "male"; //Sets gender to male if male button is clicked.
            }
        });
    }

    public void setFemaleButton() {
        radioBtnFemale = findViewById(R.id.radioBtnFemale2);
        radioBtnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGender = "female"; //Sets gender to female if female button is clicked.
            }
        });
    }

    public void setGainWeightButton() {
        radioBtnGain = findViewById(R.id.radioBtnGain2);
        radioBtnGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGoal = "gain"; // set goal to gain weight when gain weight button is clicked
            }
        });
    }

    public void setLoseWeightButton() {
        radioBtnLose = findViewById(R.id.radioBtnLose2);
        radioBtnLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGoal = "lose"; // set goal to lose weight when lose weight button is clicked
            }
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

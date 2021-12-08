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

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener, LoggedInActivity {

    User user;
    LoginSystem system;
    String username, newGender, newGoal, newHeightString, newWeightString, newAgeString;
    int newHeight, newWeight, newAge;
    LoginDataHandler loginDatabase;

    private EditText edtTxtHeight, edtTxtWeight, edtTxtAge;
    private RadioGroup radioGroupGender, radioGroupWeight;

    /**
     * Actions to do when the activity begins. Loads the user information,
     * creates update button and radio buttons, creates edit text objects,
     * and sets text views to display current user information.
     *
     * @param savedInstanceState the state of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // set the XML page to open

        // load information and instantiate
        loadUserInformation();
        setAllButtons();
        setEditTexts();
        setTextViews();
    }

    /**
     * Loads the current user information from the username
     * passed from another activity in a Bundle object.
     */
    @Override
    public void loadUserInformation() {
        Bundle extras = getIntent().getExtras();
        system = new LoginSystem(this);
        username = (String) extras.get("username");
        user = system.getUser(username);
    }

    /**
     * Set up update button and radio buttons.
     */
    private void setAllButtons() {
        Button updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(this);
        setRadioButtons();
    }

    /**
     * Set up EditText fields for user to update information.
     */
    private void setEditTexts() {
        edtTxtHeight = findViewById(R.id.edtTxtHeight2);
        edtTxtWeight = findViewById(R.id.edtTxtWeight2);
        edtTxtAge = findViewById(R.id.edtTxtAge2);
        radioGroupGender = findViewById(R.id.radioGroupGender2);
        radioGroupWeight = findViewById(R.id.radioGroupWeight2);
    }

    /**
     * Set up TextView objects to display the current user information. Assumes
     * the user information has already been loaded.
     */
    private void setTextViews() {
        setTextView(R.id.currentGenderText, "Current Gender: " + user.getGender());
        setTextView(R.id.currentHeightText, "Current Height: " + user.getHeight() + " cm");
        setTextView(R.id.currentWeightText, "Current Weight: " + user.getWeight() + " kg");
        setTextView(R.id.currentAgeText, "Current Age: " + user.getAge());
        setTextView(R.id.currentGoalText, "Current Goal: " + user.getGoal() + " Weight");
    }

    /**
     * Sets a TextView object to display text.
     *
     * @param textViewId the ID of the text view to edit text
     * @param text the new text to display
     */
    private void setTextView(int textViewId, String text) {
        TextView tv = findViewById(textViewId);
        tv.setText(text);
    }

    /**
     * Finds which part of the View was clicked. If this part is the update
     * button, then the user information is updated in the database.
     *
     * @param v the current View object
     */
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

    /**
     * Check all fields in the update form. Make sure everything has been
     * entered. If so, then update information and launch the home page.
     * If not, display Toast message to warn the user.
     */
    public void checkAllFields() {
        /* showcase appropriate Toast message based on missing information
           else update information */
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

    /**
     * Update all user information in the database as per the new
     * inputted details.
     */
    private void updateFields() {
        newHeight = Integer.parseInt(newHeightString);
        newWeight = Integer.parseInt(newWeightString);
        newAge = Integer.parseInt(newAgeString);

        System.out.println(newAge);

        loginDatabase.UpdateDetails(user.getUsername(), newHeight, newWeight, newAge, newGender, newGoal);

    }

    /**
     * Set up the radio buttons.
     */
    private void setRadioButtons() {
        setMaleButton();
        setFemaleButton();
        setGainWeightButton();
        setLoseWeightButton();
    }

    /**
     * Set up the gender select male radio button to set newGender
     * String to male.
     */
    public void setMaleButton() {
        RadioButton radioBtnMale = findViewById(R.id.radioBtnMale2);
        radioBtnMale.setOnClickListener(v -> {
            newGender = "male"; //Sets gender to male if male button is clicked.
        });
    }

    /**
     * Set up the gender select female radio button to set newGender
     * String to female.
     */
    public void setFemaleButton() {
        RadioButton radioBtnFemale = findViewById(R.id.radioBtnFemale2);
        radioBtnFemale.setOnClickListener(v -> {
            newGender = "female"; //Sets gender to female if female button is clicked.
        });
    }

    /**
     * Set up the goal select gain weight radio button to set newGoal
     * String to gain.
     */
    public void setGainWeightButton() {
        RadioButton radioBtnGain = findViewById(R.id.radioBtnGain2);
        radioBtnGain.setOnClickListener(v -> {
            newGoal = "gain"; // set goal to gain weight when gain weight button is clicked
        });
    }

    /**
     * Set up the goal select lose weight radio button to set newGoal
     * String to lose.
     */
    public void setLoseWeightButton() {
        RadioButton radioBtnLose = findViewById(R.id.radioBtnLose2);
        radioBtnLose.setOnClickListener(v -> {
            newGoal = "lose"; // set goal to lose weight when lose weight button is clicked
        });
    }

    /**
     * Open the home page and start HomePageActivity with provided username.
     * Should only be called if user has logged in with valid credentials.
     */
    public void openHomePage() {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        openTheHomePage.putExtra("username", username);
        startActivity(openTheHomePage);
    }

    /**
     * Open the home page and start HomePageActivity with provided username.
     * @param view the current View object.
     */
    @Override
    public void openHomePage(View view) {
        Intent openTheHomePage = new Intent(this, HomePageActivity.class);
        openTheHomePage.putExtra("username", username);
        startActivity(openTheHomePage);
    }

    /**
     * Refresh the profile page and restart ProfileActivity.
     * @param view the current View object.
     */
    @Override
    public void openProfilePage(View view) {
        // refresh the page
        finish();
        startActivity(getIntent());
    }

    /**
     * Open the meal generator page and start MealGeneratorActivity with provided username.
     * @param view the current View object.
     */
    @Override
    public void openMealGeneratorPage(View view) {
        Intent openTheMealGeneratorPage = new Intent(this, MealGeneratorActivity.class);
        openTheMealGeneratorPage.putExtra("username", username);
        startActivity(openTheMealGeneratorPage);
    }
}

package drivers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import com.example.loginpage.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import drivers.Activity.MainActivity;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

@RunWith(JUnit4.class)
public class ProfileActivityTest implements TestLoginSystem {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        registerLoginNewUser("johndoe123", "password");
        openProfilePage();
    }

    @Test
    public void testLaunch() {
        onView(withId(R.id.updateBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void testUpdateHeight() {
        // current height is 140 cm, change to 180 cm
        onView(withId(R.id.edtTxtHeight2)).perform(typeText("180"));
        onView(withId(R.id.edtTxtWeight2)).perform(typeText("61"));
        onView(withId(R.id.edtTxtAge2)).perform(typeText("22"));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.radioBtnFemale2)).perform(click());
        onView(withId(R.id.radioBtnGain2)).perform(click());
        onView(withId(R.id.updateBtn)).perform(click());

        // verify that current height is now 180 cm
        openProfilePage();
        onView(withId(R.id.currentHeightText)).check(matches(withText("Current Height: 180.0 cm")));
    }

    @Test
    public void testUpdateWeight() {
        // current weight is 61 kg, change to 58 kg
        onView(withId(R.id.edtTxtHeight2)).perform(typeText("180"));
        onView(withId(R.id.edtTxtWeight2)).perform(typeText("58"));
        onView(withId(R.id.edtTxtAge2)).perform(typeText("22"));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.radioBtnFemale2)).perform(click());
        onView(withId(R.id.radioBtnGain2)).perform(click());
        onView(withId(R.id.updateBtn)).perform(click());

        // verify that current weight has changed
        openProfilePage();
        onView(withId(R.id.currentWeightText)).check(matches(withText("Current Weight: 58.0 kg")));
    }

    @Test
    public void testUpdateAge() {
        // current age is 22, change to 35
        onView(withId(R.id.edtTxtHeight2)).perform(typeText("180"));
        onView(withId(R.id.edtTxtWeight2)).perform(typeText("58"));
        onView(withId(R.id.edtTxtAge2)).perform(typeText("35"));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.radioBtnFemale2)).perform(click());
        onView(withId(R.id.radioBtnGain2)).perform(click());
        onView(withId(R.id.updateBtn)).perform(click());

        // verify that current age has changed
        openProfilePage();
        onView(withId(R.id.currentAgeText)).check(matches(withText("Current Age: 35")));
    }

    @Test
    public void testUpdateGender() {
        // current gender is female, change to male
        onView(withId(R.id.edtTxtHeight2)).perform(typeText("180"));
        onView(withId(R.id.edtTxtWeight2)).perform(typeText("58"));
        onView(withId(R.id.edtTxtAge2)).perform(typeText("35"));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.radioBtnMale2)).perform(click());
        onView(withId(R.id.radioBtnGain2)).perform(click());
        onView(withId(R.id.updateBtn)).perform(click());

        // verify that current gender has changed
        openProfilePage();
        onView(withId(R.id.currentGenderText)).check(matches(withText("Current Gender: male")));
    }

    @Test
    public void testUpdateGoal() {
        // current gender is female, change to male
        onView(withId(R.id.edtTxtHeight2)).perform(typeText("180"));
        onView(withId(R.id.edtTxtWeight2)).perform(typeText("58"));
        onView(withId(R.id.edtTxtAge2)).perform(typeText("35"));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.radioBtnMale2)).perform(click());
        onView(withId(R.id.radioBtnLose2)).perform(click());
        onView(withId(R.id.updateBtn)).perform(click());

        // verify that current goal has changed
        openProfilePage();
        onView(withId(R.id.currentGoalText)).check(matches(withText("Current Goal: lose Weight")));
    }

    private void openProfilePage() {
        onView(withId(R.id.imageViewProfile)).perform(click());
    }

}
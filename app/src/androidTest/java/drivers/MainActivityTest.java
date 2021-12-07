package drivers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

import android.view.View;

import com.example.loginpage.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import drivers.Activity.MainActivity;
import drivers.Activity.RegisterActivity;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(JUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLaunch(){
        onView(withId(R.id.txtViewPassword)).check(matches(withText("Password")));
    }
    @Test
    public void testRegistration() {
        onView(withId(R.id.buttonCreateAcc)).perform(click());
        onView(withId(R.id.radioBtnGain)).check(matches(isDisplayed()));
    }
}
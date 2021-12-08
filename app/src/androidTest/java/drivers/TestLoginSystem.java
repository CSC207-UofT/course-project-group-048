package drivers;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.action.ViewActions;

import com.example.loginpage.R;

public interface TestLoginSystem {

    default void registerNewUser(String username, String password) {
        onView(withId(R.id.edtTxtFullName)).perform(typeText("New User"));
        onView(withId(R.id.edtTxtUser)).perform(typeText(username));
        onView(withId(R.id.edtTxtPass)).perform(typeText(password));
        onView(withId(R.id.radioBtnFemale)).perform(click());
        onView(withId(R.id.edtTxtHeight)).perform(typeText("140"));
        onView(withId(R.id.edtTxtWeight)).perform(typeText("61"));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.edtTxtAge)).perform(typeText("22"));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.radioBtnGain)).perform(click());
        onView(withId(R.id.registerBtn)).perform(click());
    }

    default void loginNewUser(String username, String password) {
        onView(withId(R.id.edtTxtUsername)).perform(typeText(username));
        onView(withId(R.id.edtTxtPassword)).perform(typeText(password));
        onView(isRoot()).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.loginButton)).perform(click());
    }

    default void goToLoginPage() {
        try {
            onView(withId(R.id.loginButton)).check(matches(isDisplayed()));
        } catch(androidx.test.espresso.NoMatchingViewException e) {
            onView(isRoot()).perform(ViewActions.pressBack());
        }
    }

    default void registerLoginNewUser(String username, String password) {
        onView(withId(R.id.buttonCreateAcc)).perform(click());
        registerNewUser(username, password);
        goToLoginPage();
        loginNewUser(username, password);
    }
}

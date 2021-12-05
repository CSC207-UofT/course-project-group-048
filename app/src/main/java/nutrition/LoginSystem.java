package nutrition;

import android.content.Context;

import com.example.loginpage.RegisterActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    A system to store users of the app and their
    information. Gives access to a particular user.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/*
    A system to store usernames and corresponding passwords of the users of the app.
 */

public class LoginSystem {

    private HashMap<String, String> logindata;
    MyDBHandler dbHandler;

    public LoginSystem(Context context){
        dbHandler = new MyDBHandler(context, null, null, 1);
        this.logindata = this.dbHandler.GetLoginData();
    }

    /**
     * Retrieves the usernames of all the users in the app.
     * @return a set containing all usernames of the app users.
     */
    public boolean checkUsernameExists(String username){
        return logindata.containsKey(username);
    }

    /**
     * Checks whether the given password matches the password of the username. If the username
     * does not exist then returns false.
     * @param username Username inputted by the user.
     * @param password Password inputted by the user.
     * @return True if password matches the true password of the given username and false otherwise.
     * Also returns false if username does not exist.
     */
    public boolean CheckUsernamePassword(String username, String password){
        if (logindata.containsKey(username)){
            return Objects.equals(logindata.get(username), password);
        }
        return false;
    }

    public void RegisterUser(User user){
        dbHandler.addUser(user);
    }



}
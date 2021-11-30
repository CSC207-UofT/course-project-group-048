package nutrition;

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

    public LoginSystem(HashMap<String, String> LoginData){
        this.logindata = LoginData;
    }

    /**
     * Retrieves the usernames of all the users in the app.
     * @return a set containing all usernames of the app users.
     */
    public Set<String> GetUsernames(){
        return logindata.keySet();
    }

    /**
     * Checks whether the given password matches the password of the username. If the username
     * does not exist then returns false.
     * @param username Username inputted by the user.
     * @param password Password inputted by the user.
     * @return True if password matches the true password of the given username and false otherwise.
     * Also returns false if username does not exist.
     */
    public Boolean CheckUsernamePassword(String username, String password){
        if (logindata.containsKey(username)){
            return Objects.equals(logindata.get(username), password);
        }
        return false;
    }



}
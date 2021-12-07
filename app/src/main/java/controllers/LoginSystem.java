package controllers;

import android.content.Context;

import java.util.HashMap;

import entities.User;
import entities.Utils;
import usecases.MyDBHandler;

/*
    A system to store users of the app and their
    information. Gives access to a particular user.
 */

/*
    A system to store usernames and corresponding passwords of the users of the app.
 */

public class LoginSystem {

    private HashMap<String, User> loginData;
    MyDBHandler dbHandler;

    public LoginSystem(Context context){
        dbHandler = new MyDBHandler(context, null, null, 1);
        // dbHandler.resetDatabase();
        this.loginData = this.dbHandler.getLoginData();
    }

    /**
     * Retrieves the usernames of all the users in the app.
     * @return a set containing all usernames of the app users.
     */
    public boolean checkUsernameExists(String username){
        return loginData.containsKey(username);
    }

    /**
     * Checks whether the given password matches the password of the username. If the username
     * does not exist then returns false.
     * @param username Username inputted by the user.
     * @param password Password inputted by the user.
     * @return True if password matches the true password of the given username and false otherwise.
     * Also returns false if username does not exist.
     */
    public boolean checkUsernamePassword(String username, String password){
        if (loginData.containsKey(username)){
            String actualPassword = loginData.get(username).getPasswordHash();
            String enteredPassword = Utils.getHash(password);
            return actualPassword.equals(enteredPassword);
        }
        return false;
    }

    public User getUser(String username) {
        return loginData.get(username);
    }

    public void registerUser(User user){
        dbHandler.addUser(user);
    }



}
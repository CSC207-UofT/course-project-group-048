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

public class LoginSystem {

    private HashMap<String, User> loginData;
    private MyDBHandler dbHandler;

    /**
     * Create a new LoginSystem instance.
     *
     * @param context the instance of the driver activity
     */
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

    /**
     * Get a User instance from a username. Assumes method is being called
     * with correct permissions to access this user.
     *
     * @param username the username of the User in loginData
     * @return the User instance associated with username
     */
    public User getUser(String username) {
        return loginData.get(username);
    }

    public void registerUser(User user){
        dbHandler.addUser(user);
    }



}
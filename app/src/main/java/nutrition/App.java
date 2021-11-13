package nutrition;

import nutrition.exceptions.*;


/*
        A class that controls the program itself. Designed to be extended
        by a User Interface class.

        Instance variables:
         - user: the current user that is logged in
         - system: database storing other accounts
     */

public class App {
    protected User user;
    private LoginSystem system;

    public App() {
        system = new LoginSystem();
    }

    /**
     * Get the username of the current user.
     *
     * @return the username of User and null if it does not exist.
     */
    public String getUserUsername() {
        if (user == null) {
            return null;
        }
        return user.getUsername();
    }

    /**
     * Login a user into the app.
     *
     * @param username the username of the User to login
     * @param passwordHash the SHA256 hash of the attempted password
     * @throws LoginException if the username or password is incorrect
     */
    public void login(String username, String passwordHash) throws LoginException {
        user = system.logInUser(username, passwordHash);
    }

    /**
     * Register a new user to the app.
     *
     * @param username the username of the User to register
     * @param passwordHash the SHA256 hash of the new password
     * @throws LoginException if the username is already registered
     */
    public void register(String username, String passwordHash, double weight,
                         double height, int activityLevel, int age) throws LoginException {
        system.registerUser(username, passwordHash, weight, height, activityLevel, age);
        login(username, passwordHash);
    }

    /**
     * Register a new user to the app.
     *
     * @param username the username of the User to register
     * @param passwordHash the SHA256 hash of the new password
     * @throws LoginException if the username is already registered
     */
    public void register(String username, String passwordHash) throws LoginException {
        system.registerUser(username, passwordHash);
        system.logInUser(username, passwordHash);
    }

}

import exceptions.*;

import java.util.ArrayList;
import java.util.List;

/*
    A system to store users of the app and their
    information. Gives access to a particular user.
 */

public class LoginSystem {

    private List<User> users;

    public LoginSystem() {
        this.users = new ArrayList<>();
    }

    /**
     * Get the user object from the username
     *
     * @param username the username of the user to get
     * @return the corresponding User instance
     * @throws UsernameNotFoundException of the username is not in the system
     */
    public User getUser(String username) throws UsernameNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        throw new UsernameNotFoundException("User \"" + username + "\" Not found.");
    }

    /**
     * Check whether a username exists in the system.
     *
     * @param username the username of the user
     * @return whether or not the username exists
     */
    public boolean userExists(String username) {
        try {
            User candidate = getUser(username);
            return true;
        } catch(UsernameNotFoundException e) {
            return false;
        }
    }

    /**
     * Login a new user to the system
     *
     * @param username the username of the user to login
     * @param passwordHash the attempted password of the user
     * @return the User object that represents the user
     * @throws LoginException if username/password is invalid
     */
    public User logInUser(String username, String passwordHash) throws LoginException {
        User candidate = getUser(username);

        if (candidate.getPasswordHash().equals(passwordHash)) {
            return candidate;
        }

        throw new InvalidPasswordException("Invalid password.");
    }

    /**
     * Register a new user to the system.
     *
     * @param username the username of the new user
     * @param passwordHash the SHA256 hash of the new user's password
     * @param weight the weight of the new user
     * @param height the height of the new user
     * @param activityLevel the level to which the new user exercises
     * @param age the age of the new user
     * @throws LoginException if the username already exists in the system.
     */
    public void registerUser(String username, String passwordHash, double weight,
                             double height, int activityLevel, int age) throws LoginException {
        if (userExists(username)) {
            throw new UserAlreadyRegisteredException("Username \"" + username + "\" is already registered.");
        } else {
            users.add(new User(username, passwordHash, weight, height, activityLevel, age));
        }
    }

    /**
     * Register a new user to the system.
     *
     * @param username the username of the new user
     * @param passwordHash the SHA256 hash of the new user's password
     * @throws LoginException if the username already exists in the system.
     */
    public void registerUser(String username, String passwordHash) throws LoginException {
         if (userExists(username)) {
            throw new UserAlreadyRegisteredException("Username \"" + username + "\" is already registered.");
        } else {
            users.add(new User(username, passwordHash));
        }
    }
}


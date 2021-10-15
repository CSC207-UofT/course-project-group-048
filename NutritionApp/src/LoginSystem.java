import exceptions.*;

import java.util.ArrayList;
import java.util.List;


public class LoginSystem {

    private List<User> users;

    public LoginSystem() {
        this.users = new ArrayList<>();
    }

    private User getUser(String username) throws UsernameNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        throw new UsernameNotFoundException("User \"" + username + "\" Not found.");
    }

    private boolean userExists(String username) {
        try {
            User candidate = getUser(username);
            return true;
        } catch(UsernameNotFoundException e) {
            return false;
        }
    }

    public User logInUser(String username, String passwordHash) throws LoginException {
        User candidate = getUser(username);

        if (candidate.getPasswordHash().equals(passwordHash)) {
            return candidate;
        }

        throw new InvalidPasswordException("Invalid password.");
    }

    public void registerUser(String username, String passwordHash) throws LoginException {
        if (userExists(username)) {
            throw new UserAlreadyRegisteredException("Username \"" + username + "\" is already registered.");
        } else {
            users.add(new User(username, passwordHash));
        }
    }

}


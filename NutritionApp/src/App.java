import exceptions.*;

public class App {
    private User user;
    private LoginSystem system;

    public App() {
        system = new LoginSystem();
    }

    public void login(String username, String passwordHash) throws LoginException {
        user = system.logInUser(username, passwordHash);
    }

    public void register(String username, String passwordHash) throws LoginException {
        system.registerUser(username, passwordHash);
        system.logInUser(username, passwordHash);
    }






}

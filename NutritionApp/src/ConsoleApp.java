import exceptions.LoginException;

/*
    Runs the program through the console by asking
    for user input with Scanner objects.
 */
public class ConsoleApp extends App {
    public ConsoleApp() {
        super();
    }

    /**
     * Welcome a new or existing user to the app.
     *
     * @throws LoginException if an existing username is registered
     * or a user logs in with invalid username/password.
     */
    public void signInUser() throws LoginException {
        System.out.println("\nWelcome to Fitness 4 Life!");
        String type = Utils.getString("Enter 'R' to register, 'L' to login ", "R", "L");
        System.out.println();

        if (type.equals("R")) {
            // get username and password and create new user.
            String username = Utils.getString("Enter a username: ");
            String passwordText = Utils.getString("Please enter a password: ");
            double weight = Utils.getDouble("Enter your weight (lbs): ");
            double height = Utils.getDouble("Enter your height (in): ");
            int activityLevel = Utils.getInt("Enter your activity level from (1 - 100)", 1, 100);
            int age = Utils.getInt("Enter your age: ", 0, 140);
            register(username, getHash(passwordText), weight, height, activityLevel, age);
        } else {
            // get entered username and password and attempt login.
            String username = Utils.getString("Please enter your username");
            String passwordText = Utils.getString("Please enter your password");
            login(username, getHash(passwordText));
        }
    }

    /**
     * Perform tasks now that the user is logged in.
     */
    public void showDashboard() {
        // TODO: main code for running the app goes here
        System.out.printf("\nWelcome, %s. \n", user.getUsername());
    }


    public void run() {
        while(Utils.getString("\nSelect 'enter' or 'quit': ", "enter", "quit").equals("enter")) {
            try {
                signInUser();
                showDashboard();
            } catch (LoginException e) {
                System.out.println("\nThe following error occurred during login: " + e.getMessage());
            }
        }
    }
}

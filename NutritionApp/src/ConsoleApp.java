import exceptions.LoginException;

import java.util.Scanner;

public class ConsoleApp extends App {
    public ConsoleApp() {
        super();
    }

    private static String arrayToString(String[] array) {
        if (array == null) {
            return "null";
        }

        StringBuilder arrString = new StringBuilder();

        for (String s : array) {
            arrString.append(s).append(" ");
        }

        return arrString.toString();
    }

    private String getInput(String message, String ... validInputs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message + " Options: " + arrayToString(validInputs));
        String input = scanner.nextLine();
        for (String validInput: validInputs) {
            if (input.equals(validInput)) {
                return input;
            }
        }

        System.out.println("Invalid Input.");
        return getInput(message, validInputs);
    }

    public void welcomeUser() throws LoginException {
        System.out.println("Welcome to Fitness 4 Life");
        Scanner sc = new Scanner(System.in);
        String type = getInput("Are you a new or existing user? ", "new", "existing");

        if (type.equals("new")) {
            System.out.println("Please enter a username");
            String username = sc.nextLine();
            System.out.println("Please enter a password");
            String password = sc.nextLine();
            register(username, password);
        } else {
            System.out.println("Please enter your username");
            String username = sc.nextLine();
            System.out.println("Please enter your password");
            String password = sc.nextLine();
            login(username, password);
        }
    }

    private String hash(String hashText) {
        // TODO: hash the text
        return hashText;
    }

    public void run() {
        try {
            welcomeUser();
        } catch (LoginException e) {
            System.out.println(e);
        }
    }
}

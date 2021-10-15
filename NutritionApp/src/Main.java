import java.util.*;


public class Main {
    private static String getInput(String message, String ... validInputs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message + " Options: " + validInputs.toString());
        String input = scanner.nextLine();
        for (String validInput: validInputs) {
            if (input.equals(validInput)) {
                return input;
            }
        }

        System.out.println("Invalid Input.");
        return getInput(message, validInputs);
    }


    public static void main(String[] args) {
        App app = new App();
        System.out.println("Welcome to Fitness 4 Life");
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you a new or existing User: (Type 'new' or 'existing')");
        String type = getInput("Are you a new or existing user? ", "new", "existing");

        if (type.equals("new")) {
            System.out.println("Please enter a username");
            String username = sc.nextLine();
            System.out.println("Please enter a password");
            String password = sc.nextLine();
            app.register(username, password);
        } else {
            System.out.println("Please enter your username");
            String username = sc.nextLine();
            System.out.println("Please enter your password");
            String password = sc.nextLine();
            app.login(username, password);
        }
    }
}

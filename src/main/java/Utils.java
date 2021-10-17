import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Scanner;

/*
    This class contains methods that are useful
    in getting input in the console.
 */
public class Utils {

    /**
     * Get an inputted string from the user.
     *
     * @param message the message to display to the user
     * @return the String the user enters
     */
    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    /**
     * Get an inputted String from the user. Repeats until
     * the input is valid.
     *
     * @param message the message to display to the user
     * @param validInputs a varying number of accepted inputs
     * @return the accepted input
     */
    public static String getString(String message, String ... validInputs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();

        for (String validInput: validInputs) {
            if (input.equals(validInput)) {
                return input;
            }
        }

        System.out.print("Invalid Input. ");
        return getString(message, validInputs);
    }

    /**
     * Get an inputted integer from the user. Repeats until
     * the input is an integer within a contained bound, inclusive.
     *
     * @param message the message to display to the user
     * @param inclusive whether the bounds are inclusive
     * @param bounds the lower and upper bounds for accepted inputs
     * @return the accepted user input.
     */
    public static int getInt(String message, boolean inclusive, int ... bounds) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
            int input = scanner.nextInt();
            if ((inclusive && bounds[0] <= input && input <= bounds[1]) || (
                    !inclusive && bounds[0] < input && input < bounds[1])) {
                return input;
            }
        } catch(java.util.InputMismatchException ignored) {}

        System.out.print("Invalid Input. ");
        return getInt(message, inclusive, bounds);
    }

    /**
     * Get an inputted integer from the user. Repeats until
     * the input is an integer within a contained bound, inclusive.
     *
     * @param message the message to display to the user
     * @param bounds the lower and upper bounds for accepted inputs
     * @return the accepted user input.
     */
    public static int getInt(String message, int ... bounds) {
        return getInt(message, true, bounds);
    }

    /**
     * Get an inputted integer from the user. Repeats until
     * the input is an integer.
     *
     * @param message the message to display to the user
     * @return the accepted user input.
     */
    public static double getInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        try {
            return scanner.nextInt();
        } catch(java.util.InputMismatchException ignored) {}

        System.out.print("Invalid Input. ");
        return getInt(message);
    }


    /**
     * Get an inputted double from the user. Repeats until
     * the input is a double within a contained bound, inclusive.
     *
     * @param message the message to display to the user
     * @param inclusive whether the bounds are inclusive
     * @param bounds the lower and upper bounds for accepted inputs
     * @return the accepted user input.
     */
    public static double getDouble(String message, boolean inclusive, double ... bounds) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
            double input = scanner.nextDouble();
            if ((inclusive && bounds[0] <= input && input <= bounds[1]) || (
                    !inclusive && bounds[0] < input && input < bounds[1])) {
                return input;
            }
        } catch(java.util.InputMismatchException ignored) {}

        System.out.print("Invalid Input. ");
        return getDouble(message, inclusive, bounds);
    }

    /**
     * Get an inputted double from the user. Repeats until
     * the input is a double within a contained bound, inclusive.
     *
     * @param message the message to display to the user
     * @param bounds the lower and upper bounds for accepted inputs
     * @return the accepted user input.
     */
    public static double getDouble(String message, double ... bounds) {
        return getDouble(message, true, bounds);
    }

    /**
     * Get an inputted double from the user. Repeats until
     * the input is a double.
     *
     * @param message the message to display to the user
     * @return the accepted user input.
     */
    public static double getDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
            return scanner.nextDouble();
        } catch(java.util.InputMismatchException ignored) {}

        System.out.print("Invalid Input. ");
        return getDouble(message);
    }


    /**
     * Get the SHA256 hash of a String.
     *
     * @param hashText the raw String to hash
     * @return the resulting SHA256 hash
     */
    public static String getHash(String hashText) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(hashText.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            return "";
        }
    }

}

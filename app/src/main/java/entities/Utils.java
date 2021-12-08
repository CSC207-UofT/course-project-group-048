package entities;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/*
    This class contains useful utility methods for the program.
 */
public class Utils {

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

    /**
     * Get the ID of a string in the application
     *
     * @param idString the string of the ID to get
     * @param resourceClass the class containing the ID
     * @return the integer ID
     */
    public static int getResId(String idString, Class<?> resourceClass) {
        try {
            Field idField = resourceClass.getDeclaredField(idString);
            return idField.getInt(idField);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return -1;
        }
    }

}

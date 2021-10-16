import exceptions.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class App {
    private User user;
    private LoginSystem system;

    public App() {
        system = new LoginSystem();
    }

    public String getUserUsername() {
        if (user == null) {
            return null;
        }
        return user.getUsername();
    }

    public void login(String username, String passwordHash) throws LoginException {
        user = system.logInUser(username, passwordHash);
    }

    public void register(String username, String passwordHash) throws LoginException {
        system.registerUser(username, passwordHash);
        system.logInUser(username, passwordHash);
    }

    protected String getHash(String hashText) {
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

import java.io.*;
import java.util.*;
import java.util.HashMap;

public class UserInformation {

    private final HashMap<String, String> information;

    public UserInformation () {
        this.information = new HashMap<>();
    }

    public boolean addPerson(String username, String password) {
        if (!this.information.containsKey(username)) {
            this.information.put(username, password);
            return true;
        }
        return false;
    }

    public boolean checkPassword(String username, String password) {
        if (this.information.containsKey(username)) {
            return password.equals(this.information.get(username));
        }
        return false;

    }

    public boolean changePassword(String username, String newPassword) {
        if (this.information.containsKey(username)) {
            this.information.replace(username, newPassword);
            return true;
        }
        return false;
    }
}

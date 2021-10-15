import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String passwordHash;
    private double weight;
    private double height;
    private int activityLevel;
    private int age;
    private List<Goal> goals;

    public User(String username, String passwordHash, double weight, double height, int activityLevel, int age) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.weight = weight;
        this.height = height;
        this.activityLevel = activityLevel;
        this.age = age;
        this.goals = new ArrayList<>();
    }

    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }



}

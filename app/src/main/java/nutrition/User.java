package nutrition;

import java.util.ArrayList;
import java.util.List;

/*
    A User is the main entity of the program. They have
    a unique access ID (username) and information that is
    accessed by LoginSystem.
 */
public class User {
    private String username;
    private String passwordHash;
    private double weight;
    private double height;
    private int activityLevel;
    private int age;
    private List<Goal> goals;

    /**
     * Create a new User object.
     *
     * @param username the username of the new user.
     * @param passwordHash the password SHA256 of the new user.
     * @param weight the weight of the new user.
     * @param height the height of the new user.
     * @param activityLevel the level of activity of the new user.
     * @param age the age of the new user.
     */
    public User(String username, String passwordHash, double weight, double height, int activityLevel, int age) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.weight = weight;
        this.height = height;
        this.activityLevel = activityLevel;
        this.age = age;
        this.goals = new ArrayList<>();
    }

    /**
     * Create a new User object.
     *
     * @param username the username of the new user.
     * @param passwordHash the password SHA256 of the new user.
     */
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


    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public int getAge() {
        return age;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }
}

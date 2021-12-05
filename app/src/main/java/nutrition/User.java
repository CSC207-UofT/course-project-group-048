package nutrition;

import java.util.ArrayList;
import java.util.List;

/*
    A User is the main entity of the program. They have
    a unique access ID (username) and information that is
    accessed by LoginSystem.
 */
public class User {
    private String name;
    private String username;
    private String passwordHash;
    private String gender;
    private double weight;
    private double height;
    private int age;
    private boolean goal;

    /**
     * Create a new User object.
     *
     * @param username the username of the new user.
     * @param passwordHash the password SHA256 of the new user.
     * @param weight the weight of the new user.
     * @param height the height of the new user.
     * @param age the age of the new user.
     */

    //I have removed "activity levels" and "goals" variable from this constructor because we have
    //not decided on their exact use yet. We can add them later.
    public User(String name, String username, String passwordHash, String gender, double weight,
                double height, int age, boolean goal) {
        this.name = name;
        this.username = username;
        this.passwordHash = passwordHash;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public boolean getGoal() {return goal;}

}

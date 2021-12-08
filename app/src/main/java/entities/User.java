package entities;

import java.io.Serializable;

/*
    A User is the main entity of the program. They have
    a unique access ID (username) and information that is
    accessed by LoginSystem.
 */
public class User implements Serializable {
    private String name;
    private String username;
    private String passwordHash;
    private String gender;
    private double weight;
    private double height;
    private int age;
    private String goal;

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
    public User(String name, String username, String passwordHash, String gender, int weight,
                int height, int age, String goal) {
        this.name = name;
        this.username = username;
        this.passwordHash = passwordHash;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.goal = goal;
    }

    /**
     * Calulates and returns the rounded BMR of the user using the relevant attributes (weight,
     * height and age) as an integer.
     * @return an integer representing the BMR value of the user.
     */
    public int calculateBMR() {
        double bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        return (int) Math.round(bmr);
    }

    /**
     * A getter method for the name attribute.
     * @return a String representing the name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method for the username attribute.
     * @return a String representing the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * A getter method for the passwordHash attribute.
     * @return a String representing the passwordHash of the user.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * A getter method for the gender attribute.
     * @return a String representing the gender of the user.
     */
    public String getGender() {
        return gender;
    }

    /**
     * A getter method for the weight attribute.
     * @return a double representing the weight of the user.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * A getter method for the height attribute.
     * @return a double representing the height of the user.
     */
    public double getHeight() {
        return height;
    }

    /**
     * A getter method for the age attribute.
     * @return an integer representing the age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * A getter method for the goal attribute.
     * @return a String representing the goal of the user.
     */
    public String getGoal() {return goal;}

}

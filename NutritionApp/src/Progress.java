import java.util.HashMap;

public class Progress {
    private String username; // stores the name of the user
    private double currentWeight; // stores the current weight of the user in kg
    private double currentHeight; // stores the current height of the user in metres
    private double currentBmi; // stores the current BMI of the user in kg/m^2
    private HashMap nutrientLevel; // stores the level of various nutrients the user has based on their food intake.
    private Goal goal; // stores the goal set by the user


    /**
     * Constructs a Progress with the username and goal of the user
     * @param username Name of the user.
     * @param goal Goal of the user.
     * @param initialWeight Initial weight of the user as they input it while creating an account.
     * @param initialHeight Initial height of the user as they input it while creating an account.
     * @param nutrientLevel Level of nutrients the user has initially.
     */
    public Progress(String username, Goal goal, double initialWeight, double initialHeight, HashMap nutrientLevel){
        this.username = username;
        this.currentHeight = initialHeight;
        this.currentWeight = initialWeight;
        this.currentBmi = initialWeight/(Math.pow(initialHeight, 2));
        this.nutrientLevel = nutrientLevel;
        this.goal = goal;
    }


    /**
     * Updates the nutritional status of the user.
     * @param currentWeight Current weight of the user.
     * @param currentHeight Current height of the user.
     * @param nutrientLevel Level of nutrients the user has based on their food intake.
     */
    public void changeParameters(double currentWeight, double currentHeight, HashMap nutrientLevel){
        this.currentHeight = currentHeight;
        this.currentWeight = currentWeight;
        this.currentBmi = currentWeight/(Math.pow(currentHeight, 2));
        this.nutrientLevel = nutrientLevel;
    }
}

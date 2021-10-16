import java.util.HashMap;

public class Progress {
    private String username; /* stores the name of the user*/
    private double current_weight; /* stores the current weight of the user in kg*/
    private double current_height; /* stores the current height of the user in metres*/
    private double current_bmi; /* stores the current BMI of the user in kg/m^2*/
    private HashMap nutrient_level; /* stores the level of various nutrients the user has based on their food intake.*/
    private Goal goal; /* stores the goal set by the user*/


    /**
     * Constructs a Progress with the username and goal of the user
     * @param username Name of the user.
     * @param goal Goal of the user.
     * @param initial_weight Initial weight of the user as they input it while creating an account.
     * @param initial_height Initial height of the user as they input it while creating an account.
     * @param nutrient_level Level of nutrients the user has initially.
     */
    public Progress(String username, Goal goal, double initial_weight, double initial_height, HashMap nutrient_level){
        this.username = username;
        this.current_height = initial_height;
        this.current_weight = initial_weight;
        this.current_bmi = initial_weight/(Math.pow(initial_height, 2));
        this.nutrient_level = nutrient_level;
        this.goal = goal;

    }


    /**
     * Updates the nutritional status of the user.
     * @param current_weight Current weight of the user.
     * @param current_height Current height of the user.
     * @param nutrient_level Level of nutrients the user has based on their food intake.
     */
    public void change_parameters(double current_weight, double current_height, HashMap nutrient_level){
        this.current_height = current_height;
        this.current_weight = current_weight;
        this.current_bmi = current_weight/(Math.pow(current_height, 2));
        this.nutrient_level = nutrient_level;
    }
}

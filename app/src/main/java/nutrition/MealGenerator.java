package nutrition;

public class MealGenerator {

    String mealType;
    int caloriesAim;
    String dietInfo;

    /**
     * A goal set for a given User.
     *
     * @param mt the type of meal to be generated
     * @param ca the target calories to be gained from the meal generated
     * @param di dietary requirements (vegan, vegetarian, etc)
     */

    public void MealGenerator(String mt, int ca, String di) {
        this.mealType = mt;
        this.caloriesAim = ca;
        this.dietInfo = di;
    }

    /*
    private void customMeal(FoodItems fd) {
        boolean possible = false
        for(int i = 0; i < len(fd); i++) {
             add conditions: enough items for a custom meal/*
            if conditions meet, change possible to true

        }
        if (possible) {
             since a meal is possible, generate a random one, and return it

        }
        else {
             return not possible, use API instead
        }
    }

    */

    private void apiGenerator() {


    }
}



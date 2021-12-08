package usecases;

import java.util.ArrayList;
import java.util.HashMap;

import entities.FoodItem;


public class FoodItems {
    public static final ArrayList<FoodItem> foodList = new ArrayList<>();

    final static FoodItem FRUITS = new FoodItem("fruits", 300,
            new String[]{"fruit", "snack", "vegan"}, new int[]{23, 4, 0, 0});
    final static FoodItem CEREAL = new FoodItem("cereal", 350,
            new String[]{"grain", "breakfast", "vegetarian"}, new int[]{113, 23, 1, 2});
    final static FoodItem CHICKEN_BREAST = new FoodItem("chicken breast",
            750, new String[]{"poultry", "dinner", "none"}, new int[]{110, 2, 3, 20});
    final static FoodItem BIG_MAC_MEAL = new FoodItem("big mac meal", 1080
            , new String[]{"grain", "dinner", "vegan"}, new int[]{160, 38, 0, 3});
    final static FoodItem PASTA = new FoodItem("pasta", 580,
            new String[]{"grain", "dinner", "vegetarian"}, new int[]{265, 54, 1, 9});
    final static FoodItem STEAK = new FoodItem("steak", 640,
            new String[]{"meat", "dinner", "none"}, new int[]{170, 0, 9, 23});
    final static FoodItem YOGURT = new FoodItem("yogurt", 270,
            new String[]{"dairy", "breakfast", "vegetarian"}, new int[]{100, 20, 0, 5});
    final static FoodItem SMOKED_SALMON = new FoodItem("smoked salmon", 115,
            new String[]{"fish", "breakfast", "vegetarian"}, new int[]{100, 0, 1, 24});
    final static FoodItem COD = new FoodItem("cod", 560,
            new String[]{"fish", "dinner", "vegetarian"}, new int[]{138, 0, 4, 24});
    final static FoodItem TUNA = new FoodItem("tuna", 456,
            new String[]{"fish", "lunch", "vegetarian"}, new int[]{50, 1, 1, 10});
    final static FoodItem HAM_SANDWICH = new FoodItem("ham sandwich", 395,
            new String[]{"poultry", "lunch", "gluten"}, new int[]{60, 2, 3, 8});
    final static FoodItem MAC_AND_CHEESE = new FoodItem("mac and cheese", 489,
            new String[]{"grain", "dinner", "vegetarian"}, new int[]{230, 19, 14, 7});
    final static FoodItem PORK = new FoodItem("pork", 235,
            new String[]{"meat", "dinner", "none"}, new int[]{214, 6, 13, 19});
    final static FoodItem TURKEY = new FoodItem("turkey", 425,
            new String[]{"poultry", "dinner", "none"}, new int[]{160, 1, 8, 2, 22});
    public final static FoodItem CHICKEN_CURRY = new FoodItem("chicken curry", 530,
            new String[]{"poultry", "dinner", "none"}, new int[]{243, 3, 11, 28});
    final static FoodItem SHRIMP_BOWL = new FoodItem("shrimp bowl", 668,
            new String[]{"fish", "dinner", "vegetarian"}, new int[]{100, 0, 2, 21});

    /**
     * A constructor for the FoodItems class. Adds all of the foodItem objects to the foodList
     * attribute.
     */
    public FoodItems() {
        foodList.add(FRUITS);
        foodList.add(CEREAL);
        foodList.add(CHICKEN_BREAST);
        foodList.add(PASTA);
        foodList.add(STEAK);
        foodList.add(YOGURT);
        foodList.add(SMOKED_SALMON);
        foodList.add(COD);
        foodList.add(BIG_MAC_MEAL);
        foodList.add(TUNA);
        foodList.add(HAM_SANDWICH);
        foodList.add(MAC_AND_CHEESE);
        foodList.add(PORK);
        foodList.add(TURKEY);
        foodList.add(CHICKEN_CURRY);
        foodList.add(SHRIMP_BOWL);
    }
}

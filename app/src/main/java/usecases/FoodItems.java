package usecases;

import java.util.ArrayList;
import java.util.HashMap;

import entities.FoodItem;


public class FoodItems {
    public static final ArrayList<FoodItem> foodList = new ArrayList<>();
    public static HashMap<String, ArrayList<FoodItem>> meals = new HashMap<>();

    final static FoodItem FRUITS = new FoodItem("fruits", 300,
            new String[]{"fruit", "snack", "vegan"}, new Integer[]{23, 4, 0, 0});
    final static FoodItem CEREAL = new FoodItem("cereal", 250,
            new String[]{"grain", "breakfast", "vegetarian"}, new Integer[]{113, 23, 1, 2});
    final static FoodItem CHICKEN_BREAST = new FoodItem("chicken breast",
            750, new String[]{"poultry", "dinner", "none"}, new Integer[]{110, 2, 3, 20});
    final static FoodItem BIG_MAC_MEAL = new FoodItem("big mac meal", 1080
            , new String[]{"grain", "dinner", "vegan"}, new Integer[]{160, 38, 0, 3});
    final static FoodItem PASTA = new FoodItem("pasta", 280,
            new String[]{"grain", "dinner", "vegetarian"}, new Integer[]{265, 54, 1, 9});
    final static FoodItem STEAK = new FoodItem("steak", 340,
            new String[]{"meat", "dinner", "none"}, new Integer[]{170, 0, 9, 23});
    final static FoodItem YOGURT = new FoodItem("yogurt", 170,
            new String[]{"dairy", "breakfast", "vegetarian"}, new Integer[]{100, 20, 0, 5});
    final static FoodItem SMOKED_SALMON = new FoodItem("smoked salmon", 115,
            new String[]{"fish", "breakfast", "vegetarian"}, new Integer[]{100, 0, 1, 24});
    final static FoodItem COD = new FoodItem("cod", 350,
            new String[]{"fish", "dinner", "vegetarian"}, new Integer[]{138, 0, 4, 24});
    final static FoodItem TUNA = new FoodItem("tuna", 256,
            new String[]{"fish", "lunch", "vegetarian"}, new Integer[]{50, 1, 1, 10});
    final static FoodItem HAM_SANDWICH = new FoodItem("ham sandwich", 235,
            new String[]{"poultry", "lunch", "gluten"}, new Integer[]{60, 2, 3, 8});
    final static FoodItem KALE = new FoodItem("kale", 70,
            new String[]{"vegetable", "dinner", "vegan"}, new Integer[]{25, 4, 0, 2});
    final static FoodItem TORTILLA_CHIPS = new FoodItem("tortilla chips", 30,
            new String[]{"grain", "snack", "vegetarian"}, new Integer[]{150, 21, 6, 2});
    final static FoodItem CHILLI = new FoodItem("chilli", 100,
            new String[]{"grain", "dinner", "none"}, new Integer[]{145, 28, 1, 5});
    final static FoodItem MAC_AND_CHEESE = new FoodItem("mac and cheese", 100,
            new String[]{"grain", "dinner", "vegetarian"}, new Integer[]{230, 19, 14, 7});
    final static FoodItem TOFU = new FoodItem("tofu", 85,
            new String[]{"grain", "dinner", "vegan"}, new Integer[]{70, 2, 4, 7});
    final static FoodItem SWEET_POTATO = new FoodItem("sweet potato", 133,
            new String[]{"legume", "dinner", "vegan"}, new Integer[]{114, 27, 0, 2});
    final static FoodItem GREEN_PEAS = new FoodItem("green peas", 85,
            new String[]{"legume", "dinner", "vegan"}, new Integer[]{70, 12, 0, 5});
    final static FoodItem PORK = new FoodItem("pork", 135,
            new String[]{"meat", "dinner", "none"}, new Integer[]{214, 6, 13, 19});
    final static FoodItem TURKEY = new FoodItem("turkey", 115,
            new String[]{"poultry", "dinner", "none"}, new Integer[]{160, 1, 8, 2, 22});
    final static FoodItem PEANUT_BUTTER = new FoodItem("peanut butter", 15,
            new String[]{"legume", "breakfast", "vegan"}, new Integer[]{85, 1, 7, 4});
    public final static FoodItem CHICKEN_CURRY = new FoodItem("chicken curry", 230,
            new String[]{"poultry", "dinner", "none"}, new Integer[]{243, 3, 11, 28});
    final static FoodItem WHEY_PROTEIN = new FoodItem("whey protein", 30,
            new String[]{"dairy", "snack", "none"}, new Integer[]{117, 2, 1, 24});
    final static FoodItem CARROTS = new FoodItem("carrots", 78,
            new String[]{"legume", "dinner", "vegan"}, new Integer[]{27, 6, 0, 1});
    final static FoodItem HUMMUS = new FoodItem("hummus", 30,
            new String[]{"grain", "dinner", "vegan"}, new Integer[]{70, 4, 5, 2});
    final static FoodItem SHRIMP = new FoodItem("shrimp", 85,
            new String[]{"fish", "dinner", "vegetarian"}, new Integer[]{100, 0, 2, 21});
    final static FoodItem POTATOES = new FoodItem("potatoes", 100,
            new String[]{"legume", "dinner", "vegan"}, new Integer[]{86, 20, 0, 2});
    final static FoodItem QUINOA = new FoodItem("quinoa", 185,
            new String[]{"grain", "lunch", "vegan"}, new Integer[]{222, 39, 4, 8});
    final static FoodItem ALMONDS = new FoodItem("almonds", 27,
            new String[]{"legume", "snack", "vegan"}, new Integer[]{124, 4, 8, 4});
    final static FoodItem MUSHROOM = new FoodItem("mushroom", 100,
            new String[]{"legume", "dinner", "vegan"}, new Integer[]{21, 3, 0, 3});
    final static FoodItem BLACK_BEANS = new FoodItem("black beans", 110,
            new String[]{"grain", "lunch", "vegan"}, new Integer[]{118, 14, 1, 7});


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
        foodList.add(KALE);
        foodList.add(TORTILLA_CHIPS);
        foodList.add(CHILLI);
        foodList.add(MAC_AND_CHEESE);
        foodList.add(TOFU);
        foodList.add(SWEET_POTATO);
        foodList.add(GREEN_PEAS);
        foodList.add(PORK);
        foodList.add(TURKEY);
        foodList.add(PEANUT_BUTTER);
        foodList.add(CHICKEN_CURRY);
        foodList.add(WHEY_PROTEIN);
        foodList.add(CARROTS);
        foodList.add(HUMMUS);
        foodList.add(POTATOES);
        foodList.add(SHRIMP);
        foodList.add(QUINOA);
        foodList.add(ALMONDS);
        foodList.add(MUSHROOM);
        foodList.add(BLACK_BEANS);

        // put values of meals in the hashmap, vegan 1, vegetarian (1 + 1 vegan), none: (1+2 veg),
        // naming convention 1500veg, 2000vegan, and 2500all examples
        ArrayList<FoodItem> meal1 = new ArrayList<>();
        meal1.add(STEAK);
        meals.put("1500all", meal1);

    }
}

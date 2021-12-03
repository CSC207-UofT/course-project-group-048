package nutrition;/*
    A database of food items.
 */


import java.lang.reflect.Field;

/*
    Dataset of FoodItem
 */

public class FoodItems {
    final static FoodItem ORANGE = new FoodItem("orange", 50,
            new String[]{"fruit","snack", "vegan"}, new Integer[]{23, 4, 0, 0});
    final static FoodItem APPLE = new FoodItem("apple", 182,
            new String[] {"fruit", "snack", "vegan"}, new Integer[]{95, 25, 0, 0});
    final static FoodItem BANANA = new FoodItem("banana", 118,
            new String[]  {"fruit", "snack", "vegan"}, new Integer[]{105, 27, 0, 1});
    final static FoodItem EGG = new FoodItem("egg", 70,
            new String[] {"dairy", "breakfast", "vegetarian"}, new Integer[]{70, 0, 5, 6});
    final static FoodItem BROCCOLI = new FoodItem("broccoli", 100,
            new String[] {"vegetable","lunch","vegan"}, new Integer[]{34, 7, 0, 3});
    final static FoodItem WHITEBREAD = new FoodItem("white bread",
            60, new String[] {"grain", "vegetarian", "breakfast"});
    final static FoodItem CEREAL = new FoodItem("cereal", 30, new String[] {"grain", "breakfast", "vegetarian"});
    final static FoodItem CHICKENBREAST = new FoodItem("chicken breast",
            120, new String[]  {"poultry", "dinner", "none"});
    final static FoodItem WHITERICE = new FoodItem("white rice",
            200, new String[] {"grain", "dinner", "vegan"});
    final static FoodItem PASTA = new FoodItem("pasta", 180, new String[] {"grain", "dinner", "vegetarian"});
    final static FoodItem ICECREAM = new FoodItem("ice cream",
            60, new String[] {"dessert", "snack", "vegetarian"});
    final static FoodItem CHOCOLATE = new FoodItem("chocolate",
            20, new String[] {"dessert", "snack", "vegetarian"});
    final static FoodItem FRENCHFRIES = new FoodItem("french fries",
            90, new String[] {"vegetable", "lunch", "vegan"});
    final static FoodItem CHICKPEAS = new FoodItem("chickpeas",
            150, new String[] {"legume", "snack", "vegan"});
    final static FoodItem OATS = new FoodItem("oats",
            40, new String[] {"grain", "breakfast", "vegan"});
    final static FoodItem STEAK = new FoodItem("steak", 130, new String[] {"meat", "dinner", "none"});
    final static FoodItem TOMATO= new FoodItem("tomato", 50, new String[] {"vegetable", "lunch", "vegan"});
    final static FoodItem PEANUTS = new FoodItem("peanuts", 30, new String[] {"legume", "snack", "vegan"});
    final static FoodItem COOKIES = new FoodItem("cookies", 30, new String[] {"dessert", "snack", "vegetarian"});
    final static FoodItem NOODLES = new FoodItem("noodle", 180, new String[] {"grain", "dinner", "vegetarian"});
    final static FoodItem LETTUCE = new FoodItem("lettuce", 30, new String[] {"vegetable", "lunch", "vegan"});


    /*
    made an array including all FoodItem in FoodItems class to that
    they can be used in the MealGenerator class
 */
    public void main(String[] args) {
        Field[] fooditems = FoodItems.class.getDeclaredFields();
    }
}

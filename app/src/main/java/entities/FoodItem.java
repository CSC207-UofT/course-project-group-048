package entities;/*
   FoodItem stores food name, type (fruit, vegetable, meat etc.)
   and its amount in grams and its corresponding nutritional values(carbohydrates, protein and fat)
 */

public class FoodItem {

    public String name;
    public int calories;
    public String[] types;
    public Integer[] nutrients;

    /**
     * A class representing a FoodItem object.
     *
     * @param name name of the food
     * @param cals amount of the food
     * @param types type of the food (food category, diet and meal type)
     * @param nutrients nutrients of the food item
     */

    public FoodItem(String name, int cals, String[] types, Integer[] nutrients) {
        this.name = name;
        this.calories = cals;
        this.types = types;
        this.nutrients = nutrients;
    }

    public String[] getTypes() {
        return types;
    }

    public String getName() {
        return name;
    }
    public int getCalories() {
        return calories;
    }

    public String getStringTypes() {
        // the logic here is to take the list of types, and return a string representation of it
        // POSSIBLY: implement a sanity check of types, or only allow certain allowed in a certain
        // order
        // ALSO: string representation should be readable by code, follow a pattern,
        // strip whitespace, join with spaces
        //
        StringBuilder s = new StringBuilder();
        for (String value : types) {
            String type = value.replaceAll("\\s+", "");
            s.append(type).append(", ");
        }
        return s.toString().trim();
    }


    public static String[] getTypesFromString(String s) {
        return s.split(",");
    }

    public static Integer[] getNutsFromString(String s) {
        String[] n = s.split(",");
        Integer[] nutrients = new Integer[n.length];
        for (int i = 0; i < n.length; i++) {
            nutrients[i] = Integer.valueOf(n[i]);
        }
        return nutrients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public Integer[] getNutrients() {
        return nutrients;
    }

    public void setNutrients(Integer[] nutrients) {
        this.nutrients = nutrients;
    }

    public String getStringNutrition () {
        StringBuilder s = new StringBuilder();
        for (int value : nutrients) {
            String amount = String.valueOf(value);
            s.append(amount).append(", ");
        }
        return s.toString().trim();

    }
}
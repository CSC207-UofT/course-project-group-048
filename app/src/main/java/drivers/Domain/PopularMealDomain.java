package drivers.Domain;

import java.io.Serializable;

public class PopularMealDomain implements Serializable {
    private final String title;
    private final String picture;
    private final int calories;

    /**
     * Creates an instance of the PopularMealDomain object, used in the PopularMealAdapter class
     * providing information about each popular meal that the adapter processes.
     *
     * @param title    the title of the meal
     * @param picture  a picture of the meal (contained as a string containing information about the
     *                 file)
     * @param calories an integer representing the calories contained in the meal
     */
    public PopularMealDomain(String title, String picture, int calories) {
        this.title = title;
        this.picture = picture;
        this.calories = calories;
    }

    /**
     * A getter method for the title attribute.
     *
     * @return the title attribute (a string)
     */
    public String getTitle() {
        return title;
    }

    /**
     * A getter method for the picture attribute.
     *
     * @return the picture attribute (a string containing file information)
     */
    public String getPicture() {
        return picture;
    }

    /**
     * A getter method for the calories attribute.
     *
     * @return the calories attribute (an integer)
     */
    public int getCalories() {
        return calories;
    }

}

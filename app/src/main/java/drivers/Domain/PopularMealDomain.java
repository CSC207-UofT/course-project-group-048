package drivers.Domain;

import java.io.Serializable;

public class PopularMealDomain implements Serializable {
    private final String title;
    private final String picture;
    private final int calories;

    public PopularMealDomain(String title, String picture, int calories) {
        this.title = title;
        this.picture = picture;
        this.calories = calories;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }

    public int getCalories() {
        return calories;
    }

}

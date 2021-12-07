package drivers.Domain;

import java.io.Serializable;

public class PopularMealDomain implements Serializable {
    private String title;
    private String picture;
    private int calories;

    public PopularMealDomain(String title, String picture, int calories) {
        this.title = title;
        this.picture = picture;
        this.calories = calories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}

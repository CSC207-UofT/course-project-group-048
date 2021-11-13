package nutrition;

import java.time.LocalDate;
import java.util.List;

public class Stat {
    /*
        A class that stores statistics for a User. References a list of FoodItem to
        keep track of what is being consumed throughout that time period.  This will also
        contribute to the Stat that is provided to track progression.

        Instance variables:
         - caloricIntake:  the total calories for the day
         - user:  The User instance the stat is linked to.
         - startDate:  when this stat starts tracking.
         - foodItems:  A list of FoodItem
         - endDate:  when this stat stops tracking
     */

    User user;
    int caloricIntake;
    LocalDate startDate;
    LocalDate endDate;
    List<FoodItem> foodItems;

    /**
     * Construct a new Stat object.
     *
     * @param user the user to store the stat for
     */
    public Stat(User user) {
        this.user = user;
    }

    /**
     * Construct a new Stat object.
     *
     * @param user the user to store the stat for
     * @param caloricIntake the number of calories taken in
     * @param startDate the date the stat starts
     * @param endDate the date the stat stops
     * @param foodItems the items consumed by user
     */
    public Stat(User user, int caloricIntake, LocalDate startDate,
                LocalDate endDate, List<FoodItem> foodItems) {
        this.user = user;
        this.caloricIntake = caloricIntake;
        this.startDate = startDate;
        this.endDate = endDate;
        this.foodItems = foodItems;
    }

}

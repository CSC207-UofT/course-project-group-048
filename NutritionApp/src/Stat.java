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

    public Stat(User user) {
        this.user = user;
    }

    public Stat(User user, int caloricIntake, LocalDate startDate,
                LocalDate endDate, List<FoodItem> foodItems) {
        this.user = user;
        this.caloricIntake = caloricIntake;
        this.startDate = startDate;
        this.foodItems = foodItems;
    }

}

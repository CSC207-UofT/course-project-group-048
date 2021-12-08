package entities;

import java.time.LocalDate;

/*
 *  Represents a user's weight loss goal.
 */
public class Goal {
    int userWeight;
    int goalWeight;
    LocalDate dueDate;
    boolean achieved;

    /**
     * A goal set for a given User.
     *
     * @param userWeight the current user weight
     * @param goalWeight the target user weight
     * @param dueDate the date to complete the goal
     */
    public Goal(int userWeight, int goalWeight, LocalDate dueDate) {
        this.userWeight = userWeight;
        this.goalWeight = goalWeight;
        this.dueDate = dueDate;
        this.achieved = false;
    }

    /**
     * Changes the achieved attribute of the instance to true.
     */
    public void markAchieved() {
        this.achieved = true;
    }

}

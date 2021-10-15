import java.time.LocalDate;

public class Goal {
    int userWeight;
    int goalWeight;
    LocalDate dueDate;
    boolean achieved;

    public Goal(int userWeight, int goalWeight, LocalDate dueDate) {
        this.userWeight = userWeight;
        this.goalWeight = goalWeight;
        this.dueDate = dueDate;
        this.achieved = false;
    }

    public void markAchieved() {
        this.achieved = true;
    }

}

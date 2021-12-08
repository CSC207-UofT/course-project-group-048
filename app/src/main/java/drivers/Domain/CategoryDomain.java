package drivers.Domain;

public class CategoryDomain {
    private final String title;

    /**
     * Creates an instance of the CategoryDomain object, used in the CategoryAdapter class
     * providing information about each category that the adapter processes.
     *
     * @param title the string representing the information contained in this CategoryDomain object.
     */
    public CategoryDomain(String title) {
        this.title = title;
    }

    /**
     * A getter method for the title attribute.
     *
     * @return the title attribute of the class, which is a string.
     */
    public String getTitle() {
        return title;
    }

}

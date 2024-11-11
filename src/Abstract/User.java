package Abstract;

// SOLID PRINCIPLE - Open/Close principle used here
public abstract class User {
    protected String userID; // Common ID for all users
    protected String name;    // Common name for all users

    // Abstract method to display user information
    public abstract void displayInfo();

    // Getters and Setters for userID and name
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

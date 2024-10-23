package Movie;

public class DocumentaryMovie extends Movie {
    private String subject;

    // Constructor for DocumentaryMovie
    public DocumentaryMovie(String title, String genre, double price, String subject) {
        super(title, genre, price);  // Call to Movie's constructor
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }
}

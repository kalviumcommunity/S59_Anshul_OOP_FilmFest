package Movie;

public class AnimatedMovie extends Movie {
    private String animationStudio;

    // Constructor for AnimatedMovie
    public AnimatedMovie(String title, String genre, double price, String animationStudio) {
        super(title, genre, price);  // Call to Movie's constructor
        this.animationStudio = animationStudio;
    }

    public String getAnimationStudio() {
        return animationStudio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Animation Studio: " + animationStudio;
    }
}

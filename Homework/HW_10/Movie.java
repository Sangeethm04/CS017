/**
 * movie class to test hashtable that is comparable
 */
public class Movie implements Comparable < Movie > {
    private int id;
    private String title;
    private String genre;
    private int ratings;
    private double rating;

    /**
     * Constructor with three parameters
     * @param id id for the movei
     * @param title title of the movie
     * @param genre genre of the movie
     */
    public Movie(int id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    /**
     * Getter for the id
     * @return id of the movie
     */
    public int getID() {
        return id;
    }

    /**
     * Getter for the title
     * @return title of the movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the genre
     * @return genre of the movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Getter for the ratings
     * @return ratings of the movie
     */
    public int getRatings() {
        return ratings;
    }

    /**
     * getter for rating
     * @return double rating of the movie
     */
    public double getRating() {
        return rating;
    }

    /**
     * Setter for the id
     * @param id new id for the movie
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Setter for the title
     * @param title new title for the movie
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter for the genre
     * @param genre new genre for the movie
     */
    public void setGenre(String genre) {
        this.genre = genre;

    }

    /**
     * adder for the ratings
     * @param ratings new ratings added to the movie
     */
    public void addRating(double rating) {
        this.rating = (this.rating * ratings + rating) / (ratings + 1);
        ratings++;
    }

    /**
     * toString method
     * @return formatted string with attributes of the movie
     */
    public String toString() {
        return "Movie: " + title + " Genre: " + genre + " Ratings: " + ratings + " Rating: " + rating;
    }

    /**
     * compareTo method
     * @param movie object to compare
     * @return compareto 0,1,-1
     */
    public int compareTo(Movie movie) {
        if (this.rating > movie.rating) {
            return 1;
        } else if (this.rating < movie.rating) {
            return -1;
        } else {
            return 0;
        }
    }
}
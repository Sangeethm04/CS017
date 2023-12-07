public class Movie implements Comparable < Movie > {
    private int id;
    private String title;
    private String genre;
    private int ratings;
    private double rating;

    public Movie(int id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public int getID() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public int getRatings() {
        return ratings;
    }

    public double getRating() {
        return rating;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;

    }

    public void addRating(double rating) {
        this.rating = (this.rating * ratings + rating) / (ratings + 1);
        ratings++;
    }

    public String toString() {
        return "Movie: " + title + " Genre: " + genre + " Ratings: " + ratings + " Rating: " + rating;
    }

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
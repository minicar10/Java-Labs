package VideoStore;

import java.util.*;

public class Video extends Rental {
    public static final int G = 0;
    public static final int PG = 1;
    public static final int PG13 = 2;
    public static final int R = 3;

    private String director;
    private String description;
    private ArrayList<String> leadingActors;
    int minutes;

    public Video(String title, double cost, int rating, String description, String director,
            ArrayList<String> leadingActors, int minutes) {
        super(title, cost, rating);
        this.director = director;
        this.description = description;
        this.leadingActors = leadingActors;
        this.minutes = minutes;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDirector() {
        return this.director;
    }

    public ArrayList<String> getLeadingActors() {
        return this.leadingActors;
    }

    public int getMinutes() {
        return this.minutes;
    }

    @Override
    public String toString() {
        String rating;

        switch (getRating()) {
            case G -> rating = "G";
            case PG -> rating = "PG";
            case PG13 -> rating = "PG13";
            case R -> rating = "R";
            default -> throw new Error();
        }

        return super.toString() + " " + rating + " " + this.description + " " + this.director + " " + this.minutes;
    }
}

package VideoStore;

public class Game extends Rental {
    public static final int G = 0;
    public static final int EVERYONE = 1;
    public static final int EVERYONE_TEN_PLUS = 2;
    public static final int TEEN = 3;
    public static final int MATURE = 4;
    public static final int ADULTS_ONLY = 5;
    public static final int RATING_PENDING = 6;

    private String platform;
    private int numberOfPlayers;

    public Game(String title, double cost, int rating, String platform, int numberOfPlayers) {
        super(title, cost, rating);
        this.platform = platform;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    @Override
    public String toString() {
        String rating;

        switch (getRating()) {
            case G -> rating = "G";
            case EVERYONE -> rating = "EVERYONE";
            case EVERYONE_TEN_PLUS -> rating = "EVERYONE TEN PLUS";
            case TEEN -> rating = "TEEN";
            case MATURE -> rating = "MATURE";
            case ADULTS_ONLY -> rating = "ADULTS ONLY";
            case RATING_PENDING -> rating = "RATING PENDING";
            default -> throw new Error();
        }

        return super.toString() + " " + rating + " " + this.platform + " " + this.numberOfPlayers;
    }
}

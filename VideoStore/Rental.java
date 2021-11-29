package VideoStore;

public class Rental {
    private String title;
    private double cost;
    private int rating;

    private boolean rented;

    public Rental(String title, double cost, int rating) {
        this.title = title;
        this.cost = cost;
        this.rating = rating;
    }

    public String getTitle() {
        return this.title;
    }

    public double getCost() {
        return this.cost;
    }

    public int getRating() {
        return this.rating;
    }

    public boolean getRented() {
        return this.rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return String.format("%s: $%f", title, cost);
    }
}

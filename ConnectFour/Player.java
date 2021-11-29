package ConnectFour;

public abstract class Player {
    private String name;
    private int color;

    public Player(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public int getColor() {
        return this.color;
    }

    public abstract int move(ConnectFourGame game);
}


public class Tile {
    public int x;
    public int y;
    public char symbol = ' ';

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty() {
        return this.symbol == ' ';
    }

    public boolean isTaken() {
        return !this.isEmpty();
    }
}

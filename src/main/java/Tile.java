
public class Tile {
    public int row;
    public int column;
    public char symbol = ' ';

    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isEmpty() {
        return this.symbol == ' ';
    }

    public boolean isTaken() {
        return !this.isEmpty();
    }
}


public class Tile {
    public int row;
    public int column;

    public Symbol symbol = Symbol.NONE;

    public Tile(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isEmpty() {
        return this.symbol == Symbol.NONE;
    }

    public boolean isTaken() {
        return !this.isEmpty();
    }

    public boolean isAt(int row, int column) {
        return this.row == row && this.column == column;
    }
}

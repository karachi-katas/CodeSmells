import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> plays = new ArrayList<>();

    public Board()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                Tile tile = new Tile(row, column);
                plays.add(tile);
            }
        }
    }

    public Tile tileAt(int x, int y)
    {
        for (Tile t : plays) {
            if (t.row == x && t.column == y){
                return t;
            }
        }
        return null;
    }

    public void addTileAt(int row, int column, char symbol) {
        tileAt(row,column).symbol = symbol;
    }

    public boolean hasSameSymbolIn(int row) {
        return isRowNotEmpty(row) &&
               tileAt(row, 0).symbol ==
               tileAt(row, 1).symbol &&
               tileAt(row, 2).symbol ==
               tileAt(row, 1).symbol;
    }

    private boolean isRowNotEmpty(int row) {
        return tileAt(row, 0).isTaken() &&
                tileAt(row, 1).isTaken() &&
                tileAt(row, 2).isTaken();
    }

    public char getWinnerIfExists() {
        for (int row = 0; row < 3; row++) {
            if (hasSameSymbolIn(row)) {
                return tileAt(row, 0).symbol;
            }
        }

        return ' ';
    }
}

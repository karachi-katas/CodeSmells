import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> tiles = new ArrayList<>();

    public Board()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 3; column++)
            {
                Tile tile = new Tile(row, column);
                tiles.add(tile);
            }
        }
    }

    public Tile tileAt(int row, int column)
    {
        for (Tile tile : tiles) {
            if (tile.isAt(row,column)){
                return tile;
            }
        }
        return null;
    }

    public void addTileAt(int row, int column, char symbol) {
        tileAt(row,column).symbol = Symbol.from(symbol);

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
                return tileAt(row, 0).symbol.symbol;
            }
        }

        return ' ';
    }

    public boolean tileAlreadyTaken(int x, int y) {
        return tileAt(x, y).isTaken();
    }
}

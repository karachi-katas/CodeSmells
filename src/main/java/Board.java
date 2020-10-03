import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Tile tile = new Tile(i, j);
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.x == x && t.y == y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y)
    {
        TileAt(x,y).symbol = symbol;
    }

    public boolean rowHasSameSymbol(int row) {
        return isRowNotEmpty(row) &&
               TileAt(row, 0).symbol ==
               TileAt(row, 1).symbol &&
               TileAt(row, 2).symbol ==
               TileAt(row, 1).symbol;
    }

    private boolean isRowNotEmpty(int row) {
        return TileAt(row, 0).isTaken() &&
                TileAt(row, 1).isTaken() &&
                TileAt(row, 2).isTaken();
    }
}

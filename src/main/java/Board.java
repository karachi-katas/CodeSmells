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
                Tile tile = new Tile();
                tile.X = i;
                tile.Y = j;
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.X == x && t.Y == y){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y)
    {
        Tile newTile = new Tile();
        newTile.X = x;
        newTile.Y = y;
        newTile.Symbol = symbol;

        TileAt(x,y).Symbol = symbol;
    }

    boolean checkWinnerForLastRow() {
        //if the positions in first row are taken
        if (TileAt(2, 0).Symbol != ' ' &&
                TileAt(2, 1).Symbol != ' ' &&
                TileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (TileAt(2, 0).Symbol ==
                    TileAt(2, 1).Symbol &&
                    TileAt(2, 2).Symbol ==
                            TileAt(2, 1).Symbol) {
                return true;
            }
        }
        return false;
    }

    boolean checkWinnerForMiddleRow() {
        //if the positions in first row are taken
        if (TileAt(1, 0).Symbol != ' ' &&
                TileAt(1, 1).Symbol != ' ' &&
                TileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (TileAt(1, 0).Symbol ==
                    TileAt(1, 1).Symbol &&
                    TileAt(1, 2).Symbol ==
                            TileAt(1, 1).Symbol) {
                return true;
            }
        }
        return false;
    }

    boolean checkWinnerForFirstRow() {
        //if the positions in first row are taken
        if (TileAt(0, 0).Symbol != ' ' &&
                TileAt(0, 1).Symbol != ' ' &&
                TileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (TileAt(0, 0).Symbol ==
                    TileAt(0, 1).Symbol &&
                    TileAt(0, 2).Symbol == TileAt(0, 1).Symbol) {
                return true;
            }
        }
        return false;
    }
}
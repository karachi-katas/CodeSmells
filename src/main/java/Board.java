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

    public Tile TileAt(Position position)
    {
        for (Tile t : _plays) {
            if (t.X == position.row && t.Y == position.col){
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, Position position)
    {
        Tile newTile = new Tile();
        newTile.X = position.row;
        newTile.Y = position.col;
        newTile.Symbol = symbol;

        TileAt(position).Symbol = symbol;
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

    char winningChecks() {
        if (checkWinnerForFirstRow()) return TileAt(0, 0).Symbol;
        if (checkWinnerForMiddleRow()) return TileAt(1, 0).Symbol;
        if (checkWinnerForLastRow()) return TileAt(2, 0).Symbol;

        return ' ';
    }
}
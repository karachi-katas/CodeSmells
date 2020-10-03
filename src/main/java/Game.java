import exceptions.InvalidFirstPlayerException;
import exceptions.InvalidPositionException;
import exceptions.ConsecutivePlayException;

public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        checkForInvalidMove(symbol, x, y);

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    private void checkForInvalidMove(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new InvalidFirstPlayerException();
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new ConsecutivePlayException();
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).Symbol != ' ') {
            throw new InvalidPositionException();
        }
    }

    public char Winner() {
        return _board.winningChecks();
    }

}


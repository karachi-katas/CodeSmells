import exceptions.InvalidFirstPlayerException;
import exceptions.InvalidPositionException;
import exceptions.ConsecutivePlayException;


public class Game {
    private char _lastSymbol = ' ';
    private Marker marker;
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        Position position = new Position(x, y);
        checkForInvalidMove(symbol, position);

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, position);
    }

    private void checkForInvalidMove(char symbol, Position position) throws Exception {
        //if first move
        firstPlayerIsO(symbol);
        //if not first move but player repeated
        repeatedMove(symbol);
        //if not first move but play on an already played tile
        invalidPosition(position);
    }

    private void invalidPosition(Position position) throws InvalidPositionException {
        if (_board.TileAt(position).Symbol != Marker.EMPTY.marker) {
            throw new InvalidPositionException();
        }
    }

    private void repeatedMove(char symbol) throws ConsecutivePlayException {
        if (symbol == _lastSymbol) {
            throw new ConsecutivePlayException();
        }
    }

    private void firstPlayerIsO(char symbol) throws InvalidFirstPlayerException {
        if (_lastSymbol == Marker.EMPTY.marker) {
            //if player is X
            if (symbol == Marker.NOUGHT.marker) {
                throw new InvalidFirstPlayerException();
            }
        }
    }

    public char Winner() {
        return _board.winningChecks();
    }

}


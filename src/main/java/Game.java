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
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }
    }

    public char Winner() {
        if (checkWinnerForFirstRow()) return _board.TileAt(0, 0).Symbol;
        if (checkWinnerForMiddleRow()) return _board.TileAt(1, 0).Symbol;
        if (checkWinnerForLastRow()) return _board.TileAt(2, 0).Symbol;

        return ' ';
    }

    private boolean checkWinnerForLastRow() {
        //if the positions in first row are taken
        if (_board.TileAt(2, 0).Symbol != ' ' &&
                _board.TileAt(2, 1).Symbol != ' ' &&
                _board.TileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).Symbol ==
                    _board.TileAt(2, 1).Symbol &&
                    _board.TileAt(2, 2).Symbol ==
                            _board.TileAt(2, 1).Symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerForMiddleRow() {
        //if the positions in first row are taken
        if (_board.TileAt(1, 0).Symbol != ' ' &&
                _board.TileAt(1, 1).Symbol != ' ' &&
                _board.TileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).Symbol ==
                    _board.TileAt(1, 1).Symbol &&
                    _board.TileAt(1, 2).Symbol ==
                            _board.TileAt(1, 1).Symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerForFirstRow() {
        //if the positions in first row are taken
        if (_board.TileAt(0, 0).Symbol != ' ' &&
                _board.TileAt(0, 1).Symbol != ' ' &&
                _board.TileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).Symbol ==
                    _board.TileAt(0, 1).Symbol &&
                    _board.TileAt(0, 2).Symbol == _board.TileAt(0, 1).Symbol) {
                return true;
            }
        }
        return false;
    }
}


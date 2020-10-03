public class Game {
    private char lastSymbol = ' ';
    private Board board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (board.TileAt(x, y).symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (rowHasSameSymbol(0)) {
                return board.TileAt(0, 0).symbol;
        }

        //if the positions in first row are taken
        if (rowHasSameSymbol(1)) {
                return board.TileAt(1, 0).symbol;
            }

        //if the positions in first row are taken
        if (rowHasSameSymbol(2)) {
                return board.TileAt(2, 0).symbol;
            }

        return ' ';
    }

    private boolean rowHasSameSymbol(int row) {
        return isRowNotEmpty(row) &&
               board.TileAt(row, 0).symbol ==
               board.TileAt(row, 1).symbol &&
               board.TileAt(row, 2).symbol ==
               board.TileAt(row, 1).symbol;
    }

    private boolean isRowNotEmpty(int row) {
        return board.TileAt(row, 0).symbol != ' ' &&
               board.TileAt(row, 1).symbol != ' ' &&
               board.TileAt(row, 2).symbol != ' ';
    }
}


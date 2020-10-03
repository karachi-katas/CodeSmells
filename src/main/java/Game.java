public class Game {
    private char lastSymbol = ' ';
    private Board board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        if (playerOTakesFirstTurn(symbol)) {
            throw new Exception("Invalid first player");
        }
        else if (playerRepeatsTurn(symbol)) {
            throw new Exception("Invalid next player");
        }
        else if (tileAlreadyTaken(x, y)) {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        board.AddTileAt(symbol, x, y);
    }

    private boolean tileAlreadyTaken(int x, int y) {
        return board.TileAt(x, y).symbol != ' ';
    }

    private boolean playerOTakesFirstTurn(char symbol) {
        return firstMove() && playerIsO(symbol);
    }

    private boolean playerIsO(char symbol) {
        return symbol == 'O';
    }

    private boolean playerRepeatsTurn(char symbol) {
        return symbol == lastSymbol;
    }

    private boolean firstMove() {
        return lastSymbol == ' ';
    }

    public char Winner() {
        for (int row = 0; row <= 2; row++) {
            if (rowHasSameSymbol(row)) {
                return board.TileAt(row, 0).symbol;
            }
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


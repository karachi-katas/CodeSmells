public class Game {
    private char lastSymbol = ' ';
    private Board board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        guardAgainstInvalidMove(symbol, x, y);
        updateGameState(symbol, x, y);
    }

    private void updateGameState(char symbol, int x, int y) {
        lastSymbol = symbol;
        board.addTileAt(x, y, symbol);
    }

    private void guardAgainstInvalidMove(char symbol, int x, int y) throws Exception {
        if (playerOTakesFirstTurn(symbol)) {
            throw new Exception("Invalid first player");
        }
        if (playerRepeatsTurn(symbol)) {
            throw new Exception("Invalid next player");
        }
        if (board.tileAlreadyTaken(x, y)) {
            throw new Exception("Invalid position");
        }
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
        return board.getWinnerIfExists();
    }

}


public enum Symbol {
    PLAYER_ONE('X'),
    PLAYER_TWO('O'),
    NONE(' ');
    char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    public static Symbol from(char symbol) {
        if (symbol == 'X') {
            return PLAYER_ONE;
        }
        if (symbol == 'O') {
            return PLAYER_TWO;
        }
        return NONE;

    }
}

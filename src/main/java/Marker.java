public enum Marker {
    CROSS('X'), NOUGHT('O'), EMPTY(' ');
    char marker;
    Marker(char marker) {
        this.marker = marker;
    }

    public static Marker from(char symbol) {
        if (symbol == 'X') {
            return CROSS;
        }
        if (symbol == 'O') {
            return NOUGHT;
        }
        return EMPTY;
    }
}

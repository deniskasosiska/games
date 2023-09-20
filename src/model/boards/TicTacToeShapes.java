package model.boards;

public enum TicTacToeShapes implements IShapes{
    o('0'),
    x('X'),
    empty(' ');

    private final char shape;

    TicTacToeShapes(char shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "" + this.shape;
    }
}

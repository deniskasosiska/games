package model.boards;

import model.interfaces.IBoard;

import java.util.HashMap;

public abstract class Board implements IBoard {
    protected BivariateHashMap<Integer, Integer, Character> board;
    protected final int width;
    protected final int length;

    public Board(int width, int length) {
        this.width = width;
        this.length = length;
        this.board = new BivariateHashMap<>();
        setEmptyBoard(width,length);
    }

    @Override
    public abstract BivariateHashMap<Integer, Integer, Character> getBoard();
    protected abstract void setEmptyBoard(int width, int length);

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getLength() {
        return length;
    }
    @Override
    public char getValue(int x, int y) {
        return board.get(x, y);
    }
    @Override
    public void setValue(int x, int y, char value) {
        board.put(x, y, value);
    }
}

package model.boards;

import model.BivariateHashMap;
import model.Position;
import model.games.TicTacToeGame;

abstract class Board implements IBoard {
    protected BivariateHashMap<Integer, Integer, IShapes> board;
    protected final int width;
    protected final int length;

    public Board(int width, int length) {
        this.width = width;
        this.length = length;
        this.board = new BivariateHashMap<>();
        setEmptyBoard(width,length);
    }

    @Override
    public abstract BivariateHashMap<Integer, Integer, IShapes> getBoard();
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
    public IShapes getValue(Position<Integer, Integer>k) {
        return board.get(k);
    }

    @Override
    public void setValue(Position<Integer, Integer> position, IShapes shapes) {
        board.put(position,shapes);
    }
}

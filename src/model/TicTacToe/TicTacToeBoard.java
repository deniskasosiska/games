package model.TicTacToe;

import model.BivariateHashMap;
import model.Position;
import model.boards.Board;
import model.boards.IShapes;

public class TicTacToeBoard extends Board {

    public TicTacToeBoard(int size) {
        super(size, size);
    }


    @Override
    public BivariateHashMap<Integer, Integer, IShapes> getBoard() {
        return board;
    }

    @Override
    protected void setEmptyBoard(int width, int length) {
        for(int i=0;i<width;i++){
            for(int f=0;f<length;f++){
                board.put(new Position<>(i, f), TicTacToeShapes.empty);
            }
        }
    }
}

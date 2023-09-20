package model.boards;

import model.BivariateHashMap;
import model.Position;

public class TicTacToeBoard extends Board{

    public TicTacToeBoard() {
        super(3, 3);
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

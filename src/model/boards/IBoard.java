package model.boards;
import model.BivariateHashMap;
import model.Position;
import model.games.TicTacToeGame;

public interface IBoard {
    BivariateHashMap<Integer, Integer, IShapes> getBoard();
    int getLength();
    int getWidth();
    IShapes getValue(Position<Integer, Integer>k);

    void setValue(Position<Integer, Integer> position, IShapes shapes);
}

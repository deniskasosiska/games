package view;

import model.Position;
import model.boards.IBoard;
import model.players.IPlayer;

public interface IView {
    void getStartMessage(String nameGame);
    Position<Integer, Integer> getNextStep(IPlayer player, IBoard board);
    void incorrectStep();
    void getEndMessage(IPlayer winner, IBoard board);
    void getDrawMessage(IBoard board);
}

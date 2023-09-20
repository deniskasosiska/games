package model.view;

import model.Position;
import model.boards.IBoard;
import model.players.IPlayer;
import model.players.Player;

import java.util.List;

public interface IView {
    void getStartMessage(String nameGame);
    Position<Integer, Integer> getNextStep(IPlayer player, IBoard board);
    void incorrectStep();
    void getEndMessage(IPlayer winner);
}

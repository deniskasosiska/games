package controller.games;

import model.boards.IBoard;
import model.players.IPlayer;
import view.IView;

import java.util.List;

public abstract class Game implements IGame{
    protected final String nameGame;
    protected final IBoard board;
    protected final List<IPlayer> players;
    protected final IView view;

    public Game(String nameGame, IBoard board, List<IPlayer> players, IView view) {
        this.nameGame = nameGame;
        this.board = board;
        this.players = players;
        this.view = view;
    }

    public abstract void start();
}

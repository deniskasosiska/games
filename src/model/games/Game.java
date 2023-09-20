package model.games;

import model.boards.IBoard;
import model.players.IPlayer;
import model.view.IView;

import java.util.List;

abstract class Game implements IGame{
    protected String nameGame;
    protected IBoard board;
    protected List<IPlayer> players;
    protected IView view;

    public Game(String nameGame, IBoard board, List<IPlayer> players, IView view) {
        this.nameGame = nameGame;
        this.board = board;
        this.players = players;
        this.view = view;
    }

    public abstract void start();
}

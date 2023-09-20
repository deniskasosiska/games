import model.boards.TicTacToeBoard;
import model.boards.IBoard;
import model.games.IGame;
import model.games.TicTacToeGame;
import model.players.IPlayer;
import model.players.Player;
import model.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IPlayer> players= new ArrayList<>();
        players.add(new Player("Марина"));
        players.add(new Player("Денис"));
        IGame game = new TicTacToeGame(players,new View());
        game.start();
    }
}
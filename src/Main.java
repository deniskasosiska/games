import controller.games.IGame;
import controller.TicTacToeGame;
import model.players.IPlayer;
import model.players.Player;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<IPlayer> players= new ArrayList<>();
        players.add(new Player("Марина"));
        players.add(new Player("Денис"));
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int s = Math.min(Math.max(in.nextInt(),3),10);
            if (in.hasNextInt()) {
                int Sv = Math.min(Math.max(in.nextInt(),3),10);
                IGame game = new TicTacToeGame(players,new View(),s,Sv);
                game.start();
            }
        }

    }
}
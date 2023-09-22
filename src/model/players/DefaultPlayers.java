package model.players;

import java.util.ArrayList;
import java.util.List;

public class DefaultPlayers {
    private static final List<IPlayer> players = new ArrayList<>();

    public static List<IPlayer> getOnePlayers() {
        players.add(new Player("Player 1"));
        return players;
    }
    public static List<IPlayer> getTwoPlayers() {
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        return players;
    }
}

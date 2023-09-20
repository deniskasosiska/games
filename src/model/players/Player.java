package model.players;

import javax.xml.namespace.QName;

public class Player implements IPlayer{

    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void addScore(int var) {
        score+=var;
    }

    @Override
    public String toString() {
        return name+" - score: "+score;
    }
}

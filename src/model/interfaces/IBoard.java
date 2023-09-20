package model.interfaces;
import model.boards.BivariateHashMap;

import java.util.HashMap;

public interface IBoard {
    BivariateHashMap<Integer, Integer, Character> getBoard();
    int getLength();
    int getWidth();
    void setValue(int x, int y, char value);
    char getValue(int x, int y);
}

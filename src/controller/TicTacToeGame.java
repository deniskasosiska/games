package controller;

import model.BivariateHashMap;
import model.Position;
import model.TicTacToe.TicTacToeBoard;
import model.TicTacToe.TicTacToeShapes;
import model.boards.IShapes;
import controller.games.Game;
import model.players.IPlayer;
import view.IView;
import java.util.List;

public class TicTacToeGame extends Game
{
    private final int sizeLineToWin;
    public TicTacToeGame(List<IPlayer> players, IView view, int size, int sizeLineToWin)
    {
        super("Крестики нолики", new TicTacToeBoard(size), players, view);
        this.sizeLineToWin = sizeLineToWin;
    }

    @Override
    public void start()
    {
        view.getStartMessage(nameGame);

        for(int i=0; i<Math.pow(board.getWidth(),2);)
        {
            Position<Integer, Integer> position = view.getNextStep(players.get(i%2), board);
            BivariateHashMap<Integer, Integer, IShapes> m = board.getBoard();

            IShapes value = board.getValue(position);
            if (value == TicTacToeShapes.empty)
            {
                board.setValue(position, i%2==0?TicTacToeShapes.x:TicTacToeShapes.o);
                if (checkWin(position)){
                    IPlayer winner = players.get(i%2);
                    winner.addScore(10);
                    view.getEndMessage(winner,board);
                    return;
                }
                i++;
            }
            else view.incorrectStep();
        }
        view.getDrawMessage(board);
    }



    private boolean checkWin(Position<Integer,Integer> lastPosition){
        for (int i = 0;i<board.getWidth();i++) {
            for (int f = 0; f<board.getWidth();f++){
                Position<Integer, Integer> pos = new Position<>(i,f);
                int h=0;
                int v=0;
                int d=0;
                int rd=0;
                if (board.getValue(lastPosition)==board.getValue(pos)) {
                    for (int g = 1; g < sizeLineToWin; g++) {
                        Position<Integer, Integer> posh = new Position<>(i + g, f);
                        Position<Integer, Integer> posv = new Position<>(i, f + g);
                        Position<Integer, Integer> posd = new Position<>(i + g, f + g);
                        Position<Integer, Integer> posrd = new Position<>(i - g, f + g);
                        if (board.getValue(posh) != null && board.getValue(posh) == board.getValue(pos)) h++;
                        if (board.getValue(posv) != null && board.getValue(posv) == board.getValue(pos)) v++;
                        if (board.getValue(posd) != null && board.getValue(posd) == board.getValue(pos)) d++;
                        if (board.getValue(posrd) != null && board.getValue(posrd) == board.getValue(pos)) rd++;
                    }
                    if (h == sizeLineToWin - 1 || v == sizeLineToWin - 1 || d == sizeLineToWin - 1 || rd == sizeLineToWin - 1)
                        return true;
                }
            }
        }
        return false;
    }


}

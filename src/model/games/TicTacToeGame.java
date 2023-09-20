package model.games;

import model.BivariateHashMap;
import model.Position;
import model.boards.IShapes;
import model.boards.TicTacToeShapes;
import model.boards.TicTacToeBoard;
import model.players.IPlayer;
import model.players.Player;
import model.view.IView;

import java.awt.*;
import java.util.List;

public class TicTacToeGame extends Game
{

    public TicTacToeGame(List<IPlayer> players, IView view)
    {
        super("Крестики нолики", new TicTacToeBoard(), players, view);
    }

    @Override
    public void start()
    {
        view.getStartMessage(nameGame);

        boolean gamePointer = true;
        int gameStep = 0;
        while(gamePointer)
        {
            Position<Integer, Integer> position = view.getNextStep(players.get(gameStep%2), board);
            BivariateHashMap<Integer, Integer, IShapes> m = board.getBoard();

            IShapes value = board.getValue(position);
            if (value == TicTacToeShapes.empty)
            {
                board.setValue(position, gameStep%2==0?TicTacToeShapes.x:TicTacToeShapes.o);
                gamePointer = !checkWin(position);
                if(!gamePointer)break;
                gameStep++;
                if(gameStep==9){
                    view.getEndMessage(new Player("А вот никто"));
                }
            }
            else
            {
                view.incorrectStep();
                if(gameStep==9){
                    view.getEndMessage(new Player("А вот никто"));
                }
            }
        }
        view.getEndMessage(players.get(gameStep%2));
    }



    private boolean checkWin(Position<Integer,Integer> lastPosition){
        IShapes p00 = board.getValue(new Position<>(0,0));
        IShapes p01 = board.getValue(new Position<>(0,1));
        IShapes p02 = board.getValue(new Position<>(0,2));
        IShapes p10 = board.getValue(new Position<>(1,0));
        IShapes p11 = board.getValue(new Position<>(1,1));
        IShapes p12 = board.getValue(new Position<>(1,2));
        IShapes p20 = board.getValue(new Position<>(2,0));
        IShapes p21 = board.getValue(new Position<>(2,1));
        IShapes p22 = board.getValue(new Position<>(2,2));
        IShapes p99 =  TicTacToeShapes.empty;

        if ((p00==p01 && p00==p02 && p00 != p99)||(p10==p11 && p10==p12 && p10 != p99)||(p20==p21 && p20==p22 && p20 != p99)||
                (p00==p10 && p00==p20 && p10 != p99)||(p01==p11 && p01==p21 && p01 != p99)||(p02==p12 && p02==p22 && p02 != p99)||
                (p00==p11 && p00==p22 && p00 != p99)||(p02==p11 && p02==p20 && p02 != p99)) return true;
        return false;
    }
}

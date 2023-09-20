package model.view;

import model.Position;
import model.boards.IBoard;
import model.players.IPlayer;
import model.players.Player;

import java.util.Scanner;

public class View implements IView{

    @Override
    public void getStartMessage(String nameGame) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру: "+nameGame);
        in.nextLine();
    }

    @Override
    public Position<Integer, Integer> getNextStep(IPlayer player, IBoard board) {
        Scanner in = new Scanner(System.in);
        int width = board.getWidth();
        int length = board.getLength();

        System.out.println("Ходит - "+player.getName());
        System.out.print(" ");

        for(int i = 0;i<width;i++){
            System.out.print(" "+(i+1));
        }
        System.out.println();
        System.out.println(frame(width));
        for(int i=0;i<width;i++){
            System.out.print(i+1);
            for(int f=0;f<width;f++){
                System.out.print("|"+board.getValue(new Position<>(i,f)));
            }
            System.out.println("|");
            System.out.println(frame(width));
        }
        if (in.hasNextInt()) {
            int x = in.nextInt();
            if (in.hasNextInt()) {
                int y = in.nextInt();
                System.out.print("\033[H\033[2J");
                return new Position<>(x-1,y-1);
            }
        }
        return null;
    }

    @Override
    public void incorrectStep() {
        System.out.println("Что-то не то написал/");
    }

    @Override
    public void getEndMessage(IPlayer winner) {
        System.out.println("Победил(а) - "+winner.getName()+"!!!!");
    }

    private String frame(int cell){
        String out = " |";
        for (int i=0;i<cell;i++){
            out+= i<cell-1
                ?"-+"
                :"-|";
        }
        return out;
    }
}

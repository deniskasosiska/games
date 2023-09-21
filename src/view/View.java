package view;

import model.Position;
import model.boards.IBoard;
import model.players.IPlayer;
import view.IView;

import java.util.Scanner;

public class View implements IView {

    @Override
    public void getStartMessage(String nameGame) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру: "+nameGame+"\nНажмите *Enter* чтобы продолжить");
        in.nextLine();
    }

    @Override
    public Position<Integer, Integer> getNextStep(IPlayer player, IBoard board) {
        Scanner in = new Scanner(System.in);

        visual(board);

        System.out.println("Ходит - "+player.getName()+"\nНапишите сначала стобец потом строчку через пробел - *3 1*");

        if (in.hasNextInt()) {
            int y = in.nextInt();
            if (in.hasNextInt()) {
                int x = in.nextInt();
                return new Position<>(x-1,y-1);
            }
        }
        return null;
    }
    private void visual(IBoard board){
        System.out.print("\033[H\033[2J");
        int width = board.getWidth();
        System.out.print("\t");

        for(int i = 0;i<width;i++){
            System.out.print(" "+(i+1));
        }
        System.out.println();
        System.out.println(frame(width));
        for(int i=0;i<width;i++){
            System.out.print(i+1+"\t");
            for(int f=0;f<width;f++){
                System.out.print("|"+board.getValue(new Position<>(i,f)));
            }
            System.out.println("|");
            System.out.println(frame(width));
        }
    }

    @Override
    public void incorrectStep() {
        System.out.println("Не корректный ввод");
    }

    @Override
    public void getEndMessage(IPlayer winner, IBoard board) {
        visual(board);
        System.out.println("Победил(а) - "+winner.getName()+"!\n" +
                "У Марины - "+winner.getScore()+" очков!");
    }

    @Override
    public void getDrawMessage(IBoard board) {
        visual(board);
        System.out.println("У нас ничья ребята!");
    }

    private String frame(int cell){
        String out = "\t|";
        for (int i=0;i<cell;i++){
            out+= i<cell-1
                ?"-+"
                :"-|";
        }
        return out;
    }
}

import model.boards.Board;
import model.boards.TicTacToeBoard;
import model.interfaces.IBoard;

public class Main {
    public static void main(String[] args) {
        IBoard board = new TicTacToeBoard();
        System.out.println(board.getBoard());
    }
}
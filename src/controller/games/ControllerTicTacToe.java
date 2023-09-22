package controller.games;

public class ControllerTicTacToe extends ControllerGame{
    public ControllerTicTacToe() {
        nameGame = "Крестики нолики";
    }

    @Override
    protected IGame init() {
        return new TicTacToeGame.Builder().setName(nameGame).build();
    }
}

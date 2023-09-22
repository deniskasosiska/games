package controller.games;

public abstract class ControllerGame implements IControllerGame{
    protected String nameGame;
    protected IGame game;
    @Override
    public String getNameGame() {
        return nameGame;
    }
    @Override
    public IGame getGame() {
        return game == null
                ? init()
                : game;
    }
    protected abstract IGame init();
}

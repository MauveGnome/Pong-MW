package pongCore;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 05/09/2012
 * Time: 00:09
 * To change this template use File | Settings | File Templates.
 */
public abstract class Game {

    private Player primaryPlayer = null;
    private Player player2;

    public void addPrimaryPlayer(Player primaryPlayer){
        this.primaryPlayer = primaryPlayer;
    }

    public void addPlayerTwo(Player player){
        this.player2 = player;
    }

    public Player getPrimaryPlayer() {
        return primaryPlayer;
    }

    public Player getPlayerTwo() {
        return player2;
    }
}

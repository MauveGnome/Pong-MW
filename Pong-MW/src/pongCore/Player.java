package pongCore;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 30/08/2012
 * Time: 18:56
 * To change this template use File | Settings | File Templates.
 */
public class Player {

    private final String name;
    private final GameClient gameClient;
    private Paddle paddle;

    public Player(String name, GameClient gameClient){
        this.name = name;
        this.gameClient = gameClient;
        this.paddle = new Paddle();
    }

    public void setPaddleY(int paddleY) {
        this.paddle.setY(paddleY);
    }

    public Paddle getPaddle() {
        return paddle;
    }
}

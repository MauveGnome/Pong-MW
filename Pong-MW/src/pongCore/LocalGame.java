package pongCore;

import pongCore.ai.UselessAI;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 05/09/2012
 * Time: 00:19
 * To change this template use File | Settings | File Templates.
 */
public class LocalGame extends Game {

    public LocalGame(){
        this.addPrimaryPlayer(new Player("Player 1", null));
        this.addPlayerTwo(new UselessAI("Player 2"));
    }
}

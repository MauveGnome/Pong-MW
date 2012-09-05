package pongCore.ai;

import pongCore.GameClient;
import pongCore.Player;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 05/09/2012
 * Time: 00:42
 * To change this template use File | Settings | File Templates.
 */
public class UselessAI extends Player implements Runnable{

    public UselessAI(String name) {
        super(name, null);

        new Thread(this).start();
    }

    @Override
    public void run() {
        Random random = new Random(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(100);

                boolean up = random.nextBoolean();

// moveUp seems to work, moveDown doesnt. hacked around it. :-P
//                if(up){
//                    getPaddle().moveUp();
//                } else {
//                    getPaddle().moveDown();
//                }

                if(up){
                    getPaddle().setY(getPaddle().getYPos() - 10);
                } else {
                    getPaddle().setY(getPaddle().getYPos() + 10);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}

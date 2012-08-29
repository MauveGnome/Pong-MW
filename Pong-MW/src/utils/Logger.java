package utils;

import java.sql.Time;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ian
 * Date: 27/08/2012
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 */
public class Logger {

    private static Logger logger = new Logger();
    private boolean logging = true;

    /**
     * Method for turning logging on and off.
     * @param shouldLog true will turn logging and and false disables it.
     */
    public static void setLogging(boolean shouldLog){
        logger.logging = shouldLog;
    }

    /**
     * Prints out a message containing the time/date and a message.
     * @param msg The message to be printed in the log item.
     */
    public static void log(String msg){
        if(logger.logging){
            System.out.println(new Date().toString() + " : " + msg);
        }
    }
}

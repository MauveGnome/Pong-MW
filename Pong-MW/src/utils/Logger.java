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

    public static void setLogging(boolean shouldLog){
        logger.logging = shouldLog;
    }

    public static void log(String msg){
        if(logger.logging){
            System.out.println(new Date().toString() + " : " + msg);
        }
    }
}

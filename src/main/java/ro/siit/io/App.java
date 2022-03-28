package ro.siit.io;


import java.util.logging.Logger;

/**
 *
 *
 */
public class App 
{
    private static Logger logger = Logger.getLogger("log.txt");
    public static void main( String[] args )
    {
        logger.info("App just started");
        ReadInput s = new ReadInput();
        System.out.println( s.readInputData() );
        logger.info("Data sorted is: \n" + s.readInputData());


    }
}

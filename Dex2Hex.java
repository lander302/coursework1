import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.io.ByteArrayOutputStream;
import java.util.logging.Handler;
import java.io.IOException;

class Dex2Hex {
    public static final Logger logger = Logger.getLogger(Dex2Hex.class.getName());

    public static void main(String args[])    {

        // Create a ByteArrayOutputStream to capture log output
        ByteArrayOutputStream logStream = new ByteArrayOutputStream();
        Handler logHandler = new ConsoleHandler() {
            @Override
             public void publish(java.util.logging.LogRecord record) {
                try {
                    // Write the formatted log message to logStream
                    logStream.write((getFormatter().format(record)).getBytes());
                } catch (IOException e) {
                    // Handle the IOException (you can log it if necessary)
                    logger.severe("Error writing to log stream: " + e.getMessage());
                }
            }
        };        
	logHandler.setLevel(Level.ALL);
	logger.addHandler(logHandler);


	if (args.length == 0) {
            logger.info("Error: No input given");
            return;
        }
        int arg1;
        try {
            arg1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            logger.info("Error: Please input an integer.");
            return;
  }


        char[] ch ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem;
        int num = arg1;
        StringBuilder hexadecimal = new StringBuilder();


        logger.info("Converting the Decimal Value " + num + " to Hex...");


        while(num != 0){
            rem = num % 16;
            hexadecimal.insert(0, ch[rem]);
            num = num / 16;
        }
		
		
        logger.info("Hexadecimal representation is: " + hexadecimal);
        logger.info("Your integer has been converted");

 	System.out.println(logStream.toString());
}
}


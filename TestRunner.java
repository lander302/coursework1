import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.*;
import org.junit.runner.notification.Failure;
import java.util.logging.Logger;

public class TestRunner {

//Initialises Logger
private static final Logger logger = Logger.getLogger(TestRunner.class.getName());

	public static void main(String[] args) {
      		Result result = JUnitCore.runClasses(Dex2HexTest.class);
      		int fails = 0;

	//Uses try catch method to check is tests were successful and then outputs repsonse 
      		try{
          		for (Failure failure : result.getFailures()) {
             			logger.info(failure.toString());
             			fails++;
         	   }
          		if(fails >0)
            			throw  new Exception();
          		logger.info("Tests run successful: " + result.wasSuccessful());
      		}
      		catch(Exception e)
      		{
          		logger.info("" + fails + " tests failed");
          		System.exit(1);
      		}
      		System.exit(0);
   	}
}

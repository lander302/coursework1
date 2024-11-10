import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.*;
import org.junit.runner.notification.Failure;
import java.lang.Exception;
import java.util.logging.Logger;

public class TestRunner {

private static final Logger logger = Logger.getLogger(TestRunner.class.getName());

	public static void main(String[] args) {
      		Result result = JUnitCore.runClasses(Dex2HexTest.class);
      		int fails = 0;
      		try{
          		for (Failure failure : result.getFailures()) {
             			logger.info(failure.toString());
             			fails++;
         	   }
          		if(fails >0)
            			throw  new Exception();
          		logger.info("Test run successful: " + result.wasSuccessful());
      		}
      		catch(Exception e)
      		{
          		logger.info("" + fails + " tests failed");
          		System.exit(1);
      		}
      		System.exit(0);
   	}
}

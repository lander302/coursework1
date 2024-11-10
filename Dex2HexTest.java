import org.junit.*;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import java.util.logging.*;

public class Dex2HexTest {


	private Dex2Hex dex2hex;
	private ByteArrayOutputStream logStream;
	private PrintStream originalOut;
	private PrintStream originalErr;

    @Before
    public void setUp() {
        dex2hex = new Dex2Hex();

    	logStream = new ByteArrayOutputStream();
	originalOut = System.out;
	originialErr = System.err;

        System.setOut(new PrintStream(logStream)); // sets it to System.out
	System.setErr(new PrintStream(logStream));

	ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        Logger logger = Logger.getLogger(Dex2Hex.class.getName());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);   

	}

   @After
   public void tearDown() {

	System.setOut(originalOut);
	System.setErr(originalErr);

 	Logger logger = Logger.getLogger(Dex2Hex.class.getName());
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);

	  }
	}

    @Test
    public void testForcorrectInput() {
        // Valid integer input
        String[] args = {"255"};
        String output = getOutput(args);

	System.out.println("Captured Output: \n" + output);

        // Convert input to hexadecimal output
        assertTrue(output.contains("Converting the Decimal Value 255 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: FF"));
        assertTrue(output.contains("Your integer has been converted"));

        }



    @Test
    public void testForNoInput() {
        // No output given
        String[] args = {};
        String output = getOutput(args);  // Use getOutput to capture console output

	System.out.println("Captured Output: \n" + output);

        // Validate output message for no input and make sure no white space
        assertEquals("Error: No input has been given", output.trim());


    }

    @Test
    public void testForANonIntegerInput() {
        //When a non-integer input is given
        String[] args = {"abc"};
        String output = getOutput(args);  // Use getOutput to capture console output



        // Validate output message for non-integer input and make sure no white space
        assertEquals("Error: Please input an integer.", output.trim());

        }

    // Utility method to capture console output with input arguments
     private String getOutput(String[] args) {
 	 try {
            // Run Dex2Hex with the specified arguments
            Dex2Hex.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return logStream.toString().trim();

    }

}

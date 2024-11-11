import org.junit.*;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class Dex2HexTest {

    public Dex2HexTest() {}

    Dex2Hex dex2hex;

// Initialises variable
    @Before
    public void setUp() {
        dex2hex = new Dex2Hex();
    }



    @Test
    public void testForcorrectInput() {
        // assigning valid integer input
        String[] args = {"255"};
        String output = getOutput(args);

        // Converts input to hexadecimal output
        assertTrue(output.contains("Converting the Decimal Value 255 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: FF"));
        assertTrue(output.contains("Your integer has been converted"));

        }



    @Test
    public void testForNoInput() {
        // assigns no output given
        String[] args = {};
	// Captures console output in variable
        String output = getOutput(args);

        // assign output message for no input and make sure no white space
        assertEquals("Error: No input has been given", output.trim());


    }

    @Test
    public void testForANonIntegerInput() {
        // assigns a non-integer input is given
        String[] args = {"abc"};
	// Captures console output in variable
        String output = getOutput(args);



        // assign output message for non-integer input and make sure no white space
        assertEquals("Error: Please input an integer.", output.trim());

        }

    // method to capture console output with the given input arguments
     private String getOutput(String[] args) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));





  try {
            // Run Dex2Hex with the specified arguments
            Dex2Hex.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Restores original System.out after the method executes
            System.setOut(originalOut);
        }

        return outputStream.toString().trim();

    }

}

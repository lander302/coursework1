import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dex2HexTest {

    public Dex2HexTest() {}

    Dex2Hex dex2hex;


    @Before
    public void setUp() {
        dex2hex = new Dex2Hex();

    }



    @Test
    public void testForcorrectInput() {
        // Valid integer input
        String[] args = {"255"};
        String output = getOutput(args);

        // Converts input to hexadecimal and outputs answer
        assertTrue(output.contains("Converting the Decimal Value 255 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: FF"));
        assertTrue(output.contains("Your integer has been converted"));

        }



    @Test
    public void testForNoInput() {
        // No output given
        String[] args = {};
        String output = getOutput(args);  // Use getOutput to capture console output

        // Output message for no input given
        assertTrue(output.contains("Error: \n No input given"));

    }

    @Test
    public void testForANonIntegerInput() {
        //When a non-integer input is given
        String[] args = {"abc"};
        String output = getOutput(args);  // Use getOutput to capture console output



        // Validate output message for non-integer input
        assertTrue(output.contains("Error: Please input an integer"));

        }

    // Utility method to capture console output with input arguments
    private String getOutput(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));



        // Run Dex2Hex with the specified args
        Dex2Hex.main(args);



        // Restore original System.out
        System.setOut(originalOut);


	// Returns output depending on input
        return outputStream.toString();

    }

}

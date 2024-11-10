import org.junit.*;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.*;

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
 
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));



        // Run Dex2Hex with the specified args
//        Dex2Hex.main(args);

  try {
            // Run Dex2Hex with the specified arguments
            Dex2Hex.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Restore original System.out after the method executes
            System.setOut(originalOut);
        }




        // Restore original System.out
        System.setOut(originalOut);

//	System.out.println("Captured Output: " + outputStream.toString());

        return outputStream.toString().trim();

    }

}

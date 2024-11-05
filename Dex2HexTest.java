import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dex2HexTest {

    // Helper method to capture printed output
    private String captureOutput(Runnable methodToRun) {
        // Set up a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;  // Save the original System.out

        // Redirect System.out to the ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));

        // Run the method (this will print to the outputStream)
        methodToRun.run();

        // Restore original System.out
        System.setOut(originalOut);

        return outputStream.toString().trim();  // Return the captured output as a String
    }

    // Tests when there is no input argument provided
    @Test
    public void testNoInput() {
        String output = captureOutput(() -> Dex2Hex.main(new String[]{}));
        assertEquals("Error: You haven't provided a number. Please provide a decimal number to convert.", output);
    }

    // Tests when the input is not an integer
    @Test
    public void testInvalidInput() {
        String output = captureOutput(() -> Dex2Hex.main(new String[]{"abc"}));
        assertEquals("Error: Invalid input. Please provide a decimal number to convert.", output);
    }

    // Tests when a valid decimal input is provided
    @Test
    public void testValidDecimalInput() {
        String output = captureOutput(() -> Dex2Hex.main(new String[]{"255"}));
        assertTrue(output.contains("Converting the Decimal Value 255 to Hex..."));
        assertTrue(output.contains("Hexadecimal representation is: FF"));
    }

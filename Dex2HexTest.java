import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dex2HexTest {

    @Test
    public void testNoInputArgument() {
        // Simulate no input argument being provided
        String[] args = {};
        // Capture the system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dex2Hex.main(args);

        String output = outputStream.toString().trim();
        assertEquals("Error: No input argument provided.", output);
    }

    @Test
    public void testInvalidIntegerInput() {
        // Simulate invalid input (non-integer)
        String[] args = {"abc"};
        // Capture the system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dex2Hex.main(args);

        String output = outputStream.toString().trim();
        assertEquals("Error: Invalid input. Please provide an integer.", output);
    }
}

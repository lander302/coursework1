import org.junit.Test;
import static org.junit.Assert.*;

public class Dex2HexTest {

    @Test
    public void testForCorrectInput() {
        String[] args = {"255"};  // Valid input
        Dex2Hex.main(args);  // runs the program with this input
    }

    @Test
    public void testForNoInput() {
        String[] args = {};  // No input
        Dex2Hex.main(args);  // Expect an error message
          }

    @Test
    public void testForANonIntegerInput() {
        String[] args = {"abc"};  // Invalid input
        Dex2Hex.main(args);  // Expect an error message
      
    }
}

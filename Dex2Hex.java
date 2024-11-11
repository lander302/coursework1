import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class Dex2Hex {


    public static void main(String args[])    {

	//Prints Error message is no input is given
        if (args.length == 0) {
            System.out.println("Error: No input has been given");
            return;
        }
        int arg1;
        try {
            arg1 = Integer.parseInt(args[0]);
	//Catches the other solution of nothing being entered and printing error message
        } catch (NumberFormatException e) {
            System.out.println("Error: Please input an integer.");
            return;
  }


        char[] ch ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem;
        int num = arg1;
        StringBuilder hexadecimal = new StringBuilder();

        System.out.println("Converting the Decimal Value " + num + " to Hex...");


        while(num != 0){
            rem = num % 16;
            hexadecimal.insert(0, ch[rem]);
            num = num / 16;
        }


        System.out.println("Hexadecimal representation is: " + hexadecimal);
        System.out.println("Your integer has been converted");


}
}

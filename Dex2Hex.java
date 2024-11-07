import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.logging.Logger;


class Dex2Hex {
   // public static final Logger logger = Logger.getLogger(Dex2Hex.class.getName());

    public static void main(String args[])    {
        if (args.length == 0) {
            System.out.println("Error: \n No input given");
            return;
        }
        int arg1;
        try {
            arg1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please input an integer.");
            return;
        }


        char[] ch ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem; 
	num = arg1;
        String hexadecimal="";
 	
	
        System.out.println("Converting the Decimal Value " + num + " to Hex...");
	

        while(num != 0){
            rem = num % 16;
            hexadecimal = ch[rem] + hexadecimal;
            num = num / 16;
        }

	
		System.out.println("Hexadecimal representation is: " + hexadecimal));
	
	
		System.out.println("Your integer has been converted");

	}

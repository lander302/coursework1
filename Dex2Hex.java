package com.example.hex;

import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.logging.Logger;


class Dex2Hex {
    public static final Logger logger = Logger.getLogger(Dex2Hex.class.getName());

    public static void main(String args[])    {
        if (args.length == 0) {
            logger.info("Error: \n No input given");
            return;
        }
        int arg1;
        try {
            arg1 = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            logger.info("Error: Please input an integer.");
            return;
        }


        char ch[] ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem; 
	num = arg1;
        StringBuilder hexadecimal = new StringBuilder();
 	
	if (logger.isLoggable(java.util.logging.Level.INFO)) {
        logger.info("Converting the Decimal Value " + num + " to Hex...");
	}

        while(num != 0){
            rem = num % 16;
            hexadecimal.insert(0, ch[rem]);
            num = num / 16;
        }

	if (logger.isLoggable(java.util.logging.Level.INFO)) {
		logger.info(String.format("Hexadecimal representation is: %s", hexadecimal));
	}
	if (logger.isLoggable(java.util.logging.Level.INFO)) {
		logger.info("Your integer has been converted");
    	}
	
	}
}

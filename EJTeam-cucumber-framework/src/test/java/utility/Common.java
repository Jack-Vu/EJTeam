package utility;

import java.util.Random;

public class Common {


	// generates a random 6 digit code
	public static int getRandomSixDigitCode() {
		Random random = new Random(); 
		int code = random.nextInt(999999 + 1 - 100000) + 100000; 
		return code;
		
	}
}

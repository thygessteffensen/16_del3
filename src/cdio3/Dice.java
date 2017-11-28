package cdio3;

import java.util.Random;

public class Dice
{
	private static int d1; // Value of dice 1 and 2.
	
	static Random ran = new Random(); // Instance of the Random class.
	
	/**
	 * Bruger Random klassen til at slå med en terning
	 * @return Summen af terningen
	 */
	public static void roll()
	{
		d1 = ran.nextInt(6)+1;
	}

	/**
	 * getDiceValue1 returnerer værdien d1 
	 * @return
	 */
	public static int getDiceValue1() {
		return d1;
	}

}

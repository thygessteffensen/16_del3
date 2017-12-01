package cdio3;

import java.util.Random;

/**
 * @author CDIO2
 * @version 28/11/2017
 */

public class Dice
{
	private static int d1; // Value of dice 1 and 2.
	static Random ran = new Random(); // Instance of the Random class.
	
	/**
	 * Bruger Random klassen til at genererer et tilfældigt tal.
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
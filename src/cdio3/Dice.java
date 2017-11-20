package cdio3;

import java.util.Random;

public class Dice
{
	private int d1; // Value of dice 1 and 2.
	
	Random ran = new Random(); // Instance of the Random class.
	
	/**
	 * Bruger Random klassen til at slå med en terning
	 * @return Summen af terningen
	 */
	public void roll()
	{
		//To terninger defineres.
		d1 = ran.nextInt(6)+1;
	}

	/**
	 * getDiceValue1 returnerer værdien d1 
	 * @return
	 */
	public int getDiceValue1() {
		return d1;
	}

}

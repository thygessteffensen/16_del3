package cdio3;

import java.util.Random;

public class Dice
{
	private int d1, d2; // Value of dice 1 and 2.
	
	Random ran = new Random(); // Instance of the Random class.
	
	/**
	 * Bruger Random klassen til at slå med en terning
	 * @return Summen af terningerne
	 */
	public void roll()
	{
		//To terninger defineres.
		d1 = ran.nextInt(6)+1;
		d2 = ran.nextInt(6)+1;
	}
	
	/**
	 * getDiceValue1 returnerer værdien d1 
	 * @return
	 */
	public int getDiceValue1() {
		return d1;
	}
	
	/**
	 * getDiceValue2 returnerer værdien d2  
	 * @return
	 */
	public int getDiceValue2() {
		return d2;
	}
	/**
	 * getSum retunererer værdien af GetDiceValue 1 og getDiceValue2
	 * @return
	 */
	public int getSum() {
		return getDiceValue1() + getDiceValue2();
	}
	
	
	
}

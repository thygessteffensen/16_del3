package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cdio3.Dice;

/**
 * Tester Dice klassen.
 * @author thyge
 * @version 21.11.2017
 */
public class TestDice {
	Dice dice = new Dice();
	
	/**
	 * Tester om terningen ligger inde for spekteret,
	 */
	@Test
	public void testGetDiceValue1() {
		for (int i = 0; i < 100000; i++) { // Ruller terning 1 100000 gange
			dice.roll();
			if (dice.getDiceValue1() < 1 || dice.getDiceValue1() > 6) {
				fail("Roll-returværdi er udenfor spektret 1-6");
				break;
			}
		}
	}
	/**
	 * Tester om hyppigheden for hvert slag er er lige stor, for terning 1.
	 */
	@Test
	public void testRollFrequencyTerning1() {
		//Definere alle øjnene
		int count1d1=0, count2d1=0, count3d1=0, count4d1=0, count5d1=0, count6d1=0;

		//Tester for 100000 kast og ser om hyppigheden for hvert slag er lige stor for terning 1
		for (int i = 0; i < 100000; i++) {
			dice.roll();
			switch(dice.getDiceValue1()) {
			case 1: count1d1++;
			break;
			case 2: count2d1++;
			break;
			case 3: count3d1++;
			break;
			case 4: count4d1++;
			break;
			case 5: count5d1++;
			break;
			case 6: count6d1++;
			break;
			default: fail("Virker ikke");
			break;
			}

		}
		//Nu tester vi om hver terning slår hver side cirka lige hyppigt med en afvigelse på 4%
		//Denne test er for terning 1
		int test = (int)(100000*16.6667)/(100);	//1/6 af størrelsen på testen
		int grænsOp = (int)(test + (test*4)/(100));
		int grænsNed = (int)(test - (test*4)/(100));
		//Dump programmet hvis hvert tilfælde er ude for den øvre og nedre grænse 
		if (count1d1 > grænsOp || count1d1 < grænsNed || count2d1 > grænsOp || count2d1 < grænsNed || count3d1 > grænsOp || count3d1 < grænsNed || 
				count4d1 > grænsOp || count4d1 < grænsNed || count5d1 > grænsOp || count5d1 < grænsNed ||
				count6d1 > grænsOp || count6d1 < grænsNed){ 
			fail("Hyppigheden af de forskellige forekommer ikke lige ofte");	
		}
	}
}

package test;

import static org.junit.Assert.*;
/**
 * Tester wallet klassen
 * @author mathias
 * @version 1/12/17
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cdio3.Wallet;

public class TestWallet {
	Wallet wallet = new Wallet("Bil", 2); // Instansiere en ny wallet som har brik bil, der er 2 spillere og de starter med 20 matadollars hver.
	Wallet test3 = new Wallet("UFO", 3); //Laver ny wallet med 3 spillere.
	Wallet test4 = new Wallet("UFO", 4); //Laver ny wallet med 4 spillere.
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testWallet() {
		assertEquals(20, test3.getBalance());
		assertEquals(20, test4.getBalance());
	}
	/**
	 * Tester getBalance
	 * Forventer returværdi på 20, da konstruktør er sat til 2 spillere.
	 */
	@Test
	public void testGetBalance() {
		assertEquals(20, wallet.getBalance()); //Tester om de 20 wallet er blevet instansieret med er de 20 jeg forventer de er
	}

	/**
	 * Tester setBalance
	 * Sætter balance til 30
	 * Forventer at getBalance returner 30
	 */
	@Test
	public void testSetBalance() {
		wallet.setBalance(30);
		assertEquals(30, wallet.getBalance());
		 
		
	}
		
	/**
	 * Tester playerLost 
	 */

	@Test
	public void testPlayerLost() {
		wallet.setBalance(5); //Sætter balancen til 5
		System.out.println(wallet.getBalance());
		assertFalse(wallet.playerLost()); //Forventer false da den ikke er negativ. 
		wallet.setBalance(-5); //-5 trækkes med ned i if statement i klassen og gør at den bliver kørt
		System.out.println(wallet.getBalance());
		assertTrue(wallet.playerLost());//Forventer True da -5 er mindre end 0
	}
	
	/**
	 * Tester changeBalance
	 */
	@Test
	public void testChangeBalance() {
		wallet.changeBalance(5); //Tilføjer 5 til balancen
		assertEquals(25, wallet.getBalance()); //Tester om de 25 jeg har ændret balancen til også er de 25 jeg forventer.
	}

}

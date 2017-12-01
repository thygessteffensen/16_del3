package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cdio3.Wallet;

public class TestWallet {
	Wallet wallet = new Wallet("Bil", 2); // Instansiere en ny wallet som har brik bil, der er 2 spillere og de starter med 20 matadollars hver.
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testWallet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBalance() {
		assertEquals(20, wallet.getBalance()); //Tester om de 20 wallet er blevet instansieret med er de 20 jeg forventer de er
	}

	/**
	 * 
	 */
	@Test
	public void testSetBalance() {
		wallet.setBalance(30);
		assertEquals(30, wallet.getBalance());
		 
		
	}
		

	@Test
	public void testGetPlayerLost() {
		wallet.setBalance(5); //Sætter balancen til 5
		System.out.println(wallet.getBalance());
		assertFalse(wallet.playerLost()); //Forventer false da den ikke er negativ. 
		wallet.setBalance(-5); //-5 trækkes med ned i if statement i klassen og gør at den bliver kørt
		System.out.println(wallet.getBalance());
		assertTrue(wallet.playerLost());//Forventer True da -5 er mindre end 0
	}

	@Test
	public void testChangeBalance() {
		wallet.changeBalance(5); //Tilføjer 5 til balancen
		assertEquals(25, wallet.getBalance()); //Tester om de 25 jeg har ændret balancen til også er de 25 jeg forventer.
	}

}

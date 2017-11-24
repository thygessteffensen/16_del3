package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cdio3.Wallet;

public class TestWallet {
	Wallet wallet = new Wallet("Bil", 2, 20); // Instansiere en ny wallet som har brik bil, der er 2 spillere og de starter med 20 matadollars hver.
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

	@Test
	public void testSetBalance() {
		/*
		wallet.setBalance(30);
		assertEquals(30, wallet.getBalance());
		SetBalance sætter ikke nogen balance, men tjekker derimod om en spiller har under 0 på kontoen
		 */
		wallet.setBalance(); //Lige meget hvad sættes til da den kun trækker det med ned til if statement nedenunder i klassen.
		assertFalse(wallet.getPlayerLost()); //Forventer false da den ikke er negativ. 
		wallet.setBalance(-5000); //-5000 trækkes med ned i if statement i klassen og gør at den bliver kørt
		assertTrue(wallet.getPlayerLost());//Forventer True da -5000 er mindre end 0
	}
		

	@Test
	public void testGetPlayerLost() {
		//fail("Not yet implemented");
		//Bliver testet i testSetBalance
	}

	@Test
	public void testChangeBalance() {
		wallet.changeBalance(5); //Tilføjer 5 til balancen
		assertEquals(25, wallet.getBalance()); //Tester om de 25 jeg har ændret balancen til også er de 25 jeg forventer.
	}

}

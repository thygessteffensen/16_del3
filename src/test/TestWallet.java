package test;

import static org.junit.Assert.*;
/**
 * Tester Wallet klassen
 * @Author Mathias
 * @Version 24.11.2017
 */

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
	/**
	 * Tester getBalance() ved at tjekke om de 20 matadollars i parameteren.
	 * er de samme som de 20 matadollars jeg forventer.
	 */
	@Test
	public void testGetBalance() {
		assertEquals(20, wallet.getBalance());
	}
	/**
	 * Tester setBalance ved at sætte et beløb ind i parameteren og se om getteren får det samme.
	 * Derefter testes om if statement giver true når konto er negativ.
	 */
	@Test
	public void testSetBalance() {
		wallet.setBalance(5);
		assertEquals(5, wallet.getBalance());
		System.out.println(wallet.getBalance());
		wallet.setBalance(-5);
		assertTrue(wallet.playerLost());
		System.out.println(wallet.playerLost());
	}
		

	@Test
	public void testPlayerLost() {
		//fail("Not yet implemented");
		//Bliver testet i testSetBalance
	}
	/**
	 * Tester changeBalance
	 * Først tilføjes 5 matadollars til kontoen og derefter tjekkes om kontoen er 25.
	 */
	@Test
	public void testChangeBalance() {
		wallet.changeBalance(5);
		assertEquals(25, wallet.getBalance());
	}
}

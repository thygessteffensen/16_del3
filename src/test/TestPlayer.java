/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cdio3.Player;
//import cdio3.Wallet;

/**
 * Tester Player klassen
 * @author Simon
 *24/11/2017
 */
public class TestPlayer {
	Player player = new Player("piece", 2);
	private String piece = "piece";
	
	/**
	 * Tester antal spillere i spillet
	 */
	@Test
	public void testPlayer()
	{
		Player p1 = new Player("piece", 2);
		player.equals(p1);
	}

//	/**
//	 * Tester om spillerne har korrekt startbeløb alt efter antallet af spillere
//	 */ 
//	@Test
//	public void testPlayer()
//	{
//		player
//	}
	
	/**
	 * Tester spillerens location
	 */
	@Test
	public void testGetLocation()
	{
		player.setLocation(10);
		assertEquals("Spillerens egentlige location matcher ikke den forventet", 
					10, 
					player.getLocation());
	}	
	/**
	 * Tester locationen af 
	 */
	public void testSetLocation() 
	{
		assertEquals("Spillerens nye location matcher ikke den forventet", 
					10, 
					player.getLocation());
	}
	
	
	/**
	 * Tester om spilleren modtager en brik
	 */
	@Test
	public void testGetPiece()
	{
		player.setPiece(piece);
		assertEquals("Spillerens egetlige brik matcher ikke den forventet", 
					piece, 
					player.getPiece());
	}
	
	/**
	 * Tester om spilleren tildeles en brik
	 */
	@Test
	public void testSetPiece()
	{
		assertEquals("Spillerens nye brik matcher ikke den forventet",
					piece,
					player.getPiece());
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
	}

}

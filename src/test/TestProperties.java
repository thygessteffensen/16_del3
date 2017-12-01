package test;

/**
 * @author mathias
 * @version 01/12/17
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cdio3.Properties;

public class TestProperties {

	Properties prop = new Properties();
	
	@Before
	public void setUp() throws Exception {
		prop.getEffect(7, 2, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test af getPayAmount
	 * Forventer -2, da propvalue er 2
	 */

	@Test
	public void testGetPayAmount() {
		assertEquals(-2, prop.getPayAmount());
	}
	
	/**
	 * Test af getRecieveAmount
	 * Forventer -2, da propvalue er 2
	 */
	
	@Test
	public void testGetRecieveAmount() {
		assertEquals(-2, prop.getRecieveAmount());
		
	}
	/**
	 * test af getMessage
	 * Forventer null da der ikke er nogen message til return.
	 */

	@Test
	public void testGetMessage() {
		System.out.println(prop.getMessage());
	}
	
	/**
	 * Test af getReciever
	 * Forventer 0, da der ikke lejes en grund, men købes og derfor er int uændret, derfor standard 0.
	 */
	@Test
	public void testGetReciever() {
		assertEquals(0, prop.getReciever());
	}

}

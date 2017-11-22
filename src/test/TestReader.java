package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cdio3.Reader;

public class TestReader {
	Reader reader;

	@Before
	public void setUp() throws Exception {
		reader = new Reader();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tester getString() i via stikprøve af alle fem tekstfiler.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test
	public void testGetString() throws IOException, InterruptedException {
		// Array der indeholder forventede tekst strenge
		String[] expected = {
				"SKIBET",
				"Giv dette kort til KATTEN, og tag et chancekort mere.\\n KAT: På din næste tur skal du liste dig hen på hvilket som helst ledigt felt og købe det. \\n Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!",
				"På besøg i fængslet ",
				"Du er landet på et felt, der er par-eget - Betal: ",
				"1.  Den yngeste spiller starter! Spillet fortsætter mod venstre."};
		// Array der indeholder id'et readeren skal bruge.
		String[] expectedID = {
			"skib",
			"CC12",
			"f6b",
			"købt2",
			"s1"};
		// Array der indeholder stien, hvortil tekstfilen ligger.
		String[] path = {
				"brikker",
				"chanceKort",
				"felter",
				"spil",
				"velkommen"};
		//String der indeholde den akutelle læste streng.
		String actual;
		// for loop der kører det antal gange, array'sne er lange.
		for (int i = 0; i < path.length; i++) {
			// Tilegner actual en streng via getString()
			actual = reader.getString(expectedID[i], path[i]);
			// Hvis de to ikke er lig hianden, udskriver den en fejl.
			if(!expected[i].equals(actual))
				fail("Reader henter ikke den korrekte streng. Der er fejl ved array linje " + i);
		}
	}

}

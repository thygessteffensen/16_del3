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

	@Test
	public void testGetString() throws IOException, InterruptedException {
		String[] expected = {
				"SKIBET",
				"Giv dette kort til KATTEN, og tag et chancekort mere.\\n KAT: På din næste tur skal du liste dig hen på hvilket som helst ledigt felt og købe det. \\n Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller!",
				"På besøg i fængslet",
				"u er landet på et felt, der er par-eget - Betal:",
				"1.  Den yngeste spiller starter! Spillet fortsætter mod venstre."};
		String[] expectedID = {
			"skib",
			"CC12",
			"f6b",
			"købt2",
			"s1"};
		String[] path = {
				"brikker",
				"chanceKort",
				"felter",
				"spil",
				"velkommen"};
		String actual;
		
		System.out.println(path.length);
		for (int i = 0; i < path.length; i++) {
			actual = reader.getString(expectedID[i], path[i]);
			System.out.println(actual);
			System.out.println(expected[i]);
			if(!expected[i].equals(actual))
				fail("Reader henter ikke den korrekte streng.");
			TimeUnit.SECONDS.sleep(1);
		}
	}

}

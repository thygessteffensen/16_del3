package cdio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author unknown
 * @version 20.11.2017
 */
public class Reader {	
	/**
	 * getString finder .TXT filen, en ønsket linje deri og omdanner den til en String
	 * @param id
	 * @return Linjen som en String
	 * @throws IOException
	 */
	public String getString (String id, String textFile) throws IOException{
		String file = textFile;
		String line;
		String line1 = null;
		BufferedReader fileReader = new BufferedReader (new FileReader ("textFiles/" + file));
		while((line = fileReader.readLine()) !=null) {
			if (line.equals(id)) line1 = fileReader.readLine();
		}
			
		return line1;
	}
}

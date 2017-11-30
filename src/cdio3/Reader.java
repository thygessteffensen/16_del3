package cdio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author CDIO2
 * @version 20.11.2017
 */
public class Reader {	
	/**
	 * getString finder .TXT filen, en ønsket linje deri og omdanner den til en String
	 * @param id Strengens linje id (tekst)
	 * @return Den ønskede linje
	 * @throws IOException
	 */
	public String getString (String id, String textFile) throws IOException{
		String file = textFile;
		String line;
		String line1 = "Intet læst";
		BufferedReader fileReader = new BufferedReader (new FileReader ("textFiles/" + file));
		while((line = fileReader.readLine()) !=null) {
			if (line.equals(id)) line1 = fileReader.readLine();
		}
		fileReader.close();
		return line1;
	}
}

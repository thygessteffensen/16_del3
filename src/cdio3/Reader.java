package cdio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	static String lang = "lang_DK";
	String[][] database;
	/**
	 * Reader sætter sproget (lang) 
	 * @param lang
	 */
	public Reader(String lang) {
		this.lang = lang;
	}
	
	/**
	 * getString finder .TXT filen, en ønsket linje deri og omdanner den til en String
	 * @param id
	 * @return Linjen som en String
	 * @throws IOException
	 */
	public String getString (String id) throws IOException{
		String file = lang;
		String line;
		String line1 = null;
		BufferedReader fileReader = new BufferedReader (new FileReader (file));
		while((line = fileReader.readLine()) !=null) {
			if (line.equals(id)) line1 = fileReader.readLine();
		}
			
		return line1;
	}
}

package cdio3;
/**
 * 
 * @author Mathias
 * @version 28/11/2017
 */

public class SpecialFields {
	int playerLocation; //Indeholder spillerens aktuelle lokation
	int balanceChange; //Indeholder ændringer i spillerens konto
	boolean passStart = false; //Boolean for om spilleren har passeret start
	
	/**
	 * Konstruktør
	 * @param location
	 */
	public SpecialFields(int balance, int location) {
		this.playerLocation = location;
		this.balanceChange = balance;
	}
}
package cdio3;

public class SpecialFields {
	int playerLocation; //Indeholder spillerens aktuelle lokation
	int balanceChange; //Indeholder ændringer i spillerens konto
	boolean passStart = false; //Boolean for om spilleren har passeret start
	
	public void initSF(int location) {
		this.playerLocation = location;
	}
	
	public boolean jailed() {
		return true;
		}
	public boolean passStart() {
		playerLocation -= 24;
		balanceChange += 2;
		return true;
	}
}
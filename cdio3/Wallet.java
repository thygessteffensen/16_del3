package cdio3;

public class Wallet {
	private int balance = 30000; //Start balance
	
	public getBalance() { // Getter til balance
		
		return balance
	}
	
	public void setBalance(int balance) { // Setter til balance
		if (balance < 0)
			PlayerLost; // Spiller har tabt
	}
	public void changeBalance(int changebalance) { //Changebalance
		changeBalance += changebalance;
	}
}

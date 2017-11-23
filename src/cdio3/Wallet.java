package cdio3;

public class Wallet{
//public class Wallet extends Player{
//	WHAT?
//	super switch (Playercount) {
//	case 2: balance = 20; break;
//	case 3: balance = 18; break;
//	case 4: balance = 16; break;
//	default: System.out.println("Fejl i playercount");
//	}

	private int balance;
	private boolean playerLost = false;

//switch (playerCount) {
//case 2: balance = 20; break;
//case 3: balance = 18; break;
//case 4: balance = 16; break;
//default: System.out.println("Fejl i playercount");

	public int getBalance() { // Getter til balance
		return balance;
	}

	public boolean setBalance(int balance) { // Setter til balance
		if (balance < 0)
			playerLost = true;
		return playerLost; // Spiller har tabt
	}
	public void changeBalance(int changebalance) { //Changebalance
		this.balance += changebalance;
	}
}

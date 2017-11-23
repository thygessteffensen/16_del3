package cdio3;

public class Wallet extends Player{


	private int balance;
	private boolean playerLost = false;

	public Wallet(String piece, int playerCount, int balance) {
		super(piece, playerCount);
		this.balance = balance;
	}

	public int getBalance() { // Getter til balance
		return balance;
	}
	/* Sætter ikke balance, men checker derimod om en spillers konto er under 0
	 * Enten skal metode navnet ændres til CheckPlayerLost ellers så skal den ændres til
	 * at sætte en spillers konto til parameteren.
	 */
	public void setBalance(int balance) {
		if (balance < 0)
			playerLost = true;
		
	}
	
	public boolean getPlayerLost() {
		return playerLost; // Spiller har tabt
	}
	
	public void changeBalance(int changebalance) { //Changebalance
		this.balance += changebalance;
	}
}

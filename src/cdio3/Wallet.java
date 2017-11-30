package cdio3;

/**
 * 
 * @author Mathias
 * @version 28/11/2017
 */

public class Wallet extends Player{
	private int balance;
	private boolean playerLost = false;
	
	/**
	 * Konstruktør
	 * @param piece Den valgte brik
	 * @param playerCount Antallet af spillere
	 */
	public Wallet(String piece, int playerCount) {
		super(piece);
		switch (playerCount) {
		case 2: this.balance = 20;
		break;
		case 3: this.balance = 18;
		break;
		case 4: this.balance = 16;
		break;
		default: this.balance = 0;
		break;
		}
	}
	
	/**
	 * getBalance()
	 * @return balance Spillerens aktuelle balance 
	 */
	public int getBalance() { 
		return balance;
	}
	
	/**
	 * Lægger 'value' til spillerens balance og trækker negative fra.
	 * @param value Værdien balancen skal ændres med, både +-
	 */
	public void setBalance(int value) {
		balance += value;
		
	}
	
	/**
	 * Tjekker om spillerens balance er lig med eller under 0.
	 * @return playerLost Den er sand, hvis spilleren har tabt
	 */
	public boolean playerLost() {
		if (balance <= 0) {
			playerLost = true;
		}
		return playerLost;
	}
	
	/**
	 * Lægger 'changebalance' til spillerens balance og trækker negative fra.
	 * @param value Værdien balancen skal ændres med, både +-
	 */
	public void changeBalance(int changebalance) {
		this.balance += changebalance;
	}
}

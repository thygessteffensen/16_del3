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
	 * @param piece
	 * @param playerCount
	 * @param balance
	 */
	public Wallet(String piece, int playerCount) {
		super(piece, playerCount);
		switch (playerCount) {
		case 2: this.balance = 20;
		break;
		case 3: this.balance = 18;
		break;
		case 4: this.balance = 16;
		break;
		default: System.out.println("Fejl i wallet");
		break;
		}
	}
	/**
	 * Laver en getbalance så programmet ikke har direkte adgang til balance
	 * @return balance
	 */
	public int getBalance() { // Getter til balance
		return balance;
	}
	
	/**
	 * Laver en set balance så programmet kan hardset en balance på en player
	 * @param value given værdi der gør metoden i stand til at hardset balancen
	 */
	public void setBalance(int value) {
		balance += value;
		
	}
	
 	/**
 	 * Tjekker om en spiller har tabt ved at se om balancen er under 0
 	 * @return om spilleren har tabt eller ej
 	 */
	public boolean playerLost() {
		if (balance <= 0) {
			playerLost = true;
		}
		return playerLost;
	}
	
	/**
	 * Gør programmet i stand til at ændre en balance uden at skulle hardset den.
	 * @param changebalance Den balance der bliver ændret med.
	 */
	public void changeBalance(int changebalance) {
		this.balance += changebalance;
	}
}

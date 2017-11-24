package cdio3;

public class Wallet extends Player{
	
	private int balance;
	private boolean playerLost = false;
	
	/**
	 * Konstruktør
	 * @param piece
	 * @param playerCount
	 * @param balance
	 */
	public Wallet(String piece, int playerCount, int balance) {
		super(piece, playerCount);
		this.balance = balance;
	}
	/**
	 * Laver en getbalance så programmet ikke har direkte adgang til balance
	 * @return
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Laver en set balance så programmet kan hardset en balance på en player
	 * @param value given værdi der gør metoden i stand til at hardset balancen
	 */
	public void setBalance(int value) {
		balance = value;
		
	}
	
 	/**
 	 * Tjekker om en spiller har tabt ved at se om balancen er under 0
 	 * @return
 	 */
	public boolean playerLost() {
		if (getBalance() < 0)
			playerLost = true;
		return playerLost;
	}
	
	/**
	 * Gør programmet i stand til at ændre en balance uden at skulle hardset den.
	 * @param
	 */
	public void changeBalance(int changebalance) {
		this.balance += changebalance;
	}
}

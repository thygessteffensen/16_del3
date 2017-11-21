package cdio3;

public class Player 
{
	private Brik brik = new Brik();
	private int brikNum
	private int alder; 
	private Wallet wallet = new Wallet();
	public int currentField = -1; 
	
	public Player() {
	}
	
	/**
	 * brik
	 */
	public Brik getBrik(){
		return brik;
	}
	
//	/**
//	 * Alder (vis nødvendig)
//	 */
//	public Player (int alder) {
//		this.alder = alder;
//	}
//	public int getAlder() {
//		return alder;
//	}
	
	/**
	 * Wallet
	 * @return
	 */
	public Wallet getWallet() {
		return wallet;
	}
	
}

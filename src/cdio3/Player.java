package cdio3;

public class Player 
{
	private Piece piece = new Piece();
	private String piece
	private int alder; 
	private Wallet wallet = new Wallet();
	public int currentField = -1; 
	
	public Player(String piece) {
	}
	
	/**
	 * brik
	 */
	public Piece getPiece(){
		return piece;
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

package cdio3;

/**
 * @author Simon
 */
public class Player 
{
	Wallet wallet;
	private String piece;
	private int balance;
	private int location;

	/**
	 * Konstruktør
	 * @param piece Brikken som player skal have.
	 * @param playerCount Antallet af spillere
	 */
	public Player(String piece) {
		this.piece = piece;		
	}
	
	/**
	 * Jail metode
	 */
	public void jail(int location) {
		wallet.changeBalance(-2);
	}
	
	/**
	 * getPiece
	 * @return piece String med brikkens navn
	 */
	public String getPiece(){
		return piece;
	}

	/**
	 * setLocation sætter spillerens felt.
	 * @param location
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	
	/**
	 * Sætter brikken i Player
	 * @param piece Brikken i string.
	 */
	public void setPiece(String piece){
		this.piece = piece;
	}	
}

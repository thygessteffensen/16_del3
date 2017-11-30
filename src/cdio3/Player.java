package cdio3;

/**
 * 
 * @author Simon og Mathias
 *
 */
public class Player 
{
	Dice dice = new Dice();
	private String piece;
	Wallet wallet;
	int balance;
	int location;

	public Player(String piece, int playerCount) {
		this.piece = piece;
	}
	
	/**
	 * Jail metode
	 */
	public void jail() {
		if(location == 18) 
			wallet.changeBalance(-2);
		else wallet.playerLost();
	}
	
	/**
	 *  getLocation
	 * @return location
	 */
	public int getLocation() {
		return location;
		
	}
	
	
	/**
	 * getPiece
	 * @return piece
	 */
	public String getPiece(){
		return piece;
	}

	/**
	 * setLocation
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	
	
	/**
	 * setPiece
	 */
	public void setPiece(String piece){
		this.piece = piece;
	}	



}
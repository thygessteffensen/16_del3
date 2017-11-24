package cdio3;
/**
 * 
 * @author Simon
 *
 */
public class Player 
{
	private String piece;
	Wallet wallet;
	int balance;
	int location;

	public Player(String piece, int playerCount) {
		switch (playerCount) {
		case 2: balance = 20;
		break;
		case 3: balance = 18;
		break;
		case 4: balance = 16;
		break;
		default: System.out.println("Fejl i wallet");
		break;
		}
		this.piece = piece;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLocation() {
		return location;
		
	}
	
	
	/**
	 * brik
	 */
	public String getPiece(){
		return piece;
	}

	/**
	 * 
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public void setPiece(String piece){
		this.piece = piece;
	}	



}
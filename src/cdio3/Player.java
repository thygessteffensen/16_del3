package cdio3;

/**
 * 
 * @author Simon
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
	 * Jail metode
	 */
	public void jail() {
		if(location == 18) {
			if(wallet.getBalance() <=3) {
				if(<escapeBotton> == true) {
					wallet.changeBalance(-2);
					dice.roll();
				}							
			}
			else dice.setDiceValue1(0);
		}
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
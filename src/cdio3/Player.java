package cdio3;

public class Player 
{
	private String piece;
	Wallet wallet;
	int balance;

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
	 * brik
	 */
	public String getPiece(){
		return piece;
	}

	/**
	 * 
	 * @return
	 */
	public void setPiece(String piece){
		this.piece = piece;
	}	



}
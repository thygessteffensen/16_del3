package cdio3;

public class Player 
{
	private String piece;
	Wallet wallet;

	public Player(String piece, int playerCount) {
		wallet = new Wallet();
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
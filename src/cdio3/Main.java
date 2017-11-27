package cdio3;

import java.io.IOException;

/**
 * 
 * @author thyge
 * @version 23.11.2017
 */
public class Main {
	static UI ui;
	static Player[] player; // Player array der indeholder referrencer til player objekter.
	static Wallet wallet;
	static Reader reader = new Reader();
	static Dice dice;
	static AssignFieldEffect afe;
	
	
	public static void main(String[] args) throws IOException {
		ui = new UI();
		ui.setUp();
		String[] optPiece = {reader.getString("skib", "brikker"), reader.getString("bil", "brikker")
				,reader.getString("kat", "brikker"),reader.getString("hund", "brikker")};
		
		String[] optPlayer = {"2", "3", "4"};
		int playerCount;
		playerCount = Integer.parseInt(ui.dropDown(reader.getString("spillerAntal", "velkommen"), optPlayer));
		ui.getUserResponse(reader.getString("startPenge"+(playerCount-1), "velkommen"), "OK!");
		player = new Player[playerCount];
		
//--------------------------------------------------------------------------------------------------------------------
//                                              Spillere tilføjes
//--------------------------------------------------------------------------------------------------------------------
	
		/**
		 * Tilføjer spiller med brik og så'n
		 */
		String taken = "none";
		for (int i = 0; i < player.length ; i++) {
			optPiece = availiblePieces(taken, optPiece);
			taken = ui.dropDown(reader.getString("vælgBrik","velkommen"), optPiece);
			player[i] = new Player(taken, playerCount);
			player[i].wallet = new Wallet(taken, playerCount, 20);
			ui.addPlayer(playerCount, i, player[i].getPiece(), player[i].wallet.getBalance());
		}
		
//--------------------------------------------------------------------------------------------------------------------
//                                              Spillet påbegyndes:
//--------------------------------------------------------------------------------------------------------------------

//		for (int i = 0; i < optPlayer.length; i++) {
//			while(player[i].wallet.getPlayerLost()) {
//				// Tilføj gameplay her:
//			}
//		}
		
		
		while(!player[1].wallet.getPlayerLost()) {
			ui.getUserResponse("Du må slå", "ok");
			// Fix static
			dice.roll();
			ui.setDice(dice.getDiceValue1());
			ui.setLocation();
		}
		
		
		
		
		
		
		
		
		
		

	}
	public static String[] availiblePieces(String taken, String[] opt) {
		String[] ap = new String[opt.length];
		String temp = "";
		for (int i = 0; i < opt.length; i++)
			if(!taken.equals(opt[i]))
				temp += opt[i] + " ";
		ap = temp.split(" ");
		return ap;
	}
}


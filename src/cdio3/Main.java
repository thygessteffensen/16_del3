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
	static AssignFieldEffect afe = new AssignFieldEffect();
	static int[] location;


	public static void main(String[] args) throws IOException {
		ui = new UI();
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
		location = new int[playerCount];
		for (int i = 0; i < playerCount ; i++) {
			optPiece = availiblePieces(taken, optPiece);
			taken = ui.dropDown(reader.getString("vælgBrik","velkommen"), optPiece);
			player[i] = new Player(taken, playerCount);
			player[i].wallet = new Wallet(taken, playerCount);
			ui.addPlayer(playerCount, i, player[i].getPiece(), player[i].wallet.getBalance());
			ui.setUp(i);
			location[i] = 0;
		}

		//--------------------------------------------------------------------------------------------------------------------
		//                                              Spillet påbegyndes:
		//--------------------------------------------------------------------------------------------------------------------

		//		for (int i = 0; i < optPlayer.length; i++) {
		//			while(player[i].wallet.getPlayerLost()) {
		//				// Tilføj gameplay her:
		//			}
		//		}

		


		int diceValue;
		int oldLoc;
		int j = 0;
//		while(!player[j].wallet.getPlayerLost()) {
		while(true) {
			for (j = 0; j < playerCount; j++) {
				ui.getUserResponse("Du må slå", "ok");
				// Fix static
				dice.roll();
				diceValue = dice.getDiceValue1();
				ui.setDice(diceValue);
				oldLoc = location[j];
				location[j] += diceValue;
				if(location[j] >=24 )
					location[j] = location[j] - 24;
				ui.setLocation(j, oldLoc, location[j]);
				//-----------------------------------------------
				afe.initFieldEffect(location[j], j);
				player[j].wallet.changeBalance(afe.getBalance());
				System.out.println(afe.getBalance());
				ui.changeBalance(j, player[j].wallet.getBalance());
				
			}
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


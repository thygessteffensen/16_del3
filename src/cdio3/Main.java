package cdio3;

import java.io.IOException;

/**
 * 
 * @author thyge og Mathias
 * @version 23.11.2017
 */
public class Main {
	static UI ui;
	static Player[] player; // Player array der indeholder referrencer til player objekter.
	static Wallet wallet;
	static Reader reader = new Reader();
	static Dice dice;
	static AssignFieldEffect afe;
	static int[] location;


	public static void main(String[] args) throws IOException {
		afe = new AssignFieldEffect();
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
		int diceValue;
		int oldLoc;
		int j = 0;
		String payer;
		String reciever;
		while(!player[j].wallet.playerLost()) {
			while(true) {
				for (j = 0; j < playerCount; j++) {
					ui.getUserResponse(player[j].getPiece() +  " må slå", "Slå");
					// Fix static
					dice.roll();
					diceValue = dice.getDiceValue1();
					ui.setDice(diceValue);
					oldLoc = location[j];
					afe.initFieldEffect(location[j], j);
					location[j] += diceValue + afe.getNewLocation();
					if(location[j] >=24 ) {
						location[j] = location[j] - 24;
						player[j].wallet.changeBalance(+2);
					}
					ui.setLocation(j, oldLoc, location[j]);
					player[j].wallet.changeBalance(afe.getBalance());
					ui.changeBalance(j, player[j].wallet.getBalance());
					payer = player[j].getPiece();
					reciever = player[afe.getReciever()].getPiece();
					if((location[j] % 6) == 0) {
						switch(location[j]) {
						case 0:
							ui.showText("Start");
							break;
						case 6:
							ui.showText(reader.getString("f6b", "felter"));
							break;
						case 12:
							ui.showText(reader.getString("f12", "felter"));
							break;
						case 18:
							ui.showText(reader.getString("f18", "felter"));
							break;
						default:
							ui.showText("Felt nummer -1");
							break;
						}
					}
					else if((location[j] % 6) == 3) {
						ui.showText(afe.getChangeMessage());
					}
					else if(!payer.equals(reciever))
						ui.showText(payer + " skal betale M" + afe.getBalance() +" til " + reciever);
					else if(!payer.equals(reciever))
						ui.showText(payer + " skal betale M" + afe.getBalance() +" til " + reciever);
					else
						ui.showText(payer + " købte " + ui.getFieldName(location[j]) + " for M" + (Math.abs(afe.getBalance()))); 

					if (player[j].wallet.playerLost() == true)
						endProgram(player[j].getPiece());
				}
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

	private static void endProgram(String piece){
		ui.getUserResponse("Spiller " + piece + " har desværre tabt", "Luk spilx");
		System.exit(0);
	
	}
}
package cdio3;

import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 
 
 * 
 * @author thyge
 * @version 3011.2017
 */

public class Game {
	 Ui ui;
	 Player[] player; // Player array der indeholder referrencer til player objekter.
	 Wallet wallet;
	 Reader reader;
	 Dice dice;
	 GameBoard gameBoard;
	 
	 
	 
	 
	 AssignFieldEffect afe;
	 int[] location;
	 int playerCount;
	 String[] optPiece;

	
	public void playGame() throws IOException {
		afe = new AssignFieldEffect();
		ui = new Ui();
		reader = new Reader();

		startGame();

		addPlayers();

		gamePlay();
	}

	/**
	 * Generer spille pladen og "vælger" antal spillere.
	 * @throws IOException
	 * 
	 */
	private void startGame() throws IOException {
		optPiece = new String[]{reader.getString("skib", "brikker"), reader.getString("bil", "brikker")
				,reader.getString("kat", "brikker"),reader.getString("hund", "brikker")};

		String[] optPlayer = {"4", "3", "2"};
		playerCount = Integer.parseInt(ui.dropDown(reader.getString("spillerAntal", "velkommen"), optPlayer));
		ui.getUserResponse(reader.getString("startPenge"+(playerCount-1), "velkommen"), "OK!");
		player = new Player[playerCount];
	}

	/**
	 * Spillerne kan vølge brik og den bliver tilføjet til pladen.
	 * @throws IOException
	 */
	private void addPlayers() throws IOException {
		String taken = "none";
		location = new int[playerCount];
		for (int i = 0; i < playerCount ; i++) {
			optPiece = availiblePieces(taken, optPiece);
			taken = ui.dropDown(reader.getString("vælgBrik","velkommen"), optPiece);
			player[i] = new Player(taken);
			player[i].wallet = new Wallet(taken, playerCount);
			ui.addPlayer(playerCount, i, player[i].getPiece(), player[i].wallet.getBalance());
			ui.setUp(i);
			location[i] = 0;
		}
	}

	/**
	 * Generer en ny liste af nu tilgængeligebrikker.
	 * @param taken Den netop valgte brik
	 * @param opt Den gamle liste af brikker
	 * @return Ny liste af brikker.
	 */
	private String[] availiblePieces(String taken, String[] opt) {
		String[] ap = new String[opt.length];
		String temp = "";
		for (int i = 0; i < opt.length; i++)
			if(!taken.equals(opt[i]))
				temp += opt[i] + " ";
		ap = temp.split(" ");
		return ap;
	}

	/**
	 * GamePlay
	 * @throws IOException
	 */
	private void gamePlay() throws IOException {
		int diceValue;
		int oldLoc;
		int j = 0;
		String payer;
		String reciever;
		while(!player[j].wallet.playerLost()) {
			while(true) {
				for (j = 0; j < playerCount; j++) {
					ui.getUserResponse(player[j].getPiece() +  " må slå", "Slå");
					// Fix 
					dice.roll();
					diceValue = dice.getDiceValue1();
					ui.setDice(diceValue);
					oldLoc = location[j];

					
					location[j] += diceValue;
					if(location[j] >=24 ) {
						location[j] = location[j] - 24;
						player[j].wallet.changeBalance(2);
					}
					afe.initFieldEffect(location[j], j);
					
					
					if(location[j] == 18) {
						player[j].jail(location[j]);
					}
					ui.setLocation(j, oldLoc, location[j]);


					player[j].wallet.changeBalance(afe.getBalanceChange());

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
						try {
							ui.showText(afe.toString());
						} catch (Exception e) {
							ui.showText("Intet gyldig tekst");
						}

					}
					else if(!payer.equals(reciever)) {
						ui.showText(payer + " skal betale M" + afe.getBalanceChange() +" til " + reciever);
						// Modtageren
						player[afe.getReciever()].wallet.changeBalance(afe.getPayAmount());
						// Aftageren
						player[j].wallet.changeBalance(-1*afe.getPayAmount());
					}
					else {
						ui.showText(payer + " købte " + ui.getFieldName(location[j]) + " for M" + (Math.abs(afe.getBalanceChange()))); 
						ui.setOwener(location[j], j);
					}
						
					if (player[j].wallet.playerLost() == true)
						endProgram(player[j].getPiece());
				}
			}
		}
	}

	/**
	 * Viser vinderne og slutter spillet.
	 * @param piece Brikken på den aktuelle spiller
	 * @throws IOException
	 */
	private void endProgram(String piece) throws IOException{
		
		String winner = player[0].getPiece();
		for (int i = 1; i < location.length; i++) {
			if(player[i-1].wallet.getBalance() < player[i].wallet.getBalance())
				winner = player[i].getPiece();
		}
		ui.getUserResponse(reader.getString("tillykke", "spil") + " " + winner + reader.getString("vandt", "spil"), "Luk spillet");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Fejl i sleep når program lukker");
			e.printStackTrace();
		}
		System.exit(0);
	}
}
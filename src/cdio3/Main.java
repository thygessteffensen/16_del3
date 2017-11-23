package cdio3;

import java.io.IOException;

public class Main {
	static UI ui;
	static Player[] player; // Player array der indeholder referrencer til player objekter.
	static Reader reader = new Reader();
	
	
	
	public static void main(String[] args) throws IOException {
		ui = new UI();
		ui.setUp();
		String[] optPiece = {reader.getString("skib", "brikker"), reader.getString("bil", "brikker")
				,reader.getString("kat", "brikker"),reader.getString("hund", "brikker")};
		
		String[] optPlayer = {"2", "3", "4"};
		int playerCount;
		//		playerCount = Integer.parseInt(ui.dropDown(reader.getString("spillerAntal", "velkommen"), {"2", "3", "4"));
		playerCount = Integer.parseInt(ui.dropDown("test", optPlayer));
		//		ui.getUserResponse(reader.getString("startPenge"+(playerCount-1), "velkommen"), "OK!");
		ui.getUserResponse("startPenge"+(2-1), "OK!");
		player = new Player[playerCount];
		
		String taken = null;
		for (int i = 0; i < player.length ; i++) {
			optPiece = availiblePieces(taken, optPiece);
			player[i].setPiece(ui.dropDown(reader.getString("vælgBrik","velkommen"), optPiece));
		}


	}
	public static String[] availiblePieces(String taken, String[] opt) {
		String[] ap = new String[opt.length];
		String temp = "";
		for (int i = 0; i < opt.length; i++) {
			if(!taken.equals(opt[i])) {
				temp += opt[i] + " ";
			}
			
			
			
		}

		return opt;
	}
}


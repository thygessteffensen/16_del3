package cdio3;

public class Main {
	static UI ui;
	static Player[] player; // Player array der indeholder referrencer til player objekter.
	String [] optPiece = {reader.getString("skib", "brikker"), reader.getString("bil", "brikker")
			,reader.getString("kat", "brikker"),reader.getString("hund", "brikker")};
	}
	
	
	public static void main(String[] args) {
		ui = new UI();
		ui.setUp();

		String[] optPlayer = {"2", "3", "4"};
		int playerCount;
		//		playerCount = Integer.parseInt(ui.dropDown(reader.getString("spillerAntal", "velkommen"), {"2", "3", "4"));
		playerCount = Integer.parseInt(ui.dropDown("test", optPlayer));
		//		ui.getUserResponse(reader.getString("startPenge"+(playerCount-1), "velkommen"), "OK!");
		ui.getUserResponse("startPenge"+(2-1), "OK!");
		player = new Player[playerCount];
		
		
		for (int i = 0; i < player.length ; i++) {
			availiblePieces() = optPiece;
			player[i].setPiece(ui.dropDown(reader.getString("vælgBrik","velkommen"), optPiece));
		}


	}
	public String[] availiblePieces(String taken, String[] opt) {
		String[] ap = new String[opt.length];
		for (int i = 0; i < opt.length; i++) {
			if(!taken.equals(opt[i])) {
				
			}
			
			
		}

		return opt;
	}
}


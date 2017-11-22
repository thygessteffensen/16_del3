package cdio3;

public class Main {
	static UI ui;
	Player[] player; // Player array der indeholder referrencer til player objekter.
	public static void main(String[] args) {
		ui = new UI();
		ui.setUp();
		
		String[] optPlayer = {"2", "3", "4"};
		int playerCount;
//		playerCount = Integer.parseInt(ui.dropDown(reader.getString("spillerAntal", "velkommen"), {"2", "3", "4"));
		playerCount = Integer.parseInt(ui.dropDown("test", optPlayer));
//		ui.getUserResponse(reader.getString("startPenge"+(playerCount-1), "velkommen"), "OK!");
		ui.getUserResponse("startPenge"+(2-1), "OK!");
		
		//ui.addPlayer(2, name, balance);
	}
}


package cdio3;

import gui_main.GUI;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

// Link til Jdoc
// http://htmlpreview.github.io/?https://raw.githubusercontent.com/diplomit-dtu/Matador_GUI/repository/Desktop_GUI/doc/index.html
public class UI {
	GUI gui;
	GUI_Field[] fields;
	GUI_Player[] player;


	/**
	 * Opsætter spillepladen ved init.
	 */
	public void setUp() {
		gui = new GUI();
		fields = gui.getFields();
	}
	
	/**
	 * Tilføjer antal spillere til pladen.
	 * @param playerCount Antal spillere
	 * @param name String[] med navne
	 * @param balance itn[] med balance
	 */
	public void addPlayer(int playerCount, String[] name, int[] balance) {
		player = new GUI_Player[playerCount];
		for (int i = 0; i < playerCount; i++) {
			player[i] = new GUI_Player(name[i], balance[i]);
			gui.addPlayer(player[i]);
		}
	}
	
	/**
	 * Sætter terninger med de respektive antal højen på spille pladen.
	 * @param d1 Antal øjne på terning 1
	 * @param d2 Antal øjne på terning 2
	 */
	public void setDice(int d1, int d2) {
		gui.setDice(d1, d2);
	}
	
	


}

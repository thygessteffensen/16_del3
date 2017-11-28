package cdio3;

import gui_main.GUI;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;

// Link til Jdoc
// http://htmlpreview.github.io/?https://raw.githubusercontent.com/diplomit-dtu/Matador_GUI/repository/Desktop_GUI/doc/index.html

/**
 * UserInterface
 * @author thyge
 * @version 23.11.2017
 */
public class UI {
	GUI gui;
	GUI_Field field;
	GUI_Field[] fields;
	GUI_Player[] player;


	public UI() {
		fields = getFields();
		gui = new GUI(fields);
	}

	public GUI_Field[] getFields() {
		GUI_Field[] temp = new GUI_Field[24];

		temp[0] = new GUI_Street();

		for (int i = 1; i < temp.length; i++) {
			temp[i] = new GUI_Street();
			temp[i].setTitle("Brik " + i);
		}
		return temp;
	}

	/**
	 * Opsætter spillepladen ved init.
	 */
	public void setUp(int playerNumber) {
		fields[0].setCar(player[playerNumber], true);	
	}

	/**
	 * Tilføjer spillere til GUI_Player, såvel som på pladen
	 * @param playerCount Antal spillere
	 * @param i tælleren
	 * @param name Spilleres brik navn
	 * @param balance Spillerens balance
	 */
	public void addPlayer(int playerCount, int i, String name, int balance) {
		player = new GUI_Player[playerCount];
		player[i] = new GUI_Player(name, balance);
		gui.addPlayer(player[i]);
	}

	/**
	 * Sætter terninger med de respektive antal højen på spille pladen.
	 * @param d1 Antal øjne på terning 1
	 * @param d2 Antal øjne på terning 2
	 */
	public void setDice(int d1) {
		gui.setDice(d1, 1);
	}

	/**
	 * Danner en dropdownmenu, hvor i man kan vælge mellem strengene
	 * i Streng arrayet. Der retuneres en streg
	 * @param Message Besked til spilleren
	 * @param opt Stiring[] med valgmuligheder.
	 * @return
	 */
	public String dropDown(String Message, String[] opt) {
		return gui.getUserSelection(Message, opt);
	}

	/**
	 * Modtag bruger respons
	 * @param msg Besked til spilleren
	 * @param button Tekst til knappen.
	 */
	public void getUserResponse(String msg, String button) {
		gui.getUserButtonPressed(msg, button);
	}

	/**
	 * Retunerer en string som bruger giver os, ud fra beskden msg
	 * @param msg Besked der skal vises til spilleren.
	 * @return
	 */
	public String getUserString(String msg) {
		return gui.getUserString(msg);
	}

	public void setLocation(int playerNumber, int oldLocation, int newLocation) {
		System.out.println(player[playerNumber].toString());
		fields[oldLocation].setCar(player[playerNumber], false);
		fields[newLocation].setCar(player[playerNumber], true);
	}
}
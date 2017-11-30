package cdio3;

import gui_main.GUI;
import gui_fields.GUI_Board;
import gui_fields.GUI_Car;
import gui_fields.GUI_Car.Type;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;

import java.awt.Color;
import java.awt.color.*;
import java.io.IOException;

import gui_codebehind.GUI_Center;

// Link til Jdoc
// http://htmlpreview.github.io/?https://raw.githubusercontent.com/diplomit-dtu/Matador_GUI/repository/Desktop_GUI/doc/index.html

/**
 * UserInterface
 * @author thyge
 * @version 23.11.2017
 */
public class Ui {
	GUI gui;
	GUI_Field field;
	GUI_Field[] temp;
	GUI_Player[] player;
	Reader reader = new Reader();
	GameBoard gameBoard = new GameBoard();



	public Ui() throws IOException {
		temp = gameBoard.getFields();
		gui = new GUI(temp);
	}

	/**
	 * Opsætter spillepladen ved init.
	 */
	public void setUp(int playerNumber) {
		temp[0].setCar(player[playerNumber], true);	
	}

	/**
	 * Tilføjer spillere til GUI_Player, såvel som på pladen
	 * @param playerCount Antal spillere
	 * @param i tælleren
	 * @param name Spilleres brik navn
	 * @param balance Spillerens balance
	 */
	public void addPlayer(int playerCount, int i, String name, int balance) {
		if(player == null)
			player = new GUI_Player[playerCount];
		player[i] = new GUI_Player(name, balance, guiCar(name));
		gui.addPlayer(player[i]);
	}

	/**
	 * Denne metode vælger en bil til spilleren.
	 * @param type Navnet på brikken
	 * @return GUI_Car
	 */
	private GUI_Car guiCar(String type) {
		GUI_Car car = null;
		if(type.equals("UFO")) {
			car = new GUI_Car(Color.GREEN , Color.YELLOW, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL);
		}
		else if(type.equals("BIL")) {
			car = new GUI_Car(Color.PINK , Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
		}
		else if(type.equals("RACERBIL")) {
			car = new GUI_Car(Color.RED , Color.BLUE, GUI_Car.Type.RACECAR, GUI_Car.Pattern.FILL);
		}
		else if(type.equals("TRAKTOR")) {
			car = new GUI_Car(Color.ORANGE , Color.WHITE, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL);
		}
		return car;
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

	public void setLocation(int playerNumber, int oldLocation, int newLocation) {
		temp[oldLocation].setCar(player[playerNumber], false);
		temp[newLocation].setCar(player[playerNumber], true);
	}
	public void changeBalance(int i, int value) {
		player[i].setBalance(value);
	}

	public void showText(String str) {
		gui.showMessage(str);
	}

	public void showChanceText(String str) {
		gui.displayChanceCard(str);
	}
	
	public String getFieldName(int location) {
		return temp[location].getTitle();
	}
}
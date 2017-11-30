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
public class UI {
	GUI gui;
	GUI_Field field;
	GUI_Field[] temp;
	GUI_Player[] player;
	Reader reader = new Reader();



	public UI() throws IOException {
		temp = getFields();
		gui = new GUI(temp);
	}

	public GUI_Field[] getFields() throws IOException {
		GUI_Field[] temp = new GUI_Field[24];
		temp[0] = new GUI_Start("Start", "", "Hver gang du passere start, modtager du M2.", Color.GREEN, Color.BLACK);
        temp[1] = new GUI_Street("Burgerbaren","1M", "Dette felt er ejet af:\n",  "1", Color.YELLOW.brighter(), Color.BLACK);
        temp[2] = new GUI_Street("Pizzariaet", "1M", "", "1", Color.YELLOW.brighter(), Color.BLACK);
        temp[3] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        temp[4] = new GUI_Street("Slikbutikken", "1M", "", "1", Color.ORANGE, Color.BLACK);
        temp[5] = new GUI_Street("Iskiosken", "1M", "", "1", Color.ORANGE, Color.BLACK);
        temp[6] = new GUI_Jail(); temp[6].setSubText("");
        temp[7] = new GUI_Street("Museet", "2M", "", "2", Color.MAGENTA, Color.BLACK);
        temp[8] = new GUI_Street("Biblioteket", "2M", "", "2", Color.MAGENTA, Color.BLACK);
        temp[9] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        temp[10] = new GUI_Street("Skaterparken", "2M", "", "2", Color.PINK, Color.BLACK);
        temp[11] = new GUI_Street("SvÃ¸mmingpoolen", "2M", "", "2", Color.PINK, Color.BLACK);
        temp[12] = new GUI_Refuge(); temp[12].setTitle("Gratis parkering"); temp[12].setSubText("");
        temp[13] = new GUI_Street("Spillehallen", "3M", "", "3", Color.RED, Color.BLACK);
        temp[14] = new GUI_Street("Biografen", "3M", "", "3", Color.RED, Color.BLACK);
        temp[15] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        temp[16] = new GUI_Street("Legetøjsbutikken", "3M", "", "3", Color.CYAN, Color.BLACK);
        temp[17] = new GUI_Street("Dyrehandlen", "3M", "", "3", Color.CYAN, Color.BLACK);
        temp[18] = new GUI_Shipping(); temp[18].setTitle("Gå i fængsel"); temp[18].setSubText("");
        temp[19] = new GUI_Street("Bowlinghallen", "4M", "", "4", Color.GREEN.darker(), Color.BLACK);
        temp[20] = new GUI_Street("Zoo", "4M", "", "4", Color.GREEN.darker(), Color.BLACK);
        temp[21] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        temp[22] = new GUI_Street("Vandlandet", "5M", "", "5", Color.BLUE, Color.WHITE);
        temp[23] = new GUI_Street("Strandpromenaden", "5M", "", "5", Color.BLUE, Color.WHITE);
//        temp[23] = new GUI_Street(title, subText, description, rent, bgColor, fgColor)
//        udfyldes som set i eksemplet ovenover!
		return temp;
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

	/**
	 * Retunerer en string som bruger giver os, ud fra beskden msg
	 * @param msg Besked der skal vises til spilleren.
	 * @return
	 */
	public String getUserString(String msg) {
		return gui.getUserString(msg);
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
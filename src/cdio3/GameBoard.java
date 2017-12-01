package cdio3;

import java.awt.Color;
import java.io.IOException;

import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;

/**
 * 
 * @author thyge
 * @version 30.11.2017
 */
public class GameBoard {
	GUI_Field[] fields = new GUI_Field[24];
	
	/**
	 * Indeholder alle felterne til brættet
	 * @return Retunerer GUI_Field[]
	 * @throws IOException
	 */
	public GUI_Field[] getFields() throws IOException {
		fields[0] = new GUI_Start("Start", "", "Hver gang du passere start, modtager du M2.", Color.GREEN, Color.BLACK);
        fields[1] = new GUI_Street("Burgerbaren","1M", "Dette felt er ejet af:\n",  "1", Color.YELLOW.brighter(), Color.BLACK);
        fields[2] = new GUI_Street("Pizzariaet", "1M", "", "1", Color.YELLOW.brighter(), Color.BLACK);
        fields[3] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        fields[4] = new GUI_Street("Slikbutikken", "1M", "", "1", Color.ORANGE, Color.BLACK);
        fields[5] = new GUI_Street("Iskiosken", "1M", "", "1", Color.ORANGE, Color.BLACK);
        fields[6] = new GUI_Jail(); fields[6].setSubText("");
        fields[7] = new GUI_Street("Museet", "2M", "", "2", Color.MAGENTA, Color.BLACK);
        fields[8] = new GUI_Street("Biblioteket", "2M", "", "2", Color.MAGENTA, Color.BLACK);
        fields[9] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        fields[10] = new GUI_Street("Skaterparken", "2M", "", "2", Color.PINK, Color.BLACK);
        fields[11] = new GUI_Street("SvÃ¸mmingpoolen", "2M", "", "2", Color.PINK, Color.BLACK);
        fields[12] = new GUI_Refuge(); fields[12].setTitle("Gratis parkering"); fields[12].setSubText("");
        fields[13] = new GUI_Street("Spillehallen", "3M", "", "3", Color.RED, Color.BLACK);
        fields[14] = new GUI_Street("Biografen", "3M", "", "3", Color.RED, Color.BLACK);
        fields[15] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        fields[16] = new GUI_Street("Legetøjsbutikken", "3M", "", "3", Color.CYAN, Color.BLACK);
        fields[17] = new GUI_Street("Dyrehandlen", "3M", "", "3", Color.CYAN, Color.BLACK);
        fields[18] = new GUI_Shipping(); fields[18].setTitle("Gå i fængsel"); fields[18].setSubText("");
        fields[19] = new GUI_Street("Bowlinghallen", "4M", "", "4", Color.GREEN.darker(), Color.BLACK);
        fields[20] = new GUI_Street("Zoo", "4M", "", "4", Color.GREEN.darker(), Color.BLACK);
        fields[21] = new GUI_Chance("?", "", "Træk en chance kort!", Color.WHITE, Color.BLACK);
        fields[22] = new GUI_Street("Vandlandet", "5M", "", "5", Color.BLUE, Color.WHITE);
        fields[23] = new GUI_Street("Strandpromenaden", "5M", "", "5", Color.BLUE, Color.WHITE);
		return fields;
	}
	
	public void setBorderColor(int fieldNumber, Color color) {
		fields[fieldNumber].setForeGroundColor(color);		
	}
	
	public String toString() {
		String temp = "";
		for (int i = 0; i < fields.length; i++) {
			temp += fields[i].toString();
			temp += " \n";
		}
		return temp;
	}
}

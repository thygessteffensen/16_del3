package cdio3;

import java.util.Random;

public class ChanceKort extends FieldEffect{
	Random ran = new Random();
	int numberOfCards = 18;
	private boolean[] taken = new boolean[numberOfCards];
	private boolean[] extraCard = new boolean[numberOfCards];
	private String[] cards = new String[numberOfCards];
	private String[] moveToColor = new String[numberOfCards];
	private int[] numberOfFields = new int[numberOfCards];
	private int[] getPayMoney = new int[numberOfCards];
	
	
	public ChanceKort() {
		// Sætter alle korte til false
		for(int i = 0; i<numberOfCards; i++) {
			taken[i] = false;
			//cards[i] = reader.getString("cc1", "chanceCardsText"); // Metoden endnu ikke implemtereret
			cards[i] = "test " + i;
		}
		
		
		
	}
	// 18 chancekort
	
	public void loadChanceKort() {
		
	}
	
	
	public void getChanceKort() {
		int card = ran.nextInt(numberOfCards)-1;
		if(taken[card] == true) {
			do {
				if(card <= numberOfCards)
					card = -1;
				card += 1;
			}
			while(taken[card] == true);
		}
		taken[card] = true;
	}
	
	
	
}

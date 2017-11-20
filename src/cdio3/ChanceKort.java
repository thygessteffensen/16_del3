package cdio3;

import java.util.Random;

public class ChanceKort extends FieldEffect{
	Random ran = new Random();
	int numberOfCards = 18;
	int location;
	private boolean[] taken = new boolean[numberOfCards]; // Hvis kortet er blevet taget, bliver den true.
	private boolean[] extraCard = new boolean[numberOfCards]; //Er true ved de steder, hvor chancekortet må trækkes en gang til
	private String[] cards = new String[numberOfCards]; // 
	private int[] moveTo = new int[numberOfCards]; // flytter brikken hen til: start, næste farve, fem felter frem.
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
	
	public void getChanceKort(int location) {
		int card = getCard();
		this.location = location;
	}
	
	/**
	 * Vælger et kort, hvis dette kort allerede er
	 * blivet taget, finder det et nyt kort osv.
	 * @return
	 */
	private int getCard() {
		int card = ran.nextInt(numberOfCards)-1;
		if(taken[card] == true) {
			do {
				if(card >= numberOfCards-1) 
					card = -1;	
				card += 1;
			}
			while(taken[card] == true);
		}
		taken[card] = true;
		
		return card;
	}
	
	
	
	/**
	 * Indholder om man må trække engang til.
	 */
	private void setExtraCard(){
		for(int i = 0; i<numberOfCards; i++) {
			extraCard[i] = false;
		}
		extraCard[0] = true;
		extraCard[5] = true;
		extraCard[11] = true;
		extraCard[12] = true;		
	}
	
	public boolean getExtraCard() {
		return extraCard[location];
	}
	
	/**
	 * Indeholder værdier der skal ændre balancen.
	 */
	private void setGetPayMoney() {
		for(int i = 0; i<numberOfCards; i++) {
			getPayMoney[i] = 0;
		}
		getPayMoney[1] = 2;
		getPayMoney[6] = -2;
		getPayMoney[15] = 2;
	}
	
	/**
	 * Giver en værdi 
	 * @param location
	 */
	private void setMoveTo(int location) {
		for(int i = 0; i<numberOfCards; i++) {
			moveTo[i] = 0;
		}
		// 24 felter
		moveTo[1] = 25 - location; // Ryk hen til start
		moveTo[2] = location + 5; // Rykker fem felter frem
		moveTo[5] = location + 1; // Ryk et felt frem
		// Farve kort:
			// Farve felterne afventer vi
		moveTo[10] = 24 - location; // Flytter brikken til strandpromonaden
		moveTo[17] = 11 - location; // Flytter brikken til skateparken
	}	
}

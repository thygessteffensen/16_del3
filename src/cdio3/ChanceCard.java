package cdio3;

import java.util.Random;

public class ChanceCard extends FieldEffect{
	Random ran = new Random();
	int numberOfCards = 18;
	int location;
	int card;
	private boolean[] taken = new boolean[numberOfCards]; // Hvis kortet er blevet taget, bliver den true.
	private boolean[] extraCard = new boolean[numberOfCards]; //Er true ved de steder, hvor chancekortet må trækkes en gang til
	private String[] cardMessage = new String[numberOfCards]; // 
	private int[] moveTo = new int[numberOfCards]; // flytter brikken hen til: start, næste farve, fem felter frem.
	private int[] balanceChange = new int[numberOfCards]; // balance ændring
	
	
	
//----------------------------------------------------------------------------------
	//                         Den tager udgangspunkt i 
	//                       at start er felt nummer 1 og
	//                    det sidste felt, er felt nummer 24
//----------------------------------------------------------------------------------
	
	/**
	 * Konstruktør. 
	 */
	public ChanceCard() {
		setCardMessage(); // Tilføjer den aktuelle tekst til kortet
		allCardFalse(); // Sætter alle kort til false.
		setExtraCard(); // Sætter felter til true, til der hvor man må trække et ekstra kort.
		setBalanceChange(); // Sætter balancen
		setMoveTo(); // sætter moveto værdierne
	}

	/**
	 * Giver spilleren et kort.
	 * @param location
	 */
	public void initChanceCard(int location) {
		card = getCard();
		this.location = location;
	}	

	/**
	 * Vælger et kort, hvis dette kort allerede er
	 * blivet taget, finder det et nyt kort osv.
	 * @return
	 */
	private int getCard() {
		int card = ran.nextInt(numberOfCards)-1;
		do {
			if(card >= numberOfCards-1) 
				card = -1;	
			card += 1;
		}
		while(taken[card] == true);

		taken[card] = true;

		return card;
	}
//----------------------------------------------------------------------------------
	//                              getters
//----------------------------------------------------------------------------------

	/**
	 * Retunerer true, hvis man må trække et kort til
	 * @return boolean
	 */
	public boolean getExtraCard() {
		return extraCard[card];
	}
	
	/**
	 * Retunerer int location spiller skal stå på.
	 * @return int
	 */
	public int getMoveTo() {
		// 24 felter
		moveTo[1] = 25 - location; // Ryk hen til start
		moveTo[2] = 5; // Rykker fem felter frem
		moveTo[5] = 1; // Ryk et felt frem
		// Farve kort:
		// Farve felterne afventer vi
		moveTo[10] = 24 - location; // Flytter brikken til strandpromonaden
		moveTo[17] = 25 - location + 10; // Flytter brikken til skateparken
		
		return moveTo[card];
	}
	
	/**
	 * Retunerer ændringen i balancen, både postive og negative værdier.
	 * @return balanceChange
	 */
	public int getBalanceChange() {
		return balanceChange[card];
	}
	
	/**
	 * Retunerer den streng spiller skal se.
	 * @return String
	 */
	public String getCardMessage() {
		return cardMessage[card];
	}

//----------------------------------------------------------------------------------
	//                              setters
//----------------------------------------------------------------------------------
	
	
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

	/**
	 * Indeholder værdier der skal ændre balancen.
	 */
	private void setBalanceChange() {
		for(int i = 0; i<numberOfCards; i++) {
			balanceChange[i] = 0;
		}
		balanceChange[1] = 2;
		balanceChange[6] = -2;
		balanceChange[15] = 2;
	}

	/**
	 * Giver en værdi 
	 * @param location
	 */
	private void setMoveTo() {
		for(int i = 0; i<numberOfCards; i++) {
			moveTo[i] = 0;
		}
	}	
	
	private void setCardMessage() {
//		for (int i = 0; i < numberOfCards; i++) {
//			cardMessage[i] = reader.getString("CC"+i, "chanceCardsText"); // Metoden endnu ikke implemtereret
//		}
		cardMessage[0] = "Et kort til";
		cardMessage[1] = "Ryk frem til start";
		cardMessage[2] = "Fem felter frem";
		cardMessage[3] = "0";
		cardMessage[4] = "1 felt frem";
		cardMessage[5] = "Et chancekort til";
		cardMessage[6] = "-2 m";
		cardMessage[7] = "0";
		cardMessage[8] = "0";
		cardMessage[9] = "0";
		cardMessage[10] = "Strandpromanaden 24";
		cardMessage[11] = "et kort til";
		cardMessage[12] = "et kort til";
		cardMessage[13] = "0";
		cardMessage[14] = "0";
		cardMessage[15] = "+2 m";
		cardMessage[16] = "0";
		cardMessage[17] = "Ryk frem til 11";
	}


//----------------------------------------------------------------------------------
	//                              allCardFalse
//----------------------------------------------------------------------------------

	/**
	 * Sætter alle kort til false, i den forstand af de endnu ikke er brugt.
	 */
	private void allCardFalse() {
		for(int i = 0; i<numberOfCards; i++) {
			taken[i] = false;
		}
	}
}

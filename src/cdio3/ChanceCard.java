package cdio3;

import java.io.IOException;
import java.util.Random;

/**
 * ChanceCard
 * @author thyge
 * @version 20.11.2017
 */
public class ChanceCard extends FieldEffect{
	Random ran = new Random(); 
	int numberOfCards = 18; //Antal af chance kort
	int location; //Indeholder spillerens aktuelle lokation.
	int card; // Indeholder det chancekort nummer som er aktuelt for denne session.
	private boolean[] taken = new boolean[numberOfCards]; // Holder styr på taget/ikke taget stakken
	private boolean[] extraCard = new boolean[numberOfCards]; // true hvis spilleren må trække et kort til.
	private String[] cardMessage = new String[numberOfCards]; // chancekort beskeden bliver "loadet" ved start.
	private int[] moveTo = new int[numberOfCards]; // angiver hvor mange felter man skal flytte for at komme chance stedet hen (start, 5 felter, skaterpark)
	private int[] balanceChange = new int[numberOfCards]; // ændringen af balancen, enten negativ eller positiv
	Reader reader = new Reader();
	
//----------------------------------------------------------------------------------
	//                         Den tager udgangspunkt i 
	//                       at start er felt nummer 1 og
	//                    det sidste felt, er felt nummer 24
//----------------------------------------------------------------------------------
	
	/**
	 * Konstruktør. 
	 * @throws IOException 
	 */
	public ChanceCard() throws IOException {
//		setCardMessage(); // Tilføjer den aktuelle tekst til kortet
		allCardFalse(); // Sætter alle kort til false.
		setExtraCard(); // Sætter felter til true, til der hvor man må trække et ekstra kort.
		setBalanceChange(); // Sætter balancen
		setMoveTo(); // sætter moveto værdierne
	}

	/**
	 * Giver spilleren et kort og initialisere lokationen
	 * @param location
	 */
	public void initChanceCard(int location) {
		card = getCard();
		this.location = location;
	}	

	/**
	 * Vælger et kort, hvis dette kort allerede er
	 * blivet taget, finder den et nyt kort osv.
	 * @return
	 */
	private int getCard() {
		checkPile();
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
	
	/**
	 * Checker om der er flere ledige kort
	 */
	private void checkPile() {
		int falseCounter = 0;
		for (int i = 0; i < numberOfCards; i++) 
			if(taken[i] == false)
				falseCounter++;
		if(falseCounter == 0) 
			allCardFalse();
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
	 * Retunerer antal felter spilleren skal rykke
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
	 * Retunerer den streng spillerne skal se.
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
	 * Indeholder værdi der skal ændre balancen.
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
	 * Giver en værdi brikken skal rykke.
	 * @param location
	 */
	private void setMoveTo() {
		for(int i = 0; i<numberOfCards; i++) {
			moveTo[i] = 0;
		}
	}	
	
	/**
	 * Loader alle tekst strenge til et array
	 * - NB: Afventer reader.
	 * @throws IOException 
	 */
	private void setCardMessage() throws IOException {
		for (int i = 1; i <= numberOfCards; i++) 
			cardMessage[i] = reader.getString("CC"+i, "chanceKort"); 
	}
	


//----------------------------------------------------------------------------------
	//                              allCardFalse
//----------------------------------------------------------------------------------

	/**
	 * Sætter alle kort til false, i den forstand at de endnu ikke er brugt.
	 */
	private void allCardFalse() {
		for(int i = 0; i<numberOfCards; i++) {
			taken[i] = false;
		}
	}
	
	private void allCardTrue() {
		for(int i = 0; i<numberOfCards; i++) {
			taken[i] = true;
		}
	}
}

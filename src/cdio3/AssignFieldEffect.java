package cdio3;

import java.io.IOException;

/**
 * 
 * @author thyge & mathias
 * @version 27/11/2017
 */
public class AssignFieldEffect {
	private String chanceMessage;
	private String message;
	private int balance;
	private int propertyValue;
	private int location;
	private int reciever;
	private int payer;
	private int amount;
	private int newLocation;
	private boolean jail;
	private boolean extraChanceCard;
	ChanceCard cc;
	Properties properties = new Properties();
	
	/**
	 * Konstruktør
	 * @throws IOException
	 */
	public AssignFieldEffect() throws IOException {
		cc = new ChanceCard();
	}
	
	/**
	 * Initialisere felt effekten. 
	 * Giver de respektive variabler, de rigitge værdier. 
	 * @param location Lokationen på spilleren.
	 * @param playerNumber Den givne spillers "navn".
	 */
	public void initFieldEffect(int location, int playerNumber) {
		reset(location);
		// switch der håndterer hvilke metode der skal benyttes, i forhold til hvilket felt man lander på.
		switch(location) {
		case 0: 
			break;
		case 1: case 2: case 4: case 5:
			propertyValue = 1;
			properties.getEffect(location, propertyValue, playerNumber);
			balance = properties.getRecieveAmount();
			break;
		case 6: case 12:
			propertyValue = 0;
			break;
		case 7: case 8: case 10: case 11:
			propertyValue = 2;
			properties.getEffect(location, propertyValue, playerNumber);
			balance = properties.getRecieveAmount();
			break;
		case 13: case 14: case 16: case 17:
			propertyValue = 3;
			properties.getEffect(location, propertyValue, playerNumber);
			balance = properties.getRecieveAmount();
			break;
		case 19: case 20:
			propertyValue = 4;
			properties.getEffect(location, propertyValue, playerNumber);
			balance = properties.getRecieveAmount();
			break;
		case 22: case 23:
			propertyValue = 5;
			properties.getEffect(location, propertyValue, playerNumber);
			balance = properties.getRecieveAmount();
			break;
		case 3: case 9: case 15: case 21:
			cc.initChanceCard(location);
			balance = cc.getBalanceChange();
			newLocation += cc.getMoveTo();
			chanceMessage = cc.getCardMessage();
			extraChanceCard = true;
			break;
		case 18:
			jail = true;
		default: break;
		}
	}

	/**
	 * Nulstiller alle variabler.
	 * @param location Lokationen på spilleren.
	 */
	public void reset(int location) {
		this.location = 0;
		balance = 0;
		String message = "";
		String chanceMessage = "";
		newLocation = location;
		jail = false;
		extraChanceCard = false;
	}

//----------------------------------------------------------------------------------
	//                                 getters
//----------------------------------------------------------------------------------

	/**
	 * @return Beskeden generet ved chance kort
	 */
	public String getChangeMessage() {
		return chanceMessage;
	}
	
	/**
	 * @return Beskeden generet
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Ændringen i balancen
	 */
	public int getBalanceChange() {
		return balance;
	}	
	
	/**
	 * @return Modtageren af leje ved leje af grund
	 */
	public int getReciever() {
		return properties.getReciever();
	}
	
	/**
	 * @return Lejren der skal betale for leje af grund
	 */
	public int getPayer() {
		return properties.getPayer();
	}
	
	/**
	 * @return Lejen det koster at leje den aktuelle grund
	 */
	public int getPayAmount() {
		return properties.getPayAmount();
	}

	/**
	 * @return Ændringen der skal lægges til lokationen
	 */
	public int getLocationChange() {
		return newLocation;
	}
	
	/**
	 * Afgører om man må tage et chance kort til
	 * @return Sand hvis man skal trække et kort til
	 */
	public boolean getExtraChanceCard() {
		return extraChanceCard;
	}
}

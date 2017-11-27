package cdio3;

/**
 * 
 * @author thyge & mathias
 * @version 27/11/2017
 */
public class AssignFieldEffect {
	int balance;
	private int propertyValue;
	SpecialFields sp;
	ChanceCard cc;
	boolean jail;
	String message;
	int newLocation;
	

	/**
	 * Initialisere felt effekten. 
	 * Giver de respektive variabler, de rigitge værdier. 
	 * @param location Lokationen på spilleren.
	 */
	public void initFieldEffect(int location) {
		reset(location);
		// switch der håndterer hvilke metode der skal benyttes, i forhold til hvilket felt man lander på.
		switch(location) {
		case 0: 
			sp.passStart();
			break;
		case 1: case 2: case 4: case 5:
			propertyValue = 1;
			break;
		case 7: case 8: case 10: case 11:
			propertyValue = 2;
			break;
		case 13: case 14: case 16: case 17:
			propertyValue = 3;
			break;
		case 19: case 20:
			propertyValue = 4;
			break;
		case 22: case 23:
			propertyValue = 5;
			break;
		case 3: case 9: case 15: case 21:
			cc.initChanceCard(location);
			balance = cc.getBalanceChange();
			newLocation += cc.getMoveTo();
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
		location = 0;
		balance = 0;
		String message = null;
		newLocation = location;
		jail = false;
	}
	
//----------------------------------------------------------------------------------
	//                              getters
//----------------------------------------------------------------------------------
	 
	public int getBalance() {
		return balance;
	}
	
	public int getNewLocation() {
		return newLocation;
	}
	
	public boolean getJail() {
		return jail;
	}
	
	public String getMessage() {
		return message;
	}
	

}

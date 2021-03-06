package cdio3;

/**
 * @author thyge
 * @version 27.11.2017
 */
public class Properties {
	String message;
	boolean[] owned;
	int[] owner;
	int fields = 24;
	int propValue;
	int playerNumber;
	int location;
	int reciever;
	int payer;
	int amount;

	/**
	 * Konstruktør
	 */
	public Properties() {
		owned = new boolean[fields];
		owner = new int[fields];
		for (int i = 1; i < fields; i++) {
			owner[i] = 5;
			owned[i] = false;
//			if((i % 3) != 0)
//				owned[i] = false;
		}
	}


	/**
	 * Finder ud af hvad der skal ske
	 * @param location Lokationen hvor spilleren befinder sig. 0-baseret
	 * @param propValue Værdien grunden har.
	 * @param playerNumber Spillerens array index nummer
	 */
	public void getEffect(int location, int propValue, int playerNumber) {
		this.propValue = propValue;
		this.location = location;
		this.playerNumber = playerNumber;
		if(owned[location] == false) {
			buy();
		}
		else if(owned[location] == true) {
			pay();
		}
		else {
			System.out.println("You shouldn't be here!");
		}
	}

	/**
	 * Håndterer scenariet hvor grunden er ejet.
	 */
	private void pay() {
		payer = playerNumber;
		reciever = owner[location];
		amount = getPayAmount();
	}

	/**
	 * Håndterer scenariet hvor grunden skal købes
	 */
	private void buy() {
		owner[location] = playerNumber;
		owned[location] = true;
		amount = propValue * -1;
		reciever = owner[location];
	}

	/**
	 * Returnerer beløbet +- (\pm)
	 * @return Beløbet er en int der både kan være negativ og positiv.
	 */
	public int getPayAmount() {
		return (amount);
	}
	
	/**
	 * @return Lejen fremlejeren modtager
	 */
	public int getRecieveAmount() {
		return amount;
	}
	
	/**
	 * @return Beskeden til spillerne
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Leje modtagerens nummer
	 */
	public int getReciever() {
		return reciever;
	}
}

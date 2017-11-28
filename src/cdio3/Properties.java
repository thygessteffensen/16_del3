package cdio3;

/**
 * 
 * @author thyge
 * @version 27.11.2017
 */
public class Properties {
	// Nul baseret!
	boolean[] owned;
	int[] owner;
	int fields = 24;
	int propValue = 12;
	int playerNumber = 2;
	int location = 1;
	String message;
	//------------
	int reciever = 5;
	int payer = 10;
	int amount = 20;
	static Reader reader = new Reader();
	/**
	 * Konstruktør
	 */
	public Properties() {
		// generer arrays 
		for (int i = 1; i < fields; i++) {
			owned = new boolean[fields];
			owner = new int[fields];
			if((i % 3) != 0)
				owned[i] = false;
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
		amount = propValue;
	}

	/**
	 * Håndterer scenariet hvor grunden skal købes
	 */
	private void buy() {
		owner[location] = playerNumber;
		amount = propValue;
		reciever = owner[location];
	}

	/**
	 * Returnerer modtageren.
	 * @return Modtagerens plads i player arrayet.
	 */
	
	public int getPayer() {
		return payer;
	}

	/**
	 * Returnerer beløbet +-
	 * @return Beløbet er en int der både kan være negativ og positiv.
	 */
	public int getPayAmount() {
		return -1 * amount;
	}
	
	public int getRecieveAmount() {
		return amount;
	}
	





}

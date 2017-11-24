package cdio3;

public class AssignFieldEffect {
	boolean jail = false;
	private int propertyValue = 0;
	switch(Player.getPlayerLocation) {
	case 0: start {
		if (Player.getPlayerLocation > 23) {
			Player.wallet.changeBalance += 2;
			Player.setPlayerLocation -= 24;
		}
	}
		break;
	}
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
		chanceCard();
		break;
	case 18:
		jail = true;
		//Player.jail(true)
	default: break;
	
	private void chanceCard() {
		ChanceCard.getCard();
		if (ChanceCard.getExtraCard == true)
			chanceCard();
		Player.setLocation(ChanceCard.getMoveTo());
		Player.setBalance(ChanceCard.getBalanceChange());
		ChanceCard.getMessage();
		
	}


}

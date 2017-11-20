package cdio3;

import java.util.Random;

public class TestChanceCard {
	static Random ran = new Random();
	static ChanceCard cc = new ChanceCard();
	public static void main(String[] args) {
	int lok;
		for (int i = 0; i < 15; i++) {
			lok = ran.nextInt(18)-1;
			cc.initChanceCard(lok);
			System.out.println("Lokation: " + lok);
			System.out.println("Balance ændring: " + cc.getBalanceChange());
			System.out.println("Ekstra kort: " + cc.getExtraCard());
			System.out.println("Flyt til: " + cc.getMoveTo());
			System.out.println("Besked: " + cc.getCardMessage());
			System.out.println("");
		}
	}
}

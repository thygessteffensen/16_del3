package cdio3;

import java.util.Random;
import java.io.IOException;

public class TestChanceCard{
	static Random ran = new Random();
	static ChanceCard cc = new ChanceCard();
	public static void main(String[] args) {
	int lok;
		for (int i = 0; i < 40; i++) {
			lok = ran.nextInt(18)-1;
			cc.initChanceCard(lok);
			System.out.println("Kort: " + cc.card);
			System.out.println("Lokation: " + lok);
			System.out.println("Balance ændring: " + cc.getBalanceChange());
			System.out.println("Ekstra kort: " + cc.getExtraCard());
			System.out.println("Flyt til: " + (lok+cc.getMoveTo()));
			System.out.println("Besked: " + cc.getCardMessage());
			System.out.println("");
		}
	}
}

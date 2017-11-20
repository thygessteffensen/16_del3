package cdio3;

public class TestChanceCard {
	static ChanceKort ck = new ChanceKort();
	public static void main(String[] args) {
		System.out.println("test");
		ck.getChanceKort(3);
		System.out.println(ck.getExtraCard());
	}
}

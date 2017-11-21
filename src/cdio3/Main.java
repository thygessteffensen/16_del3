package cdio3;

public class Main {
	static UI ui;
	public static void main(String[] args) {
		ui = new UI();
		ui.setUp();
		String[] name = {"John", "Rambo"};
		int[] balance = {1000, 1000};
		ui.addPlayer(2, name, balance);
	}
}


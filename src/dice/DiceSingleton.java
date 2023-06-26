package dice;

public class DiceSingleton {

	private static Dice dice = new Dice();

	public static Dice getDiceInstance() {
		return dice;
	}
}

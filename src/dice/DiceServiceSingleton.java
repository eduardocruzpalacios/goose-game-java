package dice;

public class DiceServiceSingleton {

	private static DiceService diceService = new DiceService();

	public static DiceService getInstance() {
		return diceService;
	}

}

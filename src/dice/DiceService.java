package dice;

public class DiceService {

	private DiceModel diceModel1;
	private DiceModel diceModel2;
	private int lastRollValue;

	public DiceService() {
		this.diceModel1 = new DiceModel();
		this.diceModel2 = new DiceModel();
	}

	public int get2DiceRolledValue() {
		this.diceModel1.roll();
		this.diceModel2.roll();
		int diceResult = diceModel1.getFaceValue() + diceModel2.getFaceValue();
		this.lastRollValue = diceResult;
		return diceResult;
	}

	public int getLastRollValue() {
		return this.lastRollValue;
	}
}

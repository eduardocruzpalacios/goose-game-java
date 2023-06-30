package dice;

public class DiceService {

	private DiceModel diceModel1;
	private DiceModel diceModel2;
	private int lastRollValue;

	public DiceService() {
		this.diceModel1 = new DiceModel();
		this.diceModel2 = new DiceModel();
	}

	public int getLastRollValue() {
		return this.lastRollValue;
	}

	public int get2DiceRolledValue() {
		this.roll2Dice();
		int diceResult = diceModel1.getFaceValue() + diceModel2.getFaceValue();
		this.lastRollValue = diceResult;
		return diceResult;
	}

	private void roll2Dice() {
		this.diceModel1.roll();
		this.diceModel2.roll();
	}

	public int getFirstRollByPlayerValue() {
		this.roll2Dice();
		int diceResult = diceModel1.getFaceValue() + diceModel2.getFaceValue();
		if (diceResult == 9) {
			if (diceModel1.getFaceValue() == 3 || diceModel2.getFaceValue() == 3) {
				return 26;
			}
			return 53;
		}
		this.lastRollValue = diceResult;
		return diceResult;
	}

	public int get1DiceRolledValue() {
		this.diceModel1.roll();
		int diceResult = diceModel1.getFaceValue();
		this.lastRollValue = diceResult;
		return diceResult;
	}
}

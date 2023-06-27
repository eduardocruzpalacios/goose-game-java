package dice;

public class DiceModel {

	private int faceValue;

	public DiceModel() {
	}

	public void roll() {
		this.faceValue = (int) Math.random() * 6 + 1;
	}

	public int getFaceValue() {
		return faceValue;
	}

}

package dice;

import java.util.Random;

public class DiceModel {

	private int faceValue;

	public DiceModel() {
	}

	public void roll() {
		Random random = new Random();
		int min = 1;
		int max = 6;
		int randomValue = random.nextInt(max) + min;
		this.faceValue = randomValue;
	}

	public int getFaceValue() {
		return this.faceValue;
	}

}

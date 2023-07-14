package dice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DiceModelTest {

	@Test
	public void testRoll() {
		DiceModel dice = new DiceModel();
		for (int i = 0; i < 100; i++) {
			dice.roll();
			int faceValue = dice.getFaceValue();
			assertTrue(faceValue >= 1 && faceValue <= 6);
		}
	}

}

package dice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DiceServiceTest {

	private DiceService diceService = new DiceService();

	@Test
	public void testGet2DiceRolledValue() {
		for (int i = 0; i < 100; i++) {
			int value = diceService.get2DiceRolledValue();
			assertTrue(value >= 2 && value <= 12);
		}
	}

	@Test
	public void testGetFirstRollByPlayerValue() {
		for (int i = 0; i < 100; i++) {
			int value = diceService.getFirstRollByPlayerValue();
			assertTrue((value >= 2 && value <= 12) || value == 23 || value == 53);
		}
	}

	@Test
	public void testGet1DiceRolledValue() {
		for (int i = 0; i < 100; i++) {
			int value = diceService.get1DiceRolledValue();
			assertTrue(value >= 1 && value <= 6);
		}
	}

}

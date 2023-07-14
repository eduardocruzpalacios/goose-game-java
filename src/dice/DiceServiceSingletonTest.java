package dice;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class DiceServiceSingletonTest {

	@Test
	public void testGetInstance() {
		DiceService diceService1 = DiceServiceSingleton.getInstance();
		DiceService diceService2 = DiceServiceSingleton.getInstance();
		assertSame(diceService1, diceService2);
	}

}

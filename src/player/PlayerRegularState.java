package player;

import dice.DiceServiceSingleton;

public class PlayerRegularState implements PlayerState {

	private Player player;

	public PlayerRegularState(Player player) {
		this.player = player;
	}

	@Override
	public void playTurn() {
		int diceResult = DiceServiceSingleton.getInstance().get2DiceRolledValue();
		this.player.moveSquares(diceResult);
	}

}

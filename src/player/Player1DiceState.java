package player;

import dice.DiceServiceSingleton;

public class Player1DiceState implements PlayerState {

	private Player player;

	public Player1DiceState(Player player) {
		this.player = player;
	}

	@Override
	public void playTurn() {
		int diceResult = DiceServiceSingleton.getInstance().get1DiceRolledValue();
		this.player.moveSquares(diceResult);
	}

}

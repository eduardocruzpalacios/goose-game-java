package player;

import dice.Dice;
import dice.DiceSingleton;

public class PlayerRegularState implements PlayerState {

	private Player player;

	public PlayerRegularState(Player player) {
		this.player = player;
	}

	@Override
	public void playTurn() {
		int diceResult = 0;
		Dice dice = DiceSingleton.getDiceInstance();
		dice.roll();
		diceResult += dice.getFaceValue();
		dice.roll();
		diceResult += dice.getFaceValue();
		this.player.moveSquares(diceResult);
	}

}

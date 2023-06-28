package player;

import dice.DiceServiceSingleton;

public class PlayerFirstTurnState implements PlayerState {

	private Player player;

	public PlayerFirstTurnState(Player player) {
		this.player = player;
	}

	@Override
	public void playTurn() {
		int diceResult = DiceServiceSingleton.getInstance().getFirstRollByPlayerValue();
		this.player.moveSquares(diceResult);
		this.player.setPlayerState(new PlayerRegularState(this.player));
	}

}

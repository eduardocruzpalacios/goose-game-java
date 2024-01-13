package player;

public class PlayerNoTurnsState implements PlayerState {

	private int turnsWithoutPlaying;
	private Player player;

	public PlayerNoTurnsState(Player player, int turnsWithoutPlaying) {
		this.player = player;
		this.turnsWithoutPlaying = turnsWithoutPlaying;
	}

	@Override
	public void playTurn() {
		if (turnsWithoutPlaying > 1) {
			this.turnsWithoutPlaying--;
		} else {
			PlayerStateHandler.setRegularState(this.player);
		}
	}

}

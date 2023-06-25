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
		if (turnsWithoutPlaying > 0) {
			this.turnsWithoutPlaying--;
		} else {
			this.player.setPlayerState(new PlayerRegularState(this.player));
		}
	}

}

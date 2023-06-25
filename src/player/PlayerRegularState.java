package player;

public class PlayerRegularState implements PlayerState {

	private Player player;

	public PlayerRegularState(Player player) {
		this.player = player;
	}

	@Override
	public void playTurn() {
		// TODO actual turn where dices are thrown and movePlayerTo is called
	}

}

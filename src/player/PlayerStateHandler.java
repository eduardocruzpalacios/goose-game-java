package player;

public class PlayerStateHandler {

	static public void setFirstTurnState(Player player) {
		player.setPlayerState(new PlayerFirstTurnState(player));
	}

	static public void setRegularState(Player player) {
		player.setPlayerState(new PlayerRegularState(player));
	}

	static public void setNoTurnsState(Player player, int turnsNumber) {
		player.setPlayerState(new PlayerNoTurnsState(player, turnsNumber));
	}

}

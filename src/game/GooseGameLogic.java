package game;

import java.util.HashMap;
import java.util.Map;

import game.player.Player;
import game.player.PlayerNoTurnsState;

public class GooseGameLogic {

	private Board board;
	private Map<Integer, Player> players;
	private int playerIdToPlayNextTurn;
	private GooseGameLogicState gooseGameLogicState;

	public GooseGameLogic(int playersNumber) {
		super();
		this.board = new Board(this);
		this.players = new HashMap<Integer, Player>();
		for (int i = 1; i <= playersNumber; i++) {
			Player player = new Player(i, board);
			this.players.put(player.getId(), player);
		}
		this.playerIdToPlayNextTurn = 1;
	}

	public void setGooseGameLogicState(GooseGameLogicState gooseGameLogicState) {
		this.gooseGameLogicState = gooseGameLogicState;
	}

	public void giveTurnToNextPlayer() {
		if (this.playerIdToPlayNextTurn > this.players.size()) {
			this.playerIdToPlayNextTurn = 1;
		} else {
			this.playerIdToPlayNextTurn++;
		}
	}

	public void givePlayerExtraTurn(Player player) {
		this.playerIdToPlayNextTurn = player.getId();
	}

	public void makePlayerLooseTurns(Player player, int turnsNumber) {
		player.setPlayerState(new PlayerNoTurnsState(player, turnsNumber));
	}

	public void finishGame(Player player) {
		this.setGooseGameLogicState(new GameOverState());
	}

}

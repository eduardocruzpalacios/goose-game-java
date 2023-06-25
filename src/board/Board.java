package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.GooseGameLogicFacade;
import player.Player;
import player.PlayerNoTurnsState;
import squares.Square;

public class Board {

	private GooseGameLogicFacade gooseGameLogicFacade;
	private Map<Integer, Player> players;
	private int playerIdToPlayNextTurn;
	private Map<Integer, Square> squares;
	private final List<Integer> gooseSquaresIds = new ArrayList<>(
			List.of(1, 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59, 63));
	private final Map<Integer, Integer> bridgeSquaresIdsMap = new HashMap<Integer, Integer>(Map.of(6, 12, 12, 6));

	public Board(GooseGameLogicFacade gooseGameLogicFacade, int playersNumber) {
		this.gooseGameLogicFacade = gooseGameLogicFacade;
		this.players = new HashMap<Integer, Player>();
		for (int i = 1; i <= playersNumber; i++) {
			Player player = new Player(i, this);
			this.players.put(player.getId(), player);
		}
		this.playerIdToPlayNextTurn = 1;
	}

	public void playerPlaysTurnAndLandOnSquare(Player player, int squareId) {
		this.makePlayerGoTo(player, squareId);
		player.setSquareId(squareId);
		this.giveTurnToNextPlayer();
		Square square = this.squares.get(squareId);
		square.landedOn(player);
	}

	public void makePlayerGoTo(Player player, int squareId) {
		player.setSquareId(squareId);
	}

	public void giveTurnToNextPlayer() {
		if (this.playerIdToPlayNextTurn > this.players.size()) {
			this.playerIdToPlayNextTurn = 1;
		} else {
			this.playerIdToPlayNextTurn++;
		}
	}

	public void movePlayerToNextGooseSquare(Player player, int currentGooseSquareId) {
		int nextGooseSquareId = this.gooseSquaresIds.indexOf(currentGooseSquareId) + 1;
		player.setSquareId(nextGooseSquareId);
		this.givePlayerExtraTurn(player);
	}

	public void givePlayerExtraTurn(Player player) {
		this.playerIdToPlayNextTurn = player.getId();
	}

	public void movePlayerToTheOtherBridgeSquare(Player player, int currentBridgeSquareId) {
		int theOtherBridgeSquareId = this.bridgeSquaresIdsMap.get(currentBridgeSquareId);
		player.setSquareId(theOtherBridgeSquareId);
		this.givePlayerExtraTurn(player);
	}

	public void makePlayerLooseTurns(Player player, int turnsNumber) {
		player.setPlayerState(new PlayerNoTurnsState(player, turnsNumber));
	}

	public void finishGame(Player player) {
		this.gooseGameLogicFacade.finishGame(player);
	}

}

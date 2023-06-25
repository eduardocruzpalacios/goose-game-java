package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import player.Player;
import squares.Square;

public class Board {

	private GooseGameLogic gooseGameLogic;
	private Map<Integer, Square> squares;
	private final List<Integer> gooseSquaresIds = new ArrayList<>(
			List.of(1, 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59, 63));
	private final Map<Integer, Integer> bridgeSquaresIdsMap = new HashMap<Integer, Integer>(Map.of(6, 12, 12, 6));

	public Board(GooseGameLogic gooseGameLogic) {
		this.gooseGameLogic = gooseGameLogic;
	}

	public void playerPlaysTurn(Player player, int squareId) {
		this.makePlayerGoTo(player, squareId);
		this.gooseGameLogic.giveTurnToNextPlayer();
		Square square = this.squares.get(squareId);
		square.landedOn(player);
	}

	public void makePlayerGoTo(Player player, int squareId) {
		player.setSquareId(squareId);
	}

	public void movePlayerToNextGooseSquare(Player player, int currentGooseSquareId) {
		int nextGooseSquareId = this.gooseSquaresIds.indexOf(currentGooseSquareId) + 1;
		player.setSquareId(nextGooseSquareId);
		this.gooseGameLogic.givePlayerExtraTurn(player);
	}

	public void movePlayerToTheOtherBridgeSquare(Player player, int currentBridgeSquareId) {
		int theOtherBridgeSquareId = this.bridgeSquaresIdsMap.get(currentBridgeSquareId);
		player.setSquareId(theOtherBridgeSquareId);
		this.gooseGameLogic.givePlayerExtraTurn(player);
	}

	public void makePlayerLooseTurns(Player player, int turnsNumber) {
		this.gooseGameLogic.makePlayerLooseTurns(player, turnsNumber);
	}

	public void finishGame(Player player) {
		this.gooseGameLogic.finishGame(player);
	}

}

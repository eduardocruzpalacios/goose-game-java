package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.player.Player;
import game.squares.Square;

public class Board {

	private GooseGameLogic gooseGameLogic;
	private Map<Integer, Square> squares;
	private final List<Integer> gooseSquaresIds = new ArrayList<>(
			List.of(1, 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59, 63));
	private final Map<Integer, Integer>bridgeSquaresIdsMap = new HashMap<Integer, Integer>(Map.of(6, 12, 12, 6));

	public Board(GooseGameLogic gooseGameLogic) {
		this.gooseGameLogic = gooseGameLogic;
	}

	public void movePlayerTo(Player player, int squareId) {
		Square square = this.squares.get(squareId);
		player.setSquareId(squareId);
		this.gooseGameLogic.giveTurnToNextPlayer();
		square.landedOn(player);
	}

	public void executeLandedOnGooseSquare(Player player, int currentGooseSquareId) {
		int nextGooseSquareId = this.gooseSquaresIds.indexOf(currentGooseSquareId) + 1;
		player.setSquareId(nextGooseSquareId);
		this.gooseGameLogic.givePlayerExtraTurn(player);
	}

	public void executeLandedOnBridgeSquare(Player player, int currentBridgeSquareId) {
		int theOtherBridgeSquareId  = this.bridgeSquaresIdsMap.get(currentBridgeSquareId);
		player.setSquareId(theOtherBridgeSquareId);
		this.gooseGameLogic.givePlayerExtraTurn(player);
	}

	public void executeLandedOnInnSquare(Player player) {
		this.gooseGameLogic.makePlayerLooseTurns(player, 2);
	}

}

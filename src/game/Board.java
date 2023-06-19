package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import game.squares.Square;

public class Board {

	private GooseGameLogic gooseGameLogic;
	private Map<Integer, Square> squares;
	private final List<Integer> gooseSquaresIds = new ArrayList<>(
			List.of(1, 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59, 63));

	public Board(GooseGameLogic gooseGameLogic) {
		this.gooseGameLogic = gooseGameLogic;
	}

	public void movePlayerTo(Player player, int squareId) {
		Square square = squares.get(squareId);
		player.setSquareId(squareId);
		this.gooseGameLogic.giveTurnToNextPlayer();
		square.landedOn(player);
	}

	public void executeLandedOnGooseSquare(Player player, int currentGooseSquareId) {
		int nextGooseSquareId = gooseSquaresIds.indexOf(currentGooseSquareId) + 1;
		player.setSquareId(nextGooseSquareId);
		this.gooseGameLogic.givePlayerExtraTurn(player);
	}

}

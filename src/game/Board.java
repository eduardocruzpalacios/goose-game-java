package game;

import java.util.Map;

public class Board {

	private Map<Integer, Square> squares;

	public void movePlayerTo(Player player, int squareId) {
		Square square = squares.get(squareId);
		player.setSquareId(squareId);
		square.landedOn(player);
	}



}

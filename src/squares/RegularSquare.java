package squares;

import game.Board;
import player.Player;

public class RegularSquare extends Square {

	public RegularSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		return;
	}

}

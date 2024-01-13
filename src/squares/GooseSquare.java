package squares;

import board.Board;
import player.Player;

public class GooseSquare extends Square {

	public GooseSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.board.executeLandedOnGooseSquare(player, this.getId());
	}

}

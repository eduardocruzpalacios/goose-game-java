package squares;

import game.Board;
import game.player.Player;

public class SkullSquare extends Square {

	public SkullSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.board.makePlayerGoTo(player, 0);
	}

}

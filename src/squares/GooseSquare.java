package squares;

import game.Board;
import game.player.Player;

public class GooseSquare extends Square {

	public GooseSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().movePlayerToNextGooseSquare(player, this.getId());
	}

}

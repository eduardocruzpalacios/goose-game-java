package squares;

import board.Board;
import player.Player;

public class InnSquare extends Square {

	public InnSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().makePlayerLooseTurns(player, 2);
	}

}

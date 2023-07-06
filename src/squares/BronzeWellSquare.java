package squares;

import board.Board;
import player.Player;

public class BronzeWellSquare extends Square {

	public BronzeWellSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().makePlayerLooseTurns(player, 3);
	}

}

package squares;

import game.Board;
import player.Player;

public class JailSquare extends Square {

	public JailSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().makePlayerLooseTurns(player, 3);
	}

}

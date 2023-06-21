package game.squares;

import game.Board;
import game.player.Player;

public class BronzeSquare extends Square {

	public BronzeSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().makePlayerLooseTurns(player, 3);
	}

}

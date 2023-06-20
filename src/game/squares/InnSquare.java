package game.squares;

import game.Board;
import game.player.Player;

public class InnSquare extends Square{

	public InnSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().executeLandedOnInnSquare(player);
	}

}

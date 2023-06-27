package squares;

import board.Board;
import player.Player;

public class DiceSquare extends Square {

	public DiceSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().executeLandedOnDiceSquare(player, this.getId());
	}

}

package squares;

import board.Board;
import player.Player;

public class BridgeSquare extends Square {

	public BridgeSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.board.executeLandedOnBridgeSquare(player, this.getId());
	}

}

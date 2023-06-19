package game.squares;

import game.Board;
import game.Player;

public class BridgeSquare extends Square{

	public BridgeSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.getBoard().executeLandedOnBridgeSquare(player, this.getId());
	}

}

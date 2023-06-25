package game.squares;

import game.Board;
import game.player.Player;

public class GooseGardenSquare extends Square {

	public GooseGardenSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.board.finishGame(player);
	}

}

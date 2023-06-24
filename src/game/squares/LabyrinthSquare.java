package game.squares;

import game.Board;
import game.player.Player;

public class LabyrinthSquare extends Square {

	public LabyrinthSquare(Integer id, Board board) {
		super(id, board);
	}

	@Override
	public void landedOn(Player player) {
		this.board.makePlayerGoTo(player, 30);
	}

}

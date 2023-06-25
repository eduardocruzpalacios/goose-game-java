package squares;

import board.Board;
import player.Player;

public abstract class Square {

	private int id;
	protected Board board;

	public Square(Integer id, Board board) {
		this.id = id;
		this.board = board;
	}

	public int getId() {
		return id;
	}

	public Board getBoard() {
		return board;
	}

	abstract public void landedOn(Player player);
}

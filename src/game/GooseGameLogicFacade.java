package game;

import board.Board;

public class GooseGameLogicFacade {

	private Board board;

	public GooseGameLogicFacade(int playersNumber) {
		this.board = new Board(playersNumber);
	}

}

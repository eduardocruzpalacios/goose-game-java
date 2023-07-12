package game;

import board.Board;
import board.BoardLastTurnAPI;

public class GooseGameLogicFacade {

	private Board board;

	public GooseGameLogicFacade() {
	}

	public void initGame(int playersNumber) {
		this.board = new Board(playersNumber);
	}

	public BoardLastTurnAPI playNextTurn() {
		this.board.playNextTurn();
		return this.board.getBoardLastTurnAPI();
	}

}

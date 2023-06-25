package game;

import board.Board;
import player.Player;

public class GooseGameLogic {

	private Board board;
	private GooseGameLogicState gooseGameLogicState;

	public GooseGameLogic(int playersNumber) {
		super();
		this.board = new Board(this, playersNumber);
	}

	public void setGooseGameLogicState(GooseGameLogicState gooseGameLogicState) {
		this.gooseGameLogicState = gooseGameLogicState;
	}

	public void finishGame(Player player) {
		this.setGooseGameLogicState(new GameOverState());
	}

}

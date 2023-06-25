package game;

import board.Board;
import player.Player;

public class GooseGameLogicFacade {

	private Board board;
	private GooseGameLogicFacadeState gooseGameLogicFacadeState;

	public GooseGameLogicFacade(int playersNumber) {
		super();
		this.board = new Board(this, playersNumber);
	}

	public void setGooseGameLogicState(GooseGameLogicFacadeState gooseGameLogicFacadeState) {
		this.gooseGameLogicFacadeState = gooseGameLogicFacadeState;
	}

	public void finishGame(Player player) {
		this.setGooseGameLogicState(new GameOverState());
	}

}

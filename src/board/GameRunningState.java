package board;

public class GameRunningState implements BoardState {

	private Board board;

	public GameRunningState(Board board) {
		this.board = board;
	}

	@Override
	public void playNextTurn() {
		this.board.makeNextPlayerToPlay();
	}

}

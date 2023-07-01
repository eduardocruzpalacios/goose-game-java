package board;

public class GameRunningState implements BoardState {

	private Board board;

	public GameRunningState(Board board) {
		this.board = board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public void playNextTurn() {
		return;
	}

}

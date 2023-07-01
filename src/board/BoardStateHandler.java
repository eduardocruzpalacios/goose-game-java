package board;

public class BoardStateHandler {

	static public void setGameOverState(Board board) {
		board.setBoardState(new GameOverState());
	}

	static public void setGameRunningState(Board board) {
		board.setBoardState(new GameRunningState(board));
	}

}

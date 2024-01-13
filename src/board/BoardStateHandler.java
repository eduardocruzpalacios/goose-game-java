package board;

public class BoardStateHandler {

	static void setGameOverState(Board board) {
		board.setBoardState(new GameOverState());
	}

	static void setGameRunningState(Board board) {
		board.setBoardState(new GameRunningState(board));
	}

}

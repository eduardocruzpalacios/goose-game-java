package board;

public class BoardLastTurnAPI {

	private int lastPlayerIdWhoPlayed;
	private int squareIdLandedOnByLastPlayerWhoPlayed;
	private boolean gameOver;

	public BoardLastTurnAPI(int lastPlayerIdWhoPlayed, int squareIdLandedOnByLastPlayerWhoPlayed, boolean gameOver) {
		this.lastPlayerIdWhoPlayed = lastPlayerIdWhoPlayed;
		this.squareIdLandedOnByLastPlayerWhoPlayed = squareIdLandedOnByLastPlayerWhoPlayed;
		this.gameOver = gameOver;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	@Override
	public String toString() {
		return "BoardLastTurnAPI [lastPlayerIdWhoPlayed=" + lastPlayerIdWhoPlayed
				+ ", squareIdLandedOnByLastPlayerWhoPlayed=" + squareIdLandedOnByLastPlayerWhoPlayed + "]";
	}

}

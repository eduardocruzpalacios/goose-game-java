package board;

public class BoardLastTurnAPI {

	private int lastPlayerIdWhoPlayed;
	private int lastDiceThrownValue;
	private int squareIdLandedOnByLastPlayerWhoPlayed;
	private boolean gameOver;

	public BoardLastTurnAPI(int lastPlayerIdWhoPlayed, int lastDiceThrownValue, int squareIdLandedOnByLastPlayerWhoPlayed, boolean gameOver) {
		this.lastPlayerIdWhoPlayed = lastPlayerIdWhoPlayed;
		this.lastDiceThrownValue = lastDiceThrownValue;
		this.squareIdLandedOnByLastPlayerWhoPlayed = squareIdLandedOnByLastPlayerWhoPlayed;
		this.gameOver = gameOver;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	@Override
	public String toString() {
		return "BoardLastTurnAPI [lastPlayerIdWhoPlayed=" + lastPlayerIdWhoPlayed + ", lastDiceThrownValue="
				+ lastDiceThrownValue + ", squareIdLandedOnByLastPlayerWhoPlayed="
				+ squareIdLandedOnByLastPlayerWhoPlayed + ", gameOver=" + gameOver + "]";
	}

}

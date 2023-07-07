package board;

public class BoardLastTurnAPI {

	private int lastPlayerIdWhoPlayed;
	private int squareIdLandedOnByLastPlayerWhoPlayed;

	public BoardLastTurnAPI(int lastPlayerIdWhoPlayed, int squareIdLandedOnByLastPlayerWhoPlayed) {
		this.lastPlayerIdWhoPlayed = lastPlayerIdWhoPlayed;
		this.squareIdLandedOnByLastPlayerWhoPlayed = squareIdLandedOnByLastPlayerWhoPlayed;
	}

	@Override
	public String toString() {
		return "BoardLastTurnAPI [lastPlayerIdWhoPlayed=" + lastPlayerIdWhoPlayed
				+ ", squareIdLandedOnByLastPlayerWhoPlayed=" + squareIdLandedOnByLastPlayerWhoPlayed + "]";
	}

}

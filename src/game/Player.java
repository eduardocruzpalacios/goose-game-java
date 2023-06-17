package game;

public class Player {

	private int id;
	private Board board;

	public Player(int id, Board board) {
		this.id = id;
		this.board = board;
	}

	public int getId() {
		return id;
	}

	private int squareId;

	public void setSquareId(int squareId) {
		this.squareId = squareId;
	}

	public void goTo(int dicesResult) {
		this.board.movePlayerTo(this, this.squareId + dicesResult);
	}

}
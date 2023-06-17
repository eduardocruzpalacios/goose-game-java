package game;

public abstract class Square {

	private int id;
	private Board board;

	public Square(Integer id, Board board) {
		this.id = id;
		this.board = board;
	}

	public int getId() {
		return id;
	}

	abstract public void landedOn();
}

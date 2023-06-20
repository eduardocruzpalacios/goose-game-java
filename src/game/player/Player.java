package game.player;

import game.Board;

public class Player {

	private int id;
	private Board board;
	private int squareId;
	private PlayerState playerState;

	public Player(int id, Board board) {
		this.id = id;
		this.board = board;
	}

	public int getId() {
		return id;
	}

	public void setSquareId(int squareId) {
		this.squareId = squareId;
	}

	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}

	public void goTo(int dicesResult) {
		this.board.movePlayerTo(this, this.squareId + dicesResult);
	}

	public void playTurn() {
		this.playerState.playTurn();
	}

}
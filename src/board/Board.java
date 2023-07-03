package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dice.DiceServiceSingleton;
import game.GooseGameLogicFacade;
import player.Player;
import player.PlayerStateHandler;
import squares.Square;

public class Board {

	private GooseGameLogicFacade gooseGameLogicFacade;
	private Map<Integer, Player> players;
	private int playerIdToPlayNextTurn;
	private Map<Integer, Square> squares;
	private List<Integer> gooseSquaresIds = new ArrayList<>(
			List.of(1, 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59, 63));
	private Map<Integer, Integer> bridgeSquaresIdsMap = new HashMap<Integer, Integer>(Map.of(6, 12, 12, 6));
	private BoardState boardState;
	private final int SQUARES_NUMBER = 63;
	private final int SQUARE_FROM_WHICH_1_DICE_RULE_APPLIES = 60;

	public Board(GooseGameLogicFacade gooseGameLogicFacade, int playersNumber) {
		this.gooseGameLogicFacade = gooseGameLogicFacade;
		this.players = new HashMap<Integer, Player>();
		for (int i = 1; i <= playersNumber; i++) {
			Player player = new Player(i, this);
			PlayerStateHandler.setFirstTurnState(player);
			this.players.put(player.getId(), player);
		}
		this.playerIdToPlayNextTurn = 1;
		BoardStateHandler.setGameRunningState(this);
	}

	public void setBoardState(BoardState boardState) {
		this.boardState = boardState;
	}

	public void playerPlaysTurnAndLandsOnSquare(Player player, int squareId) {
		this.makePlayerGoTo(player, squareId);
		this.giveTurnToNextPlayer();
		Square square = this.squares.get(squareId);
		square.landedOn(player);
	}

	public void makePlayerGoTo(Player player, int squareId) {
		if (squareId > this.SQUARES_NUMBER) {
			player.setSquareId(this.SQUARES_NUMBER - (squareId - this.SQUARES_NUMBER));
		} else {
			if (squareId == this.SQUARES_NUMBER) {
				BoardStateHandler.setGameOverState(this);
			} else if (squareId >= this.SQUARE_FROM_WHICH_1_DICE_RULE_APPLIES) {
				PlayerStateHandler.set1DiceState(player);
			}
			player.setSquareId(squareId);
		}
	}

	public void giveTurnToNextPlayer() {
		if (this.playerIdToPlayNextTurn > this.players.size()) {
			this.playerIdToPlayNextTurn = 1;
		} else {
			this.playerIdToPlayNextTurn++;
		}
	}

	public void movePlayerToNextGooseSquare(Player player, int currentGooseSquareId) {
		int nextGooseSquareId = this.gooseSquaresIds.indexOf(currentGooseSquareId) + 1;
		this.makePlayerGoTo(player, nextGooseSquareId);
		this.givePlayerExtraTurn(player);
	}

	public void givePlayerExtraTurn(Player player) {
		this.playerIdToPlayNextTurn = player.getId();
	}

	public void movePlayerToTheOtherBridgeSquare(Player player, int currentBridgeSquareId) {
		int theOtherBridgeSquareId = this.bridgeSquaresIdsMap.get(currentBridgeSquareId);
		this.makePlayerGoTo(player, theOtherBridgeSquareId);
		this.givePlayerExtraTurn(player);
	}

	public void makePlayerLooseTurns(Player player, int turnsNumber) {
		PlayerStateHandler.setNoTurnsState(player, turnsNumber);
	}

	public void executeLandedOnDiceSquare(Player player, int squareId) {
		this.makePlayerGoTo(player, squareId + DiceServiceSingleton.getInstance().getLastRollValue());
	}

}

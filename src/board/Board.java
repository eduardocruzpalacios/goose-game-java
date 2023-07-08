package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dice.DiceServiceSingleton;
import game.GooseGameLogicFacade;
import player.Player;
import player.PlayerStateHandler;
import squares.BridgeSquare;
import squares.BronzeWellSquare;
import squares.DiceSquare;
import squares.GooseSquare;
import squares.InnSquare;
import squares.JailSquare;
import squares.LabyrinthSquare;
import squares.RegularSquare;
import squares.SkullSquare;
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
		this.createSquares();
		BoardStateHandler.setGameRunningState(this);
	}

	public Map<Integer, Player> getPlayers() {
		return players;
	}

	public int getPlayerIdToPlayNextTurn() {
		return playerIdToPlayNextTurn;
	}

	public void setBoardState(BoardState boardState) {
		this.boardState = boardState;
	}

	private void createSquares() {
		for (Integer gooseSquareId : this.gooseSquaresIds) {
			Square gooseSquare = new GooseSquare(gooseSquareId, this);
			this.squares.put(gooseSquareId, gooseSquare);
		}
		Square bridgeSquare1 = new BridgeSquare(6, this);
		this.squares.put(bridgeSquare1.getId(), bridgeSquare1);
		Square bridgeSquare2 = new BridgeSquare(12, this);
		this.squares.put(bridgeSquare2.getId(), bridgeSquare2);
		Square innSquare = new InnSquare(19, this);
		this.squares.put(innSquare.getId(), innSquare);
		Square diceSquare1 = new DiceSquare(26, this);
		this.squares.put(diceSquare1.getId(), diceSquare1);
		Square diceSquare2 = new DiceSquare(53, this);
		this.squares.put(diceSquare2.getId(), diceSquare2);
		Square labyrinthSquare = new LabyrinthSquare(30, this);
		this.squares.put(labyrinthSquare.getId(), labyrinthSquare);
		Square bronzeWellSquare = new BronzeWellSquare(31, this);
		this.squares.put(bronzeWellSquare.getId(), bronzeWellSquare);
		Square jailSquare = new JailSquare(52, this);
		this.squares.put(jailSquare.getId(), jailSquare);
		Square skullSquare = new SkullSquare(58, this);
		this.squares.put(skullSquare.getId(), skullSquare);
		for (int i = 0; i <= 63; i++) {
			if (this.squares.get(i) == null) {
				Square regulSquare = new RegularSquare(i, this);
				this.squares.put(i, regulSquare);
			}
		}
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

	public void playNextTurn() {
		this.boardState.playNextTurn();
	}

	public BoardLastTurnAPI getBoardLastTurnAPI() {
		int playerIdWhoPlayed;
		if (this.playerIdToPlayNextTurn == 1) {
			playerIdWhoPlayed = this.players.size();
		} else {
			playerIdWhoPlayed = this.playerIdToPlayNextTurn - 1;
		}
		return new BoardLastTurnAPI(playerIdWhoPlayed, this.players.get(playerIdWhoPlayed).getSquareId());
	}

}

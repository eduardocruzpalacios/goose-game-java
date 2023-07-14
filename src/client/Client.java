package client;

import board.BoardLastTurnAPI;
import game.GooseGameLogicFacade;

public class Client {

	public static void main(String[] args) {
		GooseGameLogicFacade gooseGameLogicFacade = new GooseGameLogicFacade();
		gooseGameLogicFacade.initGame(3);
		boolean exit = false;
		while (!exit) {
			BoardLastTurnAPI boardLastTurnAPI = gooseGameLogicFacade.playNextTurn();
			System.out.println(boardLastTurnAPI);
			if (boardLastTurnAPI.isGameOver()) {
				exit = true;
			}
		}
	}

}
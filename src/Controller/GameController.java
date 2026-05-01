package Controller;

import Model.Game;
import Model.Player;
import Strategy.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension,
                          List<Player> playerList,
                          List<WinningStrategy> winningStrategyList){
        return Game.getBuilder().
                setDimension(dimension).
                setPlayers(playerList).
                setWinningStrategy(winningStrategyList).
                build();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }
}

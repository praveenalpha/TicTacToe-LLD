import Controller.GameController;
import ENUM.GameState;
import ENUM.PlayerType;
import Model.Game;
import Model.Player;
import Model.Symbol;
import Strategy.WinningStrategy.ColWinningStrategy;
import Strategy.WinningStrategy.DiaWinningStrategy;
import Strategy.WinningStrategy.RowWinningStrategy;
import Strategy.WinningStrategy.WinningStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    System.out.println("Hello World ! ");

    Symbol sp1 = new Symbol('O', null);
    Player p1 = new Player(sp1, "Praveen", PlayerType.HUMAN);
    Symbol sp2 = new Symbol('X', null);
    Player p2 = new Player(sp2, "Khem", PlayerType.HUMAN);
    List<Player> playerList = new ArrayList<>();
    playerList.add(p1);
    playerList.add(p2);

    List<WinningStrategy> winningStrategyList = new ArrayList<>();
    winningStrategyList.add(new RowWinningStrategy());
    winningStrategyList.add(new ColWinningStrategy());
    winningStrategyList.add(new DiaWinningStrategy());

    GameController gameController = new GameController();
    Game newGame = gameController.startGame(3, playerList, winningStrategyList);

    while(newGame.getGameState().equals(GameState.IN_PROGRESS)){
        // print board for client to see
        gameController.printBoard(newGame);
        gameController.makeMove(newGame);
    }
    System.out.println("#################################################");
    gameController.printBoard(newGame);
    if(newGame.getGameState().equals(GameState.ENDED)){
        System.out.println("Player " + newGame.getWinner().getName() + " has WON the game !!!!!");
    }
    else if(newGame.getGameState().equals(GameState.DRAW)){
        System.out.println("It's a DRAW");
    }
}

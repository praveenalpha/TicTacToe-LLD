package Model;

import java.util.*;

import ENUM.CellState;
import ENUM.GameState;
import Strategy.WinningStrategy.WinningStrategy;

public class Game {
    private Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private Player winner;
    private int nextPlayerTurnIndex;
    private GameState gameState;
    private List<WinningStrategy> winningStrategyList;

    public static Builder getBuilder(){
        return new Builder();
    }

    private Game(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategyList){
        this.board = new Board(dimension);
        this.playerList = playerList;
        this.moveList = new ArrayList<>();
        this.winner = null;
        this.nextPlayerTurnIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategyList = winningStrategyList;
    }

    public boolean checkWinner(Move move){
        for(WinningStrategy winningStrategy: winningStrategyList){
            if(winningStrategy.checkWinner(move, board.getDimension()))
                return true;
        }
        return false;
    }
    public void printBoard(){
        board.printBoard();
    }

    private boolean validateMove(int row, int col){
        if(row < 0 || col < 0 || row >= board.getDimension() || col >= board.getDimension())
                return false;
        if(board.getBoard().get(row).get(col).getCellState() != CellState.EMPTY)
                return false;
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerTurnIndex() {
        return nextPlayerTurnIndex;
    }

    public void setNextPlayerTurnIndex(int nextPlayerTurnIndex) {
        this.nextPlayerTurnIndex = nextPlayerTurnIndex;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }

    public void makeMove(){
        // who's turn it is?
        Player currentPlayer = playerList.get(nextPlayerTurnIndex);
        System.out.println("It's " + currentPlayer.getName() + "'s turn :");

        // ask the player to make a move
        Cell dummyCell = currentPlayer.chooseCellToPlay(board);
        int row  = dummyCell.getRow();
        int col = dummyCell.getCol();

        if(!validateMove(row, col)){
            System.out.println("It's an invalid move, you can choose again");
            return;
        }

        // mark the cell with current player
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move move = new Move(currentPlayer, cell);
        moveList.add(move);

        nextPlayerTurnIndex = (nextPlayerTurnIndex + 1) % playerList.size();

        // check whether this move is a winning move
        if(checkWinner(move)){
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }
        else if(moveList.size() == board.getDimension() * board.getDimension()){
            gameState = GameState.DRAW;
        }

        // do we need tp validate other players inspection or approval before making this move?
        // Not in current requirement

        return;
    }
    public static class Builder{
        private int dimension;
        private List<Player> playerList;
        private List<WinningStrategy> winningStrategyList;


        public Game build(){
            validate();
            return new Game(dimension, playerList, winningStrategyList);
        }

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.playerList = players;
            return this;
        }

        public Builder setWinningStrategy(List<WinningStrategy> winningStrategyList){
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        private void validatePlayerCount() {
            // yet to be done
//            if(playerList.size() != dimension - 1)
//                throw new PlayerCountNotValidException("Player's count iequal to dimension -1");
        }

        private void validateUniqueSymbols(){
//            HashSet<Character> symbols = new HashSet<Character>();
//            for(Player player : playerList){
//                Character symbol = player
//            }
        }

        private void validateBotCount() {
            // yet to be done
        }

        private void validate(){
            validatePlayerCount();
            validateUniqueSymbols();
            validateBotCount();
        }

    }

    public GameState getGameState(){
        return this.gameState;
    }
}

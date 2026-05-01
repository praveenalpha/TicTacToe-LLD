package Model;

import ENUM.PlayerType;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private String name;
    private PlayerType playerType;
    private Scanner scanner = new Scanner(System.in);

    public Player(Symbol symbol, String name, PlayerType playerType){
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Cell chooseCellToPlay(Board board){
        System.out.println("Enter the row you want to play on: ");
        int row = scanner.nextInt();

        System.out.println("Enter coloumn you want to play on: ");
        int col = scanner.nextInt();

        return new Cell(row, col);
    }
    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}

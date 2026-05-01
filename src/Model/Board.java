package Model;

import ENUM.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension){
        this.dimension = dimension;
        this.board = new ArrayList<>();

        for(int i=0;i<dimension;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<dimension;j++){
                row.add(new Cell(i, j));
            }
            this.board.add(row);
        }
    }
    
    public void printBoard(){
        System.out.println("---------------");
        for(List<Cell> row: board){
            for(Cell cell : row){
                if(cell.getCellState() == CellState.EMPTY){
                    System.out.print("|   |");
                }
                else if(cell.getCellState() == CellState.FILLED){
                    System.out.print("| " + cell.getPlayer().getSymbol().getSymbol() + " |");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
    public List<List<Cell>> getBoard(){
        return this.board;
    }

    public int getDimension(){
        return this.dimension;
    }
}

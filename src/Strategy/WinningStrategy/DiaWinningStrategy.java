package Strategy.WinningStrategy;

import Model.Move;
import Model.Player;
import Model.Symbol;

import java.util.HashMap;

public class DiaWinningStrategy implements WinningStrategy{
    HashMap<Symbol, Integer> dia1 = new HashMap<>();
    HashMap<Symbol, Integer> dia2 = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int size){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            dia1.put(symbol, dia1.getOrDefault(symbol, 0) + 1);
            if(dia1.get(symbol) == size)
                return true;
        }
        if(row + col == size - 1){
            dia2.put(symbol, dia2.getOrDefault(symbol, 0) + 1);
            if(dia2.get(symbol) == size)
                return true;
        }
        return false;
    }
}

package Strategy.WinningStrategy;

import Model.Move;
import Model.Player;
import Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Move move, int size){
        HashMap<Integer, HashMap<Symbol, Integer>> rowHashmap = new HashMap<>();
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowHashmap.containsKey(row)){
            rowHashmap.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> mp = rowHashmap.get(row);

        if(!mp.containsKey(symbol)){
            mp.put(symbol, 1);
        }
        else{
            mp.put(symbol, mp.get(symbol));
        }

        int count = mp.get(symbol);
        if(count == size)
            return true;

        return false;
    }
}

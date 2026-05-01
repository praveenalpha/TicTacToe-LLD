package Strategy.WinningStrategy;

import Model.Move;
import Model.Player;
import Model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Symbol, Integer>>  colHashmap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int size){
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!colHashmap.containsKey(col)){
            colHashmap.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> mp = colHashmap.get(col);

        if(!mp.containsKey(symbol)){
            mp.put(symbol, 1);
        }
        else{
            mp.put(symbol, mp.get(symbol) + 1);
        }

        int count = mp.get(symbol);

        if(count == size)
            return true;

        return false;
    }
}

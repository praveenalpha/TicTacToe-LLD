package Strategy.WinningStrategy;

import Model.Move;
import Model.Player;

public interface WinningStrategy {
    boolean checkWinner(Move move, int size);
}

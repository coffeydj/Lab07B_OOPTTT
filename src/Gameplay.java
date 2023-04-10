import javax.swing.*;
import java.util.Vector;

public class Gameplay {
    public static String switchTurn(String turn) {
        if (turn.equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }

    public static boolean whoWins(String turn, Vector<Vector<JButton>> buttons) {
        return isColWin(buttons, turn) || isRowWin(buttons, turn) || isDiagonalWin(buttons, turn);
    }

    private static boolean isColWin(Vector<Vector<JButton>> buttons, String turn) {
        for (int v = 0; v < 3; v++) {
            if (buttons.get(v).get(0).getText().equals(turn) && buttons.get(v).get(1).getText().equals(turn) && buttons.get(v).get(2).getText().equals(turn)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(Vector<Vector<JButton>> buttons, String turn) {
        for (int v = 0; v < 3; v++) {
            if (buttons.get(0).get(v).getText().equals(turn) && buttons.get(1).get(v).getText().equals(turn) && buttons.get(2).get(v).getText().equals(turn)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(Vector<Vector<JButton>> buttons, String turn) {
        return (buttons.get(0).get(0).getText().equals(turn) && buttons.get(1).get(1).getText().equals(turn) && buttons.get(2).get(2).getText().equals(turn)) || (buttons.get(2).get(0).getText().equals(turn) && buttons.get(1).get(1).getText().equals(turn) && buttons.get(0).get(2).getText().equals(turn));
    }
}
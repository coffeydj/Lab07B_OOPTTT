import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class TTTTileButton {
    public static void resetOrSet(Vector<JButton> buttons, int choice, JTextArea results, JFrame frame, Vector<Vector<JButton>> buttonTable) {
        if (choice == 1) {
            //Re-enables all the buttons and resetting their text
            for (JButton button : buttons) {
                button.setEnabled(true);
                button.setText("");
            }

            //Begins on turn X again
            TTTFrame.t.setTurn("X");
            TTTFrame.updateTextBox("It's" + TTTFrame.t.getTurn() + "'s turn\n", results);
        } else {
            for (JButton button : buttons) {
                //Not sure what this means, but it makes the button not grey out the text when deactivated
                button.setUI(new MetalButtonUI() {
                    protected Color getDisabledTextColor() {
                        return Color.BLACK;
                    }
                });

                //Gives the button the action when pressed
                button.addActionListener((ActionEvent ae) -> buttonClick(button, buttons, frame, buttonTable));

                //Removes focus on the text for better style
                button.setFocusable(false);

                //Sets its background color to white and changes the font size to arial and size 30
                button.setBackground(Color.WHITE);
                button.setFont(new Font("Arial", Font.BOLD, 30));
            }
        }
    }

    public static void buttonClick(JButton button, Vector<JButton> buttons, JFrame frame, Vector<Vector<JButton>> buttonTable) {
        //Version for the assignment
        if (button.getText().equals("")) {
            button.setText(TTTFrame.t.getTurn());

            //Either someone wins, it becomes a tie or it becomes the next players turn
            if (Gameplay.whoWins(TTTFrame.t.getTurn(), buttonTable)) {
                JOptionPane.showMessageDialog(frame, TTTFrame.t.getTurn() + " Wins!");
                int a = JOptionPane.showConfirmDialog(frame, "Do you want to play again?");
                if (a == JOptionPane.YES_OPTION) {
                    TTTFrame.t.setTurnsPlayed(1);
                    resetOrSet( buttons, 1, TTTFrame.results, frame, buttonTable);
                } else {
                    quit(frame);
                }
            } else if (TTTFrame.t.getTurnsPlayed() == 7) {
                JOptionPane.showMessageDialog(frame, "It's a Tie!");
                int a = JOptionPane.showConfirmDialog(frame, "Do you want to play again?");
                if (a == JOptionPane.YES_OPTION) {
                    TTTFrame.t.setTurnsPlayed(1);
                    resetOrSet(buttons, 1, TTTFrame.results, frame, buttonTable);
                } else {
                    System.exit(0);
                }
            } else {
                TTTFrame.t.setTurnsPlayed(TTTFrame.t.getTurnsPlayed() + 1);
                TTTFrame.t.setTurn(Gameplay.switchTurn(TTTFrame.t.getTurn()));
                TTTFrame.updateTextBox("It's " + TTTFrame.t.getTurn() + "'s turn.\n", TTTFrame.results);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "That already holds a value.");
        }
    }

    public static void quit(JFrame frame) {
        JOptionPane.showMessageDialog(frame, TTTFrame.t.getTurn() + " Quit.");
        System.exit(0);
    }
}

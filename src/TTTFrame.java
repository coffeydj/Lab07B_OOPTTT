import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class TTTFrame extends JFrame {
    public static Turn t = new Turn("X", 0);
    Vector<Vector<JButton>> buttons = new Vector<>();
    Vector<JButton> justButton = new Vector<>();

    JFrame frame;
    JPanel main;

    JPanel table;
    JButton tLeft;
    JButton tMiddle;
    JButton tRight;
    JButton mLeft;
    JButton middle;
    JButton mRight;
    JButton bLeft;
    JButton bMiddle;
    JButton bRight;

    JPanel info;
    static JTextArea results;
    JScrollPane scroll;

    JPanel options;
    JButton quit;

    public TTTFrame() { //Sets up the frame
        Toolkit kit = Toolkit.getDefaultToolkit();
        frame = new JFrame();
        main = new JPanel();

        main.setLayout(new BorderLayout());
        frame.setTitle("Tic Tac Toe");

        table();
        main.add(table, BorderLayout.NORTH);

        info();
        main.add(info, BorderLayout.CENTER);

        options();
        main.add(options, BorderLayout.SOUTH);

        frame.add(main);
        results.append("It's X's turn\n");

        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        frame.setSize(screenWidth / 2, screenHeight / 2);
        frame.setLocation(screenWidth / 4, screenHeight / 4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public void table() { //Table panel
        Vector<JButton> row = new Vector<>();

        //Sets the table panel and gives it a grid layout with spacing
        table = new JPanel();
        table.setLayout(new GridLayout(3, 3));
        table.setBorder(new EmptyBorder(10, 10, 10, 10));

        //Creates all the buttons, then adds them to a vector for easy updating
        tLeft = new JButton();
        tLeft.setPreferredSize(new Dimension(50, 50)); // Sets the size for all buttons
        justButton.add(tLeft);
        tMiddle = new JButton();
        justButton.add(tMiddle);
        tRight = new JButton();
        justButton.add(tRight);
        mLeft = new JButton();
        justButton.add(mLeft);
        middle = new JButton();
        justButton.add(middle);
        mRight = new JButton();
        justButton.add(mRight);
        bLeft = new JButton();
        justButton.add(bLeft);
        bMiddle = new JButton();
        justButton.add(bMiddle);
        bRight = new JButton();
        justButton.add(bRight);

        //Sets the buttons up
        TTTTileButton.resetOrSet(justButton, 2, results, frame, buttons);

        //Adds all the buttons to the grid panel
        table.add(tLeft);
        table.add(tMiddle);
        table.add(tRight);
        table.add(mLeft);
        table.add(middle);
        table.add(mRight);
        table.add(bLeft);
        table.add(bMiddle);
        table.add(bRight);

        //Adds rows of vectors with buttons in a 2D vector
        row.add(tLeft);
        row.add(tMiddle);
        row.add(tRight);
        buttons.add(row);
        row = new Vector<>();
        row.add(mLeft);
        row.add(middle);
        row.add(mRight);
        buttons.add(row);
        row = new Vector<>();
        row.add(bLeft);
        row.add(bMiddle);
        row.add(bRight);
        buttons.add(row);
    }

    public void info() { //Info panel
        //Info panel and the text area with a scroll bar
        info = new JPanel();

        results = new JTextArea(10,40);
        results.setEditable(false);

        scroll = new JScrollPane(results);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        info.add(scroll);
    }

    private void options() { //Options panel
        //Options panel and the quit button
        options = new JPanel();

        quit = new JButton("Quit");

        quit.addActionListener((ActionEvent ae) -> TTTTileButton.quit(frame));
        options.add(quit);
    }

    public static void updateTextBox(String prompt, JTextArea results) {
        results.append(prompt);
    }
}

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author p.petropoulos
 */
public class Game extends JPanel {

    private JLabel result;
    private JPanel r1;
    JButton buttons[] = new JButton[9]; 
    private int num = 0; //if even put X else put O

    public Game() {
        setLayout(new GridLayout(3, 3));
        initializeButtons();
    }

    public void initializeButtons() {

        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new ActionButton());
            
            add(buttons[i]); 
        }

    }

    public void resetButtons() {
        for (int i = 0; i <= 8; i++) {
            buttons[i].setText("");
        }
    }

    private class ActionButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked
            if (num % 2 == 0) {
                buttonClicked.setText("X");
            } else {
                buttonClicked.setText("O");
            }

            if (checkForWin() == true) {
                JOptionPane.showConfirmDialog(null, "Game Over.");
                resetButtons();
            }

            num++;

        }

        public boolean checkForWin() {
            //horizontal win check
            if (checkAdjacent(0, 1) && checkAdjacent(1, 2)) //no need to put " == true" because the default check is for true
            {
                return true;
            } else if (checkAdjacent(3, 4) && checkAdjacent(4, 5)) {
                return true;
            } else if (checkAdjacent(6, 7) && checkAdjacent(7, 8)) {
                return true;
            } //vertical win check
            else if (checkAdjacent(0, 3) && checkAdjacent(3, 6)) {
                return true;
            } else if (checkAdjacent(1, 4) && checkAdjacent(4, 7)) {
                return true;
            } else if (checkAdjacent(2, 5) && checkAdjacent(5, 8)) {
                return true;
            } //diagonal win check
            else if (checkAdjacent(0, 4) && checkAdjacent(4, 8)) {
                return true;
            } else if (checkAdjacent(2, 4) && checkAdjacent(4, 6)) {
                return true;
            } else {
                return false;
            }

        }
        
        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
    }

}

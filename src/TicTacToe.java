
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author p.petropoulos
 */
public class TicTacToe {

    
    public static void main(String[] args) {
       JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Game());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
    
}

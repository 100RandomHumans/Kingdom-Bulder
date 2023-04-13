import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KingdomPanel extends JPanel implements MouseListener {
    int xSize = 1600;
    int ySize = 900;

    public KingdomPanel() {
        setBounds(200,200, 1200, 1400);
        setBackground(Color.blue);
        setLayout(null);
        BoardPanel board = new BoardPanel();
        add(board);
        addMouseListener(this);
    }


    public void paintComponent(Graphics g) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addNotify() {
        super.addNotify();
        requestFocus();


    }
}

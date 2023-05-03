import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ScoringPanel extends JPanel implements MouseListener {
    public ScoringPanel(GameLogic gameLogic, GameState gameState, Board board) {

        setBounds(0, 0, 1600, 900);
        setLayout(null);
        setOpaque(false);
        setBackground( new Color(255, 0, 0, 20) );

        addMouseListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageLoader.get("/Pictures/GreyBackground.png"), 0, 0, 1600, 900, null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void addNotify() {
        super.addNotify();
    }
}

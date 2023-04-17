import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InformationPanel extends JPanel implements MouseListener {
    public InformationPanel() {

        setBounds(0, 0, 1600, 900);
        setBackground(Color.blue);
        setLayout(null);
        addMouseListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 900, 900);
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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class KingdomPanel extends JPanel implements MouseListener {
    int xSize = 1600;
    int ySize = 900;

    public KingdomPanel() {
        setBounds(0,0, 1600, 900);
        setBackground(Color.blue);
        setLayout(null);
        BoardPanel board = new BoardPanel();
        add(board);
        addMouseListener(this);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = null;
        try {
            background = ImageIO.read(Objects.requireNonNull(KingdomPanel.class.getResource("/Pictures/Background.png")));
        } catch (IOException e) {
            System.out.println("Failed to get background");
        }
        g.drawImage(background, 0, 0, null);
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


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}

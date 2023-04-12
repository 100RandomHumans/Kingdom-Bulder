import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    public BoardPanel() {
        setLayout(null);

        setBackground(Color.red);
        setSize(500, 500);
    }
    public void paint(Graphics g) {
        g.drawLine(0, 0, 500, 500);
    }
}

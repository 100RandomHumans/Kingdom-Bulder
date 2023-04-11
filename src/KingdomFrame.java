import javax.swing.*;
import java.awt.*;

public class KingdomFrame extends JFrame {
    int x = 1600;
    int y = 900;
    public KingdomFrame() {

        setSize(x, y);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new Panel());
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

}

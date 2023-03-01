import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {

        setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        add(panel);
        setVisible(true);

    }
}

import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FRAME TRANSPARENT");
        frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        frame.setResizable(false);
        Panel panel = new Panel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
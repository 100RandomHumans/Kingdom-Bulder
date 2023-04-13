import javax.swing.*;

public class KingdomFrame extends JFrame {
    int x = 1600;
    int y = 900;
    public KingdomFrame() {

        super("Kingdom Builder But Dumb");



        setLayout(null);
        setBounds(0,0,1600, 939);
        setResizable(false);
        add(new KingdomPanel());
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

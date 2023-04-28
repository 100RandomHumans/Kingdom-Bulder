import javax.swing.*;

public class KingdomFrame extends JFrame {
    int x = 1600;
    int y = 900;
    public KingdomFrame(int houses) {

        super("Kingdom Builder But Dumb");
        setDefaultCloseOperation(3);
        setLayout(null);
        setBounds(0,0,1600, 939);
        setResizable(false);
        add(new KingdomPanel(houses));
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

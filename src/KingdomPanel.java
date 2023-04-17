import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Objects;

public class KingdomPanel extends JPanel implements MouseListener {
    int xSize = 1600;
    int ySize = 900;
    GameLogic gameLogic = new GameLogic();
    InformationPanel informationPanel = new InformationPanel();
    public KingdomPanel() {

        setBounds(0,0, 1600, 900);
        setBackground(Color.blue);
        setLayout(null);
        BoardPanel board = new BoardPanel();

        informationPanel.setVisible(false);
        add(informationPanel);
        add(board);

        addMouseListener(this);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = null;
        try {
            background = ImageIO.read(Objects.requireNonNull(KingdomPanel.class.getResource("/Pictures/Background.jpg")));
        } catch (IOException e) {
            System.out.println("Failed to get background");
        }
        g.drawImage(background, 0, 0, null);


        try {
            System.out.println(gameLogic.cardOne + " " + gameLogic.cardTwo + " " + gameLogic.cardThree);
            String name = "/ObjectiveCards/Objective" + gameLogic.cardOne + ".png";
            Image yourImage = ImageIO.read(Objects.requireNonNull(KingdomPanel.class.getResource(name)));
            Image newImage = yourImage.getScaledInstance(195, 300, Image.SCALE_DEFAULT);
            g.drawImage(newImage, 900, 0, null);
             name = "/ObjectiveCards/Objective" + gameLogic.cardTwo + ".png";
             yourImage = ImageIO.read(Objects.requireNonNull(KingdomPanel.class.getResource(name)));
             newImage = yourImage.getScaledInstance(195, 300, Image.SCALE_DEFAULT);
            g.drawImage(newImage, 900, 300, null);
             name = "/ObjectiveCards/Objective" + gameLogic.cardThree + ".png";
            yourImage = ImageIO.read(Objects.requireNonNull(KingdomPanel.class.getResource(name)));
            newImage = yourImage.getScaledInstance(195, 300, Image.SCALE_DEFAULT);
            g.drawImage(newImage, 900, 600, null);
        } catch (Exception e) {
            System.out.println(e + " when painting the objective cards");
        }
        try {
            Image image = ImageIO.read(KingdomPanel.class.getResource("/Pictures/PlayerBox.png"));
            g.drawImage(image, 1100, 5, null);
            g.drawImage(image, 1100, 210, null);
            g.drawImage(image, 1100, 415, null);
            g.drawImage(image, 1100, 620, null);

        } catch (Exception e) {
            System.out.println(e + " when painting the player area");
        }
        try {
            Image image = ImageIO.read(KingdomPanel.class.getResource("/Pictures/question.png"));
            g.drawImage(image, 1100, 830, null);
        } catch (Exception e) {

        }


    } // end of paintComponent


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("KingdomPanel " + e.getX() + " : " + e.getY());
        if (e.getX() > 1100 && e.getX() < 1165 && e.getY() > 830) {
            informationPanel.setVisible(true);
        }
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

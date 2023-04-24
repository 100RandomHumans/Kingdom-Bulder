import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KingdomPanel extends JPanel implements MouseListener {

    GameLogic gameLogic = new GameLogic();
    InformationPanel informationPanel = new InformationPanel();
    Image houseRed, houseBlue, houseGreen, houseYellow;
    public KingdomPanel() {

        System.out.println(gameLogic.cardOne + " " + gameLogic.cardTwo + " " + gameLogic.cardThree);
        setBounds(0,0, 1600, 900);
        setBackground(Color.blue);
        setLayout(null);
        BoardPanel board = new BoardPanel(gameLogic);

        informationPanel.setVisible(false);
        add(informationPanel);
        add(board);

        addMouseListener(this);
        try {
            houseRed = ImageLoader.get("/Pictures/Houses/HouseRed.png");
            houseBlue = ImageLoader.get("/Pictures/Houses/HouseBlue.png");
            houseGreen = ImageLoader.get("/Pictures/Houses/HouseGreen.png");
            houseYellow = ImageLoader.get("/Pictures/Houses/HouseYellow.png");

        } catch (Exception e) {
            System.out.println("failed to get houses");
        }
    }

    Image background;
    public void paintComponent(Graphics g) {
        background = ImageLoader.get("Pictures/Background.jpg");
        g.drawImage(background, 0, 0, null);


        try {
            Image yourImage = ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardOne + ".png");
            Image newImage = yourImage.getScaledInstance(195, 300, Image.SCALE_DEFAULT);
            g.drawImage(newImage, 900, 0, null);

             yourImage = ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardTwo + ".png");
             newImage = yourImage.getScaledInstance(195, 300, Image.SCALE_DEFAULT);
            g.drawImage(newImage, 900, 300, null);
            yourImage = ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardThree + ".png");
            newImage = yourImage.getScaledInstance(195, 300, Image.SCALE_DEFAULT);
            g.drawImage(newImage, 900, 600, null);
        } catch (Exception e) {
            System.out.println(e + " when painting the objective cards");
        }

            // red

            Image playerBox = ImageLoader.get("/Pictures/PlayerBox.png");
            g.drawImage(playerBox, 1100, 5, null);
            g.drawImage(houseRed.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 10, null);
            if (gameLogic.playerRed.card != null) {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerRed.card + ".png"), 1120, 90, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 90, null);
            }

            // blue

            g.drawImage(playerBox, 1100, 210, null);
            g.drawImage(houseBlue.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 215, null);
            if (gameLogic.playerBlue.card != null) {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerBlue.card + ".png"), 1120, 295, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 295, null);
            }

            // green

            g.drawImage(playerBox, 1100, 415, null);
            g.drawImage(houseGreen.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 420, null);
            if (gameLogic.playerGreen.card != null) {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerGreen.card + ".png"), 1120, 500, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 500, null);
            }

            // yellow

            g.drawImage(playerBox, 1100, 620, null);
            g.drawImage(houseYellow.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 625, null);
            if (gameLogic.playerYellow.card != null) {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerBlue.card + ".png"), 1120, 705, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 705, null);
            }

            Image image = ImageLoader.get("/Pictures/question.png");
            g.drawImage(image, 1100, 830, null);


            for (int i = 0; i < 4; i++) { // top
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 10, null); //red
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerBlue.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 215, null); //blue
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerGreen.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 425, null); //green
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerYellow.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 635, null); //yellow
                //bottom
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 105, null); //red
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerBlue.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 310, null); //blue
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerGreen.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 520, null); //green
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerYellow.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 730, null); //yellow

            }








    } // end of paintComponent


    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("KingdomPanel " + e.getX() + " : " + e.getY());
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

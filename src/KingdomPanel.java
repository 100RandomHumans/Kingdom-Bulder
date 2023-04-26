import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class KingdomPanel extends JPanel implements MouseListener {

    GameLogic gameLogic = new GameLogic();
    GameState gameState = new GameState(gameLogic);
    InformationPanel informationPanel = new InformationPanel();
    Image houseRed, houseBlue, houseGreen, houseYellow;
    Image background;
    Font redressed;
    public KingdomPanel() {
        try {
            redressed = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\chris\\JavaProjects\\ProjectsFolder\\Kingdom-Bulder\\src\\Redressed-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\chris\\JavaProjects\\ProjectsFolder\\Kingdom-Bulder\\src\\Redressed-Regular.ttf")));

        } catch (IOException | FontFormatException e) {
            System.out.println("cant find it");
        }
        setBounds(0, 0, 1600, 900);
        setBackground(Color.blue);
        setLayout(null);
        BoardPanel board = new BoardPanel(gameLogic, gameState);

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

    public void paintComponent(Graphics g) {
        g.setFont(redressed);
        background = ImageLoader.get("Pictures/Background.jpg");
        g.drawImage(background, 0, 0, null);

        g.drawImage(ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardOne + ".png").getScaledInstance(175, 270, Image.SCALE_DEFAULT), 900, 40, null);
        g.drawImage(ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardTwo + ".png").getScaledInstance(175, 270, Image.SCALE_DEFAULT), 900, 315, null);
        g.drawImage(ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardThree + ".png").getScaledInstance(175, 270, Image.SCALE_DEFAULT), 900, 590, null);

        g.drawImage(ImageLoader.get("/Pictures/ContinueButton.png").getScaledInstance(450, 90, Image.SCALE_SMOOTH), 225, 800, null);

        Image playerBox = ImageLoader.get("/Pictures/PlayerBox.png").getScaledInstance(470, 200, Image.SCALE_SMOOTH);

        // red
        g.drawImage(playerBox, 1105, 12, null);
        g.drawImage(houseRed.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 17, null);
        if (gameLogic.playerRed.card != null) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerRed.card + ".png"), 1120, 97, null);
        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 97, null);
        }
        g.drawString(String.valueOf(gameLogic.playerRed.remainingHouses), 1125, 78);

        // blue
        g.drawImage(playerBox, 1105, 237, null);
        g.drawImage(houseBlue.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 242, null);
        if (gameLogic.playerBlue.card != null) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerBlue.card + ".png"), 1120, 322, null);
        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 322, null);
        }
        g.drawString(String.valueOf(gameLogic.playerBlue.remainingHouses), 1125, 303);

        // green
        g.drawImage(playerBox, 1105, 462, null);
        g.drawImage(houseGreen.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 467, null);
        if (gameLogic.playerGreen.card != null) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerGreen.card + ".png"), 1120, 547, null);
        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 547, null);
        }
        g.drawString(String.valueOf(gameLogic.playerBlue.remainingHouses), 1125, 528);

        // yellow
        g.drawImage(playerBox, 1105, 687, null);
        g.drawImage(houseYellow.getScaledInstance(70, 75, Image.SCALE_DEFAULT), 1120, 692, null);
        if (gameLogic.playerYellow.card != null) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerBlue.card + ".png"), 1120, 772, null);
        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 772, null);
        }
        g.drawString(String.valueOf(gameLogic.playerBlue.remainingHouses), 1125, 754);

        for (int i = 0; i < 4; i++) { // top
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 17, null); //red
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerBlue.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 242, null); //blue
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerGreen.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 467, null); //green
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerYellow.specialTokens.get(i) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 692, null); //yellow
            //bottom
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 114, null); //red
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerBlue.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 339, null); //blue
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerGreen.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 564, null); //green
            g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerYellow.specialTokens.get(i + 4) + ".png").getScaledInstance(80, 92, Image.SCALE_DEFAULT), 1195 + (95 * i), 789, null); //yellow

        }

        g.drawImage(ImageLoader.get("/Pictures/Houses/House" + gameLogic.players.get(gameState.turnNum - 1).getColor() + ".png"), 10, 800, null);
        g.drawString(String.valueOf(gameState.turnNum), 25, 860);
    } // end of paintComponent


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X - " + e.getX() + " : Y - " + e.getY() );
        if (e.getX() > 225 && e.getX() < 675 && e.getY() > 800) {
            gameState.nextTurn();
            repaint();

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

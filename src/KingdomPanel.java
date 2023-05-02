import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class KingdomPanel extends JPanel implements MouseListener {

    GameLogic gameLogic = new GameLogic();
    GameState gameState = new GameState(gameLogic);
    ScoringPanel scoringPanel;
    Image houseRed = ImageLoader.get("/Pictures/Houses/HouseRed.png");
    Image houseBlue =  ImageLoader.get("/Pictures/Houses/HouseBlue.png");
    Image houseGreen =ImageLoader.get("/Pictures/Houses/HouseGreen.png");
    Image houseYellow = ImageLoader.get("/Pictures/Houses/HouseYellow.png");
    Image background;
    Image start = ImageLoader.get("/Pictures/Start.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    Font redressed;
    boolean secondTimeRound = false;
    boolean thirdTimeRound = false;
    Image emptyHex = ImageLoader.get("/Pictures/PlayerTiles/TileEmpty.png").getScaledInstance(80, 92, Image.SCALE_DEFAULT);
    public KingdomPanel(int houses) {


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
        BoardPanel board = new BoardPanel(gameLogic, gameState, this);
        scoringPanel = new ScoringPanel(gameLogic, gameState, gameLogic.board);
        scoringPanel.setVisible(false);
        add(scoringPanel);
        add(board);

        addMouseListener(this);
        gameLogic.playerRed.remainingHouses = houses;
        gameLogic.playerBlue.remainingHouses = houses;
        gameLogic.playerGreen.remainingHouses = houses;
        gameLogic.playerYellow.remainingHouses = houses;

    }

    public void paintComponent(Graphics g) {
        g.setFont(redressed);
        background = ImageLoader.get("Pictures/Background.jpg");
        g.drawImage(background, 0, 0, null);

        g.drawImage(ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardOne + ".png"), 900, 30, 175, 270, null);
        g.drawImage(ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardTwo + ".png"), 900, 310, 175, 270, null);
        g.drawImage(ImageLoader.get("/Pictures/ObjectiveCards/Objective" + gameLogic.cardThree + ".png"), 900, 590, 175, 270, null);
        if (gameLogic.housePlaced == 3 || gameState.currentPlayer.remainingHouses == 0) {
            g.drawImage(ImageLoader.get("/Pictures/ContinueButton.png"), 225, 800, 450, 90, null);
        }

        Image playerBox = ImageLoader.get("/Pictures/PlayerBox.png");

        // red
        g.drawImage(playerBox, 1105, 12, 470, 200, null);
        g.drawImage(houseRed, 1120, 17, 70, 75, null);
        if (gameLogic.playerRed.terrain != null && gameState.turnNum == 1) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerRed.terrain + ".png"), 1120, 97, 68, 105, null);
        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 97, null);
        }
        g.drawString(String.valueOf(gameLogic.playerRed.remainingHouses), 1125, 78);

        // blue
        g.drawImage(playerBox, 1105, 237, 470, 200,null);
        g.drawImage(houseBlue, 1120, 242, 70, 75, null);
        if (gameLogic.playerBlue.terrain != null && gameState.turnNum == 2) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerBlue.terrain + ".png"), 1120, 322, 68, 105, null);

        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 322, null);
        }
        g.drawString(String.valueOf(gameLogic.playerBlue.remainingHouses), 1125, 303);

        // green
        g.drawImage(playerBox, 1105, 462, 470, 200, null);
        g.drawImage(houseGreen, 1120, 467, 70, 75,null);
        if (gameLogic.playerGreen.terrain != null && gameState.turnNum == 3) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerGreen.terrain + ".png"), 1120, 547, 68, 105,null);
        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 547, null);
        }
        g.drawString(String.valueOf(gameLogic.playerGreen.remainingHouses), 1125, 528);

        // yellow
        g.drawImage(playerBox, 1105, 687, 470, 200, null);
        g.drawImage(houseYellow, 1120, 692, 70, 75, null);
        if (gameLogic.playerYellow.terrain != null && gameState.turnNum == 4) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerYellow.terrain + ".png"), 1120, 772, 68, 105, null);
        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 772, null);
        }
        g.drawString(String.valueOf(gameLogic.playerYellow.remainingHouses), 1125, 754);

        for (int i = 0; i < 4; i++) { // top // currently takes way too long to load, need to load at begining or make it faster

            if (Objects.equals(gameLogic.playerRed.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 17, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 17, 80, 92,null); //red

            }
            if (Objects.equals(gameLogic.playerBlue.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 242, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 242, 80, 92, null); //red

            }
            if (Objects.equals(gameLogic.playerGreen.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 467, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 467, 80, 92, null); //red

            }
            if (Objects.equals(gameLogic.playerYellow.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 692, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 692, 80, 92, null); //red

            }
            //bottom
            if (Objects.equals(gameLogic.playerRed.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 110, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 110, 80, 92, null); //red

            }
            if (Objects.equals(gameLogic.playerBlue.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 335, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 335, 80, 92, null); //red

            }
            if (Objects.equals(gameLogic.playerGreen.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 560, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 560, 80, 92, null); //red

            }
            if (Objects.equals(gameLogic.playerYellow.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 785, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 785, 80, 92, null); //red

            }
        }
        g.drawImage(start, 1100, 10, null);

        g.drawImage(ImageLoader.get("/Pictures/Houses/House" + gameLogic.players.get(gameState.turnNum - 1).getColor() + ".png"), 10, 800, null);
        // g.drawString(String.valueOf(gameState.turnNum), 25, 860);


    } // end of paintComponent

    Player firstOut = new Player(null);
    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("X - " + e.getX() + " : Y - " + e.getY() );

        if (gameState.currentPlayer.remainingHouses <= 0 && !secondTimeRound && e.getX() > 225 && e.getX() < 675 && e.getY() > 800) { // end game logic
            firstOut = gameState.currentPlayer;
            secondTimeRound = true;
        } else if (firstOut.equals(gameLogic.players.get(gameState.turnNum % 4)) && secondTimeRound && e.getX() > 225 && e.getX() < 675 && e.getY() > 800) {
            scoringPanel.setVisible(true);
            thirdTimeRound = true;
        } else if (thirdTimeRound) {
            scoringPanel.setVisible(true);
        }

        if (e.getX() > 225 && e.getX() < 675 && e.getY() > 800 && !thirdTimeRound && (gameLogic.housePlaced == 3 || gameState.currentPlayer.remainingHouses == 0)) {
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

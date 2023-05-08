import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class KingdomPanel extends JPanel implements MouseListener {
    Image grayTile = ImageLoader.get("/Pictures/PlayerTiles/TileGray.png").getScaledInstance(80, 92, Image.SCALE_DEFAULT);
    GameLogic gameLogic = new GameLogic();
    GameState gameState = new GameState(gameLogic);
    ScoringPanel scoringPanel;
    BoardPanel boardPanel;
    Image houseRed = ImageLoader.get("/Pictures/Houses/HouseRed.png");
    Image houseBlue = ImageLoader.get("/Pictures/Houses/HouseBlue.png");
    Image houseGreen = ImageLoader.get("/Pictures/Houses/HouseGreen.png");
    Image houseYellow = ImageLoader.get("/Pictures/Houses/HouseYellow.png");
    Image background;
    Image start = ImageLoader.get("/Pictures/Start.png").getScaledInstance(45, 45, Image.SCALE_SMOOTH);
    Font redressed;
    boolean secondTimeRound = false;
    boolean thirdTimeRound = false;
    Image emptyHex = ImageLoader.get("/Pictures/PlayerTiles/TileEmpty.png").getScaledInstance(80, 92, Image.SCALE_DEFAULT);
    Player firstOut = new Player(null);

    public KingdomPanel(int houses) {
        try {
            Font uniFont = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(this.getClass().getResourceAsStream("Redressed-Regular.ttf")));
            redressed = uniFont.deriveFont(24f);
        } catch (IOException | FontFormatException e) {
            System.out.println("cant find it");
        }
        setBounds(0, 0, 1600, 900);
        setBackground(Color.blue);
        setLayout(null);
        boardPanel = new BoardPanel(gameLogic, gameState, this, redressed);
        scoringPanel = new ScoringPanel(gameLogic, gameState, gameLogic.board, redressed);
        scoringPanel.setVisible(false);
        add(scoringPanel);
        add(boardPanel);

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
        if ((gameLogic.housePlaced == 3 || gameState.currentPlayer.remainingHouses == 0) && gameState.gameState == 1) {
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
        g.drawImage(playerBox, 1105, 237, 470, 200, null);
        g.drawImage(houseBlue, 1120, 242, 70, 75, null);
        if (gameLogic.playerBlue.terrain != null && gameState.turnNum == 2) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerBlue.terrain + ".png"), 1120, 322, 68, 105, null);

        } else {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Cardback.png"), 1120, 322, null);
        }
        g.drawString(String.valueOf(gameLogic.playerBlue.remainingHouses), 1125, 303);

        // green
        g.drawImage(playerBox, 1105, 462, 470, 200, null);
        g.drawImage(houseGreen, 1120, 467, 70, 75, null);
        if (gameLogic.playerGreen.terrain != null && gameState.turnNum == 3) {
            g.drawImage(ImageLoader.get("/Pictures/TerrainCards/Card" + gameLogic.playerGreen.terrain + ".png"), 1120, 547, 68, 105, null);
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


        for (int i = 0; i < 4; i++) { // top // currently takes way too long to load, need to load at start or make it faster

            if (Objects.equals(gameLogic.playerRed.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 17, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 17, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerRed) && gameState.avilableTiles.get(i).equals("Empty") && !gameLogic.playerRed.specialTokens.get(i).equals("Empty")) {
                    g.drawImage(grayTile, 1195 + (95 * i), 17, 80, 92, null);
                }
            }
            if (Objects.equals(gameLogic.playerBlue.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 242, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerBlue.specialTokens.get(i) + ".png"), 1195 + (95 * i), 242, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerBlue) && gameState.avilableTiles.get(i).equals("Empty") && !gameLogic.playerBlue.specialTokens.get(i).equals("Empty")) {
                    g.drawImage(grayTile, 1195 + (95 * i), 242, 80, 92, null);
                }
            }
            if (Objects.equals(gameLogic.playerGreen.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 467, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerGreen.specialTokens.get(i) + ".png"), 1195 + (95 * i), 467, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerGreen) && gameState.avilableTiles.get(i).equals("Empty") && !gameLogic.playerGreen.specialTokens.get(i).equals("Empty")) {
                    g.drawImage(grayTile, 1195 + (95 * i), 467, 80, 92, null);
                }
            }
            if (Objects.equals(gameLogic.playerYellow.specialTokens.get(i), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 692, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerYellow.specialTokens.get(i) + ".png"), 1195 + (95 * i), 692, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerYellow) && gameState.avilableTiles.get(i).equals("Empty") && !gameLogic.playerYellow.specialTokens.get(i).equals("Empty")) {
                    g.drawImage(grayTile, 1195 + (95 * i), 692, 80, 92, null);
                }
            }
            //bottom
            if (Objects.equals(gameLogic.playerRed.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 110, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerRed.specialTokens.get(i) + ".png"), 1195 + (95 * i), 110, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerRed) && gameState.avilableTiles.get(i + 4).equals("Empty") && !gameLogic.playerRed.specialTokens.get(i + 4).equals("Empty")) {
                    g.drawImage(grayTile, 1195 + (95 * i), 110, 80, 92, null);
                }
            }
            if (Objects.equals(gameLogic.playerBlue.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 335, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerBlue.specialTokens.get(i) + ".png"), 1195 + (95 * i), 335, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerBlue) && gameState.avilableTiles.get(i + 4).equals("Empty") && !gameLogic.playerBlue.specialTokens.get(i + 4).equals("Empty")) {
                    g.drawImage(grayTile, 1195 + (95 * i), 335, 80, 92, null);
                }
            }
            if (Objects.equals(gameLogic.playerGreen.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 560, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerGreen.specialTokens.get(i) + ".png"), 1195 + (95 * i), 560, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerGreen) && gameState.avilableTiles.get(i + 4).equals("Empty") && !gameLogic.playerGreen.specialTokens.get(i + 4).equals("Empty")) {
                    g.drawImage(grayTile, 1195 + (95 * i), 560, 80, 92, null);
                }
            }
            if (Objects.equals(gameLogic.playerYellow.specialTokens.get(i + 4), "Empty")) {
                g.drawImage(emptyHex, 1195 + (95 * i), 785, null);
            } else {
                g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/Tile" + gameLogic.playerYellow.specialTokens.get(i) + ".png"), 1195 + (95 * i), 785, 80, 92, null); //red
                if (gameState.currentPlayer.equals(gameLogic.playerGreen) && gameState.avilableTiles.get(i + 4).equals("Empty") && !gameLogic.playerGreen.specialTokens.get(i + 4).equals("Empty")) {
                    g.drawImage(grayTile, 785 + (95 * i), 560, 80, 92, null);
                }
            }
        }
        g.drawImage(start, 1105, 12 + (225 * gameLogic.players.indexOf(gameState.firstPlayer)), null);

        switch (gameState.gameState) {
            case 1 -> {
                g.drawImage(ImageLoader.get("/Pictures/Houses/House" + gameLogic.players.get(gameState.turnNum - 1).getColor() + ".png"), 10, 800, null);
                g.drawString(String.valueOf(3 - gameLogic.housePlaced), 25, 860);
            }
            case 2 -> g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/TileTower.png"), 10, 800, 70, 80, null);
            case 3 -> g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/TileOracle.png"), 10, 800, 70, 80, null);
            case 4, 6 -> g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/TileHarbor.png"), 10, 800, 70, 80, null);
            case 5, 7 -> g.drawImage(ImageLoader.get("/Pictures/PlayerTiles/TilePaddock.png"), 10, 800, 70, 80, null);
        }
        if (gameLogic.terrainDeck.size() == 0) {
            g.drawString("shuffling", 1118,150 + (225 * ((gameLogic.players.indexOf(gameState.currentPlayer) + 1) % 4) )  );
        }

    } // end of paintComponent

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gameState.currentPlayer.remainingHouses != 0 && gameLogic.housePlaced != 0 && gameLogic.housePlaced != 3) {
            System.out.println("between placing 3 houses, nope");
            return;
        }
        System.out.println("X - " + e.getX() + " : Y - " + e.getY());

        if (gameState.currentPlayer.remainingHouses <= 0 && !secondTimeRound && e.getX() > 225 && e.getX() < 675 && e.getY() > 800) { // end game logic
            firstOut = gameState.currentPlayer;
            secondTimeRound = true;
        } else if (firstOut.equals(gameLogic.players.get(gameState.turnNum % 4)) && secondTimeRound && e.getX() > 225 && e.getX() < 675 && e.getY() > 800) {
            scoringPanel.calculateScores();
            scoringPanel.setVisible(true);
            thirdTimeRound = true;
        } else if (thirdTimeRound) {
            scoringPanel.setVisible(true);
        }
        if (gameState.gameState == 6 || gameState.gameState == 7) {
            return;
        }


        if (e.getX() > 225 && e.getX() < 675 && e.getY() > 800 && !thirdTimeRound && (gameLogic.housePlaced == 3 || gameState.currentPlayer.remainingHouses == 0)) {
            gameState.nextTurn();
            repaint();
            boardPanel.repaint();
            return;
        }

        if (gameState.currentPlayer.equals(gameLogic.playerRed) && (gameLogic.housePlaced == 0 || gameLogic.housePlaced == 3)) { // red
            ArrayList<String> tokens = gameLogic.playerRed.specialTokens;
            if (!tokens.get(0).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 30 && e.getY() < 110 && !gameState.avilableTiles.get(0).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(0));
                gameState.avilableTiles.set(0, "Empty");
            } else if (!tokens.get(1).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 30 && e.getY() < 110 && !gameState.avilableTiles.get(1).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(1));
                gameState.avilableTiles.set(1, "Empty");
            } else if (!tokens.get(2).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 30 && e.getY() < 110 && !gameState.avilableTiles.get(2).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(2));
                gameState.avilableTiles.set(2, "Empty");
            } else if (!tokens.get(3).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 30 && e.getY() < 110 && !gameState.avilableTiles.get(3).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(3));
                gameState.avilableTiles.set(3, "Empty");
            } else if (!tokens.get(4).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 110 && e.getY() < 200 && !gameState.avilableTiles.get(4).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(4));
                gameState.avilableTiles.set(4, "Empty");
            } else if (!tokens.get(5).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 110 && e.getY() < 200 && !gameState.avilableTiles.get(5).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(5));
                gameState.avilableTiles.set(5, "Empty");
            } else if (!tokens.get(6).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 110 && e.getY() < 200 && !gameState.avilableTiles.get(6).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(6));
                gameState.avilableTiles.set(6, "Empty");
            } else if (!tokens.get(7).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 110 && e.getY() < 200 && !gameState.avilableTiles.get(7).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerRed.specialTokens.get(7));
                gameState.avilableTiles.set(7, "Empty");
            } else {
                return;
            }
        }

        if (gameState.currentPlayer.equals(gameLogic.playerBlue) && (gameLogic.housePlaced == 0 || gameLogic.housePlaced == 3)) { // blue
            ArrayList<String> tokens = gameLogic.playerBlue.specialTokens;
            if (!tokens.get(0).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 240 && e.getY() < 330 && !gameState.avilableTiles.get(0).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(0));
                gameState.avilableTiles.set(0, "Empty");
            } else if (!tokens.get(1).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 240 && e.getY() < 330 && !gameState.avilableTiles.get(1).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(1));
                gameState.avilableTiles.set(1, "Empty");
            } else if (!tokens.get(2).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 240 && e.getY() < 330 && !gameState.avilableTiles.get(2).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(2));
                gameState.avilableTiles.set(2, "Empty");
            } else if (!tokens.get(3).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 240 && e.getY() < 330 && !gameState.avilableTiles.get(3).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(3));
                gameState.avilableTiles.set(3, "Empty");
            } else if (!tokens.get(4).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 330 && e.getY() < 420 && !gameState.avilableTiles.get(4).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(4));
                gameState.avilableTiles.set(4, "Empty");
            } else if (!tokens.get(5).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 330 && e.getY() < 420 && !gameState.avilableTiles.get(5).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(5));
                gameState.avilableTiles.set(5, "Empty");
            } else if (!tokens.get(6).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 330 && e.getY() < 420 && !gameState.avilableTiles.get(6).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(6));
                gameState.avilableTiles.set(6, "Empty");
            } else if (!tokens.get(7).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 330 && e.getY() < 420 && !gameState.avilableTiles.get(7).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerBlue.specialTokens.get(7));
                gameState.avilableTiles.set(7, "Empty");
            } else {
                return;
            }
        }

        if (gameState.currentPlayer.equals(gameLogic.playerGreen) && (gameLogic.housePlaced == 0 || gameLogic.housePlaced == 3)) { // green
            ArrayList<String> tokens = gameLogic.playerGreen.specialTokens;
            if (!tokens.get(0).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 470 && e.getY() < 555 && !gameState.avilableTiles.get(0).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(0));
                gameState.avilableTiles.set(0, "Empty");
            } else if (!tokens.get(1).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 470 && e.getY() < 555 && !gameState.avilableTiles.get(1).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(1));
                gameState.avilableTiles.set(1, "Empty");
            } else if (!tokens.get(2).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 470 && e.getY() < 555 && !gameState.avilableTiles.get(2).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(2));
                gameState.avilableTiles.set(2, "Empty");
            } else if (!tokens.get(3).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 470 && e.getY() < 555 && !gameState.avilableTiles.get(3).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(3));
                gameState.avilableTiles.set(3, "Empty");
            } else if (!tokens.get(4).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 555 && e.getY() < 650 && !gameState.avilableTiles.get(4).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(4));
                gameState.avilableTiles.set(4, "Empty");
            } else if (!tokens.get(5).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 555 && e.getY() < 650 && !gameState.avilableTiles.get(5).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(5));
                gameState.avilableTiles.set(5, "Empty");
            } else if (!tokens.get(6).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 555 && e.getY() < 650 && !gameState.avilableTiles.get(6).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(6));
                gameState.avilableTiles.set(6, "Empty");
            } else if (!tokens.get(7).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 555 && e.getY() < 650 && !gameState.avilableTiles.get(7).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerGreen.specialTokens.get(7));
                gameState.avilableTiles.set(7, "Empty");
            } else {
                return;
            }
        }

        if (gameState.currentPlayer.equals(gameLogic.playerYellow) && (gameLogic.housePlaced == 0 || gameLogic.housePlaced == 3)) { // yellow
            ArrayList<String> tokens = gameLogic.playerYellow.specialTokens;
            if (!tokens.get(0).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 690 && e.getY() < 780 && !gameState.avilableTiles.get(0).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(0));
                gameState.avilableTiles.set(0, "Empty");
            } else if (!tokens.get(1).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 690 && e.getY() < 780 && !gameState.avilableTiles.get(1).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(1));
                gameState.avilableTiles.set(1, "Empty");
            } else if (!tokens.get(2).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 690 && e.getY() < 780 && !gameState.avilableTiles.get(2).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(2));
                gameState.avilableTiles.set(2, "Empty");
            } else if (!tokens.get(3).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 690 && e.getY() < 780 && !gameState.avilableTiles.get(3).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(3));
                gameState.avilableTiles.set(3, "Empty");
            } else if (!tokens.get(4).equals("Empty") && e.getX() > 1195 && e.getX() < 1275 && e.getY() > 780 && e.getY() < 875 && !gameState.avilableTiles.get(4).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(4));
                gameState.avilableTiles.set(4, "Empty");
            } else if (!tokens.get(5).equals("Empty") && e.getX() > 1290 && e.getX() < 1370 && e.getY() > 780 && e.getY() < 875 && !gameState.avilableTiles.get(5).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(5));
                gameState.avilableTiles.set(5, "Empty");
            } else if (!tokens.get(6).equals("Empty") && e.getX() > 1385 && e.getX() < 1465 && e.getY() > 780 && e.getY() < 875 && !gameState.avilableTiles.get(6).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(6));
                gameState.avilableTiles.set(6, "Empty");
            } else if (!tokens.get(7).equals("Empty") && e.getX() > 1480 && e.getX() < 1560 && e.getY() > 780 && e.getY() < 875 && !gameState.avilableTiles.get(7).equals("Empty")) {
                gameState.gameState = currentState(gameLogic.playerYellow.specialTokens.get(7));
                gameState.avilableTiles.set(7, "Empty");
            } else {
                return;
            }
        }



        boardPanel.repaint();
        repaint();
    }

    public int currentState(String enter) {
        switch (enter) {
            case "Tower" -> {
                return 2;
            }
            case "Oracle" -> {
                return 3;
            }
            case "Harbor" -> {
                return 4;
            }
            case "Paddock" -> {
                return 5;
            }
            default -> {
                System.out.println("KingdomPanel line 230 return default");
                return 1;
            }
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

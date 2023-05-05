import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class BoardPanel extends JPanel implements MouseListener {
    GameLogic gameLogic;
    GameState gameState;
    Image boardOne, boardTwo, boardThree, boardFour;
    Image houseBlue = ImageLoader.get("/Pictures/PlayerTiles/TileBlue.png").getScaledInstance(44, 50, Image.SCALE_SMOOTH);
    Image houseRed = ImageLoader.get("/Pictures/PlayerTiles/TileRed.png").getScaledInstance(44, 50, Image.SCALE_SMOOTH);
    Image houseGreen = ImageLoader.get("/Pictures/PlayerTiles/TileGreen.png").getScaledInstance(44, 50, Image.SCALE_SMOOTH);
    Image houseYellow = ImageLoader.get("/Pictures/PlayerTiles/TileYellow.png").getScaledInstance(44, 50, Image.SCALE_SMOOTH);
    Image grayTile = ImageLoader.get("/Pictures/PlayerTiles/TileGray.png").getScaledInstance(44, 50, Image.SCALE_SMOOTH);
    KingdomPanel kingdomPanel;
    boolean[][] darken;
    int currentHighlightState = 1;
    SpecialAction specialAction = new SpecialAction();

    AvailableHousePlacement available = new AvailableHousePlacement();

    int holdX, holdY;
    public BoardPanel(GameLogic gameLogic, GameState gameState, KingdomPanel kingdomPanel) {
        this.gameState = gameState;
        this.gameLogic = gameLogic;
        this.kingdomPanel = kingdomPanel;
        setOpaque(false);
        setBounds(0, 0, 900, 800);
        setLayout(null);
        addMouseListener(this);
        boardOne = ImageLoader.get("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[0]));
        boardTwo = ImageLoader.get("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[1]));
        boardThree = ImageLoader.get("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[2]));
        boardFour = ImageLoader.get("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[3]));

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (i % 2 == 0) {
                    gameLogic.board.BoardNoX[i][j].x = 5 + 43 * j + 22;
                } else {
                    gameLogic.board.BoardNoX[i][j].x = 27 + 43 * j + 22;

                }
                gameLogic.board.BoardNoX[i][j].y = 40 + i * 36 + 25;
                if (i > 9) {
                    gameLogic.board.BoardNoX[i][j].y += 2;
                }
            }
        }


    }

    public void paintComponent(Graphics g) {
        super.repaint();
        g.drawImage(boardOne, 5, 40, 451, 375, null);
        g.drawImage(boardTwo, 436, 40, 451, 375, null);
        g.drawImage(boardThree, 5, 405, 451, 371, null);
        g.drawImage(boardFour, 436, 405, 451, 371, null);

        for (int i = 0; i < 20; i++) { // handles the painting
            for (int j = 0; j < 20; j++) {
                if (gameLogic.board.BoardNoX[i][j].hasHouse) {
                    if (Objects.equals(gameLogic.board.BoardNoX[i][j].houseColor, "Blue")) {
                        g.drawImage(houseBlue, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                    }
                    if (Objects.equals(gameLogic.board.BoardNoX[i][j].houseColor, "Red")) {
                        g.drawImage(houseRed, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                    }
                    if (Objects.equals(gameLogic.board.BoardNoX[i][j].houseColor, "Yellow")) {
                        g.drawImage(houseYellow, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                    }
                    if (Objects.equals(gameLogic.board.BoardNoX[i][j].houseColor, "Green")) {
                        g.drawImage(houseGreen, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                    }
                }
            }
        }
        if (!kingdomPanel.thirdTimeRound) {
            switch (gameState.gameState) {
                case 1: // if nothing is selected
                    if (gameLogic.housePlaced < 3 && gameState.currentPlayer.remainingHouses > 0 && !kingdomPanel.thirdTimeRound) { // blackout
                        darken = thirtyToTwenty(available.tilesToHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board));
                        for (int i = 0; i < 20; i++) {

                            for (int j = 0; j < 20; j++) {
                                if (!darken[i][j]) {
                                    g.drawImage(grayTile, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    if (gameState.currentPlayer.remainingHouses > 0 && !kingdomPanel.thirdTimeRound) { // blackout
                        darken = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Tower"));
                        for (int i = 0; i < 20; i++) {
                            for (int j = 0; j < 20; j++) {
                                if (!darken[i][j]) {
                                    g.drawImage(grayTile, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    if (gameState.currentPlayer.remainingHouses > 0 && !kingdomPanel.thirdTimeRound) { // blackout
                        darken = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Oracle"));
                        for (int i = 0; i < 20; i++) {

                            for (int j = 0; j < 20; j++) {
                                if (!darken[i][j]) {
                                    g.drawImage(grayTile, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    if (gameState.currentPlayer.remainingHouses > 0 && !kingdomPanel.thirdTimeRound) { // blackout
                        darken = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Harbor"));
                        for (int i = 0; i < 20; i++) {

                            for (int j = 0; j < 20; j++) {
                                if (!darken[i][j]) {
                                    g.drawImage(grayTile, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    if (gameState.currentPlayer.remainingHouses > 0 && !kingdomPanel.thirdTimeRound) { // blackout
                        darken = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Paddock"));
                        for (int i = 0; i < 20; i++) {
                            for (int j = 0; j < 20; j++) {
                                if (!darken[i][j]) {
                                    g.drawImage(grayTile, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    darken = thirtyToTwenty(specialAction.harbor(gameState.currentPlayer, gameLogic.board));
                    for (int i = 0; i < 20; i++) {
                        for (int j = 0; j < 20; j++) {
                            if (!darken[i][j]) {
                                g.drawImage(grayTile, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                            }
                        }
                    }
                    break;
                case 7:
                    darken = thirtyToTwenty(specialAction.paddock(gameState.currentPlayer, gameLogic.board, holdX, holdY));
                    for (int i = 0; i < 20; i++) {
                        for (int j = 0; j < 20; j++) {
                            if (!darken[i][j]) {
                                g.drawImage(grayTile, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("something fkedUp");
            }
        }
        kingdomPanel.repaint();
    }

    public boolean[][] thirtyToTwenty(boolean[][] b) {

        boolean[][] temp = new boolean[20][20];
        int tracker = 0;
        for (int i = 0; i < 20; i++) {
            System.arraycopy(b[i], tracker, temp[i], 0, 20);
            if (i % 2 == 0) {
                tracker++;
            }
        }
        return temp;
    }

    public void mouseClicked(MouseEvent e) {
        if (kingdomPanel.thirdTimeRound) {
            kingdomPanel.scoringPanel.setVisible(true);
            return;
        }


        if (e.getY() > 800) {
            return;
        } // for testing, will change in the future!

        //System.out.println(e.getX() + " " + e.getY()); fix this later
        int i = 0;
        int j = 0;
        int distance = Integer.MAX_VALUE;
        for (int a = 0; a < 20; a++) {
            for (int b = 0; b < 20; b++) {

                int xDistance = Math.abs(e.getX() - gameLogic.board.BoardNoX[a][b].x);
                int yDistance = Math.abs(e.getY() - gameLogic.board.BoardNoX[a][b].y);
                int holder = (int) Math.sqrt(xDistance * xDistance + yDistance * yDistance);
                if (distance > holder) {
                    i = a;
                    j = b;
                    distance = holder;
                }
            }
        }

        switch (gameState.gameState) {
            case 1:
                System.out.println("called");
                boolean[][] hold = thirtyToTwenty(available.tilesToHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board));
                if (hold[i][j] && gameLogic.housePlaced < 3 && gameState.currentPlayer.remainingHouses != 0) {
                    gameLogic.board.BoardNoX[i][j].hasHouse = true;
                    gameLogic.board.BoardNoX[i][j].houseColor = gameState.currentPlayer.color;
                    gameState.currentPlayer.remainingHouses -= 1;
                    gameLogic.housePlaced++;
                    checkForSpecialActions(i, j);
                }
                break;
            case 2:
                hold = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Tower"));
                if (gameState.currentPlayer.remainingHouses == 0) { // if there are no houses
                    System.out.println("no houses");
                    gameState.gameState = 1;
                    return;
                }
                if (hold[i][j]) {
                    gameLogic.board.BoardNoX[i][j].hasHouse = true;
                    gameLogic.board.BoardNoX[i][j].houseColor = gameState.currentPlayer.color;
                    gameState.currentPlayer.remainingHouses -= 1;
                    checkForSpecialActions(i, j);
                    gameState.gameState = 1;
                }
                break;
            case 3:
                hold = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Oracle"));
                if (gameState.currentPlayer.remainingHouses == 0) { // if there are no houses
                    System.out.println("no houses");
                    return;
                }
                if (hold[i][j]) {
                    gameLogic.board.BoardNoX[i][j].hasHouse = true;
                    gameLogic.board.BoardNoX[i][j].houseColor = gameState.currentPlayer.color;
                    gameState.currentPlayer.remainingHouses -= 1;
                    checkForSpecialActions(i, j);
                    gameState.gameState = 1;
                    break;
                }
            case 4:
                hold = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Harbor"));
                if (gameState.currentPlayer.remainingHouses == 0) { // if there are no houses
                    System.out.println(" houses being placed ");
                    return;
                }
                if (hold[i][j]) {
                    holdX = i;
                    holdY = j;
                    gameState.gameState = 6;
                }
                break;
            case 5:
                hold = thirtyToTwenty(specialAction.specialHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board, "Paddock"));
                if (gameState.currentPlayer.remainingHouses == 0) { // if there are no houses
                    System.out.println(" houses being placed ");
                    return;
                }
                if (hold[i][j]) {
                     holdX = i;
                     holdY = j;
                    gameState.gameState = 7;
                }
                break;
            case 6:
                hold = thirtyToTwenty(specialAction.harbor(gameState.currentPlayer, gameLogic.board));
                if (hold[i][j]) {
                    gameLogic.board.BoardNoX[i][j].hasHouse = true;
                    gameLogic.board.BoardNoX[holdX][holdY].hasHouse = false;
                    gameLogic.board.BoardNoX[i][j].houseColor = gameState.currentPlayer.color;
                    gameLogic.board.BoardNoX[holdX][holdY].houseColor = null;
                    checkForSpecialActions(i, j);
                    gameState.gameState = 1;
                    break;
                }
            case 7:
                hold = thirtyToTwenty(specialAction.paddock(gameState.currentPlayer, gameLogic.board, holdX, holdY));
                if (hold[i][j]) {
                    gameLogic.board.BoardNoX[i][j].hasHouse = true;
                    gameLogic.board.BoardNoX[holdX][holdY].hasHouse = false;
                    gameLogic.board.BoardNoX[i][j].houseColor = gameState.currentPlayer.color;
                    gameLogic.board.BoardNoX[holdX][holdY].houseColor = null;
                    checkForSpecialActions(i, j);
                    gameState.gameState = 1;
                    break;
                }
                default:
                System.out.println("Something messed up BoardPanel 273");
        }


        repaint();
    } // ---------------------------------------- end of mouseClick -----------------------------------------------------------------


    public boolean checkTwice(int a, int b, String color) {
        boolean temp = false;
        for (int i = 0; i < gameLogic.board.Board[a][b].usedPlayers.size(); i++) {
            if (gameLogic.board.Board[a][b].usedPlayers.get(i).equals(color)) {
                temp = true;
                return temp;
            }
        }
        if (gameLogic.board.Board[a][b].usedPlayers.size() == 0) {
            temp = false;
        }
        return temp;
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

    public String switchCase(String cases) {
        return switch (cases) {
            case "oracleBoard" -> "BoardOracle.png";
            case "tavernBoard" -> "BoardTavern.png";
            case "farmBoard" -> "BoardFarm.png";
            case "harborBoard" -> "BoardHarbor.png";
            case "oasisBoard" -> "BoardOasis.png";
            case "towerBoard" -> "BoardTower.png";
            case "paddockBoard" -> "BoardPaddock.png";
            default -> "something messed up switchCase";
        };

    }

    /*
        public boolean[][] removeX(boolean[][] boards) {
            Tile[][] temp = new Tile[20][20];

            for (int i = 0; i < 20; i++) {
                int count = 0;
                for (boolean t : boards[i]) {
                    if (!t.getLocation().equals("x")) {
                        temp[i][count] = t;
                        count++;
                    }
                }
            }

            return temp;

        }
    */
    public void checkForSpecialActions(int i, int j) {
        int jBoard = 0;
        if (i == 0) {
            jBoard = j;
        } else if (i == 1 || i == 2) {
            jBoard = j + 1;
        } else if (i == 3 || i == 4) {
            jBoard = j + 2;
        } else if (i == 5 || i == 6) {
            jBoard = j + 3;
        } else if (i == 7 || i == 8) {
            jBoard = j + 4;
        } else if (i == 9 || i == 10) {
            jBoard = j + 5;
        } else if (i == 11 || i == 12) {
            jBoard = j + 6;
        } else if (i == 13 || i == 14) {
            jBoard = j + 7;
        } else if (i == 15 || i == 16) {
            jBoard = j + 8;
        } else if (i == 17 || i == 18) {
            jBoard = j + 9;
        } else if (i == 19) {
            jBoard = j + 10;
        }

        //left tile
        if (jBoard != 0 && !gameLogic.board.Board[i][jBoard - 1].getLocation().equals("") && gameLogic.board.Board[i][jBoard - 1].numTokensLeft > 0 && !checkTwice(i, jBoard - 1, gameState.currentPlayer.color) && !gameLogic.board.Board[i][jBoard - 1].getLocation().equals("City") && !gameLogic.board.Board[i][jBoard - 1].getLocation().equals("x")) {
            gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i][jBoard - 1].getLocation());
            gameLogic.board.Board[i][jBoard - 1].numTokensLeft--;
            gameLogic.board.Board[i][jBoard - 1].usedPlayers.add(gameState.currentPlayer.color);
        }
        //right tile
        if (jBoard != 29 && !gameLogic.board.Board[i][jBoard + 1].getLocation().equals("") && gameLogic.board.Board[i][jBoard + 1].numTokensLeft > 0 && !checkTwice(i, jBoard + 1, gameState.currentPlayer.color) && !gameLogic.board.Board[i][jBoard + 1].getLocation().equals("City") && !gameLogic.board.Board[i][jBoard + 1].getLocation().equals("x")) {
            gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i][jBoard + 1].getLocation());
            gameLogic.board.Board[i][jBoard + 1].numTokensLeft--;
            gameLogic.board.Board[i][jBoard + 1].usedPlayers.add(gameState.currentPlayer.color);
        }
        //tile above
        if (i != 0 && !gameLogic.board.Board[i - 1][jBoard].getLocation().equals("") && gameLogic.board.Board[i - 1][jBoard].numTokensLeft > 0 && !checkTwice(i - 1, jBoard, gameState.currentPlayer.color) && !gameLogic.board.Board[i - 1][jBoard].getLocation().equals("City") && !gameLogic.board.Board[i - 1][jBoard].getLocation().equals("x")) {
            gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i - 1][jBoard].getLocation());
            gameLogic.board.Board[i - 1][jBoard].numTokensLeft--;
            gameLogic.board.Board[i - 1][jBoard].usedPlayers.add(gameState.currentPlayer.color);
        }
        //tile below
        if (i != 19 && !gameLogic.board.Board[i + 1][jBoard].getLocation().equals("") && gameLogic.board.Board[i + 1][jBoard].numTokensLeft > 0 && !checkTwice(i + 1, jBoard, gameState.currentPlayer.color) && !gameLogic.board.Board[i + 1][jBoard].getLocation().equals("City") && !gameLogic.board.Board[i + 1][jBoard].getLocation().equals("x")) {
            gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i + 1][jBoard].getLocation());
            gameLogic.board.Board[i + 1][jBoard].numTokensLeft--;
            gameLogic.board.Board[i + 1][jBoard].usedPlayers.add(gameState.currentPlayer.color);
        }
        //tile upper left
        if (i != 0 && jBoard != 0 && !gameLogic.board.Board[i - 1][jBoard - 1].getLocation().equals("") && gameLogic.board.Board[i - 1][jBoard - 1].numTokensLeft > 0 && !checkTwice(i - 1, jBoard - 1, gameState.currentPlayer.color) && !gameLogic.board.Board[i - 1][jBoard - 1].getLocation().equals("City") && !gameLogic.board.Board[i - 1][jBoard - 1].getLocation().equals("x")) {
            gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i - 1][jBoard - 1].getLocation());
            gameLogic.board.Board[i - 1][jBoard - 1].numTokensLeft--;
            gameLogic.board.Board[i - 1][jBoard - 1].usedPlayers.add(gameState.currentPlayer.color);
        }
        //tile lower right
        if (i != 19 && jBoard != 29 && !gameLogic.board.Board[i + 1][jBoard + 1].getLocation().equals("") && gameLogic.board.Board[i + 1][jBoard + 1].numTokensLeft > 0 && !checkTwice(i + 1, jBoard + 1, gameState.currentPlayer.color) && !gameLogic.board.Board[i + 1][jBoard + 1].getLocation().equals("City") && !gameLogic.board.Board[i + 1][jBoard + 1].getLocation().equals("x")) {
            gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i + 1][jBoard + 1].getLocation());
            gameLogic.board.Board[i + 1][jBoard + 1].numTokensLeft--;
            gameLogic.board.Board[i + 1][jBoard + 1].usedPlayers.add(gameState.currentPlayer.color);
        }

        //for testing the specialAction token of all players
        System.out.print("Player Blue: ");
        for (int l = 0; l < 8; l++) {
            System.out.print(gameLogic.playerBlue.specialTokens.get(l) + " ");
        }
        System.out.println();
        System.out.print("Player Green: ");
        for (int l = 0; l < 8; l++) {
            System.out.print(gameLogic.playerGreen.specialTokens.get(l) + " ");
        }
        System.out.println();
        System.out.print("Player Yellow: ");
        for (int l = 0; l < 8; l++) {
            System.out.print(gameLogic.playerYellow.specialTokens.get(l) + " ");
        }
        System.out.println();
        System.out.print("Player Red: ");
        for (int l = 0; l < 8; l++) {
            System.out.print(gameLogic.playerRed.specialTokens.get(l) + " ");
        }
        System.out.println("\n");

        //edge case, moving away from special tile removes special tile from player and game
        // go to every special location, check the tiles around it, if all colors stored in that location tiles's color arraylist is still there, do nothing, if not, find color, remove that token from color
/*
        for(int a = 0; a <= 19; a++){
            for(int b = 0; b <= 29; b++){
                if(gameLogic.board.Board[a][b].getLocation().length() >= 4){
                    ArrayList<String> tempLocs = gameLogic.board.Board[a][b].usedPlayers;
                    if(gameLogic.board.Board[a][b-1].hasHouse && gameLogic.board.Board[a][b].usedPlayers.contains(gameLogic.board.Board[a][b-1].houseColor)){
                        tempLocs.remove(gameLogic.board.Board[a][b-1].houseColor);
                    }
                    if(gameLogic.board.Board[a-1][b-1].hasHouse && gameLogic.board.Board[a][b].usedPlayers.contains(gameLogic.board.Board[a-1][b-1].houseColor)){
                        tempLocs.remove(gameLogic.board.Board[a-1][b-1].houseColor);
                    }
                    if(gameLogic.board.Board[a-1][b].hasHouse && gameLogic.board.Board[a][b].usedPlayers.contains(gameLogic.board.Board[a-1][b].houseColor)){
                        tempLocs.remove(gameLogic.board.Board[a-1][b].houseColor);
                    }
                    if(gameLogic.board.Board[a+1][b].hasHouse && gameLogic.board.Board[a][b].usedPlayers.contains(gameLogic.board.Board[a+1][b].houseColor)){
                        tempLocs.remove(gameLogic.board.Board[a+1][b].houseColor);
                    }
                    if(gameLogic.board.Board[a][b+1].hasHouse && gameLogic.board.Board[a][b].usedPlayers.contains(gameLogic.board.Board[a][b+1].houseColor)){
                        tempLocs.remove(gameLogic.board.Board[a][b+1].houseColor);
                    }
                    if(gameLogic.board.Board[a+1][b+1].hasHouse && gameLogic.board.Board[a][b].usedPlayers.contains(gameLogic.board.Board[a+1][b+1].houseColor)){
                        tempLocs.remove(gameLogic.board.Board[a+1][b+1].houseColor);
                    }

                    if(tempLocs.size() != 0){
                        String s = tempLocs.get(0);
                        if(s.equals("Red")){
                            gameLogic.playerRed.specialTokens.remove(gameLogic.board.Board[a][b].getLocation());
                            gameLogic.board.Board[a][b].usedPlayers.remove("Red");
                        }
                        else if(s.equals("Green")){
                            gameLogic.playerGreen.specialTokens.remove(gameLogic.board.Board[a][b].getLocation());
                            gameLogic.board.Board[a][b].usedPlayers.remove("Green");
                        }
                        else if(s.equals("Yellow")){
                            gameLogic.playerYellow.specialTokens.remove(gameLogic.board.Board[a][b].getLocation());
                            gameLogic.board.Board[a][b].usedPlayers.remove("Yellow");
                        }
                        else if(s.equals("Blue")){
                            gameLogic.playerBlue.specialTokens.remove(gameLogic.board.Board[a][b].getLocation());
                            gameLogic.board.Board[a][b].usedPlayers.remove("Blue");
                        }
                    }

                }
            }
        }


 */

    }
}

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

    AvailableHousePlacement available = new AvailableHousePlacement();
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

                    }gameLogic.board.BoardNoX[i][j].y = 40 + i * 36 + 25;
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
//        AvailableHousePlacement availableHouses = new AvailableHousePlacement();
//        gameState.currentPlayer.terrain = "Forest";
//        gameState.currentPlayer.remainingHouses = 40;
//        boolean[][] available = availableHousePlacement.tilesToHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board);
//        boolean[][] temp = thirtyToTwenty(available);
//        for (int i = 0; i < 20; i++) { // handles the painting
//            for (int j = 0; j < 20; j++) {
//                if (temp[i][j]) {
//                   g.drawImage(houseBlue, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);
//
//                }
//            }
//
//        }
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
        kingdomPanel.repaint();
    }
    public boolean[][] thirtyToTwenty(boolean[][] b){

        boolean[][] temp = new boolean[20][20];
        int tracker = 0;
        for(int i = 0; i < 20; i++){
            System.arraycopy(b[i], tracker, temp[i], 0, 20);
            if(i%2 == 0){
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
                int holder = (int)Math.sqrt(xDistance * xDistance + yDistance * yDistance);
                if (distance > holder) {
                    i = a;
                    j = b;
                    distance = holder;
                }
            }
        }
        boolean[][] hold = thirtyToTwenty(available.tilesToHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board));
        if (hold[i][j] && gameLogic.housePlaced < 3 && gameState.currentPlayer.remainingHouses != 0) {
            gameLogic.board.BoardNoX[i][j].hasHouse = true;
            gameLogic.board.BoardNoX[i][j].houseColor = gameState.currentPlayer.color;
            gameState.currentPlayer.remainingHouses -= 1;
            //converts BoardNoX coords in Board coords
            int jBoard = 0;
            if(i==0){jBoard=j;}
            else if(i==1 || i== 2){jBoard=j+1;}
            else if(i==3 || i== 4){jBoard=j+2;}
            else if(i==5 || i== 6){jBoard=j+3;}
            else if(i==7 || i== 8){jBoard=j+4;}
            else if(i==9 || i== 10){jBoard=j+5;}
            else if(i==11 || i== 12){jBoard=j+6;}
            else if(i==13 || i== 14){jBoard=j+7;}
            else if(i==15 || i== 16){jBoard=j+8;}
            else if(i==17 || i== 18){jBoard=j+9;}
            else if(i==19){jBoard=j+10;}
            System.out.println(checkTwice(i,jBoard-1, gameState.currentPlayer.color));
            //left tile
            if(jBoard != 0 && !gameLogic.board.Board[i][jBoard-1].getLocation().equals("") && gameLogic.board.Board[i][jBoard-1].numTokensLeft > 0 && !checkTwice(i,jBoard-1, gameState.currentPlayer.color)){
                gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i][jBoard-1].getLocation());
                gameLogic.board.Board[i][jBoard-1].numTokensLeft--;
                gameLogic.board.Board[i][jBoard-1].usedPlayers.add(gameState.currentPlayer.color);
            }
            //right tile
            if(jBoard != 29 && !gameLogic.board.Board[i][jBoard+1].getLocation().equals("") && gameLogic.board.Board[i][jBoard+1].numTokensLeft > 0 && !checkTwice(i,jBoard+1, gameState.currentPlayer.color)){
                gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i][jBoard+1].getLocation());
                gameLogic.board.Board[i][jBoard+1].numTokensLeft--;
                gameLogic.board.Board[i][jBoard+1].usedPlayers.add(gameState.currentPlayer.color);
            }
            //tile above
            if(i != 0  && !gameLogic.board.Board[i-1][jBoard].getLocation().equals("") && gameLogic.board.Board[i-1][jBoard].numTokensLeft > 0 && !checkTwice(i-1,jBoard, gameState.currentPlayer.color)){
                gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i-1][jBoard].getLocation());
                gameLogic.board.Board[i-1][jBoard].numTokensLeft--;
                gameLogic.board.Board[i-1][jBoard].usedPlayers.add(gameState.currentPlayer.color);
            }
            //tile below
            if(i != 19 && !gameLogic.board.Board[i+1][jBoard].getLocation().equals("") && gameLogic.board.Board[i+1][jBoard].numTokensLeft > 0 && !checkTwice(i+1,jBoard, gameState.currentPlayer.color)){
                gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i+1][jBoard].getLocation());
                gameLogic.board.Board[i+1][jBoard].numTokensLeft--;
                gameLogic.board.Board[i+1][jBoard].usedPlayers.add(gameState.currentPlayer.color);
            }
            //tile upper left
            if(i != 0 && jBoard != 0 && !gameLogic.board.Board[i-1][jBoard-1].getLocation().equals("") && gameLogic.board.Board[i-1][jBoard-1].numTokensLeft > 0 && !checkTwice(i-1,jBoard-1, gameState.currentPlayer.color)){
                gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i-1][jBoard-1].getLocation());
                gameLogic.board.Board[i-1][jBoard-1].numTokensLeft--;
                gameLogic.board.Board[i-1][jBoard-1].usedPlayers.add(gameState.currentPlayer.color);
            }
            //tile lower right
            if(i != 19 && jBoard != 29 && !gameLogic.board.Board[i+1][jBoard+1].getLocation().equals("") && gameLogic.board.Board[i+1][jBoard+1].numTokensLeft > 0 && !checkTwice(i+1,jBoard+1, gameState.currentPlayer.color)){
                gameState.currentPlayer.addSpecialToken(gameLogic.board.Board[i+1][jBoard+1].getLocation());
                gameLogic.board.Board[i+1][jBoard+1].numTokensLeft--;
                gameLogic.board.Board[i+1][jBoard+1].usedPlayers.add(gameState.currentPlayer.color);
            }

            System.out.println();
            for(int l = 0; l < gameState.currentPlayer.specialTokens.size(); l++){
                System.out.print(gameState.currentPlayer.specialTokens.get(l) + " ");
            }

            gameLogic.housePlaced++;
        }
        repaint();
    }
    public boolean checkTwice(int a, int b, String color){
        boolean temp = true;
        for(int i = 0; i < gameLogic.board.Board[a][b].usedPlayers.size(); i++){
            if(gameLogic.board.Board[a][b].usedPlayers.get(i).equals(color)){
                temp = true;
            }
        }
        if(gameLogic.board.Board[a][b].usedPlayers.size() == 0){
            return false;
        }
        return temp;
    }
    @Override
    public void mousePressed(MouseEvent e) {}
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
}

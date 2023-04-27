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

    public BoardPanel(GameLogic gameLogic, GameState gameState) {
        this.gameState = gameState;
        this.gameLogic = gameLogic;
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
        g.drawImage(boardOne.getScaledInstance(451, 375, Image.SCALE_DEFAULT), 5, 40, null);
        g.drawImage(boardTwo.getScaledInstance(451, 375, Image.SCALE_DEFAULT), 436, 40, null);
        g.drawImage(boardThree.getScaledInstance(451, 371, Image.SCALE_DEFAULT), 5, 405, null);
        g.drawImage(boardFour.getScaledInstance(451, 371, Image.SCALE_DEFAULT), 436, 405, null);

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
        AvailableHousePlacement availableHousePlacement = new AvailableHousePlacement();
        gameState.currentPlayer.terrain = "Forest";
        gameState.currentPlayer.remainingHouses = 40;
        boolean[][] available = availableHousePlacement.tilesToHighlight(gameState.currentPlayer, gameState.currentPlayer.terrain, gameLogic.board);
        boolean[][] temp = thirtyToTwenty(available);
        for (int i = 0; i < 20; i++) { // handles the painting
            for (int j = 0; j < 20; j++) {
                if (temp[i][j]) {
                   g.drawImage(houseBlue, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 25, null);

                }
            }

        }

    }
    public boolean[][] thirtyToTwenty(boolean[][] b){
        boolean[][] temp = new boolean[20][20];
        int tracker = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                temp[i][j] = b[i][j+tracker];
            }
            if(i%2 == 0){
                tracker++;
            }
        }
        return temp;
    }
    @Override

    public void mouseClicked(MouseEvent e) {
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
        //System.out.println(i + " " + j);
        int a = 0;
        if(i==0){a = j;} else if(i==1||i==2){a = j+1;} else if(i==3||i==4){a = j+2;} else if(i==5||i==6){a = j+3;}
        else if(i==7||i==8){a = j+4;} else if(i==9||i==10){a = j+5;} else if(i==11||i==12){a = j+6;} else if(i==13||i==14){a = j+7;}
        else if(i==15||i==16){a = j+8;} else if(i==17||i==18){a = j+9;} else if(i==19||i==20){a = j+10;}

        gameLogic.board.Board[i][a].hasHouse = true;
        gameLogic.board.BoardNoX[i][j].hasHouse = true;
        gameLogic.board.BoardNoX[i][j].houseColor = gameState.currentPlayer.color;
        repaint();
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

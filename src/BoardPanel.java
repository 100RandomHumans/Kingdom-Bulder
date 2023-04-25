import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanel extends JPanel implements MouseListener {

    int x = 1;
    GameLogic gameLogic;
    Image boardOne, boardTwo, boardThree, boardFour;
    Image houseBlue = ImageLoader.get("/Pictures/PlayerTiles/TileBlue.png").getScaledInstance(44, 50, Image.SCALE_SMOOTH);

    public BoardPanel(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        setOpaque(false);
        setBounds(0, 0, 900, 900);
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

                    }gameLogic.board.BoardNoX[i][j].y = 40 + i * 36 + 36;
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
        for (int i = 0; i < 20; i++) { // 22 36
            for (int j = 0; j < 20; j++) {
                if (gameLogic.board.BoardNoX[i][j].hasHouse) {
                    g.drawImage(houseBlue, gameLogic.board.BoardNoX[i][j].x - 22, gameLogic.board.BoardNoX[i][j].y - 36, null);
                }

            }
        }




    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
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
        System.out.println(i + " " + j);

        gameLogic.board.BoardNoX[i][j].hasHouse = true;
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

    public String switchCase(String fuck) {
        System.out.println(fuck);
        switch (fuck) {
            case "oracleBoard":
                return "BoardOracle.png";
            case "tavernBoard":
                return "BoardTavern.png";
            case "farmBoard":
                return "BoardFarm.png";
            case "harborBoard":
                return "BoardHarbor.png";

            default:
                return "something messed up switchCase";
        }

    }


}

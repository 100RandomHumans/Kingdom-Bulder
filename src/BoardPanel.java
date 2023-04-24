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
                        gameLogic.board.BoardNoX[i][j].x = 5 + 43 * j;
                    } else {
                        gameLogic.board.BoardNoX[i][j].x = 27 + 43 * j;

                    }gameLogic.board.BoardNoX[i][j].y = 40 + i * 36;
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
                g.drawImage(houseBlue, gameLogic.board.BoardNoX[i][j].x, gameLogic.board.BoardNoX[i][j].y, null);
            }
        }




    }



    @Override
    public void mouseClicked(MouseEvent e) {

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

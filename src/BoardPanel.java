import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanel extends JPanel implements MouseListener {

    int x = 1;
    GameLogic gameLogic;
    Image boardOne, boardTwo, boardThree, boardFour;


    public BoardPanel(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        setOpaque(false);
        setBounds(0, 0, 900, 900);
        setLayout(null);
        addMouseListener(this);
        try {
            boardOne = ImageIO.read(BoardPanel.class.getResource("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[0])));
            boardTwo = ImageIO.read(BoardPanel.class.getResource("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[1])));
            boardThree = ImageIO.read(BoardPanel.class.getResource("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[2])));
            boardFour = ImageIO.read(BoardPanel.class.getResource("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[3])));
        } catch (Exception e) {
            System.out.println("/Pictures/Boards/" + switchCase(gameLogic.board.boardsUsed[0]) + ".png");
            System.out.println("failed to find picture");
        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(boardOne.getScaledInstance(450, 375, Image.SCALE_DEFAULT), 5, 0, null);
        g.drawImage(boardTwo.getScaledInstance(450, 375, Image.SCALE_DEFAULT), 435, 0, null);
        g.drawImage(boardThree.getScaledInstance(450, 375, Image.SCALE_DEFAULT), 5, 365, null);
        g.drawImage(boardFour.getScaledInstance(450, 375, Image.SCALE_DEFAULT), 435, 365, null);





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

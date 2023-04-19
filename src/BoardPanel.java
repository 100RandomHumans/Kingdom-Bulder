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
            boardOne = ImageIO.read(BoardPanel.class.getResource(switchCase(gameLogic.board.boardsUsed[0])));
            boardTwo = ImageIO.read(BoardPanel.class.getResource(switchCase(gameLogic.board.boardsUsed[0])));
            boardThree = ImageIO.read(BoardPanel.class.getResource(switchCase(gameLogic.board.boardsUsed[0])));
            boardFour = ImageIO.read(BoardPanel.class.getResource(switchCase(gameLogic.board.boardsUsed[0])));
        } catch (Exception e) {

        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);





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

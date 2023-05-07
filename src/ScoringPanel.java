import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ScoringPanel extends JPanel implements MouseListener { // discover worker farmer
    Scoring scoring = new Scoring();
    GameLogic gameLogic;
    GameState gameState;
    Board board;
    Image objectiveCity = ImageLoader.get("/Pictures/ObjectiveCards/ObjectiveCityScoring.png");
    Image objectiveDiscoverer = ImageLoader.get("/Pictures/ObjectiveCards/ObjectiveDiscovererScoring.png");
    Image objectiveFarmer = ImageLoader.get("/Pictures/ObjectiveCards/ObjectiveFarmerScoring.png");
    Image objectiveWorker = ImageLoader.get("/Pictures/ObjectiveCards/ObjectiveWorkerScoring.png");
    Image scoreCard = ImageLoader.get("/Pictures/ScoreCard.png");
    Image grayBackground = ImageLoader.get("/Pictures/GreyBackground.png");
    Image houseRed = ImageLoader.get("Pictures/Houses/HouseRed.png");
    Image houseBlue = ImageLoader.get("Pictures/Houses/HouseBlue.png");
    Image houseGreen  = ImageLoader.get("Pictures/Houses/HouseGreen.png");
    Image houseYellow = ImageLoader.get("Pictures/Houses/HouseYellow.png");

    int redOne, redTwo, redThree, redFour, blueOne, blueTwo, blueThree, blueFour, greenOne, greenTwo, greenThree, greenFour, yellowOne, yellowTwo, yellowThree, yellowFour;
    Font font;

    public ScoringPanel(GameLogic gameLogic, GameState gameState, Board board, Font font) {
        this.font = font.deriveFont(50f);
        this.gameLogic = gameLogic;
        this.gameState = gameState;
        this.board = board;
        setBounds(0, 0, 1600, 900);
        setLayout(null);
        setOpaque(false);
        setBackground( new Color(255, 0, 0, 20) );

        addMouseListener(this);
    }
    public void calculateScores() {
        redOne = scoring.getScore("City", gameLogic.playerRed, board);
        redTwo = scoring.getScore("Discoverer", gameLogic.playerRed, board);
        redThree = scoring.getScore("Worker", gameLogic.playerRed, board);
        redFour = scoring.getScore("Farmer", gameLogic.playerRed, board);
        blueOne = scoring.getScore("City", gameLogic.playerBlue, board);
        blueTwo = scoring.getScore("Discoverer", gameLogic.playerBlue, board);
        blueThree = scoring.getScore("Worker", gameLogic.playerBlue, board);
        blueFour = scoring.getScore("Farmer", gameLogic.playerBlue, board);
        greenOne = scoring.getScore("City", gameLogic.playerGreen, board);
        greenTwo = scoring.getScore("Discoverer", gameLogic.playerGreen, board);
        greenThree = scoring.getScore("Worker", gameLogic.playerGreen, board);
        greenFour = scoring.getScore("Farmer", gameLogic.playerGreen, board);
        yellowOne = scoring.getScore("City", gameLogic.playerYellow, board);
        yellowTwo = scoring.getScore("Discoverer", gameLogic.playerYellow, board);
        yellowThree = scoring.getScore("Worker", gameLogic.playerYellow, board);
        yellowFour = scoring.getScore("Farmer", gameLogic.playerYellow, board);


    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font);
        g.drawImage(grayBackground, 0, 0, 1600, 900, null);
        g.drawImage(scoreCard, 575 + 525, 225, 450, 450, null);
        g.drawString("Scores:", 725 + 525, 300);
        g.drawImage(houseRed, 587 + 525, 405, 50, 50, null);
        g.drawImage(houseBlue, 587 + 525, 475, 50, 50, null);
        g.drawImage(houseGreen, 587 + 525, 543, 50, 50, null);
        g.drawImage(houseYellow, 587 + 525, 612, 50, 50, null);
        g.drawImage(objectiveCity, 659 + 525, 335, 50, 50, null);
        g.drawImage(objectiveDiscoverer, 736 + 525, 335, 50, 50, null);
        g.drawImage(objectiveWorker, 811 + 525, 335, 50, 50, null);
        g.drawImage(objectiveFarmer, 885 + 525, 335, 50, 50, null);
        g.drawString(String.valueOf(redOne), 659 + 525, 445);
        g.drawString(String.valueOf(blueOne), 659 + 525, 515);
        g.drawString(String.valueOf(greenOne), 659 + 525, 583);
        g.drawString(String.valueOf(yellowOne), 659 + 525, 652);
        g.drawString(String.valueOf(redTwo), 736 + 525, 445);
        g.drawString(String.valueOf(blueTwo), 736 + 525, 515);
        g.drawString(String.valueOf(greenTwo), 736 + 525, 583);
        g.drawString(String.valueOf(yellowTwo), 736 + 525, 652);
        g.drawString(String.valueOf(redThree), 811 + 525, 445);
        g.drawString(String.valueOf(blueThree), 811 + 525, 515);
        g.drawString(String.valueOf(greenThree), 811 + 525, 583);
        g.drawString(String.valueOf(yellowThree), 811 + 525, 652);
        g.drawString(String.valueOf(redFour), 885 + 525, 445);
        g.drawString(String.valueOf(blueFour), 885 + 525, 515);
        g.drawString(String.valueOf(greenFour), 885 + 525, 583);
        g.drawString(String.valueOf(yellowFour), 885 + 525, 652);
        g.drawString(String.valueOf(redOne + redThree + redTwo + redFour), 959 + 525, 445);
        g.drawString(String.valueOf(blueOne + blueTwo + blueThree + blueFour), 959 + 525, 515);
        g.drawString(String.valueOf(greenOne + greenTwo + greenThree + greenFour), 959 + 525, 583);
        g.drawString(String.valueOf(yellowOne + yellowThree + yellowFour + yellowTwo), 959 + 525, 652);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
        setVisible(false);
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
    }
}

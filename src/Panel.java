import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements MouseListener {
    int xSize = 1600;
    int ySize = 900;
    public Panel () {
        setSize(xSize, ySize);
        addMouseListener(this);
        setLayout(null);
        setBorder(new EmptyBorder(0, 0, 800, 900));
        setBackground(Color.blue);
        BoardPanel boardOne = new BoardPanel();
        BoardPanel boardTwo = new BoardPanel();
        BoardPanel boardThree = new BoardPanel();
        BoardPanel boardFour = new BoardPanel();

        boardOne.setBounds(100, 100, 500, 500);
        boardTwo.setBounds(700, 100, 500, 500);
        boardThree.setBounds(100, 700, 500, 500);
        boardFour.setBounds(700, 700, 500, 500);

        add(boardFour);
        add(boardOne);
        add(boardThree);
        add(boardTwo);

        setVisible(true);
    }


    public void paint(Graphics g) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addNotify() {
        super.addNotify();
        requestFocus();


    }
}

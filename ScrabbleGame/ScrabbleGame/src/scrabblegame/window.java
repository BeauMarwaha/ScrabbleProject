
package scrabblegame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 15troupj
 */
public class window implements MouseListener{
    JFrame window = new JFrame("Scrabble");
    JPanel centerPanel = new JPanel(new GridLayout(15,15,2,2));
    //JScrollPane southPane = new JScrollPane();
    JPanel southPanel = new JPanel(new GridLayout(1,0,2,2));
    JPanel eastPanel = new JPanel(new GridLayout(2,1));
    JPanel buttonsPanel = new JPanel(new GridLayout(4,1));
    JPanel scoresPanel = new JPanel(new GridLayout(3,1));
    JPanel[][] board = new JPanel[15][15];
    JButton[] buttons = new JButton[4];
    JButton[] hand = new JButton[0];
    //JLabel[] stuff = new JLabel[99];
    JLabel scores = new JLabel("Scores: ");
    JLabel playerOne = new JLabel("Player One: ");
    JLabel playerTwo = new JLabel("Player Two: ");
    
    public window(){
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        //window.setSize(872,725);
        Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension (872, 725);
        window.setBounds ( screen.width / 2 - frameSize.width / 2, screen.height / 2 - frameSize.height / 2,frameSize.width, frameSize.height );
        window.add(BorderLayout.CENTER, centerPanel);
        window.add(BorderLayout.SOUTH, southPanel);
        window.add(BorderLayout.EAST, eastPanel);
        
        //SOUTH
        for(int i = 0; i < 9 ; i++){
            //Example 
            
            southPanel.add(new JButton("Hold"));
            
        }
        
        //CENTER
        centerPanel.setBackground(Color.BLACK);
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                board[i][j] = new JPanel();
                centerPanel.add(board[i][j]); 
            }
        }
        //EAST
        eastPanel.add(scoresPanel);
        eastPanel.add(buttonsPanel);
        for(int i = 0; i < 4; i++){
            buttons[i] = new JButton();
            buttons[i].addMouseListener(this);
            buttonsPanel.add(buttons[i]);
        }
        buttons[0].setText("Save");
        buttons[1].setText("Load");
        buttons[2].setText("End Turn");
        buttons[3].setText("Exit");
        
        scores.setPreferredSize(new Dimension(150,50));
        scoresPanel.add(scores);
        scoresPanel.add(playerOne);
        scoresPanel.add(playerTwo);
        
        
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}

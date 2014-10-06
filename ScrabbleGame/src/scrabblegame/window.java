
package scrabblegame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class window implements MouseListener{
    int turnValue = 1;
    int pOneScore = 0;
    int pTwoScore = 0;
    
    JFrame window = new JFrame("Scrabble");
    JPanel centerPanel = new JPanel(new GridLayout(15,15,2,2));
    JPanel southPanel = new JPanel(new GridLayout(1,0,2,2));
    JPanel eastPanel = new JPanel(new GridLayout(2,1));
    JPanel buttonsPanel = new JPanel(new GridLayout(4,1));
    JPanel scoresPanel = new JPanel(new GridLayout(6,1));
    JPanel[][] board = new JPanel[15][15];
    JButton[] buttons = new JButton[5];
    JButton[] hand = new JButton[0];
    JLabel turn = new JLabel("Whose Turn: ");
    JLabel playerOne = new JLabel("Player One Score: ");
    JLabel playerTwo = new JLabel("Player Two Score: ");
    JLabel turnNumber = new JLabel("" + turnValue);
    JLabel playerOneNumber = new JLabel("" + pOneScore);
    JLabel playerTwoNumber = new JLabel("" + pTwoScore);
    
    JPanel infoPanel = new JPanel();
    
    Color myColor = new Color(200,0,0);             

    ImageIcon myPicture = new ImageIcon("src\\pictures\\ScrabbleInfoPanel.png");
    JLabel picLabel = new JLabel(myPicture);
    boolean exchange = false;
    
    Bag theBag = new Bag();
    ArrayList<Tile> playerOneHand = new ArrayList<Tile>();
    ArrayList<Tile> playerTwoHand = new ArrayList<Tile>();
    public window(){
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension (1032, 725);
        window.setBounds ( screen.width / 2 - frameSize.width / 2, screen.height / 2 - frameSize.height / 2,frameSize.width, frameSize.height );
        window.add(BorderLayout.CENTER, centerPanel);
        window.add(BorderLayout.SOUTH, southPanel);
        window.add(BorderLayout.EAST, eastPanel);
        window.add(BorderLayout.WEST, infoPanel);
        
        turn.setFont(new Font("Verdana",1,19));
        playerOne.setFont(new Font("Verdana",1,14));
        playerTwo.setFont(new Font("Verdana",1,14));
        turnNumber.setFont(new Font("Verdana",1,20));
        playerOneNumber.setFont(new Font("Verdana",1,14));
        playerTwoNumber.setFont(new Font("Verdana",1,14));
        
        
        //CENTER
        centerPanel.setBackground(Color.BLACK);
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                board[i][j] = new JPanel();
                centerPanel.add(board[i][j]); 
            }
        }
        //line 1
        board[0][0].setBackground(myColor);
        board[0][3].setBackground(Color.LIGHT_GRAY);        
        board[0][7].setBackground(myColor);
        board[0][11].setBackground(Color.LIGHT_GRAY);
        board[0][14].setBackground(myColor);
        //line 2
        board[1][1].setBackground(Color.GRAY);
        board[1][5].setBackground(Color.DARK_GRAY);
        board[1][9].setBackground(Color.DARK_GRAY);
        board[1][13].setBackground(Color.GRAY);
        //line 3
        board[2][2].setBackground(Color.GRAY);
        board[2][6].setBackground(Color.LIGHT_GRAY);
        board[2][8].setBackground(Color.LIGHT_GRAY);
        board[2][12].setBackground(Color.GRAY);
        //line 4
        board[3][0].setBackground(Color.LIGHT_GRAY);
        board[3][3].setBackground(Color.GRAY);
        board[3][7].setBackground(Color.LIGHT_GRAY);
        board[3][11].setBackground(Color.GRAY);
        board[3][14].setBackground(Color.LIGHT_GRAY);
        //line 5
        board[4][4].setBackground(Color.GRAY); 
        board[4][10].setBackground(Color.GRAY);
        //line 6
        board[5][1].setBackground(Color.DARK_GRAY);
        board[5][5].setBackground(Color.DARK_GRAY);
        board[5][9].setBackground(Color.DARK_GRAY);
        board[5][13].setBackground(Color.DARK_GRAY);
        //line 7
        board[6][2].setBackground(Color.LIGHT_GRAY);
        board[6][6].setBackground(Color.LIGHT_GRAY);
        board[6][8].setBackground(Color.LIGHT_GRAY);
        board[6][12].setBackground(Color.LIGHT_GRAY);
        //line 8
        board[7][0].setBackground(myColor);
        board[7][3].setBackground(Color.LIGHT_GRAY);
        board[7][7].setBackground(Color.BLACK);
        board[7][11].setBackground(Color.LIGHT_GRAY);
        board[7][14].setBackground(myColor);
        //line 9
        board[8][2].setBackground(Color.LIGHT_GRAY);
        board[8][6].setBackground(Color.LIGHT_GRAY);
        board[8][8].setBackground(Color.LIGHT_GRAY);
        board[8][12].setBackground(Color.LIGHT_GRAY);
        //line 10
        board[9][1].setBackground(Color.DARK_GRAY);
        board[9][5].setBackground(Color.DARK_GRAY);
        board[9][9].setBackground(Color.DARK_GRAY);
        board[9][13].setBackground(Color.DARK_GRAY);
        //line 11 
        board[10][4].setBackground(Color.GRAY); 
        board[10][10].setBackground(Color.GRAY);
        //line 12
        board[11][0].setBackground(Color.LIGHT_GRAY);
        board[11][3].setBackground(Color.GRAY);
        board[11][7].setBackground(Color.LIGHT_GRAY);
        board[11][11].setBackground(Color.GRAY);
        board[11][14].setBackground(Color.LIGHT_GRAY);
        //line 13
        board[12][2].setBackground(Color.GRAY);
        board[12][6].setBackground(Color.LIGHT_GRAY);
        board[12][8].setBackground(Color.LIGHT_GRAY);
        board[12][12].setBackground(Color.GRAY);
        //line 14
        board[13][1].setBackground(Color.GRAY);
        board[13][5].setBackground(Color.DARK_GRAY);
        board[13][9].setBackground(Color.DARK_GRAY);
        board[13][13].setBackground(Color.GRAY);
        //line 15
        board[14][0].setBackground(myColor);
        board[14][3].setBackground(Color.LIGHT_GRAY);        
        board[14][7].setBackground(myColor);
        board[14][11].setBackground(Color.LIGHT_GRAY);
        board[14][14].setBackground(myColor);
        
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
        buttons[2].setText("Exchange");
        buttons[3].setText("Exit");
        
        turn.setPreferredSize(new Dimension(75,50));
        scoresPanel.add(turn);
        scoresPanel.add(turnNumber);
        scoresPanel.add(playerOne);
        scoresPanel.add(playerOneNumber);
        scoresPanel.add(playerTwo);
        scoresPanel.add(playerTwoNumber);
        
        //WEST
        infoPanel.add(picLabel);
        Dimension westSize = new Dimension (150, 725);
        infoPanel.setPreferredSize(westSize);
        
        for(int i = 0; i < 7; i++){
            playerOneHand.add(theBag.getBag().pop());
            playerTwoHand.add(theBag.getBag().pop());
        }
        for(int i = 0; i < 7; i++){
            southPanel.add(playerOneHand.get(i).getButton());
            playerOneHand.get(i).getButton().addMouseListener(this);
        }
        for(int i = 0; i < 7; i++){
            System.out.print(playerOneHand.get(i).getLetter());
        }
           
        System.out.println("");
        
        for(int i = 0; i < 7; i++){
            System.out.print(playerTwoHand.get(i).getLetter());
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == buttons[2] && buttons[2].isEnabled()){
            
            JOptionPane.showMessageDialog(centerPanel, "Click on all of the tiles you would like to exchange");
            buttons[4] = new JButton();
            buttons[4].addMouseListener(this);
            southPanel.add(buttons[4]);
            buttons[4].setText("Accept");
            southPanel.updateUI();
            exchange = true;
            buttons[2].setEnabled(false);
            //changeTurn();
        }
        
         for(int i = 0; i < 7; i++){
             if(e.getSource() == playerOneHand.get(i).getButton()){
                 
                 if(turnValue == 1 && exchange && !playerOneHand.get(i).getButton().isEnabled()){
                     playerOneHand.get(i).getButton().setEnabled(true);
                 }
                 if(turnValue == 1 && exchange && playerOneHand.get(i).getButton().isEnabled()){
                     playerOneHand.get(i).getButton().setEnabled(false);
                     
                 }
                 
             }
         }
         for(int i = 0; i < 7; i++){
             if(e.getSource() == playerTwoHand.get(i).getButton()){
                 
                 if(turnValue == 2 && exchange && !playerTwoHand.get(i).getButton().isEnabled()){
                     
                     playerTwoHand.get(i).getButton().setEnabled(true);
                 }
                 if(turnValue == 2 && exchange && playerTwoHand.get(i).getButton().isEnabled()){
                     
                     playerTwoHand.get(i).getButton().setEnabled(false);
                     
                 }
                 
             }
         }
        if(e.getSource() == buttons[4]){
            changeTurn();
        }
        
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
    public void changeTurn(){
        
        if(turnValue == 2){
            southPanel.removeAll();
            
            for(int i = 6; i >= 0; i--){
                if(!playerTwoHand.get(i).getButton().isEnabled()){
                    playerTwoHand.get(i).getButton().setEnabled(true);
                    theBag.getBag().push(playerTwoHand.get(i));
                    playerTwoHand.remove(i);
                    
                }
            }
            theBag.shuffleBag();
            southPanel.removeAll();
            for(int i = 0; i < 7; i++){
                playerTwoHand.add(theBag.getBag().pop());
//                southPanel.add(playerTwoHand.get(i).getButton());
//                playerTwoHand.get(i).getButton().addMouseListener(this);
                southPanel.updateUI();
            }
            buttons[2].setEnabled(true);
            
            for(int i = 0; i < 7; i++){
                southPanel.add(playerOneHand.get(i).getButton());
                playerOneHand.get(i).getButton().addMouseListener(this);
                southPanel.updateUI();
                turnValue = 1;
                turnNumber.setText("" + turnValue);
                exchange = false;
            }
            
        }else{
            southPanel.removeAll();
            
            for(int i = 6; i >= 0; i--){
                if(!playerOneHand.get(i).getButton().isEnabled()){
                    playerOneHand.get(i).getButton().setEnabled(true);
                    theBag.getBag().push(playerOneHand.get(i));
                    playerOneHand.remove(i);
                    
                }
            }
            theBag.shuffleBag();
            southPanel.removeAll();
            for(int i = 0; i < 7; i++){
                playerOneHand.add(theBag.getBag().pop());
//                southPanel.add(playerOneHand.get(i).getButton());
//                playerOneHand.get(i).getButton().addMouseListener(this);
                southPanel.updateUI();
            }
            buttons[2].setEnabled(true);
            for(int i = 0; i < 7; i++){
                southPanel.add(playerTwoHand.get(i).getButton());
                playerTwoHand.get(i).getButton().addMouseListener(this);
                southPanel.updateUI();
                turnValue = 2;
                turnNumber.setText("" + turnValue);
                exchange = false;
            }
            
        }
        System.out.println("");
        for(int i = 0; i < 7; i++){
            System.out.print(playerOneHand.get(i).getLetter());
        }
           
        System.out.println("");
        
        for(int i = 0; i < 7; i++){
            System.out.print(playerTwoHand.get(i).getLetter());
        }
    }
}

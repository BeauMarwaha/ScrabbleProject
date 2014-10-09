
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
    JLabel[] doubLetter = new JLabel[24];
    JLabel[] tripLetter = new JLabel[12];
    JLabel[] doubWord = new JLabel[16];
    JLabel[] tripWord = new JLabel[8];
    
    JPanel infoPanel = new JPanel();
    
    //Default Color Scheme
    Color myColor = new Color(200,0,0);    
    Color myColorTwo = new Color(64,64,64);  
    Color myColorThree = new Color(255,255,255); 
    Color myColorFour = new Color(192, 192, 192);    
    Color myColorFive = new Color(128,128,128);  
    Color myColorSix = new Color(238,238,238);
    
    //Strawberry Shortcake color scheme
//    Color myColor = new Color(167,156,142);    
//    Color myColorTwo = new Color(240,213,184);  
//    Color myColorThree = new Color(255,255,255); 
//    Color myColorFour = new Color(235,159,159);    
//    Color myColorFive = new Color(107,83,68);  
//    Color myColorSix = new Color(248,236,201);
    
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
        
        for(int i = 0; i < 24; i++){
            doubLetter[i] = new JLabel("<html><body>Double<br>Letter</body></html>");
            doubLetter[i].setFont(new Font("Verdana",1,10));
            doubLetter[i].setForeground(Color.WHITE);
        }
        for(int i = 0; i < 12; i++){
            tripLetter[i] = new JLabel("<html><body>Triple<br>Letter</body></html>");
            tripLetter[i].setFont(new Font("Verdana",1,10));
            tripLetter[i].setForeground(Color.WHITE);
        }
        for(int i = 0; i < 16; i++){
            doubWord[i] = new JLabel("<html><body>Double<br>Word</body></html>");
            doubWord[i].setFont(new Font("Verdana",1,10));
            doubWord[i].setForeground(Color.WHITE);
        }
        for(int i = 0; i < 8; i++){
            tripWord[i] = new JLabel("<html><body>Triple<br>Word</body></html>");
            tripWord[i].setFont(new Font("Verdana",1,10));
            tripWord[i].setForeground(Color.WHITE);
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                board[i][j].setBackground(myColorSix);
            }
        }
        //line 1
        board[0][0].setBackground(myColor);
        board[0][3].setBackground(myColorFour);        
        board[0][7].setBackground(myColor);
        board[0][11].setBackground(myColorFour);
        board[0][14].setBackground(myColor);
        
        board[0][0].add(tripWord[0]);
        board[0][3].add(doubLetter[0]);        
        board[0][7].add(tripWord[1]);
        board[0][11].add(doubLetter[1]);
        board[0][14].add(tripWord[2]);
        //line 2
        board[1][1].setBackground(myColorFive);
        board[1][5].setBackground(myColorTwo);
        board[1][9].setBackground(myColorTwo);
        board[1][13].setBackground(myColorFive);
        
        board[1][1].add(doubWord[0]);
        board[1][5].add(tripLetter[0]);
        board[1][9].add(tripLetter[1]);
        board[1][13].add(doubWord[1]);
        //line 3
        board[2][2].setBackground(myColorFive);
        board[2][6].setBackground(myColorFour);
        board[2][8].setBackground(myColorFour);
        board[2][12].setBackground(myColorFive);
        
        board[2][2].add(doubWord[2]);
        board[2][6].add(doubLetter[2]);
        board[2][8].add(doubLetter[3]);
        board[2][12].add(doubWord[3]);
        //line 4
        board[3][0].setBackground(myColorFour);
        board[3][3].setBackground(myColorFive);
        board[3][7].setBackground(myColorFour);
        board[3][11].setBackground(myColorFive);
        board[3][14].setBackground(myColorFour);
        
        board[3][0].add(doubLetter[4]);
        board[3][3].add(doubWord[4]);
        board[3][7].add(doubLetter[5]);
        board[3][11].add(doubWord[5]);
        board[3][14].add(doubLetter[6]);
        //line 5
        board[4][4].setBackground(myColorFive); 
        board[4][10].setBackground(myColorFive);
        
        board[4][4].add(doubWord[6]);
        board[4][10].add(doubWord[7]);
        //line 6
        board[5][1].setBackground(myColorTwo);
        board[5][5].setBackground(myColorTwo);
        board[5][9].setBackground(myColorTwo);
        board[5][13].setBackground(myColorTwo);
        
        board[5][1].add(tripLetter[2]);
        board[5][5].add(tripLetter[3]);
        board[5][9].add(tripLetter[4]);
        board[5][13].add(tripLetter[5]);
        //line 7
        board[6][2].setBackground(myColorFour);
        board[6][6].setBackground(myColorFour);
        board[6][8].setBackground(myColorFour);
        board[6][12].setBackground(myColorFour);
        
        board[6][2].add(doubLetter[7]);
        board[6][6].add(doubLetter[8]);
        board[6][8].add(doubLetter[9]);
        board[6][12].add(doubLetter[10]);
        //line 8
        board[7][0].setBackground(myColor);
        board[7][3].setBackground(myColorFour);
        board[7][7].setBackground(Color.BLACK);
        board[7][11].setBackground(myColorFour);
        board[7][14].setBackground(myColor);
        
        board[7][0].add(tripWord[3]);
        board[7][3].add(doubLetter[11]);
        board[7][11].add(doubLetter[12]);
        board[7][14].add(tripWord[4]);
        //line 9
        board[8][2].setBackground(myColorFour);
        board[8][6].setBackground(myColorFour);
        board[8][8].setBackground(myColorFour);
        board[8][12].setBackground(myColorFour);
        
        board[8][2].add(doubLetter[13]);
        board[8][6].add(doubLetter[14]);
        board[8][8].add(doubLetter[15]);
        board[8][12].add(doubLetter[16]);
        //line 10
        board[9][1].setBackground(myColorTwo);
        board[9][5].setBackground(myColorTwo);
        board[9][9].setBackground(myColorTwo);
        board[9][13].setBackground(myColorTwo);
        
        board[9][1].add(tripLetter[6]);
        board[9][5].add(tripLetter[7]);
        board[9][9].add(tripLetter[8]);
        board[9][13].add(tripLetter[9]);
        //line 11 
        board[10][4].setBackground(myColorFive); 
        board[10][10].setBackground(myColorFive);
        
        board[10][4].add(doubWord[8]);
        board[10][10].add(doubWord[9]);
        //line 12
        board[11][0].setBackground(myColorFour);
        board[11][3].setBackground(myColorFive);
        board[11][7].setBackground(myColorFour);
        board[11][11].setBackground(myColorFive);
        board[11][14].setBackground(myColorFour);
        
        board[11][0].add(doubLetter[17]);
        board[11][3].add(doubWord[10]);
        board[11][7].add(doubLetter[18]);
        board[11][11].add(doubWord[11]);
        board[11][14].add(doubLetter[19]);
        //line 13
        board[12][2].setBackground(myColorFive);
        board[12][6].setBackground(myColorFour);
        board[12][8].setBackground(myColorFour);
        board[12][12].setBackground(myColorFive);
        
        board[12][2].add(doubWord[12]);
        board[12][6].add(doubLetter[20]);
        board[12][8].add(doubLetter[21]);
        board[12][12].add(doubWord[13]);
        //line 14
        board[13][1].setBackground(myColorFive);
        board[13][5].setBackground(myColorTwo);
        board[13][9].setBackground(myColorTwo);
        board[13][13].setBackground(myColorFive);
        
        board[13][1].add(doubWord[14]);
        board[13][5].add(tripLetter[10]);
        board[13][9].add(tripLetter[11]);
        board[13][13].add(doubWord[15]);
        //line 15
        board[14][0].setBackground(myColor);
        board[14][3].setBackground(myColorFour);        
        board[14][7].setBackground(myColor);
        board[14][11].setBackground(myColorFour);
        board[14][14].setBackground(myColor);
        
        board[14][0].add(tripWord[5]);
        board[14][3].add(doubLetter[22]); 
        board[14][7].add(tripWord[6]);
        board[14][11].add(doubLetter[23]);
        board[14][14].add(tripWord[7]);
        
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
        scoresPanel.setBackground(myColorThree);
        
        //WEST
        infoPanel.add(picLabel);
        Dimension westSize = new Dimension (150, 725);
        infoPanel.setPreferredSize(westSize);
        infoPanel.setBackground(myColorThree);
        
        for(int i = 0; i < 7; i++){
            playerOneHand.add(theBag.getBag().pop());
            playerTwoHand.add(theBag.getBag().pop());
        }
        for(int i = 0; i < 7; i++){
            southPanel.add(playerOneHand.get(i).getButton());
            playerOneHand.get(i).getButton().addMouseListener(this);
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
        if(e.getSource() == buttons[4]){
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
                southPanel.add(playerOneHand.get(i).getButton());
                playerOneHand.get(i).getButton().addMouseListener(this);
                southPanel.updateUI();
            }
            buttons[2].setEnabled(true);
            
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
}

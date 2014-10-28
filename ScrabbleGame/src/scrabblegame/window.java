
package scrabblegame;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class window implements MouseListener, ActionListener{
    int turnValue = 1;
    int pOneScore = 0;
    int pTwoScore = 0;
    int firstX;
    int firstY;
    int holdX;
    int holdY;
    
    int lastX;
    int lastY;
    int firstClick = 0;
    boolean rightClick;
    boolean downClick;
    boolean downSkip = false;
    boolean rightSkip = false;
    boolean worked = false;
    JFrame window = new JFrame("Scrabble");
    JPanel centerPanel = new JPanel(new GridLayout(15,15,2,2));
    JPanel southPanel = new JPanel(new GridLayout(1,0,2,2));
    JPanel eastPanel = new JPanel(new GridLayout(2,1));
    JPanel buttonsPanel = new JPanel(new GridLayout(5,1));
    JLabel[] emptyLabels = new JLabel[3];
    JPanel scoresPanel = new JPanel(new GridLayout(6,1));
    JPanel[][] board = new JPanel[15][15];
    JButton[] buttons = new JButton[3];
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
    
    JMenuBar menuBar = new JMenuBar();
    
    JMenu fileMenu = new JMenu("File");
    JMenu themeMenu = new JMenu("Board Theme");
    
    JMenuItem exitAction = new JMenuItem("Exit");
    JMenuItem newGameAction = new JMenuItem("New Game");
    
    JMenuItem themeD = new JMenuItem("Default");
    JMenuItem themeSM = new JMenuItem("Strawberry Mousse");
    JMenuItem themeBT = new JMenuItem("Brown Town");
    JMenuItem themeT = new JMenuItem("Terra");
    JMenuItem themeOF = new JMenuItem("Ocean Five");
    JMenuItem themeGF = new JMenuItem("Good Friends");
    JMenuItem themeNRM = new JMenuItem("Newly Risen Moon");
    JMenuItem themeE = new JMenuItem("Entrapped");
    JMenuItem themeSIFY = new JMenuItem("She Is French, Yes?");
    JMenuItem themeON = new JMenuItem("Omega Nebula");
    JMenuItem themeV = new JMenuItem("Volcanic");
    JMenuItem themeC = new JMenuItem("Classical");
    
    //Default Color Scheme
    //triple word box color
    Color myColor = new Color(200,0,0); 
    //triple letter box color
    Color myColorTwo = new Color(64,64,64);  
    //side panels color
    Color myColorThree = new Color(255,255,255);
    //double letter box color
    Color myColorFour = new Color(192, 192, 192);    
    //double word box color
    Color myColorFive = new Color(128,128,128);  
    //empty box color
    Color myColorSix = new Color(238,238,238);
    
    //Strawberry Mousse color scheme
    Color myColorSM = new Color(167,156,142);    
    Color myColorTwoSM = new Color(240,213,184);  
    Color myColorThreeSM = new Color(255,255,255); 
    Color myColorFourSM = new Color(235,159,159);    
    Color myColorFiveSM = new Color(107,83,68);  
    Color myColorSixSM = new Color(248,236,201);
    
//    Brown Town Color Scheme
    Color myColorBT = new Color(78,42,25);    
    Color myColorTwoBT = new Color(63,30,19);  
    Color myColorThreeBT = new Color(255,255,255); 
    Color myColorFourBT = new Color(237,176,61);    
    Color myColorFiveBT = new Color(25,22,9);  
    Color myColorSixBT = new Color(160,133,82);
    
    //Terra Color Scheme
    Color myColorT = new Color(3,22,52);    
    Color myColorTwoT = new Color(3,54,73);  
    Color myColorThreeT = new Color(255,255,255); 
    Color myColorFourT = new Color(3,101,100);    
    Color myColorFiveT = new Color(205,179,128);  
    Color myColorSixT = new Color(232,221,203);
    
    //Ocean Five Color Scheme
    Color myColorOF = new Color(0,160,176);    
    Color myColorTwoOF = new Color(106,74,60);  
    Color myColorThreeOF = new Color(255,255,255); 
    Color myColorFourOF = new Color(204,51,63);    
    Color myColorFiveOF = new Color(235,104,65);  
    Color myColorSixOF = new Color(237,201,81);
    
    //Good Friends Color Scheme
    Color myColorGF = new Color(153,178,183);    
    Color myColorTwoGF = new Color(122,106,83);  
    Color myColorThreeGF = new Color(255,255,255); 
    Color myColorFourGF = new Color(217,206,178);    
    Color myColorFiveGF = new Color(148,140,117);  
    Color myColorSixGF = new Color(213,222,217);
    
    //Newly Risen Moon Color Scheme
    Color myColorNRM = new Color(54,57,59);    
    Color myColorTwoNRM = new Color(69,72,75);  
    Color myColorThreeNRM = new Color(255,255,255); 
    Color myColorFourNRM = new Color(105,103,88);    
    Color myColorFiveNRM = new Color(197,188,142);  
    Color myColorSixNRM = new Color(238,230,171);
    
    //Entrapped Color Scheme
    Color myColorE = new Color(123,59,59);    
    Color myColorTwoE = new Color(73,55,54);  
    Color myColorThreeE = new Color(255,255,255); 
    Color myColorFourE = new Color(42,40,41);    
    Color myColorFiveE = new Color(102,130,132);  
    Color myColorSixE = new Color(185,215,217);
    
    //She Is French, Yes? Color Scheme
    Color myColorSIFY = new Color(42,44,49);    
    Color myColorTwoSIFY = new Color(90,46,46);  
    Color myColorThreeSIFY = new Color(255,255,255); 
    Color myColorFourSIFY = new Color(62,65,71);    
    Color myColorFiveSIFY = new Color(223,186,105);  
    Color myColorSixSIFY = new Color(255,254,223);
    
    //Omega Nebula Color Scheme
    Color myColorON = new Color(91,117,108);    
    Color myColorTwoON = new Color(116,139,131);  
    Color myColorThreeON = new Color(255,255,255); 
    Color myColorFourON = new Color(154,148,124);    
    Color myColorFiveON = new Color(157,126,121);  
    Color myColorSixON = new Color(204,172,149);
    
    //Volcanic Color Scheme
    Color myColorV = new Color(28,1,19);    
    Color myColorTwoV = new Color(107,1,3);  
    Color myColorThreeV = new Color(255,255,255); 
    Color myColorFourV = new Color(163,0,6);    
    Color myColorFiveV = new Color(194,26,1);  
    Color myColorSixV = new Color(240,60,2);
    
    //Classical Color Scheme
    Color myColorC = new Color(74,72,87);    
    Color myColorTwoC = new Color(133,153,135);  
    Color myColorThreeC = new Color(255,255,255); 
    Color myColorFourC = new Color(109,166,122);    
    Color myColorFiveC = new Color(119,184,133);  
    Color myColorSixC = new Color(134,194,139);
    
    ImageIcon myPicture = new ImageIcon("src\\pictures\\ScrabbleInfoPanel.png");
    JLabel picLabel = new JLabel(myPicture);
    boolean exchange = false;
    boolean clickLetter = false;
    boolean turnOne = true;
    String placedWord = "";
    
    Color colorHold;
    Color colorHoldExtra;
    Bag theBag = new Bag();
    ArrayList<Tile> playerOneHand = new ArrayList<Tile>();
    ArrayList<Tile> playerTwoHand = new ArrayList<Tile>();
    ArrayList<Tile> hold = new ArrayList<Tile>();
    
    int[][] tileType = new int[15][15];
    
    Tile[][] boardLetter = new Tile[15][15];
    Tile[][] boardLetterHold = new Tile[15][15];
    public window(){
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension (1032, 745);
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
        
        window.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(themeMenu);
        
        fileMenu.add(exitAction);
        fileMenu.add(newGameAction);
        
        themeMenu.add(themeD);
        themeMenu.add(themeSM);
        themeMenu.add(themeBT);
        themeMenu.add(themeT);
        themeMenu.add(themeOF);
        themeMenu.add(themeGF);
        themeMenu.add(themeNRM);
        themeMenu.add(themeE);
        themeMenu.add(themeSIFY);
        themeMenu.add(themeON);
        themeMenu.add(themeV);
        themeMenu.add(themeC);
        
        exitAction.addActionListener(this);
        newGameAction.addActionListener(this);
        
        themeD.addActionListener(this);
        themeSM.addActionListener(this);
        themeBT.addActionListener(this);
        themeT.addActionListener(this);
        themeOF.addActionListener(this);
        themeGF.addActionListener(this);
        themeNRM.addActionListener(this);
        themeE.addActionListener(this);
        themeSIFY.addActionListener(this);
        themeON.addActionListener(this);
        themeV.addActionListener(this);
        themeC.addActionListener(this);
        
        //CENTER
        centerPanel.setBackground(Color.BLACK);
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                board[i][j] = new JPanel();
                centerPanel.add(board[i][j]);
                board[i][j].addMouseListener(this);
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
                tileType[i][j] = 0;
            }
        }
        //line 1
        board[0][0].setBackground(myColor);
        board[0][3].setBackground(myColorFour);        
        board[0][7].setBackground(myColor);
        board[0][11].setBackground(myColorFour);
        board[0][14].setBackground(myColor);
        
        board[0][0].add(tripWord[0]);
        tileType[0][0] = 1;
        board[0][3].add(doubLetter[0]);  
        tileType[0][3] = 2;
        board[0][7].add(tripWord[1]);
        tileType[0][7] = 1;
        board[0][11].add(doubLetter[1]);
        tileType[0][11] = 2;
        board[0][14].add(tripWord[2]);
        tileType[0][14] = 1;
        //line 2
        board[1][1].setBackground(myColorFive);
        board[1][5].setBackground(myColorTwo);
        board[1][9].setBackground(myColorTwo);
        board[1][13].setBackground(myColorFive);
        
        board[1][1].add(doubWord[0]);
        tileType[1][1] = 3;
        board[1][5].add(tripLetter[0]);
        tileType[1][5] = 4;
        board[1][9].add(tripLetter[1]);
        tileType[1][9] = 4;
        board[1][13].add(doubWord[1]);
        tileType[1][13] = 3;
        //line 3
        board[2][2].setBackground(myColorFive);
        board[2][6].setBackground(myColorFour);
        board[2][8].setBackground(myColorFour);
        board[2][12].setBackground(myColorFive);
        
        board[2][2].add(doubWord[2]);
        tileType[2][2] = 3;
        board[2][6].add(doubLetter[2]);
        tileType[2][6] = 2;
        board[2][8].add(doubLetter[3]);
        tileType[2][8] = 2;
        board[2][12].add(doubWord[3]);
        tileType[2][12] = 3;
        //line 4
        board[3][0].setBackground(myColorFour);
        board[3][3].setBackground(myColorFive);
        board[3][7].setBackground(myColorFour);
        board[3][11].setBackground(myColorFive);
        board[3][14].setBackground(myColorFour);
        
        board[3][0].add(doubLetter[4]);
        tileType[3][0] = 2;
        board[3][3].add(doubWord[4]);
        tileType[3][3] = 3;
        board[3][7].add(doubLetter[5]);
        tileType[3][7] = 2;
        board[3][11].add(doubWord[5]);
        tileType[3][11] = 3;
        board[3][14].add(doubLetter[6]);
        tileType[3][14] = 2;
        //line 5
        board[4][4].setBackground(myColorFive); 
        board[4][10].setBackground(myColorFive);
        
        board[4][4].add(doubWord[6]);
        tileType[4][4] = 3;
        board[4][10].add(doubWord[7]);
        tileType[4][10] = 3;
        //line 6
        board[5][1].setBackground(myColorTwo);
        board[5][5].setBackground(myColorTwo);
        board[5][9].setBackground(myColorTwo);
        board[5][13].setBackground(myColorTwo);
        
        board[5][1].add(tripLetter[2]);
        tileType[5][1] = 4;
        board[5][5].add(tripLetter[3]);
        tileType[5][5] = 4;
        board[5][9].add(tripLetter[4]);
        tileType[5][9] = 4;
        board[5][13].add(tripLetter[5]);
        tileType[5][13] = 4;
        //line 7
        board[6][2].setBackground(myColorFour);
        board[6][6].setBackground(myColorFour);
        board[6][8].setBackground(myColorFour);
        board[6][12].setBackground(myColorFour);
        
        board[6][2].add(doubLetter[7]);
        tileType[6][2] = 2;
        board[6][6].add(doubLetter[8]);
        tileType[6][6] = 2;
        board[6][8].add(doubLetter[9]);
        tileType[6][8] = 2;
        board[6][12].add(doubLetter[10]);
        tileType[6][12] = 2;
        //line 8
        board[7][0].setBackground(myColor);
        board[7][3].setBackground(myColorFour);
        board[7][7].setBackground(Color.BLACK);
        board[7][11].setBackground(myColorFour);
        board[7][14].setBackground(myColor);
        
        board[7][0].add(tripWord[3]);
        tileType[7][0] = 1;
        board[7][3].add(doubLetter[11]);
        tileType[7][3] = 2;
        board[7][11].add(doubLetter[12]);
        tileType[7][11] = 2;
        board[7][14].add(tripWord[4]);
        tileType[7][14] = 1;
        //line 9
        board[8][2].setBackground(myColorFour);
        board[8][6].setBackground(myColorFour);
        board[8][8].setBackground(myColorFour);
        board[8][12].setBackground(myColorFour);
        
        board[8][2].add(doubLetter[13]);
        tileType[8][2] = 2;
        board[8][6].add(doubLetter[14]);
        tileType[8][6] = 2;
        board[8][8].add(doubLetter[15]);
        tileType[8][8] = 2;
        board[8][12].add(doubLetter[16]);
        tileType[8][12] = 2;
        //line 10
        board[9][1].setBackground(myColorTwo);
        board[9][5].setBackground(myColorTwo);
        board[9][9].setBackground(myColorTwo);
        board[9][13].setBackground(myColorTwo);
        
        board[9][1].add(tripLetter[6]);
        tileType[9][1] = 4;
        board[9][5].add(tripLetter[7]);
        tileType[9][5] = 4;
        board[9][9].add(tripLetter[8]);
        tileType[9][9] = 4;
        board[9][13].add(tripLetter[9]);
        tileType[9][13] = 4;
        //line 11 
        board[10][4].setBackground(myColorFive); 
        board[10][10].setBackground(myColorFive);
        
        board[10][4].add(doubWord[8]);
        tileType[10][4] = 3;
        board[10][10].add(doubWord[9]);
        tileType[10][10] = 3;
        //line 12
        board[11][0].setBackground(myColorFour);
        board[11][3].setBackground(myColorFive);
        board[11][7].setBackground(myColorFour);
        board[11][11].setBackground(myColorFive);
        board[11][14].setBackground(myColorFour);
        
        board[11][0].add(doubLetter[17]);
        tileType[11][0] = 2;
        board[11][3].add(doubWord[10]);
        tileType[11][3] = 3;
        board[11][7].add(doubLetter[18]);
        tileType[11][7] = 2;
        board[11][11].add(doubWord[11]);
        tileType[11][11] = 3;
        board[11][14].add(doubLetter[19]);
        tileType[11][14] = 2;
        //line 13
        board[12][2].setBackground(myColorFive);
        board[12][6].setBackground(myColorFour);
        board[12][8].setBackground(myColorFour);
        board[12][12].setBackground(myColorFive);
        
        board[12][2].add(doubWord[12]);
        tileType[12][2] = 3;
        board[12][6].add(doubLetter[20]);
        tileType[12][6] = 2;
        board[12][8].add(doubLetter[21]);
        tileType[12][8] = 2;
        board[12][12].add(doubWord[13]);
        tileType[12][12] = 3;
        //line 14
        board[13][1].setBackground(myColorFive);
        board[13][5].setBackground(myColorTwo);
        board[13][9].setBackground(myColorTwo);
        board[13][13].setBackground(myColorFive);
        
        board[13][1].add(doubWord[14]);
        tileType[13][1] = 3;
        board[13][5].add(tripLetter[10]);
        tileType[13][5] = 4;
        board[13][9].add(tripLetter[11]);
        tileType[13][9] = 4;
        board[13][13].add(doubWord[15]);
        tileType[13][13] = 3;
        //line 15
        board[14][0].setBackground(myColor);
        board[14][3].setBackground(myColorFour);        
        board[14][7].setBackground(myColor);
        board[14][11].setBackground(myColorFour);
        board[14][14].setBackground(myColor);
        
        board[14][0].add(tripWord[5]);
        tileType[14][0] = 1;
        board[14][3].add(doubLetter[22]); 
        tileType[14][3] = 2;
        board[14][7].add(tripWord[6]);
        tileType[14][7] = 1;
        board[14][11].add(doubLetter[23]);
        tileType[14][11] = 2;
        board[14][14].add(tripWord[7]);
        tileType[14][14] = 1;
        
        //EAST
        eastPanel.add(scoresPanel);
        eastPanel.add(buttonsPanel);
        for(int i = 0; i < 3; i++){
            emptyLabels[i] = new JLabel();
            buttonsPanel.add(emptyLabels[i]);
        }
        for(int i = 0; i < 2; i++){
            buttons[i] = new JButton();
            buttons[i].addMouseListener(this);
            buttonsPanel.add(buttons[i]);
        }
        buttons[0].setText("Exchange");
        buttons[1].setText("End Turn");
        buttonsPanel.setBackground(myColorThree);
        
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
        if(e.getSource() == buttons[0] && buttons[0].isEnabled()){
            
            JOptionPane.showMessageDialog(centerPanel, "Click on all of the tiles you would like to exchange");
            buttons[2] = new JButton();
            buttons[2].addMouseListener(this);
            southPanel.add(buttons[2]);
            buttons[2].setText("Accept");
            southPanel.updateUI();
            exchange = true;
            buttons[0].setEnabled(false);
        }
        
         for(int i = 0; i < playerOneHand.size(); i++){
            if(e.getSource() == playerOneHand.get(i).getButton() ){
                if(turnValue == 1 && !playerOneHand.get(i).getButton().isEnabled()){
                     playerOneHand.get(i).getButton().setEnabled(true);
                     clickLetter = false;
                 }else if(turnValue == 1 && (exchange ||!clickLetter) && playerOneHand.get(i).getButton().isEnabled()){
                     playerOneHand.get(i).getButton().setEnabled(false);
                     clickLetter =true;
                     
                 }
            }
        }
        for(int i = 0; i < playerTwoHand.size(); i++){
            if(e.getSource() == playerTwoHand.get(i).getButton() ){
                if(turnValue == 2 && !playerTwoHand.get(i).getButton().isEnabled()){
                     playerTwoHand.get(i).getButton().setEnabled(true);
                     clickLetter = false;
                 }else if(turnValue == 2 && (exchange ||!clickLetter) && playerTwoHand.get(i).getButton().isEnabled()){
                     playerTwoHand.get(i).getButton().setEnabled(false);
                     clickLetter = true;
                     
                 }
            }
        }
         
        if(e.getSource() == buttons[1]){
            System.out.println(placedWord);
            if(downClick){
                board[lastX+1][lastY].setBackground(colorHold);
            }else if(rightClick){
                board[lastX][lastY+1].setBackground(colorHold);
            }
            
            if (checkTurnOne()){
                try {
                    checkWord();
                } catch (IOException ex) {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            firstClick = 0;
            downClick = false;
            rightClick = false;
            lastX = 0;
            lastY = 0;
            holdY = 0;
            holdX = 0;
            
        }
        
        if(e.getSource() == buttons[2]){
            changeTurn();
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                
                if(e.getSource() == board[i][j] && clickLetter && boardLetterHold[i][j] == null){
                    
                       System.out.println("X " + (lastX + 2));
                       System.out.println("Y " + (lastY  + 2));
                       System.out.println(i);
                       System.out.println(j);
                       System.out.println("dSkip " + downSkip);
                       System.out.println("rSkip " + rightSkip);
                    if(turnValue == 1){
                        for(int k = 0; k < playerOneHand.size(); k++){
                            if(!playerOneHand.get(k).getButton().isEnabled()){
                                if(board[i][j].getBackground().equals(Color.YELLOW)){
                                    if(firstClick == 1 && (lastX+1 == i && lastY == j)){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHoldExtra);
                                        board[i-1][j+1].setBackground(colorHold);
                                    }else if(firstClick == 1 && (lastY+1 == j && lastX == i)){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHold);
                                        board[i+1][j-1].setBackground(colorHoldExtra);
                                    }else if(firstClick == 1 && downSkip){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHoldExtra);
                                        board[i-2][j+1].setBackground(colorHold);
                                    }else if(firstClick == 1 && rightSkip){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHold);
                                        board[i+1][j-2].setBackground(colorHoldExtra);
                                    }else if(downClick || downSkip){
                                        board[i][j].setBackground(colorHold);
                                    }else if(rightClick || rightSkip){
                                        board[i][j].setBackground(colorHold);
                                    }
                                    
                                }

                                if(firstClick == 2){
                                    if(lastX+1 == i && lastY == j && !rightClick){
                                        System.out.println("Down");
                                        worked = true;
                                        buttons[0].setEnabled(false);
                                        board[i][j].add(new JLabel(playerOneHand.get(k).getLetter()));
                                        boardLetterHold[i][j] = playerOneHand.get(k);
                                        //placedWord += playerOneHand.get(k).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerOneHand.get(k).getButton());
                                        hold.add(playerOneHand.get(k));
                                        playerOneHand.remove(k);
                                        clickLetter = false;
                                        downClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }else if(lastY+1 == j && lastX == i && !downClick){
                                        System.out.println("Right");
                                        worked = true;
                                        buttons[0].setEnabled(false);
                                        board[i][j].add(new JLabel(playerOneHand.get(k).getLetter()));
                                        boardLetterHold[i][j] = playerOneHand.get(k);
                                        //placedWord += playerOneHand.get(k).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerOneHand.get(k).getButton());
                                        hold.add(playerOneHand.get(k));
                                        playerOneHand.remove(k);
                                        clickLetter = false;
                                        rightClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }else if((lastY == j && lastX+2 == i) && downSkip){
                                        System.out.println("Down 2");
                                        worked = true;
                                        buttons[0].setEnabled(false);
                                        board[i][j].add(new JLabel(playerOneHand.get(k).getLetter()));
                                        boardLetterHold[i][j] = playerOneHand.get(k);
                                        //placedWord += playerOneHand.get(k).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerOneHand.get(k).getButton());
                                        hold.add(playerOneHand.get(k));
                                        playerOneHand.remove(k);
                                        clickLetter = false;
                                        downClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }else if((lastY+2 == j && lastX == i) && rightSkip){
                                        System.out.println("Right 2");
                                        worked = true;
                                        buttons[0].setEnabled(false);
                                        board[i][j].add(new JLabel(playerOneHand.get(k).getLetter()));
                                        boardLetterHold[i][j] = playerOneHand.get(k);
                                        //placedWord += playerOneHand.get(k).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerOneHand.get(k).getButton());
                                        hold.add(playerOneHand.get(k));
                                        playerOneHand.remove(k);
                                        clickLetter = false;
                                        rightClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }
                                }else if(firstClick == 0){
                                    buttons[0].setEnabled(false);
                                    board[i][j].add(new JLabel(playerOneHand.get(k).getLetter()));
                                    boardLetterHold[i][j] = playerOneHand.get(k);
                                    //placedWord += playerOneHand.get(k).getLetter();
                                    centerPanel.updateUI();
                                    southPanel.remove(playerOneHand.get(k).getButton());
                                    hold.add(playerOneHand.get(k));
                                    playerOneHand.remove(k);
                                    clickLetter = false;
                                    
                                    
                                    firstX = i;
                                    firstY = j;
                                    holdX = i;
                                    holdY = j;
                                    lastX = i;
                                    lastY = j;
                                    System.out.println("");
                                    System.out.println(firstX + " " + firstY);
                                }
                                
                                if (firstClick == 0){
                                    firstClick = 1;
                                    if(boardLetter[i][j+1] != null){
                                        colorHold = board[i][j+2].getBackground();
                                        board[i][j+2].setBackground(Color.YELLOW);
                                        rightSkip = true;
                                    }else{
                                        colorHold = board[i][j+1].getBackground();
                                        board[i][j+1].setBackground(Color.YELLOW);
                                    }
                                    if(boardLetter[i][j] != null){
                                        colorHoldExtra = board[i+2][j].getBackground();
                                        board[i+2][j].setBackground(Color.YELLOW);
                                        downSkip = true;
                                    }else{
                                        colorHoldExtra = board[i+1][j].getBackground();
                                        board[i+1][j].setBackground(Color.YELLOW);
                                    }

                                    
                                }else if(downClick && (holdX+1 == i && holdY == j) && worked){
                                    if(boardLetter[i+1][j] != null){
                                            colorHold = board[i+2][j].getBackground();
                                            board[i+2][j].setBackground(Color.YELLOW);
                                            downSkip = true;
                                        }else{
                                            colorHold = board[i+1][j].getBackground();
                                            board[i+1][j].setBackground(Color.YELLOW);
                                        } 
                                    worked = false;
                                }else if(rightClick && (holdY+1 == j && holdX == i) && worked){
                                    if(boardLetter[i][j+1] != null){
                                            colorHold = board[i][j+2].getBackground();
                                            board[i][j+2].setBackground(Color.YELLOW);
                                            rightSkip = true;
                                        }else{
                                            colorHold = board[i][j+1].getBackground();
                                            board[i][j+1].setBackground(Color.YELLOW);
                                        }
                                    worked = false;
                                }else if(downSkip && worked){
                                    colorHold = board[i+1][j].getBackground();
                                    board[i+1][j].setBackground(Color.YELLOW);
                                    worked = false;
                                }else if(rightSkip&& worked){
                                    colorHold = board[i][j+1].getBackground();
                                    board[i][j+1].setBackground(Color.YELLOW);
                                    worked = false;
                                }
                                
                            }
                        }
                        
                    }else{
                        for(int k = 0; k < 7; k++){
                            for(int l = 0; l < playerTwoHand.size(); l++){
                            if(!playerTwoHand.get(l).getButton().isEnabled()){
                                if(board[i][j].getBackground().equals(Color.YELLOW)){
                                    if(firstClick == 1 && (lastX+1 == i && lastY == j)){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHoldExtra);
                                        board[i-1][j+1].setBackground(colorHold);
                                    }else if(firstClick == 1 && (lastY+1 == j && lastX == i)){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHold);
                                        board[i+1][j-1].setBackground(colorHoldExtra);
                                    }else if(firstClick == 1 && downSkip){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHoldExtra);
                                        board[i-2][j+1].setBackground(colorHold);
                                    }else if(firstClick == 1 && rightSkip){
                                        firstClick = 2;
                                        board[i][j].setBackground(colorHold);
                                        board[i+1][j-2].setBackground(colorHoldExtra);
                                    }else if(downClick){
                                        board[i][j].setBackground(colorHold);
                                    }else if(rightClick){
                                        board[i][j].setBackground(colorHold);
                                    }
                                    
                                }
                                if(firstClick == 2){
                                    if((lastX+1 == i && lastY == j && !rightClick ) ){
                                        System.out.println("Down");
                                        worked = true;
                                        buttons[0].setEnabled(false);
                                        board[i][j].add(new JLabel(playerTwoHand.get(l).getLetter()));
                                        boardLetterHold[i][j] = playerTwoHand.get(l);
                                        //placedWord += playerTwoHand.get(l).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerTwoHand.get(l).getButton());
                                        hold.add(playerTwoHand.get(l));
                                        playerTwoHand.remove(l);
                                        clickLetter = false;
                                        downClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }else if((lastY+1 == j && lastX == i && !downClick )){
                                        System.out.println("Right");
                                        buttons[0].setEnabled(false);
                                        worked = true;
                                        board[i][j].add(new JLabel(playerTwoHand.get(l).getLetter()));
                                        boardLetterHold[i][j] = playerTwoHand.get(l);
                                        //placedWord += playerTwoHand.get(l).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerTwoHand.get(l).getButton());
                                        hold.add(playerTwoHand.get(l));
                                        playerTwoHand.remove(l);
                                        clickLetter = false;
                                        rightClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }else if((lastY == j && lastX+2 == i) && downSkip ){
                                        System.out.println("Down 2");
                                        buttons[0].setEnabled(false);
                                        worked = true;
                                        board[i][j].add(new JLabel(playerTwoHand.get(l).getLetter()));
                                        boardLetterHold[i][j] = playerTwoHand.get(l);
                                        //placedWord += playerTwoHand.get(l).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerTwoHand.get(l).getButton());
                                        hold.add(playerTwoHand.get(l));
                                        playerTwoHand.remove(l);
                                        clickLetter = false;
                                        downClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }else if((lastY+2 == j && lastX == i) && rightSkip ){
                                        
                                        System.out.println("Right 2");
                                        buttons[0].setEnabled(false);
                                        worked = true;
                                        board[i][j].add(new JLabel(playerTwoHand.get(l).getLetter()));
                                        boardLetterHold[i][j] = playerTwoHand.get(l);
                                        //placedWord += playerTwoHand.get(l).getLetter();
                                        centerPanel.updateUI();
                                        southPanel.remove(playerTwoHand.get(l).getButton());
                                        hold.add(playerTwoHand.get(l));
                                        playerTwoHand.remove(l);
                                        clickLetter = false;
                                        rightClick = true;
                                        holdX = lastX;
                                        holdY = lastY;
                                        lastX = i;
                                        lastY = j;
                                    }
                                }else if(firstClick == 0){
                                    buttons[0].setEnabled(false);
                                    board[i][j].add(new JLabel(playerTwoHand.get(l).getLetter()));
                                    boardLetterHold[i][j] = playerTwoHand.get(l);
                                    //placedWord += playerTwoHand.get(l).getLetter();
                                    centerPanel.updateUI();
                                    southPanel.remove(playerTwoHand.get(l).getButton());
                                    hold.add(playerTwoHand.get(l));
                                    playerTwoHand.remove(l);
                                    clickLetter = false;
                                    
                                    
                                    firstX = i;
                                    firstY = j;
                                    holdX = i;
                                    holdY = j;
                                    lastX = i;
                                    lastY = j;
                                    System.out.println("");
                                    System.out.println(firstX + " " + firstY);
                                }
                                
                                if (firstClick == 0){
                                    firstClick = 1;
                                    if(boardLetterHold[i][j+1] != null){
                                        colorHold = board[i][j+2].getBackground();
                                        board[i][j+2].setBackground(Color.YELLOW);
                                        rightSkip = true;
                                    }else{
                                        colorHold = board[i][j+1].getBackground();
                                        board[i][j+1].setBackground(Color.YELLOW);
                                    }
                                    if(boardLetterHold[i+1][j] != null){
                                        colorHoldExtra = board[i+2][j].getBackground();
                                        board[i+2][j].setBackground(Color.YELLOW);
                                        downSkip = true;
                                    }else{
                                        colorHoldExtra = board[i+1][j].getBackground();
                                        board[i+1][j].setBackground(Color.YELLOW);
                                    }

                                    
                                }else if(downClick && (holdX+1 == i && holdY == j) && worked){
                                    if(boardLetter[i+1][j] != null){
                                            colorHold = board[i+2][j].getBackground();
                                            board[i+2][j].setBackground(Color.YELLOW);
                                            downSkip = true;
                                        }else{
                                            colorHold = board[i+1][j].getBackground();
                                            board[i+1][j].setBackground(Color.YELLOW);
                                        } 
                                    worked = false;
                                }else if(rightClick && (holdY+1 == j && holdX == i) && worked){
                                    if(boardLetter[i][j+1] != null){
                                            colorHold = board[i][j+2].getBackground();
                                            board[i][j+2].setBackground(Color.YELLOW);
                                            rightSkip = true;
                                        }else{
                                            colorHold = board[i][j+1].getBackground();
                                            board[i][j+1].setBackground(Color.YELLOW);
                                        }
                                    worked = false;
                                }else if(downSkip && worked){
                                    colorHold = board[i+1][j].getBackground();
                                    board[i+1][j].setBackground(Color.YELLOW);
                                    worked = false;
                                }else if(rightSkip&& worked){
                                    colorHold = board[i][j+1].getBackground();
                                    board[i][j+1].setBackground(Color.YELLOW);
                                    worked = false;
                                }
                                
                            }
                        }
                        
                            }
                        }
                    }
                    
                }
                
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
            
            for(int i = playerTwoHand.size() - 1; i >= 0; i--){
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
            buttons[0].setEnabled(true);
            
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
            
            for(int i = playerOneHand.size() - 1; i >= 0; i--){
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
            buttons[0].setEnabled(true);
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
        hold.clear();
    }
    
    public void checkWord()throws IOException, FileNotFoundException {
        int count = 0;
        boolean wordFound = false;
        String word = " ";
<<<<<<< HEAD
        
        
        if(downClick){
            //firstX - 1 lastx + 1
=======
        if(downClick){
            if (boardLetterHold[firstX - 1][firstY] != null){
                firstX -= 1;
            }
            if (boardLetterHold[lastX + 1][lastY] != null){
                lastX += 1;
            }
>>>>>>> origin/master
            for(int i = 0; i <= (lastX - firstX); i++){
                placedWord += boardLetterHold[firstX + i][firstY].getLetter();
                System.out.println("WORD");
                System.out.println(placedWord);
            }
        }else if(rightClick){
            if (boardLetterHold[firstX][firstY - 1] != null){
                firstY -= 1;
            }
            if (boardLetterHold[lastX][lastY + 1] != null){
                lastY += 1;
            }
            for(int i = 0; i <= (lastY - firstY); i++){
                placedWord += boardLetterHold[firstX ][firstY + i].getLetter();
                System.out.println("WORD");
                System.out.println(placedWord + " WORD");
            }
        }

        BufferedReader rd = new BufferedReader(new FileReader("src\\words\\"+placedWord.substring(0, 1) +".txt"));
        while(word != null){
            if(word.equalsIgnoreCase(placedWord)){  
                wordFound = true;
                rd.close();
                break;
            }
            //count++;
            //System.out.println(count);
            word = rd.readLine();
            //System.out.println(word);   
            
        }
        if(wordFound){
            System.out.println("Found");
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    boardLetter[i][j] = boardLetterHold[i][j];
                 }
            }
<<<<<<< HEAD

=======
>>>>>>> origin/master
            placedWord = "";

            
            if(downClick){
                int pOneScoreTemp = 0;
                int pTwoScoreTemp = 0;
                int doubX = 0;
                int tripX = 0;
                for(int i = 0; i <= (lastX - firstX); i++){
                    if(turnValue == 1){
                        if(tileType[firstX + i][firstY] == 1){
                            pOneScoreTemp += boardLetterHold[firstX + i][firstY].getPV();
                            tripX += 1;
                        }else if(tileType[firstX + i][firstY] == 2){
                            pOneScoreTemp += boardLetterHold[firstX + i][firstY].getPV() * 2;
                        }else if(tileType[firstX + i][firstY] == 3){
                            pOneScoreTemp += boardLetterHold[firstX + i][firstY].getPV();
                            doubX += 1;
                        }else if(tileType[firstX + i][firstY] == 4){
                            pOneScoreTemp += boardLetterHold[firstX + i][firstY].getPV() * 3;
                        }else {
                            pOneScoreTemp += boardLetterHold[firstX + i][firstY].getPV();
                        }
                    }
                    if(turnValue == 2){
                        if(tileType[firstX + i][firstY] == 1){
                            pTwoScoreTemp += boardLetterHold[firstX + i][firstY].getPV();
                            tripX += 1;
                        }else if(tileType[firstX + i][firstY] == 2){
                            pTwoScoreTemp += boardLetterHold[firstX + i][firstY].getPV() * 2;
                        }else if(tileType[firstX + i][firstY] == 3){
                            pTwoScoreTemp += boardLetterHold[firstX + i][firstY].getPV();
                            doubX += 1;
                        }else if(tileType[firstX + i][firstY] == 4){
                            pTwoScoreTemp += boardLetterHold[firstX + i][firstY].getPV() * 3;
                        }else {
                            pTwoScoreTemp += boardLetterHold[firstX + i][firstY].getPV();
                        }
                    }
                }
                
                if (doubX > 0){
                    for (int i = 0; i < doubX; i++){
                        if(turnValue == 1){
                            pOneScoreTemp *= 2;
                        }
                        if(turnValue == 2){
                            pTwoScoreTemp *= 2;
                        }
                    }
                }
                if (tripX > 0){
                    for (int i = 0; i < tripX; i++){
                        if(turnValue == 1){
                            pOneScoreTemp *= 3;
                        }
                        if(turnValue == 2){
                            pTwoScoreTemp *= 3;
                        }
                    }
                }
                
                pOneScore += pOneScoreTemp;
                pTwoScore += pTwoScoreTemp;
                
            }else if(rightClick){
                int pOneScoreTemp = 0;
                int pTwoScoreTemp = 0;
                int doubX = 0;
                int tripX = 0;
                for(int i = 0; i <= (lastY - firstY); i++){
                    if(turnValue == 1){
                        if(tileType[firstX][firstY + i] == 1){
                            pOneScoreTemp += boardLetterHold[firstX][firstY + i].getPV();
                            tripX += 1;
                        }else if(tileType[firstX][firstY + i] == 2){
                            pOneScoreTemp += boardLetterHold[firstX][firstY + i].getPV() * 2;
                        }else if(tileType[firstX][firstY + i] == 3){
                            pOneScoreTemp += boardLetterHold[firstX][firstY + i].getPV();
                            doubX += 1;
                        }else if(tileType[firstX][firstY + i] == 4){
                            pOneScoreTemp += boardLetterHold[firstX][firstY + i].getPV() * 4;
                        }else {
                            pOneScoreTemp += boardLetterHold[firstX][firstY + i].getPV();
                        }
                    }
                    if(turnValue == 2){
                        if(tileType[firstX][firstY + i] == 1){
                            pTwoScoreTemp += boardLetterHold[firstX][firstY + i].getPV();
                            tripX += 1;
                        }else if(tileType[firstX][firstY + i] == 2){
                            pTwoScoreTemp += boardLetterHold[firstX][firstY + i].getPV() * 2;
                        }else if(tileType[firstX][firstY + i] == 3){
                            pTwoScoreTemp += boardLetterHold[firstX][firstY + i].getPV();
                            doubX += 1;
                        }else if(tileType[firstX][firstY + i] == 4){
                            pTwoScoreTemp += boardLetterHold[firstX][firstY + i].getPV() * 4;
                        }else {
                            pTwoScoreTemp += boardLetterHold[firstX][firstY + i].getPV();
                        }
                    }
                }
                
                if (doubX > 0){
                    for (int i = 0; i < doubX; i++){
                        if(turnValue == 1){
                            pOneScoreTemp *= 2;
                        }
                        if(turnValue == 2){
                            pTwoScoreTemp *= 2;
                        }
                    }
                }
                if (tripX > 0){
                    for (int i = 0; i < tripX; i++){
                        if(turnValue == 1){
                            pOneScoreTemp *= 3;
                        }
                        if(turnValue == 2){
                            pTwoScoreTemp *= 3;
                        }
                    }
                }
                
                pOneScore += pOneScoreTemp;
                pTwoScore += pTwoScoreTemp;
            }
            playerOneNumber.setText("" + pOneScore);
            playerTwoNumber.setText("" + pTwoScore);
            scoresPanel.updateUI();
            
            changeTurn();
        }else{
            System.out.println("Not Found");
            placedWord = "";
            if(turnValue == 1){
                for(int i = hold.size() - 1; i >= 0 ; i--){
                hold.get(i).getButton().setEnabled(true);
                playerOneHand.add(hold.get(i));
                southPanel.add(playerOneHand.get(playerOneHand.size() - 1).getButton());
                }
            }else{
                for(int i = hold.size() - 1; i >= 0 ; i--){
                hold.get(i).getButton().setEnabled(true);
                playerTwoHand.add(hold.get(i));
                
                southPanel.add(playerTwoHand.get(playerTwoHand.size() - 1).getButton());
                }
            }
            
            
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
//&& !boardLetter[i][j].getLetter().equals(boardLetterHold[i][j].getLetter()
                    //&& !boardLetterHold[i][j].getLetter().equals(boardLetter[i][j].getLetter())
                    if(boardLetterHold[i][j] != null && boardLetter[i][j] == null ){
                       //if()
                        System.out.println("Found Letter");
                        boardLetterHold[i][j] = boardLetter[i][j];
                        board[i][j].removeAll();
                    }
                    board[i][j].updateUI();
                 }
            }
            southPanel.updateUI();
            
        }
        
    }
    public boolean checkTurnOne(){
        //System.out.println(boardLetterHold[7][7].getLetter());
        if(turnOne && (boardLetterHold[7][7] == null)){
            System.out.println("RAN");
                for(int i = 0; i < 15; i++){
                    for(int j = 0; j < 15; j++){
                        if(boardLetterHold[i][j] != null){
                            boardLetterHold[i][j] = null;
                            board[i][j].removeAll();
                            board[i][j].updateUI();
                        }
                    }
                }
                for(int i = hold.size() - 1; i >= 0 ; i--){
                    hold.get(i).getButton().setEnabled(true);
                    playerOneHand.add(hold.remove(i));
                    southPanel.add(playerOneHand.get(playerOneHand.size()-1).getButton());
                }
            System.out.println("False");
            System.out.println(hold + " Hold");
            for(int i = 0; i < 7; i++){
                System.out.print(playerOneHand.get(i).getLetter());
            }

            System.out.println("");

            for(int i = 0; i < 7; i++){
                System.out.print(playerTwoHand.get(i).getLetter());
            }
            southPanel.updateUI();
            JOptionPane.showMessageDialog(null, "         One letter in you word \n must be placed on the black tile");
            buttons[0].setEnabled(true);
            return false;
        }else{
            System.out.println("True");
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == themeD){
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
            //line 2
            board[1][1].setBackground(myColorFive);
            board[1][5].setBackground(myColorTwo);
            board[1][9].setBackground(myColorTwo);
            board[1][13].setBackground(myColorFive);
            //line 3
            board[2][2].setBackground(myColorFive);
            board[2][6].setBackground(myColorFour);
            board[2][8].setBackground(myColorFour);
            board[2][12].setBackground(myColorFive);
            //line 4
            board[3][0].setBackground(myColorFour);
            board[3][3].setBackground(myColorFive);
            board[3][7].setBackground(myColorFour);
            board[3][11].setBackground(myColorFive);
            board[3][14].setBackground(myColorFour);
            //line 5
            board[4][4].setBackground(myColorFive); 
            board[4][10].setBackground(myColorFive);
            //line 6
            board[5][1].setBackground(myColorTwo);
            board[5][5].setBackground(myColorTwo);
            board[5][9].setBackground(myColorTwo);
            board[5][13].setBackground(myColorTwo);
            //line 7
            board[6][2].setBackground(myColorFour);
            board[6][6].setBackground(myColorFour);
            board[6][8].setBackground(myColorFour);
            board[6][12].setBackground(myColorFour);
            //line 8
            board[7][0].setBackground(myColor);
            board[7][3].setBackground(myColorFour);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFour);
            board[7][14].setBackground(myColor);
            //line 9
            board[8][2].setBackground(myColorFour);
            board[8][6].setBackground(myColorFour);
            board[8][8].setBackground(myColorFour);
            board[8][12].setBackground(myColorFour);
            //line 10
            board[9][1].setBackground(myColorTwo);
            board[9][5].setBackground(myColorTwo);
            board[9][9].setBackground(myColorTwo);
            board[9][13].setBackground(myColorTwo);
            //line 11 
            board[10][4].setBackground(myColorFive); 
            board[10][10].setBackground(myColorFive);
            //line 12
            board[11][0].setBackground(myColorFour);
            board[11][3].setBackground(myColorFive);
            board[11][7].setBackground(myColorFour);
            board[11][11].setBackground(myColorFive);
            board[11][14].setBackground(myColorFour);
            //line 13
            board[12][2].setBackground(myColorFive);
            board[12][6].setBackground(myColorFour);
            board[12][8].setBackground(myColorFour);
            board[12][12].setBackground(myColorFive);
            //line 14
            board[13][1].setBackground(myColorFive);
            board[13][5].setBackground(myColorTwo);
            board[13][9].setBackground(myColorTwo);
            board[13][13].setBackground(myColorFive);
            //line 15
            board[14][0].setBackground(myColor);
            board[14][3].setBackground(myColorFour);        
            board[14][7].setBackground(myColor);
            board[14][11].setBackground(myColorFour);
            board[14][14].setBackground(myColor);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeSM){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixSM);
                }
            }
            //line 1
            board[0][0].setBackground(myColorSM);
            board[0][3].setBackground(myColorFourSM);        
            board[0][7].setBackground(myColorSM);
            board[0][11].setBackground(myColorFourSM);
            board[0][14].setBackground(myColorSM);
            //line 2
            board[1][1].setBackground(myColorFiveSM);
            board[1][5].setBackground(myColorTwoSM);
            board[1][9].setBackground(myColorTwoSM);
            board[1][13].setBackground(myColorFiveSM);
            //line 3
            board[2][2].setBackground(myColorFiveSM);
            board[2][6].setBackground(myColorFourSM);
            board[2][8].setBackground(myColorFourSM);
            board[2][12].setBackground(myColorFiveSM);
            //line 4
            board[3][0].setBackground(myColorFourSM);
            board[3][3].setBackground(myColorFiveSM);
            board[3][7].setBackground(myColorFourSM);
            board[3][11].setBackground(myColorFiveSM);
            board[3][14].setBackground(myColorFourSM);
            //line 5
            board[4][4].setBackground(myColorFiveSM); 
            board[4][10].setBackground(myColorFiveSM);
            //line 6
            board[5][1].setBackground(myColorTwoSM);
            board[5][5].setBackground(myColorTwoSM);
            board[5][9].setBackground(myColorTwoSM);
            board[5][13].setBackground(myColorTwoSM);
            //line 7
            board[6][2].setBackground(myColorFourSM);
            board[6][6].setBackground(myColorFourSM);
            board[6][8].setBackground(myColorFourSM);
            board[6][12].setBackground(myColorFourSM);
            //line 8
            board[7][0].setBackground(myColorSM);
            board[7][3].setBackground(myColorFourSM);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourSM);
            board[7][14].setBackground(myColorSM);
            //line 9
            board[8][2].setBackground(myColorFourSM);
            board[8][6].setBackground(myColorFourSM);
            board[8][8].setBackground(myColorFourSM);
            board[8][12].setBackground(myColorFourSM);
            //line 10
            board[9][1].setBackground(myColorTwoSM);
            board[9][5].setBackground(myColorTwoSM);
            board[9][9].setBackground(myColorTwoSM);
            board[9][13].setBackground(myColorTwoSM);
            //line 11 
            board[10][4].setBackground(myColorFiveSM); 
            board[10][10].setBackground(myColorFiveSM);
            //line 12
            board[11][0].setBackground(myColorFourSM);
            board[11][3].setBackground(myColorFiveSM);
            board[11][7].setBackground(myColorFourSM);
            board[11][11].setBackground(myColorFiveSM);
            board[11][14].setBackground(myColorFourSM);
            //line 13
            board[12][2].setBackground(myColorFiveSM);
            board[12][6].setBackground(myColorFourSM);
            board[12][8].setBackground(myColorFourSM);
            board[12][12].setBackground(myColorFiveSM);
            //line 14
            board[13][1].setBackground(myColorFiveSM);
            board[13][5].setBackground(myColorTwoSM);
            board[13][9].setBackground(myColorTwoSM);
            board[13][13].setBackground(myColorFiveSM);
            //line 15
            board[14][0].setBackground(myColorSM);
            board[14][3].setBackground(myColorFourSM);        
            board[14][7].setBackground(myColorSM);
            board[14][11].setBackground(myColorFourSM);
            board[14][14].setBackground(myColorSM);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeBT){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixBT);
                }
            }
            //line 1
            board[0][0].setBackground(myColorBT);
            board[0][3].setBackground(myColorFourBT);        
            board[0][7].setBackground(myColorBT);
            board[0][11].setBackground(myColorFourBT);
            board[0][14].setBackground(myColorBT);
            //line 2
            board[1][1].setBackground(myColorFiveBT);
            board[1][5].setBackground(myColorTwoBT);
            board[1][9].setBackground(myColorTwoBT);
            board[1][13].setBackground(myColorFiveBT);
            //line 3
            board[2][2].setBackground(myColorFiveBT);
            board[2][6].setBackground(myColorFourBT);
            board[2][8].setBackground(myColorFourBT);
            board[2][12].setBackground(myColorFiveBT);
            //line 4
            board[3][0].setBackground(myColorFourBT);
            board[3][3].setBackground(myColorFiveBT);
            board[3][7].setBackground(myColorFourBT);
            board[3][11].setBackground(myColorFiveBT);
            board[3][14].setBackground(myColorFourBT);
            //line 5
            board[4][4].setBackground(myColorFiveBT); 
            board[4][10].setBackground(myColorFiveBT);
            //line 6
            board[5][1].setBackground(myColorTwoBT);
            board[5][5].setBackground(myColorTwoBT);
            board[5][9].setBackground(myColorTwoBT);
            board[5][13].setBackground(myColorTwoBT);
            //line 7
            board[6][2].setBackground(myColorFourBT);
            board[6][6].setBackground(myColorFourBT);
            board[6][8].setBackground(myColorFourBT);
            board[6][12].setBackground(myColorFourBT);
            //line 8
            board[7][0].setBackground(myColorBT);
            board[7][3].setBackground(myColorFourBT);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourBT);
            board[7][14].setBackground(myColorBT);
            //line 9
            board[8][2].setBackground(myColorFourBT);
            board[8][6].setBackground(myColorFourBT);
            board[8][8].setBackground(myColorFourBT);
            board[8][12].setBackground(myColorFourBT);
            //line 10
            board[9][1].setBackground(myColorTwoBT);
            board[9][5].setBackground(myColorTwoBT);
            board[9][9].setBackground(myColorTwoBT);
            board[9][13].setBackground(myColorTwoBT);
            //line 11 
            board[10][4].setBackground(myColorFiveBT); 
            board[10][10].setBackground(myColorFiveBT);
            //line 12
            board[11][0].setBackground(myColorFourBT);
            board[11][3].setBackground(myColorFiveBT);
            board[11][7].setBackground(myColorFourBT);
            board[11][11].setBackground(myColorFiveBT);
            board[11][14].setBackground(myColorFourBT);
            //line 13
            board[12][2].setBackground(myColorFiveBT);
            board[12][6].setBackground(myColorFourBT);
            board[12][8].setBackground(myColorFourBT);
            board[12][12].setBackground(myColorFiveBT);
            //line 14
            board[13][1].setBackground(myColorFiveBT);
            board[13][5].setBackground(myColorTwoBT);
            board[13][9].setBackground(myColorTwoBT);
            board[13][13].setBackground(myColorFiveBT);
            //line 15
            board[14][0].setBackground(myColorBT);
            board[14][3].setBackground(myColorFourBT);        
            board[14][7].setBackground(myColorBT);
            board[14][11].setBackground(myColorFourBT);
            board[14][14].setBackground(myColorBT);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeT){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixT);
                }
            }
            //line 1
            board[0][0].setBackground(myColorT);
            board[0][3].setBackground(myColorFourT);        
            board[0][7].setBackground(myColorT);
            board[0][11].setBackground(myColorFourT);
            board[0][14].setBackground(myColorT);
            //line 2
            board[1][1].setBackground(myColorFiveT);
            board[1][5].setBackground(myColorTwoT);
            board[1][9].setBackground(myColorTwoT);
            board[1][13].setBackground(myColorFiveT);
            //line 3
            board[2][2].setBackground(myColorFiveT);
            board[2][6].setBackground(myColorFourT);
            board[2][8].setBackground(myColorFourT);
            board[2][12].setBackground(myColorFiveT);
            //line 4
            board[3][0].setBackground(myColorFourT);
            board[3][3].setBackground(myColorFiveT);
            board[3][7].setBackground(myColorFourT);
            board[3][11].setBackground(myColorFiveT);
            board[3][14].setBackground(myColorFourT);
            //line 5
            board[4][4].setBackground(myColorFiveT); 
            board[4][10].setBackground(myColorFiveT);
            //line 6
            board[5][1].setBackground(myColorTwoT);
            board[5][5].setBackground(myColorTwoT);
            board[5][9].setBackground(myColorTwoT);
            board[5][13].setBackground(myColorTwoT);
            //line 7
            board[6][2].setBackground(myColorFourT);
            board[6][6].setBackground(myColorFourT);
            board[6][8].setBackground(myColorFourT);
            board[6][12].setBackground(myColorFourT);
            //line 8
            board[7][0].setBackground(myColorT);
            board[7][3].setBackground(myColorFourT);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourT);
            board[7][14].setBackground(myColorT);
            //line 9
            board[8][2].setBackground(myColorFourT);
            board[8][6].setBackground(myColorFourT);
            board[8][8].setBackground(myColorFourT);
            board[8][12].setBackground(myColorFourT);
            //line 10
            board[9][1].setBackground(myColorTwoT);
            board[9][5].setBackground(myColorTwoT);
            board[9][9].setBackground(myColorTwoT);
            board[9][13].setBackground(myColorTwoT);
            //line 11 
            board[10][4].setBackground(myColorFiveT); 
            board[10][10].setBackground(myColorFiveT);
            //line 12
            board[11][0].setBackground(myColorFourT);
            board[11][3].setBackground(myColorFiveT);
            board[11][7].setBackground(myColorFourT);
            board[11][11].setBackground(myColorFiveT);
            board[11][14].setBackground(myColorFourT);
            //line 13
            board[12][2].setBackground(myColorFiveT);
            board[12][6].setBackground(myColorFourT);
            board[12][8].setBackground(myColorFourT);
            board[12][12].setBackground(myColorFiveT);
            //line 14
            board[13][1].setBackground(myColorFiveT);
            board[13][5].setBackground(myColorTwoT);
            board[13][9].setBackground(myColorTwoT);
            board[13][13].setBackground(myColorFiveT);
            //line 15
            board[14][0].setBackground(myColorT);
            board[14][3].setBackground(myColorFourT);        
            board[14][7].setBackground(myColorT);
            board[14][11].setBackground(myColorFourT);
            board[14][14].setBackground(myColorT);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeOF){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixOF);
                }
            }
            //line 1
            board[0][0].setBackground(myColorOF);
            board[0][3].setBackground(myColorFourOF);        
            board[0][7].setBackground(myColorOF);
            board[0][11].setBackground(myColorFourOF);
            board[0][14].setBackground(myColorOF);
            //line 2
            board[1][1].setBackground(myColorFiveOF);
            board[1][5].setBackground(myColorTwoOF);
            board[1][9].setBackground(myColorTwoOF);
            board[1][13].setBackground(myColorFiveOF);
            //line 3
            board[2][2].setBackground(myColorFiveOF);
            board[2][6].setBackground(myColorFourOF);
            board[2][8].setBackground(myColorFourOF);
            board[2][12].setBackground(myColorFiveOF);
            //line 4
            board[3][0].setBackground(myColorFourOF);
            board[3][3].setBackground(myColorFiveOF);
            board[3][7].setBackground(myColorFourOF);
            board[3][11].setBackground(myColorFiveOF);
            board[3][14].setBackground(myColorFourOF);
            //line 5
            board[4][4].setBackground(myColorFiveOF); 
            board[4][10].setBackground(myColorFiveOF);
            //line 6
            board[5][1].setBackground(myColorTwoOF);
            board[5][5].setBackground(myColorTwoOF);
            board[5][9].setBackground(myColorTwoOF);
            board[5][13].setBackground(myColorTwoOF);
            //line 7
            board[6][2].setBackground(myColorFourOF);
            board[6][6].setBackground(myColorFourOF);
            board[6][8].setBackground(myColorFourOF);
            board[6][12].setBackground(myColorFourOF);
            //line 8
            board[7][0].setBackground(myColorOF);
            board[7][3].setBackground(myColorFourOF);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourOF);
            board[7][14].setBackground(myColorOF);
            //line 9
            board[8][2].setBackground(myColorFourOF);
            board[8][6].setBackground(myColorFourOF);
            board[8][8].setBackground(myColorFourOF);
            board[8][12].setBackground(myColorFourOF);
            //line 10
            board[9][1].setBackground(myColorTwoOF);
            board[9][5].setBackground(myColorTwoOF);
            board[9][9].setBackground(myColorTwoOF);
            board[9][13].setBackground(myColorTwoOF);
            //line 11 
            board[10][4].setBackground(myColorFiveOF); 
            board[10][10].setBackground(myColorFiveOF);
            //line 12
            board[11][0].setBackground(myColorFourOF);
            board[11][3].setBackground(myColorFiveOF);
            board[11][7].setBackground(myColorFourOF);
            board[11][11].setBackground(myColorFiveOF);
            board[11][14].setBackground(myColorFourOF);
            //line 13
            board[12][2].setBackground(myColorFiveOF);
            board[12][6].setBackground(myColorFourOF);
            board[12][8].setBackground(myColorFourOF);
            board[12][12].setBackground(myColorFiveOF);
            //line 14
            board[13][1].setBackground(myColorFiveOF);
            board[13][5].setBackground(myColorTwoOF);
            board[13][9].setBackground(myColorTwoOF);
            board[13][13].setBackground(myColorFiveOF);
            //line 15
            board[14][0].setBackground(myColorOF);
            board[14][3].setBackground(myColorFourOF);        
            board[14][7].setBackground(myColorOF);
            board[14][11].setBackground(myColorFourOF);
            board[14][14].setBackground(myColorOF);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeGF){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixGF);
                }
            }
            //line 1
            board[0][0].setBackground(myColorGF);
            board[0][3].setBackground(myColorFourGF);        
            board[0][7].setBackground(myColorGF);
            board[0][11].setBackground(myColorFourGF);
            board[0][14].setBackground(myColorGF);
            //line 2
            board[1][1].setBackground(myColorFiveGF);
            board[1][5].setBackground(myColorTwoGF);
            board[1][9].setBackground(myColorTwoGF);
            board[1][13].setBackground(myColorFiveGF);
            //line 3
            board[2][2].setBackground(myColorFiveGF);
            board[2][6].setBackground(myColorFourGF);
            board[2][8].setBackground(myColorFourGF);
            board[2][12].setBackground(myColorFiveGF);
            //line 4
            board[3][0].setBackground(myColorFourGF);
            board[3][3].setBackground(myColorFiveGF);
            board[3][7].setBackground(myColorFourGF);
            board[3][11].setBackground(myColorFiveGF);
            board[3][14].setBackground(myColorFourGF);
            //line 5
            board[4][4].setBackground(myColorFiveGF); 
            board[4][10].setBackground(myColorFiveGF);
            //line 6
            board[5][1].setBackground(myColorTwoGF);
            board[5][5].setBackground(myColorTwoGF);
            board[5][9].setBackground(myColorTwoGF);
            board[5][13].setBackground(myColorTwoGF);
            //line 7
            board[6][2].setBackground(myColorFourGF);
            board[6][6].setBackground(myColorFourGF);
            board[6][8].setBackground(myColorFourGF);
            board[6][12].setBackground(myColorFourGF);
            //line 8
            board[7][0].setBackground(myColorGF);
            board[7][3].setBackground(myColorFourGF);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourGF);
            board[7][14].setBackground(myColorGF);
            //line 9
            board[8][2].setBackground(myColorFourGF);
            board[8][6].setBackground(myColorFourGF);
            board[8][8].setBackground(myColorFourGF);
            board[8][12].setBackground(myColorFourGF);
            //line 10
            board[9][1].setBackground(myColorTwoGF);
            board[9][5].setBackground(myColorTwoGF);
            board[9][9].setBackground(myColorTwoGF);
            board[9][13].setBackground(myColorTwoGF);
            //line 11 
            board[10][4].setBackground(myColorFiveGF); 
            board[10][10].setBackground(myColorFiveGF);
            //line 12
            board[11][0].setBackground(myColorFourGF);
            board[11][3].setBackground(myColorFiveGF);
            board[11][7].setBackground(myColorFourGF);
            board[11][11].setBackground(myColorFiveGF);
            board[11][14].setBackground(myColorFourGF);
            //line 13
            board[12][2].setBackground(myColorFiveGF);
            board[12][6].setBackground(myColorFourGF);
            board[12][8].setBackground(myColorFourGF);
            board[12][12].setBackground(myColorFiveGF);
            //line 14
            board[13][1].setBackground(myColorFiveGF);
            board[13][5].setBackground(myColorTwoGF);
            board[13][9].setBackground(myColorTwoGF);
            board[13][13].setBackground(myColorFiveGF);
            //line 15
            board[14][0].setBackground(myColorGF);
            board[14][3].setBackground(myColorFourGF);        
            board[14][7].setBackground(myColorGF);
            board[14][11].setBackground(myColorFourGF);
            board[14][14].setBackground(myColorGF);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeNRM){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixNRM);
                }
            }
            //line 1
            board[0][0].setBackground(myColorNRM);
            board[0][3].setBackground(myColorFourNRM);        
            board[0][7].setBackground(myColorNRM);
            board[0][11].setBackground(myColorFourNRM);
            board[0][14].setBackground(myColorNRM);
            //line 2
            board[1][1].setBackground(myColorFiveNRM);
            board[1][5].setBackground(myColorTwoNRM);
            board[1][9].setBackground(myColorTwoNRM);
            board[1][13].setBackground(myColorFiveNRM);
            //line 3
            board[2][2].setBackground(myColorFiveNRM);
            board[2][6].setBackground(myColorFourNRM);
            board[2][8].setBackground(myColorFourNRM);
            board[2][12].setBackground(myColorFiveNRM);
            //line 4
            board[3][0].setBackground(myColorFourNRM);
            board[3][3].setBackground(myColorFiveNRM);
            board[3][7].setBackground(myColorFourNRM);
            board[3][11].setBackground(myColorFiveNRM);
            board[3][14].setBackground(myColorFourNRM);
            //line 5
            board[4][4].setBackground(myColorFiveNRM); 
            board[4][10].setBackground(myColorFiveNRM);
            //line 6
            board[5][1].setBackground(myColorTwoNRM);
            board[5][5].setBackground(myColorTwoNRM);
            board[5][9].setBackground(myColorTwoNRM);
            board[5][13].setBackground(myColorTwoNRM);
            //line 7
            board[6][2].setBackground(myColorFourNRM);
            board[6][6].setBackground(myColorFourNRM);
            board[6][8].setBackground(myColorFourNRM);
            board[6][12].setBackground(myColorFourNRM);
            //line 8
            board[7][0].setBackground(myColorNRM);
            board[7][3].setBackground(myColorFourNRM);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourNRM);
            board[7][14].setBackground(myColorNRM);
            //line 9
            board[8][2].setBackground(myColorFourNRM);
            board[8][6].setBackground(myColorFourNRM);
            board[8][8].setBackground(myColorFourNRM);
            board[8][12].setBackground(myColorFourNRM);
            //line 10
            board[9][1].setBackground(myColorTwoNRM);
            board[9][5].setBackground(myColorTwoNRM);
            board[9][9].setBackground(myColorTwoNRM);
            board[9][13].setBackground(myColorTwoNRM);
            //line 11 
            board[10][4].setBackground(myColorFiveNRM); 
            board[10][10].setBackground(myColorFiveNRM);
            //line 12
            board[11][0].setBackground(myColorFourNRM);
            board[11][3].setBackground(myColorFiveNRM);
            board[11][7].setBackground(myColorFourNRM);
            board[11][11].setBackground(myColorFiveNRM);
            board[11][14].setBackground(myColorFourNRM);
            //line 13
            board[12][2].setBackground(myColorFiveNRM);
            board[12][6].setBackground(myColorFourNRM);
            board[12][8].setBackground(myColorFourNRM);
            board[12][12].setBackground(myColorFiveNRM);
            //line 14
            board[13][1].setBackground(myColorFiveNRM);
            board[13][5].setBackground(myColorTwoNRM);
            board[13][9].setBackground(myColorTwoNRM);
            board[13][13].setBackground(myColorFiveNRM);
            //line 15
            board[14][0].setBackground(myColorNRM);
            board[14][3].setBackground(myColorFourNRM);        
            board[14][7].setBackground(myColorNRM);
            board[14][11].setBackground(myColorFourNRM);
            board[14][14].setBackground(myColorNRM);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeE){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixE);
                }
            }
            //line 1
            board[0][0].setBackground(myColorE);
            board[0][3].setBackground(myColorFourE);        
            board[0][7].setBackground(myColorE);
            board[0][11].setBackground(myColorFourE);
            board[0][14].setBackground(myColorE);
            //line 2
            board[1][1].setBackground(myColorFiveE);
            board[1][5].setBackground(myColorTwoE);
            board[1][9].setBackground(myColorTwoE);
            board[1][13].setBackground(myColorFiveE);
            //line 3
            board[2][2].setBackground(myColorFiveE);
            board[2][6].setBackground(myColorFourE);
            board[2][8].setBackground(myColorFourE);
            board[2][12].setBackground(myColorFiveE);
            //line 4
            board[3][0].setBackground(myColorFourE);
            board[3][3].setBackground(myColorFiveE);
            board[3][7].setBackground(myColorFourE);
            board[3][11].setBackground(myColorFiveE);
            board[3][14].setBackground(myColorFourE);
            //line 5
            board[4][4].setBackground(myColorFiveE); 
            board[4][10].setBackground(myColorFiveE);
            //line 6
            board[5][1].setBackground(myColorTwoE);
            board[5][5].setBackground(myColorTwoE);
            board[5][9].setBackground(myColorTwoE);
            board[5][13].setBackground(myColorTwoE);
            //line 7
            board[6][2].setBackground(myColorFourE);
            board[6][6].setBackground(myColorFourE);
            board[6][8].setBackground(myColorFourE);
            board[6][12].setBackground(myColorFourE);
            //line 8
            board[7][0].setBackground(myColorE);
            board[7][3].setBackground(myColorFourE);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourE);
            board[7][14].setBackground(myColorE);
            //line 9
            board[8][2].setBackground(myColorFourE);
            board[8][6].setBackground(myColorFourE);
            board[8][8].setBackground(myColorFourE);
            board[8][12].setBackground(myColorFourE);
            //line 10
            board[9][1].setBackground(myColorTwoE);
            board[9][5].setBackground(myColorTwoE);
            board[9][9].setBackground(myColorTwoE);
            board[9][13].setBackground(myColorTwoE);
            //line 11 
            board[10][4].setBackground(myColorFiveE); 
            board[10][10].setBackground(myColorFiveE);
            //line 12
            board[11][0].setBackground(myColorFourE);
            board[11][3].setBackground(myColorFiveE);
            board[11][7].setBackground(myColorFourE);
            board[11][11].setBackground(myColorFiveE);
            board[11][14].setBackground(myColorFourE);
            //line 13
            board[12][2].setBackground(myColorFiveE);
            board[12][6].setBackground(myColorFourE);
            board[12][8].setBackground(myColorFourE);
            board[12][12].setBackground(myColorFiveE);
            //line 14
            board[13][1].setBackground(myColorFiveE);
            board[13][5].setBackground(myColorTwoE);
            board[13][9].setBackground(myColorTwoE);
            board[13][13].setBackground(myColorFiveE);
            //line 15
            board[14][0].setBackground(myColorE);
            board[14][3].setBackground(myColorFourE);        
            board[14][7].setBackground(myColorE);
            board[14][11].setBackground(myColorFourE);
            board[14][14].setBackground(myColorE);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeSIFY){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixSIFY);
                }
            }
            //line 1
            board[0][0].setBackground(myColorSIFY);
            board[0][3].setBackground(myColorFourSIFY);        
            board[0][7].setBackground(myColorSIFY);
            board[0][11].setBackground(myColorFourSIFY);
            board[0][14].setBackground(myColorSIFY);
            //line 2
            board[1][1].setBackground(myColorFiveSIFY);
            board[1][5].setBackground(myColorTwoSIFY);
            board[1][9].setBackground(myColorTwoSIFY);
            board[1][13].setBackground(myColorFiveSIFY);
            //line 3
            board[2][2].setBackground(myColorFiveSIFY);
            board[2][6].setBackground(myColorFourSIFY);
            board[2][8].setBackground(myColorFourSIFY);
            board[2][12].setBackground(myColorFiveSIFY);
            //line 4
            board[3][0].setBackground(myColorFourSIFY);
            board[3][3].setBackground(myColorFiveSIFY);
            board[3][7].setBackground(myColorFourSIFY);
            board[3][11].setBackground(myColorFiveSIFY);
            board[3][14].setBackground(myColorFourSIFY);
            //line 5
            board[4][4].setBackground(myColorFiveSIFY); 
            board[4][10].setBackground(myColorFiveSIFY);
            //line 6
            board[5][1].setBackground(myColorTwoSIFY);
            board[5][5].setBackground(myColorTwoSIFY);
            board[5][9].setBackground(myColorTwoSIFY);
            board[5][13].setBackground(myColorTwoSIFY);
            //line 7
            board[6][2].setBackground(myColorFourSIFY);
            board[6][6].setBackground(myColorFourSIFY);
            board[6][8].setBackground(myColorFourSIFY);
            board[6][12].setBackground(myColorFourSIFY);
            //line 8
            board[7][0].setBackground(myColorSIFY);
            board[7][3].setBackground(myColorFourSIFY);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourSIFY);
            board[7][14].setBackground(myColorSIFY);
            //line 9
            board[8][2].setBackground(myColorFourSIFY);
            board[8][6].setBackground(myColorFourSIFY);
            board[8][8].setBackground(myColorFourSIFY);
            board[8][12].setBackground(myColorFourSIFY);
            //line 10
            board[9][1].setBackground(myColorTwoSIFY);
            board[9][5].setBackground(myColorTwoSIFY);
            board[9][9].setBackground(myColorTwoSIFY);
            board[9][13].setBackground(myColorTwoSIFY);
            //line 11 
            board[10][4].setBackground(myColorFiveSIFY); 
            board[10][10].setBackground(myColorFiveSIFY);
            //line 12
            board[11][0].setBackground(myColorFourSIFY);
            board[11][3].setBackground(myColorFiveSIFY);
            board[11][7].setBackground(myColorFourSIFY);
            board[11][11].setBackground(myColorFiveSIFY);
            board[11][14].setBackground(myColorFourSIFY);
            //line 13
            board[12][2].setBackground(myColorFiveSIFY);
            board[12][6].setBackground(myColorFourSIFY);
            board[12][8].setBackground(myColorFourSIFY);
            board[12][12].setBackground(myColorFiveSIFY);
            //line 14
            board[13][1].setBackground(myColorFiveSIFY);
            board[13][5].setBackground(myColorTwoSIFY);
            board[13][9].setBackground(myColorTwoSIFY);
            board[13][13].setBackground(myColorFiveSIFY);
            //line 15
            board[14][0].setBackground(myColorSIFY);
            board[14][3].setBackground(myColorFourSIFY);        
            board[14][7].setBackground(myColorSIFY);
            board[14][11].setBackground(myColorFourSIFY);
            board[14][14].setBackground(myColorSIFY);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeON){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixON);
                }
            }
            //line 1
            board[0][0].setBackground(myColorON);
            board[0][3].setBackground(myColorFourON);        
            board[0][7].setBackground(myColorON);
            board[0][11].setBackground(myColorFourON);
            board[0][14].setBackground(myColorON);
            //line 2
            board[1][1].setBackground(myColorFiveON);
            board[1][5].setBackground(myColorTwoON);
            board[1][9].setBackground(myColorTwoON);
            board[1][13].setBackground(myColorFiveON);
            //line 3
            board[2][2].setBackground(myColorFiveON);
            board[2][6].setBackground(myColorFourON);
            board[2][8].setBackground(myColorFourON);
            board[2][12].setBackground(myColorFiveON);
            //line 4
            board[3][0].setBackground(myColorFourON);
            board[3][3].setBackground(myColorFiveON);
            board[3][7].setBackground(myColorFourON);
            board[3][11].setBackground(myColorFiveON);
            board[3][14].setBackground(myColorFourON);
            //line 5
            board[4][4].setBackground(myColorFiveON); 
            board[4][10].setBackground(myColorFiveON);
            //line 6
            board[5][1].setBackground(myColorTwoON);
            board[5][5].setBackground(myColorTwoON);
            board[5][9].setBackground(myColorTwoON);
            board[5][13].setBackground(myColorTwoON);
            //line 7
            board[6][2].setBackground(myColorFourON);
            board[6][6].setBackground(myColorFourON);
            board[6][8].setBackground(myColorFourON);
            board[6][12].setBackground(myColorFourON);
            //line 8
            board[7][0].setBackground(myColorON);
            board[7][3].setBackground(myColorFourON);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourON);
            board[7][14].setBackground(myColorON);
            //line 9
            board[8][2].setBackground(myColorFourON);
            board[8][6].setBackground(myColorFourON);
            board[8][8].setBackground(myColorFourON);
            board[8][12].setBackground(myColorFourON);
            //line 10
            board[9][1].setBackground(myColorTwoON);
            board[9][5].setBackground(myColorTwoON);
            board[9][9].setBackground(myColorTwoON);
            board[9][13].setBackground(myColorTwoON);
            //line 11 
            board[10][4].setBackground(myColorFiveON); 
            board[10][10].setBackground(myColorFiveON);
            //line 12
            board[11][0].setBackground(myColorFourON);
            board[11][3].setBackground(myColorFiveON);
            board[11][7].setBackground(myColorFourON);
            board[11][11].setBackground(myColorFiveON);
            board[11][14].setBackground(myColorFourON);
            //line 13
            board[12][2].setBackground(myColorFiveON);
            board[12][6].setBackground(myColorFourON);
            board[12][8].setBackground(myColorFourON);
            board[12][12].setBackground(myColorFiveON);
            //line 14
            board[13][1].setBackground(myColorFiveON);
            board[13][5].setBackground(myColorTwoON);
            board[13][9].setBackground(myColorTwoON);
            board[13][13].setBackground(myColorFiveON);
            //line 15
            board[14][0].setBackground(myColorON);
            board[14][3].setBackground(myColorFourON);        
            board[14][7].setBackground(myColorON);
            board[14][11].setBackground(myColorFourON);
            board[14][14].setBackground(myColorON);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeV){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixV);
                }
            }
            //line 1
            board[0][0].setBackground(myColorV);
            board[0][3].setBackground(myColorFourV);        
            board[0][7].setBackground(myColorV);
            board[0][11].setBackground(myColorFourV);
            board[0][14].setBackground(myColorV);
            //line 2
            board[1][1].setBackground(myColorFiveV);
            board[1][5].setBackground(myColorTwoV);
            board[1][9].setBackground(myColorTwoV);
            board[1][13].setBackground(myColorFiveV);
            //line 3
            board[2][2].setBackground(myColorFiveV);
            board[2][6].setBackground(myColorFourV);
            board[2][8].setBackground(myColorFourV);
            board[2][12].setBackground(myColorFiveV);
            //line 4
            board[3][0].setBackground(myColorFourV);
            board[3][3].setBackground(myColorFiveV);
            board[3][7].setBackground(myColorFourV);
            board[3][11].setBackground(myColorFiveV);
            board[3][14].setBackground(myColorFourV);
            //line 5
            board[4][4].setBackground(myColorFiveV); 
            board[4][10].setBackground(myColorFiveV);
            //line 6
            board[5][1].setBackground(myColorTwoV);
            board[5][5].setBackground(myColorTwoV);
            board[5][9].setBackground(myColorTwoV);
            board[5][13].setBackground(myColorTwoV);
            //line 7
            board[6][2].setBackground(myColorFourV);
            board[6][6].setBackground(myColorFourV);
            board[6][8].setBackground(myColorFourV);
            board[6][12].setBackground(myColorFourV);
            //line 8
            board[7][0].setBackground(myColorV);
            board[7][3].setBackground(myColorFourV);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourV);
            board[7][14].setBackground(myColorV);
            //line 9
            board[8][2].setBackground(myColorFourV);
            board[8][6].setBackground(myColorFourV);
            board[8][8].setBackground(myColorFourV);
            board[8][12].setBackground(myColorFourV);
            //line 10
            board[9][1].setBackground(myColorTwoV);
            board[9][5].setBackground(myColorTwoV);
            board[9][9].setBackground(myColorTwoV);
            board[9][13].setBackground(myColorTwoV);
            //line 11 
            board[10][4].setBackground(myColorFiveV); 
            board[10][10].setBackground(myColorFiveV);
            //line 12
            board[11][0].setBackground(myColorFourV);
            board[11][3].setBackground(myColorFiveV);
            board[11][7].setBackground(myColorFourV);
            board[11][11].setBackground(myColorFiveV);
            board[11][14].setBackground(myColorFourV);
            //line 13
            board[12][2].setBackground(myColorFiveV);
            board[12][6].setBackground(myColorFourV);
            board[12][8].setBackground(myColorFourV);
            board[12][12].setBackground(myColorFiveV);
            //line 14
            board[13][1].setBackground(myColorFiveV);
            board[13][5].setBackground(myColorTwoV);
            board[13][9].setBackground(myColorTwoV);
            board[13][13].setBackground(myColorFiveV);
            //line 15
            board[14][0].setBackground(myColorV);
            board[14][3].setBackground(myColorFourV);        
            board[14][7].setBackground(myColorV);
            board[14][11].setBackground(myColorFourV);
            board[14][14].setBackground(myColorV);
            centerPanel.updateUI();
        }
        
        if(e.getSource() == themeC){
            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    board[i][j].setBackground(myColorSixC);
                }
            }
            //line 1
            board[0][0].setBackground(myColorC);
            board[0][3].setBackground(myColorFourC);        
            board[0][7].setBackground(myColorC);
            board[0][11].setBackground(myColorFourC);
            board[0][14].setBackground(myColorC);
            //line 2
            board[1][1].setBackground(myColorFiveC);
            board[1][5].setBackground(myColorTwoC);
            board[1][9].setBackground(myColorTwoC);
            board[1][13].setBackground(myColorFiveC);
            //line 3
            board[2][2].setBackground(myColorFiveC);
            board[2][6].setBackground(myColorFourC);
            board[2][8].setBackground(myColorFourC);
            board[2][12].setBackground(myColorFiveC);
            //line 4
            board[3][0].setBackground(myColorFourC);
            board[3][3].setBackground(myColorFiveC);
            board[3][7].setBackground(myColorFourC);
            board[3][11].setBackground(myColorFiveC);
            board[3][14].setBackground(myColorFourC);
            //line 5
            board[4][4].setBackground(myColorFiveC); 
            board[4][10].setBackground(myColorFiveC);
            //line 6
            board[5][1].setBackground(myColorTwoC);
            board[5][5].setBackground(myColorTwoC);
            board[5][9].setBackground(myColorTwoC);
            board[5][13].setBackground(myColorTwoC);
            //line 7
            board[6][2].setBackground(myColorFourC);
            board[6][6].setBackground(myColorFourC);
            board[6][8].setBackground(myColorFourC);
            board[6][12].setBackground(myColorFourC);
            //line 8
            board[7][0].setBackground(myColorC);
            board[7][3].setBackground(myColorFourC);
            board[7][7].setBackground(Color.BLACK);
            board[7][11].setBackground(myColorFourC);
            board[7][14].setBackground(myColorC);
            //line 9
            board[8][2].setBackground(myColorFourC);
            board[8][6].setBackground(myColorFourC);
            board[8][8].setBackground(myColorFourC);
            board[8][12].setBackground(myColorFourC);
            //line 10
            board[9][1].setBackground(myColorTwoC);
            board[9][5].setBackground(myColorTwoC);
            board[9][9].setBackground(myColorTwoC);
            board[9][13].setBackground(myColorTwoC);
            //line 11 
            board[10][4].setBackground(myColorFiveC); 
            board[10][10].setBackground(myColorFiveC);
            //line 12
            board[11][0].setBackground(myColorFourC);
            board[11][3].setBackground(myColorFiveC);
            board[11][7].setBackground(myColorFourC);
            board[11][11].setBackground(myColorFiveC);
            board[11][14].setBackground(myColorFourC);
            //line 13
            board[12][2].setBackground(myColorFiveC);
            board[12][6].setBackground(myColorFourC);
            board[12][8].setBackground(myColorFourC);
            board[12][12].setBackground(myColorFiveC);
            //line 14
            board[13][1].setBackground(myColorFiveC);
            board[13][5].setBackground(myColorTwoC);
            board[13][9].setBackground(myColorTwoC);
            board[13][13].setBackground(myColorFiveC);
            //line 15
            board[14][0].setBackground(myColorC);
            board[14][3].setBackground(myColorFourC);        
            board[14][7].setBackground(myColorC);
            board[14][11].setBackground(myColorFourC);
            board[14][14].setBackground(myColorC);
            centerPanel.updateUI();
        }
        if(e.getSource() == exitAction){
            System.exit(0);
        }
        
        if(e.getSource() == newGameAction){
            window.dispose();
            window w = new window();
        }
    }
}

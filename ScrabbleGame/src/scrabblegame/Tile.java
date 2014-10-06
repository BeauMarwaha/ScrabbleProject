/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabblegame;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 15troupj
 */
public class Tile {
    private String letter;
    private int pV;
    private JButton button = new JButton();
    public Tile(String letter, int pV){
        this.letter = letter;
        this.pV = pV;
    }
    public String getLetter(){
        return letter;
    }
    public void setLetter(String letter){
        this.letter = letter;
    }
    public int getPV(){
        return pV;
    }
    public void setPV(int pV){
        this.pV = pV;
    }
    
    public JButton getButton(){
        button.setText(letter);
        //button.addMouseListener(this);
        return button;
    }

    
}

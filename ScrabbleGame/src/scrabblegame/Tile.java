
package scrabblegame;

import java.awt.event.*;
import javax.swing.*;

public class Tile {
    private String letter;
    private int pV;
    private JButton button = new JButton();
    String[] letterWords = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    int[] letterNumbers = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
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
    
    public void setBlank(String letter){
        this.setLetter(letter.toUpperCase());
        int x = 0;
        for(int i = 0; i < 26; i++){
            if(letter.equalsIgnoreCase(letterWords[i])){
                x = letterNumbers[i];
            }
        }
        this.setPV(x);
    }
    
    public JButton getButton(){
        button.setText(letter);
        return button;
    }

    
}

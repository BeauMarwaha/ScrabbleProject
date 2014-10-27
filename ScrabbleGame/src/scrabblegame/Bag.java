
package scrabblegame;

import java.util.*;

public class Bag {
    
    Stack<Tile> bag = new Stack<Tile>();
    public Bag(){
        for(int i = 0; i < 1; i++){
            Tile k = new Tile("K",5);
            bag.push(k);
            Tile j = new Tile("J",8);
            bag.push(j);
            Tile x = new Tile("X",8);
            bag.push(x);
            Tile q = new Tile("Q",10);
            bag.push(q);
            Tile z = new Tile("Z",10);
            bag.push(z);
        }
        for(int i = 0; i < 2; i++){
            Tile b = new Tile("B",3);
            bag.push(b);
            Tile c = new Tile("C",3);
            bag.push(c);
            Tile m = new Tile("M",3);
            bag.push(m);
            Tile p = new Tile("P",3);
            bag.push(p);
            Tile f = new Tile("F",4);
            bag.push(f);
            Tile h = new Tile("H",4);
            bag.push(h);
            Tile v = new Tile("V",4);
            bag.push(v);
            Tile w = new Tile("W",4);
            bag.push(w);
            Tile y = new Tile("Y",4);
            bag.push(y);
            Tile blank = new Tile("*blank*",0);
            bag.push(blank);
        }
        for(int i = 0; i < 3; i++){
            Tile g = new Tile("G",2);
            bag.push(g);
            
        }
        for(int i = 0; i < 4; i++){
            Tile l = new Tile("L",1);
            bag.push(l);
            Tile s = new Tile("S",1);
            bag.push(s);
            Tile u = new Tile("U",1);
            bag.push(u);
            Tile d = new Tile("D",2);
            bag.push(d);
            
        }
        for(int i = 0; i < 6; i++){
            Tile n = new Tile("N",1);
            bag.push(n);
            Tile r = new Tile("R",1);
            bag.push(r);
            Tile t = new Tile("T",1);
            bag.push(t);
            
        }
        for(int i = 0; i < 8; i++){
            Tile o = new Tile("O",1);
            bag.push(o);
            
        }
        for(int j = 0; j < 9; j++){
            Tile a = new Tile("A",1);
            bag.push(a);
            Tile i = new Tile("I",1);
            bag.push(i);
            
        }
        for(int i = 0; i < 12; i++){
            Tile e = new Tile("E",1);
            bag.push(e);
            
        }
        shuffleBag();
        shuffleBag();
    }
    public void shuffleBag(){
        Collections.shuffle(bag);
        
    }
    public Stack<Tile> getBag(){
        return bag;
    }
    
}

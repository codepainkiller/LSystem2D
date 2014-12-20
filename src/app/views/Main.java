package app.views;

import app.algorithms.LSystemProduction;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        AplicationFrame aplication = new AplicationFrame();
        aplication.setLocationRelativeTo(null);
        aplication.setVisible(true);   
        /*
        Vector<String> rules = new Vector<>();
        String axiom = "F";
        
        rules.add("F[+F]F[-F]F");
        rules.add("F[+F]F");
        rules.add("F[-F]F");
        
        LSystemProduction productions = new LSystemProduction(axiom, rules, 4);
        productions.start();
        */
    
        
    }
}

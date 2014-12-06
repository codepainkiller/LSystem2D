
package app.algorithms;

import java.util.Vector;

public class LSystemProduction extends Thread {
    
    private String axiom;
    private Vector<String> rules;
    private Vector<String> productions;
    private int numProductions;   

    public LSystemProduction(String axiom, Vector<String> rules, int numProductions) {
        this.axiom = axiom;
        this.rules = rules;
        this.numProductions = numProductions;
        this.productions = new Vector<>();
    }

    @Override
    public void run() {
 
        String word = axiom;    
        
        for (int i = 0; i < numProductions; i++) {
            int cont = 0;
            
            while ( cont < word.length() ) {
                
                if ( word.charAt(cont) == 'F' ) {
                    
                    // Generating random number between 0 and 1
                    float randProd = (float) Math.random();
                    
                    if (randProd > 0.0f && randProd <= 0.33f) {
                        word = word.replaceFirst("F", rules.get(0));
                        cont += rules.get(0).length();
                    } 
                    else if (randProd > 0.33f && randProd <= 0.66f) {
                        word = word.replaceFirst("F", rules.get(1));
                        cont += rules.get(1).length();
                    }
                    else if (randProd > 0.66f && randProd <= 1.0f) {
                        word = word.replaceFirst("F", rules.get(2));
                        cont += rules.get(2).length();
                    }
                }
                else {
                    cont ++;
                }
            }
            
            productions.add(word);
        }
    }
    
    
    public String getProduction(int i) {
        return productions.get(i);
    }

    public String getAxiom() {
        return axiom;
    }

    public Vector<String> getRules() {
        return rules;
    }

    public Vector<String> getProductions() {
        return productions;
    }
    
}

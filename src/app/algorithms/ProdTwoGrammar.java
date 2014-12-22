

package app.algorithms;

import java.util.Vector;


public class ProdTwoGrammar extends Thread{
    
    private String axiom;
    private String X;
    private String F;
    private Vector<String> productions = new Vector<>();;
    private int numProductions;

    public ProdTwoGrammar(String axiom, String X, String F, int numProductions) {
        this.axiom = axiom;
        this.X = X;
        this.F = F;
        this.numProductions = numProductions;
        
        this.run();
    }
    
    
    @Override
    public void run() {

        String word = axiom;

        for (int i = 0; i <= numProductions; i++) {
            word = word.replaceAll("F", F);
            word = word.replaceAll("X", X);
            productions.add(word);
        }
    }

    public String getProduction(int i) {
        return productions.get(i);
    }

    public String getAxiom() {
        return axiom;
    }

    public Vector<String> getProductions() {
        return productions;
    }
    
}

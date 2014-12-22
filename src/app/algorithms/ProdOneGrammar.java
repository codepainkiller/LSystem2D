
package app.algorithms;

import java.util.Vector;


public class ProdOneGrammar extends Thread{
    
    private String axiom;
    private String F;
    private Vector<String> productions = new Vector<>();;
    private int numProductions;

    public ProdOneGrammar(String axiom, String F, int numProductions) {
        this.axiom = axiom;
        this.F = F;
        this.numProductions = numProductions;
  
        this.run();
    }
    
    
    @Override
    public void run() {

        String word = axiom;

        for (int i = 0; i <= numProductions; i++) {
            word = word.replaceAll("F", F);
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

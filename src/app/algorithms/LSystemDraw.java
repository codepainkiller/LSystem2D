
package app.algorithms;

import java.util.Stack;
import java.util.Vector;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class LSystemDraw implements GLEventListener{
           
    private Vector<String> productions;
    private float angle;
    private GLAutoDrawable autoDrawable;
    
    private static final float DEGTORAD = 0.0174532925199432957f ;
       
    public LSystemDraw(Vector<String> productions, float angle) {
        this.productions = productions;
        this.angle = angle;
    }

    @Override
    public void init(GLAutoDrawable glad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display(GLAutoDrawable glad) {
        this.autoDrawable = glad;
        this.draw(productions.get(3), 0, 0);
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class Node {
        public float x = 0.0f;
        public float y = 0.0f;
        public float angle = 0.0f;
    }
    
    private void drawLine(float x1, float y1, float x2, float y2) {
        
        final GL2 gl = this.autoDrawable.getGL().getGL2();
        
        gl.glBegin(GL2.GL_LINE);
        gl.glVertex3f(x1, y1, 0);
        gl.glVertex3f(x2, y2, 0);
        gl.glEnd();
    }
    
    public void draw(String word, float initX, float initY) {
        
        float rotAngle = 0.0f;
        float xo = initX;
        float yo = initY;
        float xf = xo;
        float yf = yo;
        
        Stack<Node> nodes = new Stack<>();
        Node currentNode = new Node();
        
        int  i = 0;
        
        while ( i < word.length() ) {
            
            switch ( word.charAt(i) ) {
                
                case 'F' :
                    xf = (float) (xo + 0.1f + Math.cos(rotAngle * DEGTORAD));
                    yf = (float) (yo + 0.1f + Math.cos(rotAngle * DEGTORAD));
                    this.drawLine(xo, yo, xf, yf);
                    xo = xf;
                    yo = yf;
                    break;
                
                case '[' :
                    currentNode.x = xf;
                    currentNode.y = yf;
                    currentNode.angle = rotAngle;
                    nodes.push(currentNode);
                    break;
                    
                case ']' :
                    xo = nodes.peek().x;
                    yo = nodes.peek().y;
                    xf = xo;
                    yf = yo;
                    rotAngle = nodes.peek().angle;
                    nodes.pop();
                    break;
                    
                case '+' :
                    rotAngle += angle;
                    break;
                    
                case '-' :
                    rotAngle -= angle;
                    break;
            }
            
            i++;
        }
    }
}

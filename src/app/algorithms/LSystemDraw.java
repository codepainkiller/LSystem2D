
package app.algorithms;

import com.jogamp.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class LSystemDraw implements GLEventListener {
           
    private Vector<String> productions;
    private float angle;
    private int currentProduction;
    private GLAutoDrawable autoDrawable;
     private int texture;
    
    private static final float DEGTORAD = 0.0174532925199432957f ;
       
    public LSystemDraw(Vector<String> productions, float angle) {
        this.productions = productions;
        this.angle = angle;
        this.currentProduction = 0;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glEnable(GL2.GL_TEXTURE_2D);
        try {
            File im = new File("textures/paisa.jpg");
            com.jogamp.opengl.util.texture.Texture t = TextureIO.newTexture(im, true);
            texture = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
       
       
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        this.autoDrawable = drawable;
        final GL2 gl = this.autoDrawable.getGL().getGL2();
        
        gl.glClearColor(0, 0, 0, 1);
        //this.drawEjes();
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
        
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -0.09f);
        gl.glBegin(GL2.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glScalef(0.04f, 0.04f, 0.04f);
        gl.glColor3f(0, 1, 0);
        this.drawLSystem(productions.get(currentProduction), 1, -25);
        gl.glPopMatrix();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int i, int i1, int i2, int i3) {
        
    }
    
    private class Node {
        public double x_ = 0.0f;
        public double y_ = 0.0f;
        public double angle_ = 0.0f;
    }
    
    private void drawLine(double x1, double y1, double x2, double y2) {
        
        final GL2 gl = this.autoDrawable.getGL().getGL2();
 
        gl.glBegin(GL2.GL_LINES);
        
        gl.glVertex3d(x1, y1, 0);
        gl.glVertex3d(x2, y2, 0);
        gl.glEnd();
    }
    
    public void drawLSystem(String word, double initX, double initY) {
        
        double rotAngle = 90.0f;
        double xo = initX;
        double yo = initY;
        double xf = xo;
        double yf = yo;
        
        Stack<Node> nodes = new Stack<>();
        
        
        int  i = 0;
        
        while ( i < word.length() ) {
 
            switch ( word.charAt(i) ) {
                
                case 'F' :
                    xf = xo + 1.0f * Math.cos(rotAngle * DEGTORAD ) ;
                    yf = yo + 1.0f * Math.sin(rotAngle * DEGTORAD ) ;
                   
                    this.drawLine(xo, yo, xf, yf);
                    xo = xf;
                    yo = yf;
                    break;
                
                case '[' :
                    Node currentNode = new Node();
                    currentNode.x_ = xf;
                    currentNode.y_ = yf;
                    currentNode.angle_ = rotAngle;
                    nodes.push(currentNode);
                    break;
                    
                case ']' :
                    xo = nodes.peek().x_;
                    yo = nodes.peek().y_;
                    xf = xo;
                    yf = yo;
                    rotAngle = nodes.peek().angle_;
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
    
    private void drawEjes() {
        
        //final GL2 gl = drawable.getGL().getGL2();
        final GL2 gl = this.autoDrawable.getGL().getGL2();
        
        gl.glBegin(GL2.GL_LINES);
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glVertex3f(-50.0f, 0.0f, 0.0f);
            gl.glVertex3f(50.0f, 0.0f, 0.0f);

            gl.glColor3f(0.0f, 1.0f, 0.0f);
            gl.glVertex3f(0.0f, -50.0f, 0.0f);
            gl.glVertex3f(0.0f, 50.0f, 0.0f);

            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glVertex3f(0.0f, 0.0f, -50.0f);
            gl.glVertex3f(0.0f, 0.0f, 50.0f);
        gl.glEnd(); 
    }

    public int getCurrentProduction() {
        return currentProduction;
    }

    public void setCurrentProduction(int currentProduction) {
        this.currentProduction = currentProduction;
    }
    
}

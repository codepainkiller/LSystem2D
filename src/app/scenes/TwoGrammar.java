package app.scenes;

import com.jogamp.opengl.util.texture.TextureIO;
import java.awt.DisplayMode;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class TwoGrammar implements GLEventListener {

    private GLAutoDrawable autoDrawable;
    public static DisplayMode dm, dm_old;
    private GLU glu = new GLU();
    private int texture;
    private int timeGrowing = 1;
    private int indexbackground = 1;

    private Vector<String> productions;
    private float angle;
    private int currentProduction;

    private static final float DEGTORAD = 0.0174532925199432957f;

    public TwoGrammar(Vector<String> productions, float angle) {
        this.productions = productions;
        this.angle = angle;
        this.currentProduction = 0;
    }

    @Override
    public void init(GLAutoDrawable drawable) {

        final GL2 gl = drawable.getGL().getGL2();

        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        
        String pathTexture = "textures/background" + Integer.toString(indexbackground) + ".jpg";
        
        try {
            File im = new File(pathTexture);
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
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0f, 0f, -5.0f);

        // Background
        this.drawBackground();
        
        // Tree
        gl.glPushMatrix();
        gl.glScalef(0.04f, 0.04f, 0.04f);
        this.drawLSystem(productions.get(currentProduction), 1, -50);
        gl.glPopMatrix();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        final GL2 gl = drawable.getGL().getGL2();

        if (height <= 0) {
            height = 1;
        }

        final float h = (float) width / (float) height;

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    private class Node {

        public double x_ = 0.0f;
        public double y_ = 0.0f;
        public double angle_ = 0.0f;
    }

    private void drawLine(double x1, double y1, double x2, double y2) {

        final GL2 gl = this.autoDrawable.getGL().getGL2();

        double xm = (x1 + x2) / 2;
        double ym = (y1 + y2) / 2;

        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(x1, y1, 0);
        gl.glVertex3d(x2, y2, 0);
        gl.glEnd();
    }

    private void drawSheet1(double x1, double y1, double x2, double y2) {

        final GL2 gl = this.autoDrawable.getGL().getGL2();

        double xm = (x1 + x2) / 2;
        double ym = (y1 + y2) / 2;

        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3d(x1, y1, 0);
        gl.glVertex3d(xm + 1, ym + 0.5, 0);
        gl.glVertex3d(x2 + 2, y2, 0);
        //gl.glVertex3d(xm-1.5, ym, 0);
        gl.glEnd();
    }

    private void drawSheet2(double x1, double y1, double x2, double y2) {

        final GL2 gl = this.autoDrawable.getGL().getGL2();

        double xm = (x1 + x2) / 2;
        double ym = (y1 + y2) / 2;

        float x = (float) x1;
        float y = (float) y1;
        float a = 1.5f;

        gl.glColor3d(162 / 255.0f, 205 / 255.0f, 90 / 255.0f);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3f(x, y, 0);
        gl.glVertex3f((float) (x + 0.2 * a), (float) (y - 0.15 * a), 0);
        gl.glVertex3f((float) (x + 0.15 * a), y, 0);
        gl.glVertex3f((float) (x + 0.25 * a), (float) (y - 0.1 * a), 0);
        gl.glVertex3f((float) (x + 0.5 * a), (float) (y - 0.2 * a), 0);
        gl.glVertex3f((float) (x + 0.45 * a), (float) (y + 0.05 * a), 0);
        gl.glVertex3f((float) (x + 0.25 * a), (float) (y + 0.2 * a), 0);
        gl.glVertex3f((float) (x + 0.45 * a), (float) (y + 0.15 * a), 0);
        gl.glVertex3f((float) (x + 0.75 * a), (float) (y + 0.3 * a), 0);
        gl.glVertex3f((float) (x + 0.45 * a), (float) (y + 0.45 * a), 0);
        gl.glVertex3f((float) (x + 0.25 * a), (float) (y + 0.4 * a), 0);
        gl.glVertex3f((float) (x + 0.4 * a), (float) (y + 0.5 * a), 0);
        gl.glVertex3f((float) (x + 0.5 * a), (float) (y + 0.85 * a), 0);
        gl.glVertex3f((float) (x + 0.2 * a), (float) (y + 0.7 * a), 0);
        gl.glVertex3f((float) (x + 0.1 * a), (float) (y + 0.5 * a), 0);
        gl.glVertex3f((float) (x + 0.15 * a), (float) (y + 0.7 * a), 0);
        gl.glVertex3f((float) (x + 0.0 * a), (float) (y + 1.0 * a), 0);

        gl.glVertex3f((float) (x - 0.15 * a), (float) (y + 0.7 * a), 0);
        gl.glVertex3f((float) (x - 0.1 * a), (float) (y + 0.5 * a), 0);
        gl.glVertex3f((float) (x - 0.2 * a), (float) (y + 0.7 * a), 0);
        gl.glVertex3f((float) (x - 0.5 * a), (float) (y + 0.85 * a), 0);
        gl.glVertex3f((float) (x - 0.4 * a), (float) (y + 0.5 * a), 0);
        gl.glVertex3f((float) (x - 0.25 * a), (float) (y + 0.4 * a), 0);
        gl.glVertex3f((float) (x - 0.45 * a), (float) (y + 0.45 * a), 0);
        gl.glVertex3f((float) (x - 0.75 * a), (float) (y + 0.3 * a), 0);
        gl.glVertex3f((float) (x - 0.45 * a), (float) (y + 0.15 * a), 0);
        gl.glVertex3f((float) (x - 0.25 * a), (float) (y + 0.2 * a), 0);
        gl.glVertex3f((float) (x - 0.45 * a), (float) (y + 0.05 * a), 0);
        gl.glVertex3f((float) (x - 0.5 * a), (float) (y - 0.2 * a), 0);
        gl.glVertex3f((float) (x - 0.25 * a), (float) (y - 0.1 * a), 0);
        gl.glVertex3f((float) (x - 0.15 * a), y, 0);
        gl.glVertex3f((float) (x - 0.2 * a), (float) (y - 0.15 * a), 0);
        gl.glEnd();

    }

    private void drawSheet3(double x1, double y1) {

        final GL2 gl = this.autoDrawable.getGL().getGL2();

        float x = (float) x1;
        float y = (float) y1;
        float a = 3f;

        gl.glColor3d(162 / 255.0f, 205 / 255.0f, 90 / 255.0f);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3f(x, y, 0);
        gl.glVertex3f((float) (x + 0.5 * a), (float) (y + 0.6 * a), 0);
        gl.glVertex3f((float) (x + 0.2 * a), (float) (y + 0.5 * a), 0);
        gl.glVertex3f(x, (float) (y + 1.0 * a), 0);
        gl.glVertex3f((float) (x - 0.2 * a), (float) (y + 0.5 * a), 0);
        gl.glVertex3f((float) (x - 0.5 * a), (float) (y + 0.6 * a), 0);
        gl.glEnd();
    }
    
    private void drawSheet4(double x1, double y1) {

        final GL2 gl = this.autoDrawable.getGL().getGL2();

        float x = (float) x1;
        float y = (float) y1;
        float a = 3f;
        
        gl.glColor3d(162 / 255.0f, 205 / 255.0f, 90 / 255.0f);
        gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3f(  x       , y  , 0);
            gl.glVertex3f((float) (x+0.3 *a),(float) (y+0.2 *a)  ,0);       
            gl.glVertex3f((float) (x+0.2 *a),(float) (y+0.2 *a)  ,0);
            gl.glVertex3f((float) (x+0.3 *a),(float) (y+0.5 *a)  ,0);    
            gl.glVertex3f((float) (x+0.15*a),(float) (y+0.5 *a)  ,0);    
            gl.glVertex3f((float) (x+0.2 *a),(float) (y+0.7 *a)  ,0);
	    gl.glVertex3f((float) (x+0.1 *a),(float) (y+0.7 *a)  ,0);    
            gl.glVertex3f(         x        ,(float) (y+1.0 *a)  ,0);    
	    gl.glVertex3f((float) (x-0.1 *a),(float) (y+0.7 *a)  ,0);
	    gl.glVertex3f((float) (x-0.2 *a),(float) (y+0.7 *a)  ,0);
	    gl.glVertex3f((float) (x-0.15*a),(float) (y+0.5 *a)  ,0);
	    gl.glVertex3f((float) (x-0.3 *a),(float) (y+0.5 *a)  ,0); 
	    gl.glVertex3f((float) (x-0.2 *a),(float) (y+0.2 *a)  ,0);
	    gl.glVertex3f((float) (x-0.3 *a),(float) (y+0.2 *a)  ,0); 
            gl.glEnd();
    }

    public void drawLSystem(String word, double initX, double initY) {

        final GL2 gl = this.autoDrawable.getGL().getGL2();

        double rotAngle = 90.0f;
        double xo = initX;
        double yo = initY;
        double xf = xo;
        double yf = yo;

        Stack<Node> nodes = new Stack<>();

        int i = 0;

        while (i < word.length()) {

            switch (word.charAt(i)) {

                case 'F':
                    xf = xo + 1.0f * Math.cos(rotAngle * DEGTORAD);
                    yf = yo + 1.0f * Math.sin(rotAngle * DEGTORAD);

                    gl.glColor3d(139 / 255.0f, 134 / 255.0f, 130 / 255.0f);
                    gl.glLineWidth(4);
                    this.drawLine(xo, yo, xf, yf);

                    xo = xf;
                    yo = yf;
                    break;

                case 'X':
                    xf = xo + 1.0f * Math.cos(rotAngle * DEGTORAD);
                    yf = yo + 1.0f * Math.sin(rotAngle * DEGTORAD);
                    
                    gl.glColor3d(69 / 255.0f, 139 / 255.0f, 0);
                    this.drawSheet2(xo, yo, xf, yf);
                    
                    xo = xf;
                    yo = yf;
                    break;

                case '[':
                    Node currentNode = new Node();
                    currentNode.x_ = xf;
                    currentNode.y_ = yf;
                    currentNode.angle_ = rotAngle;
                    nodes.push(currentNode);
                    break;

                case ']':
                    xo = nodes.peek().x_;
                    yo = nodes.peek().y_;
                    xf = xo;
                    yf = yo;
                    rotAngle = nodes.peek().angle_;
                    nodes.pop();
                    break;

                case '+':
                    rotAngle += angle;
                    break;

                case '-':
                    rotAngle -= angle;
                    break;
            }

            i++;
        }
    }

    private void drawBackground() {

        final GL2 gl = this.autoDrawable.getGL().getGL2();

        float size = 2.6f;
        float x = size * 1.56f;
        float y = size;

        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(1, 1, 1);
            gl.glTexCoord2f(0.0f, 0.0f);
            gl.glVertex3f(x, y, -1.0f);

            gl.glTexCoord2f(1.0f, 0.0f);
            gl.glVertex3f(-x, y, -1.0f);

            gl.glTexCoord2f(1.0f, 1.0f);
            gl.glVertex3f(-x, -y, -1.0f);

            gl.glTexCoord2f(0.0f, 1.0f);
            gl.glVertex3f(x, -y, -1.0f);
        gl.glEnd();
    }

    private void drawEjes() {

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
        System.out.println("Nivel de produccion: " + currentProduction);
    }

    public int getTimeGrowing() {
        return timeGrowing;
    }

    public void setTimeGrowing(final int timeGrowing) {
        this.timeGrowing = timeGrowing;
        
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 4; i++) {
                    currentProduction = i;
                    autoDrawable.display();
                    int sleepTime = timeGrowing * 1000;
                    try {                      
                        Thread.sleep(sleepTime);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Time: " + i);
                }
            }
        };

        new Thread(runnable).start();
    }

    public int getIndexbackground() {
        return indexbackground;
    }

    public void setIndexbackground(int indexbackground) {
        this.indexbackground = indexbackground;
    }
}

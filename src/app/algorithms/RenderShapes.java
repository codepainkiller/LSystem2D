package app.algorithms;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class RenderShapes implements GLEventListener {
    
    private GLAutoDrawable gLAutoDrawable;

    public RenderShapes(GLAutoDrawable gLAutoDrawable) {
        this.gLAutoDrawable = gLAutoDrawable;
    }

    public RenderShapes() {
    }
    

    public void drawLine(GLAutoDrawable drawable, int x1, int y1, int x2, int y2) {
        final GL2 gl = drawable.getGL().getGL2();
    }

    public void drawSheet(GLAutoDrawable drawable, int x, int y, float angle) {
        final GL2 gl = drawable.getGL().getGL2();
        
        gl.glBegin(GL2.GL_LINE_STRIP);
        
            gl.glVertex3f(-1, 0, 0);
            gl.glVertex3f(-1, 3, 0);
            gl.glVertex3f(-2, 4, 0);
            gl.glVertex3f(-2.2f, 5.5f, 0);
            gl.glVertex3f(-2.3f, 6.5f, 0);
            gl.glVertex3f(-1.7f,8, 0);
            gl.glVertex3f(-1.2f, 9, 0);
            gl.glVertex3f(0,10, 0);
            gl.glVertex3f(1.2f, 9, 0);
            gl.glVertex3f(1.7f,8, 0);
            gl.glVertex3f(2.3f, 6.5f, 0);
            gl.glVertex3f(2.2f, 5.5f, 0);
            gl.glVertex3f(2, 4, 0);
            gl.glVertex3f(1, 3, 0);
            gl.glVertex3f(1, 0, 0);
        
        gl.glEnd();
    
    }
    
    private void drawEjes(GLAutoDrawable drawable) {
        
        final GL2 gl = drawable.getGL().getGL2();
        
        
        
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
    
    @Override
    public void init(GLAutoDrawable drawable) {
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        gl.glRotatef(-10, 1, 0, 0);
        gl.glRotatef(-30, 0, 1, 0);
        //gl.glRotatef(-30, 1, 0, 0);
        gl.glScalef(0.05f, 0.05f, 0.05f);
        //this.drawEjes(drawable);
        this.drawSheet(drawable, 0, 0, 0);
        
        
        gl.glColor3f(0f, 1f, 0f); //green color

        gl.glBegin(GL2.GL_LINE_STRIP);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(50.0f, 50.0f, 0.0f);

        gl.glEnd();

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int hright) {
    }
}

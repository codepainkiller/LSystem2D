package app.scenes;

import java.awt.DisplayMode;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Cube implements GLEventListener{

   public static DisplayMode dm, dm_old;
   private GLU glu = new GLU();
   private float rquad=0.0f;
   
   @Override
   public void display( GLAutoDrawable drawable ) {
      final GL2 gl = drawable.getGL().getGL2();
      gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );     
      gl.glLoadIdentity();
      gl.glTranslatef( 0f, 0f, -5.0f ); 
      gl.glRotatef( rquad, 1.0f, 1.0f, 1.0f ); // Rotate The Cube On X, Y & Z
      //giving different colors to different sides
      gl.glBegin( GL2.GL_QUADS ); // Start Drawing The Cube
      gl.glColor3f( 1f,0f,0f );   //red color
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
      gl.glColor3f( 0f,1f,0f ); //green color
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad 
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad 
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad 
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 
      gl.glColor3f( 0f,0f,1f ); //blue color
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad 
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 
      gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad 
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)
      gl.glColor3f( 1f,0f,1f ); //purple (red + green)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad 
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 
      gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad 
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad 
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 
      gl.glEnd(); // Done Drawing The Quad
      gl.glFlush();
      rquad -=0.15f;
   }
   @Override
   public void dispose( GLAutoDrawable drawable ) {
   // TODO Auto-generated method stub
   }
   @Override
   public void init( GLAutoDrawable drawable ) {
      final GL2 gl = drawable.getGL().getGL2();
      gl.glShadeModel( GL2.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( GL2.GL_DEPTH_TEST );
      gl.glDepthFunc( GL2.GL_LEQUAL );
      gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
   }
   @Override
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
      final GL2 gl = drawable.getGL().getGL2();
      if( height <=0 )
         height =1;
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( GL2.GL_PROJECTION );
      gl.glLoadIdentity();
      glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      gl.glLoadIdentity();
   }
   
}
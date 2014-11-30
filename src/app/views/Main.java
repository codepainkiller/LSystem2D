package app.views;

import app.scenes.*;

import app.scenes.Cube;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;

public class Main {

    public static void main(String[] args) {
        
        AplicationFrame aplication = new AplicationFrame();
        aplication.setLocationRelativeTo(null);
        aplication.setVisible(true);
        
        /*
        GLProfile.initSingleton();
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        // The canvas 
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        CubeTexture r = new CubeTexture();
        glcanvas.addGLEventListener(r);
        glcanvas.setSize(400, 400);
        
        final JFrame frame = new JFrame(" Textured Cube");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
        animator.start();
                */
    }
}

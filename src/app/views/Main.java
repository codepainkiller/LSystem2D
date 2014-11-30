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
       
    }
}

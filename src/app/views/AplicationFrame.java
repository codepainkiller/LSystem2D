package app.views;

import app.algorithms.LSystemDraw;
import app.algorithms.LSystemProduction;
import app.scenes.CubeTexture;
import com.jogamp.opengl.util.FPSAnimator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

public class AplicationFrame extends javax.swing.JFrame {

    private GLCanvas glcanvas;
    private FPSAnimator animator;
    private GLProfile profile;
    private GLCapabilities capabilities;
    private int widthCanvas;
    private int heightCanvas;
    private boolean animationScene;

    private LSystemProduction productions;
    private LSystemDraw lsd;

    private static final int NUM_PRODUCTIONS = 4;

    public AplicationFrame() {

        initComponents();

        this.initScene();
        this.createProductions();
    }

    private void createProductions() {

        Vector<String> rules = new Vector<>();
        String axiom = "F";

        rules.add("F[+F]F[-F]F");
        rules.add("F[+F]F");
        rules.add("F[-F]F");

        productions = new LSystemProduction(axiom, rules, NUM_PRODUCTIONS);
        productions.start();
    }

    private void initScene() {

        // Capture panel size
        widthCanvas = pnlRender.getWidth();
        heightCanvas = pnlRender.getHeight();

        // Create canvas 
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        capabilities = new GLCapabilities(profile);
        glcanvas = new GLCanvas(capabilities);
        glcanvas.setSize(widthCanvas, heightCanvas);

        // Load scene and add to canvas
        //CubeTexture cubeTexture = new CubeTexture();
        //glcanvas.addGLEventListener(cubeTexture);
        // Add scene panel
        pnlRender.add(glcanvas);
        this.pack();

        // Instance animator
        animator = new FPSAnimator(glcanvas, 500, true);
        animationScene = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRender = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnAnimation = new javax.swing.JButton();
        btnGenerateProd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTime = new javax.swing.JList();
        btnRotationX = new javax.swing.JButton();
        btnRotationY = new javax.swing.JButton();
        btnRotationZ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaLogs = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRender.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlRenderLayout = new javax.swing.GroupLayout(pnlRender);
        pnlRender.setLayout(pnlRenderLayout);
        pnlRenderLayout.setHorizontalGroup(
            pnlRenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 849, Short.MAX_VALUE)
        );
        pnlRenderLayout.setVerticalGroup(
            pnlRenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAnimation.setText("No tocar :v");
        btnAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimationActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnimation, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 130, 40));

        btnGenerateProd.setText("Dibujar L-System");
        btnGenerateProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateProdActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerateProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, 37));

        lstTime.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiempo de crecimiento"));
        lstTime.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1 segundo", "2  segundos", "3  segundos", "4  segundos", "5  segundos", "6  segundos", "7  segundos", "8  segundos", "9  segundos", "10 segundos" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstTime.setSelectedIndex(1);
        jScrollPane2.setViewportView(lstTime);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 145, 114));

        btnRotationX.setText("Rotar X");
        jPanel1.add(btnRotationX, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 230, 138, -1));

        btnRotationY.setText("Rotar Y");
        jPanel1.add(btnRotationY, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 259, 138, -1));

        btnRotationZ.setText("Rotar Z");
        jPanel1.add(btnRotationZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 288, 138, -1));

        txaLogs.setColumns(20);
        txaLogs.setLineWrap(true);
        txaLogs.setRows(5);
        txaLogs.setWrapStyleWord(true);
        txaLogs.setBorder(javax.swing.BorderFactory.createTitledBorder("Producciones"));
        jScrollPane1.setViewportView(txaLogs);

        jMenu1.setText("File");

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("jMenuItem3");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlRender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlRender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimationActionPerformed

        if (!animationScene) {
            animationScene = !animationScene;
            animator.start();
            this.btnAnimation.setText("Stop animation!");
        } else {
            animationScene = !animationScene;
            animator.stop();
            this.btnAnimation.setText("Start animation!");
        }
    }//GEN-LAST:event_btnAnimationActionPerformed

    private void btnGenerateProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateProdActionPerformed

        // Capturas el tiempo de crecimiento
        int time = this.lstTime.getSelectedIndex() + 1;
        System.out.println("Time is: " + time);

        // Mostrando producciones en el Frame
        String cad = "";

        for (int i = 0; i < productions.getProductions().size(); i++) {
            cad += productions.getProduction(i) + "\n\n";
        }
        this.txaLogs.setText(cad);

        // Creammo el objeto
        if (lsd == null) {
            lsd = new LSystemDraw(productions.getProductions(), 25.7f);
            glcanvas.addGLEventListener(lsd);
            System.out.println("Creando nuevo objeto");
        }
        
        // Asigamos el nivel de produccion
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 4; i++) {

                    try {
                        Thread.sleep(time * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    lsd.setCurrentProduction(i);
                    glcanvas.display();
                }
            }
        };
        
        new Thread(runnable).start();
        
        

    }//GEN-LAST:event_btnGenerateProdActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplicationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnimation;
    private javax.swing.JButton btnGenerateProd;
    private javax.swing.JButton btnRotationX;
    private javax.swing.JButton btnRotationY;
    private javax.swing.JButton btnRotationZ;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstTime;
    private javax.swing.JPanel pnlRender;
    private javax.swing.JTextArea txaLogs;
    // End of variables declaration//GEN-END:variables

}

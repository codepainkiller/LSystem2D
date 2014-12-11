package app.views;

import app.algorithms.LSystemDraw;
import app.algorithms.LSystemProduction;
import app.algorithms.RenderShapes;
import app.scenes.CubeTexture;
import com.jogamp.opengl.util.FPSAnimator;
import java.util.Vector;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;


public class AplicationFrame extends javax.swing.JFrame  {

    private GLCanvas glcanvas;
    private FPSAnimator animator;
    private GLProfile profile;
    private GLCapabilities capabilities; 
    private int widthCanvas;
    private int heightCanvas;
    private boolean animationScene;
    
    private LSystemProduction productions;
    
    private static final int NUM_PRODUCTIONS = 6;
  
   
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
        
        LSystemDraw lsd = new LSystemDraw(rules, 25.7f);
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
        //RenderShapes shape = new RenderShapes();
        //glcanvas.addGLEventListener(shape);
        
        
        
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
        jTextField3 = new javax.swing.JTextField();
        btnAnimation = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaLogs = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnGenerateProd = new javax.swing.JButton();
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
            .addGap(0, 661, Short.MAX_VALUE)
        );
        pnlRenderLayout.setVerticalGroup(
            pnlRenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 153, 255))); // NOI18N

        btnAnimation.setText("Start Animation");
        btnAnimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimationActionPerformed(evt);
            }
        });

        txaLogs.setColumns(20);
        txaLogs.setLineWrap(true);
        txaLogs.setRows(5);
        txaLogs.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txaLogs);

        jLabel1.setText("Logs:");

        btnGenerateProd.setText("Generar producciones");
        btnGenerateProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerateProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField3)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnimation)
                    .addComponent(btnGenerateProd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlRender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimationActionPerformed
        
        if ( !animationScene ) {
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
        String cad = "";
        
        for (int i = 0; i < productions.getProductions().size(); i++) {
            cad += productions.getProduction(i) + "\n\n";
        }
        
        this.txaLogs.setText(cad);
    }//GEN-LAST:event_btnGenerateProdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel pnlRender;
    private javax.swing.JTextArea txaLogs;
    // End of variables declaration//GEN-END:variables

  
}

package app.views;

import app.algorithms.ProdEstocatic;
import app.algorithms.ProdOneGrammar;
import app.algorithms.ProdTwoGrammar;
import app.scenes.Estocastic;
import app.scenes.TwoGrammar;
import com.jogamp.opengl.util.FPSAnimator;
import java.util.Vector;
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

    private Vector<String> productions;
    private Estocastic lsd;
    TwoGrammar tg;

    private static final int NUM_PRODUCTIONS = 4;

    public AplicationFrame() {

        initComponents();

        this.initRenderSettings();
        this.createProductions();
    }

    private void createProductions() {

        Vector<String> rules = new Vector<>();
        String axiom = "F";

        rules.add("F[+F]F[-F]F");
        rules.add("F[+F]F");
        rules.add("F[-F]F");
    }

    private void initRenderSettings() {

        // Capture panel size
        widthCanvas = pnlRender.getWidth();
        heightCanvas = pnlRender.getHeight();

        // Create canvas 
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        capabilities = new GLCapabilities(profile);
        glcanvas = new GLCanvas(capabilities);
        glcanvas.setSize(widthCanvas, heightCanvas);

        /// Add scene panel
        pnlRender.add(glcanvas);
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRender = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnGenerateProd = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstScenes = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaLogs = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstTime = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstBackground = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRender.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlRenderLayout = new javax.swing.GroupLayout(pnlRender);
        pnlRender.setLayout(pnlRenderLayout);
        pnlRenderLayout.setHorizontalGroup(
            pnlRenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
        );
        pnlRenderLayout.setVerticalGroup(
            pnlRenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnGenerateProd.setText("Dibujar L-System");
        btnGenerateProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateProdActionPerformed(evt);
            }
        });

        lstScenes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "L-System", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        lstScenes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lstScenes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "L-System 1", "L-System 2", "L-System 3", "L-System 4" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstScenes.setSelectedIndex(0);
        jScrollPane3.setViewportView(lstScenes);

        txaLogs.setColumns(20);
        txaLogs.setLineWrap(true);
        txaLogs.setRows(5);
        txaLogs.setWrapStyleWord(true);
        txaLogs.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Producciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane1.setViewportView(txaLogs);

        lstTime.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Crecimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        lstTime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lstTime.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1 segundo", "2  segundos", "3  segundos", "4  segundos", "5  segundos", "6  segundos", "7  segundos", "8  segundos", "9  segundos", "10 segundos" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstTime.setSelectedIndex(0);
        jScrollPane4.setViewportView(lstTime);

        lstBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Background", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        lstBackground.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lstBackground.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Fondo 1", "Fondo 2", "Fondo 3", "Fondo 4", "Fondo 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstBackground.setSelectedIndex(1);
        jScrollPane2.setViewportView(lstBackground);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGenerateProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu2.setText("File");

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlRender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateProdActionPerformed

        // Captura el tiempo y numero de escena
        int timeGrowing = this.lstTime.getSelectedIndex() + 1;
        int numScene = this.lstScenes.getSelectedIndex() + 1;
        int indexBackground = this.lstBackground.getSelectedIndex() + 1;

        if (numScene == 1) {

            ProdTwoGrammar grammar = new ProdTwoGrammar("X", "F-[[X]+X]+F[+FX]-X", "FF", 4);
            productions = grammar.getProductions();
            tg = new TwoGrammar(productions, 25.0f);

        } else if (numScene == 2) {

            ProdTwoGrammar grammar = new ProdTwoGrammar("X", "FX[-F[X]-X][X+X][+F[X]+X]", "FF", 4);
            productions = grammar.getProductions();
            tg = new TwoGrammar(productions, 22.5f);

        } else if (numScene == 3) {

            ProdTwoGrammar grammar = new ProdTwoGrammar("X", "F[+X]F[-X]+X", "FF", 4);
            productions = grammar.getProductions();
            tg = new TwoGrammar(productions, 20.0f);

        } else if (numScene == 4) {

            ProdTwoGrammar grammar = new ProdTwoGrammar("X", "F[+X][-X]F[+X][-X]FX", "FF", 4);
            productions = grammar.getProductions();
            tg = new TwoGrammar(productions, 30.0f);

        }
        
        tg.setIndexbackground(indexBackground);
        glcanvas.addGLEventListener(tg);
        glcanvas.display();
        tg.setTimeGrowing(timeGrowing);
        

        // Mostrando producciones en el Frame
        String cad = "";
        for (int i = 0; i < productions.size(); i++) 
            cad += productions.get(i) + "\n\n";
        
        this.txaLogs.setText(cad);

    }//GEN-LAST:event_btnGenerateProdActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
    private javax.swing.JButton btnGenerateProd;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList lstBackground;
    private javax.swing.JList lstScenes;
    private javax.swing.JList lstTime;
    private javax.swing.JPanel pnlRender;
    private javax.swing.JTextArea txaLogs;
    // End of variables declaration//GEN-END:variables

}

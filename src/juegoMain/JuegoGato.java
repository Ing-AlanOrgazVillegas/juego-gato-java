package juegoMain;

import frontendUi.Menu;

/**
 *
 * @author Alan
 */
public class JuegoGato extends javax.swing.JFrame {
    
    // Atributos de la clase
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JuegoGato.class.getName());
    private int alto = 400;
    private int ancho = 600;
    
    // ventanas
    Menu menu = new Menu(ancho,alto);
    
    public JuegoGato() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(ancho, alto);
        //setResizable(false);
        ventanaMenu();
    }
    
    private void ventanaMenu(){
        menu.setBounds(0, 0, ventanaPrincipal.getWidth(), ventanaPrincipal.getHeight());
        ventanaPrincipal.add(menu);
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventanaPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));

        ventanaPrincipal.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout ventanaPrincipalLayout = new javax.swing.GroupLayout(ventanaPrincipal);
        ventanaPrincipal.setLayout(ventanaPrincipalLayout);
        ventanaPrincipalLayout.setHorizontalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        ventanaPrincipalLayout.setVerticalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventanaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventanaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JuegoGato().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ventanaPrincipal;
    // End of variables declaration//GEN-END:variables
}

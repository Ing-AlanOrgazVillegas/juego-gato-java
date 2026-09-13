package frontendUi;

import java.awt.Color;

/**
 *
 * @author Alan
 */
public class Menu extends javax.swing.JPanel {
    
    // Atributos
    private String nombreUsuario;
    private boolean tieneNombre = false;
    
    // Constructor 
    
    public Menu(int ancho, int alto) {
        initComponents();
        setSize(ancho,alto);
        setBackground(Color.ORANGE); 
    }
    
    // metodos
    
    private void nombreUsuario(){
        this.nombreUsuario = this.nombreUsuarioTxt.getText();
        System.out.println("Bienvenido " + this.nombreUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnBuscarPartida = new javax.swing.JButton();
        btnHistorialPartidas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nombreUsuarioTxt = new javax.swing.JEditorPane();
        lblNombre = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Juego del gato");
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 6, 264, 60));

        btnBuscarPartida.setText("Buscar partida");
        btnBuscarPartida.addActionListener(this::btnBuscarPartidaActionPerformed);
        add(btnBuscarPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 100, -1, -1));

        btnHistorialPartidas.setText("Historial de partidas");
        btnHistorialPartidas.addActionListener(this::btnHistorialPartidasActionPerformed);
        add(btnHistorialPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 163, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jScrollPane1.setViewportView(nombreUsuarioTxt);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 199, -1));

        lblNombre.setText("Nombre de usuario");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 111, 159, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPartidaActionPerformed
        if (tieneNombre == false) {
            System.out.println("Escribe un nombre antes de jugar");
        }else{
            System.out.println("Buscando partida...");
        }
    }//GEN-LAST:event_btnBuscarPartidaActionPerformed

    private void btnHistorialPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialPartidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistorialPartidasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.nombreUsuarioTxt.getText().isEmpty()) {
            System.out.println("Escribe un nombre de usuario");
        }else{
            nombreUsuario();
            this.tieneNombre = true;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPartida;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHistorialPartidas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JEditorPane nombreUsuarioTxt;
    // End of variables declaration//GEN-END:variables
}

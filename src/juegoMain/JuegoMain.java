package juegoMain;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.Font;


/**
 *
 * @author Alan
 */
public class JuegoMain extends javax.swing.JFrame {
    
    // Atributos
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JuegoMain.class.getName());
    private int ventana = 0;
    private boolean tieneNombre = false;
    private String nombreUsuario;
    private String nombreRival;
    private String usuarioVsRival;
    private String[][] matriz;
    private String valorMovimiento = "";
    private boolean turnoJ1;
    private boolean turnoJ2;
    private int primerTurno;
    private String figuraJ1 = "X";
    private String figuraJ2 = "O";
    private boolean finJuego = false;
    private String nombreGanador = "";
    private int cantidadVictoriasJ1 = 0;
    private int cantidadVictoriasJ2 = 0;
    
    // Constructor
    public JuegoMain() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        seleccionarVentana(ventana);
    }
    
    // Metodos iniciales
    private void seleccionarVentana(int ventanaSeleccionada){
        switch(this.ventana){
            case 0:
                iniciarVentanaMenu();
                break;
            case 1:
                iniciarVentanaJuego();
                break;
            default:
        }
    }
    
    private void iniciarVentanaMenu(){
        this.ventanaMenu.setVisible(true);
        this.ventanaJuego.setVisible(false);
        
        this.ventanaMenu.setBackground(Color.ORANGE);
    }
       
    private void iniciarVentanaJuego(){
        this.ventanaMenu.setVisible(false);
        this.ventanaJuego.setVisible(true);
        
        this.ventanaJuego.setBackground(Color.ORANGE);
        
        usuarioVsRival = getNombreUsuario() + " VS " + this.nombreRival;
        this.lblNombreUsuarioVSnombreRival.setText(usuarioVsRival);
        this.btnRevancha.setVisible(false);
        
        crearTablero();
        primerTurnoJugador();
    }
    
    // Metodo del juego
    private void crearTablero(){
        matriz = new String[][]{
            {"","",""}, // fila 0, con 3 columnas
            {"","",""}, // fila 1, con 3 columnas 
            {"","",""}  // fila 2, con 3 columnas 
        };
        
        this.finJuego = false;
        this.nombreGanador = "";
        
        this.btn00.setText("");
        this.btn00.setEnabled(true);
        
        this.btn01.setText("");
        this.btn01.setEnabled(true);
        
        this.btn02.setText("");
        this.btn02.setEnabled(true);
        
        this.btn10.setText("");
        this.btn10.setEnabled(true);
        
        this.btn11.setText("");
        this.btn11.setEnabled(true);
        
        this.btn12.setText("");
        this.btn12.setEnabled(true);
        
        this.btn20.setText("");
        this.btn20.setEnabled(true);
        
        this.btn21.setText("");
        this.btn21.setEnabled(true);
        
        this.btn22.setText("");
        this.btn22.setEnabled(true);
        
        this.lineaVictoriaColumnaCero.setVisible(false);
        this.lineaVictoriaColumnaUno.setVisible(false);
        this.lineaVictoriaColumnaDos.setVisible(false);
        
        this.lineaVictoriaFilaCero.setVisible(false);
        this.lineaVictoriaFilaUno.setVisible(false);
        this.lineaVictoriaFilaDos.setVisible(false); 
        
        this.lineaVictoriaDiagonalCero0.setVisible(false);
        this.lineaVictoriaDiagonalCero1.setVisible(false);
        this.lineaVictoriaDiagonalCero2.setVisible(false);
        this.lineaVictoriaDiagonalCero3.setVisible(false);
        this.lineaVictoriaDiagonalCero4.setVisible(false);
        this.lineaVictoriaDiagonalCero5.setVisible(false);
        this.lineaVictoriaDiagonalCero6.setVisible(false);
        this.lineaVictoriaDiagonalCero7.setVisible(false);
        this.lineaVictoriaDiagonalCero8.setVisible(false);
        this.lineaVictoriaDiagonalCero9.setVisible(false);
        
        this.lineaVictoriaDiagonalUno0.setVisible(false);
        this.lineaVictoriaDiagonalUno1.setVisible(false);
        this.lineaVictoriaDiagonalUno2.setVisible(false);
        this.lineaVictoriaDiagonalUno3.setVisible(false);
        this.lineaVictoriaDiagonalUno4.setVisible(false);
        this.lineaVictoriaDiagonalUno5.setVisible(false);
        this.lineaVictoriaDiagonalUno6.setVisible(false);
        this.lineaVictoriaDiagonalUno7.setVisible(false);
        this.lineaVictoriaDiagonalUno8.setVisible(false);
        this.lineaVictoriaDiagonalUno9.setVisible(false);
        
    }
    
    private void primerTurnoJugador(){
        Random random = new Random();
        this.primerTurno = random.nextInt(0, 100);
        if (this.primerTurno % 2 == 0) {
            this.turnoJ1 = true;
            this.turnoJ2 = false;
            this.lblNombreJugadorTurnoActual.setText(this.nombreUsuario);
            this.valorMovimiento = this.figuraJ1;
        }else{
            this.turnoJ2 = true;
            this.turnoJ1 = false;
            this.lblNombreJugadorTurnoActual.setText(this.nombreRival);
            this.valorMovimiento = this.figuraJ2;
        }
    }
    
    private void siguienteTurno(boolean fin){
        if (this.turnoJ1 == true && fin == false) {
            this.turnoJ2 = true;
            this.turnoJ1 = false;
            this.lblNombreJugadorTurnoActual.setText(this.nombreRival);
            this.valorMovimiento = this.figuraJ2;
        }else if(this.turnoJ2 == true && fin == false){
            this.turnoJ1 = true;
            this.turnoJ2 = false;
            this.lblNombreJugadorTurnoActual.setText(this.nombreUsuario);
            this.valorMovimiento = this.figuraJ1;
        }else if(this.turnoJ2 == true || this.turnoJ1 == true && fin == true){
            JOptionPane.showMessageDialog(null, "Gana el jugador " + this.nombreGanador);
            if (this.nombreGanador.equals(this.nombreUsuario)) {
                this.cantidadVictoriasJ1++;
                this.lblVictoriasNombreJ1.setText(this.nombreUsuario);
            }else if(this.nombreGanador.equals(this.nombreRival)){
                this.cantidadVictoriasJ2++;
                this.lblVictoriasNombreJ2.setText(this.nombreRival);
            }
            
            // mostrar cantidad de victorias
            this.lblCantidadVictoriasJ1.setText(this.cantidadVictoriasJ1 + "");
            this.lblCantidadVictoriasJ2.setText(this.cantidadVictoriasJ2 + "");
                    
            desactivarBotonesJuego();
            return;
        }
    }
    
    private void desactivarBotonesJuego(){
        this.btn00.setEnabled(false);
        this.btn01.setEnabled(false);
        this.btn02.setEnabled(false);
        
        this.btn10.setEnabled(false);
        this.btn11.setEnabled(false);
        this.btn12.setEnabled(false);
        
        this.btn20.setEnabled(false);
        this.btn21.setEnabled(false);
        this.btn22.setEnabled(false);
        
        this.btnRevancha.setVisible(true);
    }
    
    // metodo de juego
    private void verificarVictoria(){
        
        // revisar columna 0 
        String equisColCero = "";
        String circuloColCero = "";
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0].equals(figuraJ1)) {
                equisColCero = equisColCero + figuraJ1;
                if (equisColCero.length() == 3) {
                    this.nombreGanador = this.nombreUsuario;  
                    finJuego = true;
                    this.lineaVictoriaColumnaCero.setVisible(true);
                    break;
                }
            }else if(matriz[i][0].equals(figuraJ2)){
                circuloColCero = circuloColCero + this.figuraJ2;
                if (circuloColCero.length() == 3) {
                    this.nombreGanador = this.nombreRival;  
                    finJuego = true;
                    this.lineaVictoriaColumnaCero.setVisible(true);
                    break;
                }
            }
        }
        
        // revisar columna 1 
        String equisColUno = "";
        String circuloColUno = "";
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][1].equals(figuraJ1)) {
                equisColUno =  equisColUno + figuraJ1;
                if (equisColUno.length() == 3) {
                    this.nombreGanador = this.nombreUsuario;  
                    finJuego = true;
                    this.lineaVictoriaColumnaUno.setVisible(true);
                    break;
                }
            }else if(matriz[i][1].equals(figuraJ2)){
                circuloColUno = circuloColUno + this.figuraJ2;
                if (circuloColUno.length() == 3) {
                    this.nombreGanador = this.nombreRival;  
                    finJuego = true;
                    this.lineaVictoriaColumnaUno.setVisible(true);
                    break;
                }
            }
        }
        
        // revisar columna 2 
        String equisColDos = "";
        String circuloColDos = "";
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][2].equals(figuraJ1)) {
                equisColDos =  equisColDos + figuraJ1;
                if (equisColDos.length() == 3) {
                    this.nombreGanador = this.nombreUsuario;  
                    finJuego = true;
                    this.lineaVictoriaColumnaDos.setVisible(true);
                    break;
                }
            }else if(matriz[i][2].equals(figuraJ2)){
                circuloColDos = circuloColDos + this.figuraJ2;
                if (circuloColDos.length() == 3) {
                    this.nombreGanador = this.nombreRival;  
                    finJuego = true;
                    this.lineaVictoriaColumnaDos.setVisible(true);
                    break;
                }
            }
        }
        
        // revisar fila 0 
        String equisFilaCero = "";
        String circuloFilaCero = "";
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[0][i].equals(figuraJ1)) {
                equisFilaCero = equisFilaCero + figuraJ1;
                if (equisFilaCero.length() == 3) {
                    this.nombreGanador = this.nombreUsuario;  
                    finJuego = true;
                    this.lineaVictoriaFilaCero.setVisible(true);
                    break;
                }
            }else if(matriz[0][i].equals(figuraJ2)){
                circuloFilaCero = circuloFilaCero + figuraJ2;
                if (circuloFilaCero.length() == 3) {
                    this.nombreGanador = this.nombreRival;  
                    finJuego = true;
                    this.lineaVictoriaFilaCero.setVisible(true);
                    break;
                }
            }
        }
        
        // revisar fila 1
        String equisFilaUno = "";
        String circuloFilaUno = "";
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[1][i].equals(figuraJ1)) {
                equisFilaUno = equisFilaUno + this.figuraJ1;
                if (equisFilaUno.length() == 3) {
                    this.nombreGanador = this.nombreUsuario;  
                    finJuego = true;
                    this.lineaVictoriaFilaUno.setVisible(true);
                    break;
                }
            }else if(matriz[1][i].equals(figuraJ2)){
                circuloFilaUno = circuloFilaUno + this.figuraJ2;
                if (circuloFilaUno.length() == 3) {
                    this.nombreGanador = this.nombreRival;  
                    finJuego = true;
                    this.lineaVictoriaFilaUno.setVisible(true);
                    break;
                }
            }
        }
        
        // revisar fila 2
        String equisFilaDos = "";
        String circuloFilaDos = "";
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[2][i].equals(figuraJ1)) {
                equisFilaDos = equisFilaDos +this.figuraJ1;
                if (equisFilaDos.length() == 3) {
                    this.nombreGanador = this.nombreUsuario;  
                    finJuego = true;
                    this.lineaVictoriaFilaDos.setVisible(true);
                    break;
                }
            }else if(matriz[2][i].equals(figuraJ2)){
                circuloFilaDos = circuloFilaDos + this.figuraJ2;
                if (circuloFilaDos.length() == 3) {
                    this.nombreGanador = this.nombreRival;  
                    finJuego = true;
                    this.lineaVictoriaFilaDos.setVisible(true);
                    break;
                }
            }
        }
        
        // revisar diagonales
        String equisDiagonalCero = "";
        String circuloDiagonalCero = "";
        
        String equisDiagonalUno = "";
        String circuloDiagonalUno= "";
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j && matriz[i][j].equals(figuraJ1)) {
                    equisDiagonalCero = equisDiagonalCero + this.figuraJ1;
                    if (equisDiagonalCero.length() == 3) {
                        this.nombreGanador = this.nombreUsuario; 
                        finJuego = true;
                        dibujarDiagonalCero();
                        break;
                    }
                }else if(i == j && matriz[i][j].equals(figuraJ2)){
                    circuloDiagonalCero = circuloDiagonalCero + this.figuraJ2;
                    if (circuloDiagonalCero.length() == 3) {
                        this.nombreGanador = this.nombreRival; 
                        finJuego = true;
                        dibujarDiagonalCero();
                        break;
                    }
                }
                
                if (i == 1 && j == 1 && matriz[i][j].equals(figuraJ1)) {
                    equisDiagonalUno = equisDiagonalUno + this.figuraJ1;
                }else if(i == 0 && j == 2 && matriz[i][j].equals(figuraJ1)){
                    equisDiagonalUno = equisDiagonalUno + this.figuraJ1;
                }else if(i == 2 && j == 0 && matriz[i][j].equals(figuraJ1)){
                    equisDiagonalUno = equisDiagonalUno + this.figuraJ1;
                }
                
                if(i == 1 && j == 1 && matriz[i][j].equals(figuraJ2)){
                    circuloDiagonalUno = circuloDiagonalUno + this.figuraJ2;
                }else if(i == 0 && j == 2 && matriz[i][j].equals(figuraJ2)){
                    circuloDiagonalUno = circuloDiagonalUno + this.figuraJ2;
                }else if(i == 2 && j == 0 && matriz[i][j].equals(figuraJ2)){
                    circuloDiagonalUno = circuloDiagonalUno + this.figuraJ2;
                }
                
                
                
                if (equisDiagonalUno.length() == 3) {
                    this.nombreGanador = this.nombreUsuario; 
                    finJuego = true;
                    dibujarDiagonalUno();
                    break;
                }
                if (circuloDiagonalUno.length() == 3) {
                    this.nombreGanador = this.nombreRival; 
                    finJuego = true;
                    dibujarDiagonalUno();
                    break;
                }
            }
        }
        
        siguienteTurno(finJuego);
    }
    
    private void dibujarDiagonalCero(){
        this.lineaVictoriaDiagonalCero0.setVisible(true);
        this.lineaVictoriaDiagonalCero1.setVisible(true);
        this.lineaVictoriaDiagonalCero2.setVisible(true);
        this.lineaVictoriaDiagonalCero3.setVisible(true);
        this.lineaVictoriaDiagonalCero4.setVisible(true);
        this.lineaVictoriaDiagonalCero5.setVisible(true);
        this.lineaVictoriaDiagonalCero6.setVisible(true);
        this.lineaVictoriaDiagonalCero7.setVisible(true);
        this.lineaVictoriaDiagonalCero8.setVisible(true);
        this.lineaVictoriaDiagonalCero9.setVisible(true);
    }
    
    private void dibujarDiagonalUno(){
        this.lineaVictoriaDiagonalUno0.setVisible(true);
        this.lineaVictoriaDiagonalUno1.setVisible(true);
        this.lineaVictoriaDiagonalUno2.setVisible(true);
        this.lineaVictoriaDiagonalUno3.setVisible(true);
        this.lineaVictoriaDiagonalUno4.setVisible(true);
        this.lineaVictoriaDiagonalUno5.setVisible(true);
        this.lineaVictoriaDiagonalUno6.setVisible(true);
        this.lineaVictoriaDiagonalUno7.setVisible(true);
        this.lineaVictoriaDiagonalUno8.setVisible(true);
        this.lineaVictoriaDiagonalUno9.setVisible(true);
    }
    
    // setter y getter
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombre){
        this.nombreUsuario = nombre;
    }

    public String getNombreRival(){
        return this.nombreRival;
    }
    
    public void setNombreRival(String rival){
        this.nombreRival = rival;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventanaMenu = new javax.swing.JPanel();
        btnJugar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnSalirJuego = new javax.swing.JButton();
        nombreUsuarioTxt = new javax.swing.JTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblListoParaJugar = new javax.swing.JLabel();
        lblJugadorRival = new javax.swing.JLabel();
        nombreRivalTxt = new javax.swing.JTextField();
        ventanaJuego = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblNombreUsuarioVSnombreRival = new javax.swing.JLabel();
        panelJuegoInteractivo = new javax.swing.JPanel();
        lineaVictoriaColumnaCero = new javax.swing.JSeparator();
        lineaVictoriaColumnaUno = new javax.swing.JSeparator();
        lineaVictoriaColumnaDos = new javax.swing.JSeparator();
        lineaVictoriaFilaCero = new javax.swing.JSeparator();
        lineaVictoriaFilaUno = new javax.swing.JSeparator();
        lineaVictoriaFilaDos = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero0 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero1 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero2 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero3 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero4 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero5 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero6 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero7 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero8 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalCero9 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno0 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno1 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno2 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno3 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno4 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno5 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno6 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno7 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno8 = new javax.swing.JSeparator();
        lineaVictoriaDiagonalUno9 = new javax.swing.JSeparator();
        btn00 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        lblTituloTurno = new javax.swing.JLabel();
        lblNombreJugadorTurnoActual = new javax.swing.JLabel();
        lblTituloVictorias = new javax.swing.JLabel();
        lblVictoriasNombreJ1 = new javax.swing.JLabel();
        lblVictoriasNombreJ2 = new javax.swing.JLabel();
        lblCantidadVictoriasJ1 = new javax.swing.JLabel();
        lblCantidadVictoriasJ2 = new javax.swing.JLabel();
        btnRevancha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ventanaMenu.setName("ventanaMenu"); // NOI18N
        ventanaMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(this::btnJugarActionPerformed);
        ventanaMenu.add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 40));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Juego del gato");
        ventanaMenu.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 260, 70));

        btnSalirJuego.setText("Salir del juego");
        btnSalirJuego.addActionListener(this::btnSalirJuegoActionPerformed);
        ventanaMenu.add(btnSalirJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 130, 40));
        ventanaMenu.add(nombreUsuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 240, -1));

        lblNombreUsuario.setText("Escribe un nombre del jugador 1");
        ventanaMenu.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 180, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        ventanaMenu.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        lblListoParaJugar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblListoParaJugar.setText("Listo para jugar?");
        ventanaMenu.add(lblListoParaJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 260, -1));

        lblJugadorRival.setText("Escribe el nombre del jugador 2");
        ventanaMenu.add(lblJugadorRival, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));
        ventanaMenu.add(nombreRivalTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 240, -1));

        getContentPane().add(ventanaMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        ventanaJuego.setPreferredSize(new java.awt.Dimension(600, 600));
        ventanaJuego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(this::btnRegresarActionPerformed);
        ventanaJuego.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
        ventanaJuego.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 580, 10));

        lblNombreUsuarioVSnombreRival.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsuarioVSnombreRival.setText("nombreUsuario VS nombreRival");
        ventanaJuego.add(lblNombreUsuarioVSnombreRival, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 330, -1));

        panelJuegoInteractivo.setBackground(new java.awt.Color(255, 255, 255));
        panelJuegoInteractivo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lineaVictoriaColumnaCero.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaColumnaCero.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaColumnaCero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaColumnaCero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 20, 390));

        lineaVictoriaColumnaUno.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaColumnaUno.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaColumnaUno.setAlignmentX(10.0F);
        lineaVictoriaColumnaUno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaColumnaUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 20, 390));

        lineaVictoriaColumnaDos.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaColumnaDos.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaColumnaDos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaColumnaDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 20, 390));

        lineaVictoriaFilaCero.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaFilaCero.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaFilaCero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaFilaCero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 480, 20));

        lineaVictoriaFilaUno.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaFilaUno.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaFilaUno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaFilaUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 480, 20));

        lineaVictoriaFilaDos.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaFilaDos.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaFilaDos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaFilaDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 480, 20));

        lineaVictoriaDiagonalCero0.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero0.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero0, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 60, 40));

        lineaVictoriaDiagonalCero1.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero1.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 60, 40));

        lineaVictoriaDiagonalCero2.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero2.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 60, 40));

        lineaVictoriaDiagonalCero3.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero3.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 60, 40));

        lineaVictoriaDiagonalCero4.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero4.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 60, 40));

        lineaVictoriaDiagonalCero5.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero5.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 60, 40));

        lineaVictoriaDiagonalCero6.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero6.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 60, 40));

        lineaVictoriaDiagonalCero7.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero7.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 60, 40));

        lineaVictoriaDiagonalCero8.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero8.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 60, 40));

        lineaVictoriaDiagonalCero9.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero9.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalCero9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalCero9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 60, 40));

        lineaVictoriaDiagonalUno0.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno0.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno0, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 60, 40));

        lineaVictoriaDiagonalUno1.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno1.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 60, 40));

        lineaVictoriaDiagonalUno2.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno2.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 60, 40));

        lineaVictoriaDiagonalUno3.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno3.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 60, 40));

        lineaVictoriaDiagonalUno4.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno4.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 60, 40));

        lineaVictoriaDiagonalUno5.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno5.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 60, 40));

        lineaVictoriaDiagonalUno6.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno6.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 60, 40));

        lineaVictoriaDiagonalUno7.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno7.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 60, 40));

        lineaVictoriaDiagonalUno8.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno8.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 60, 40));

        lineaVictoriaDiagonalUno9.setBackground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno9.setForeground(new java.awt.Color(204, 0, 0));
        lineaVictoriaDiagonalUno9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 20));
        panelJuegoInteractivo.add(lineaVictoriaDiagonalUno9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 60, 40));

        btn00.setPreferredSize(new java.awt.Dimension(70, 10));
        btn00.addActionListener(this::btn00ActionPerformed);
        panelJuegoInteractivo.add(btn00, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 150));

        btn01.setPreferredSize(new java.awt.Dimension(70, 10));
        btn01.addActionListener(this::btn01ActionPerformed);
        panelJuegoInteractivo.add(btn01, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 180, 150));

        btn02.addActionListener(this::btn02ActionPerformed);
        panelJuegoInteractivo.add(btn02, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 180, 150));

        btn10.addActionListener(this::btn10ActionPerformed);
        panelJuegoInteractivo.add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 180, 150));

        btn11.addActionListener(this::btn11ActionPerformed);
        panelJuegoInteractivo.add(btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 180, 150));

        btn12.addActionListener(this::btn12ActionPerformed);
        panelJuegoInteractivo.add(btn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 180, 150));

        btn20.addActionListener(this::btn20ActionPerformed);
        panelJuegoInteractivo.add(btn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 150));

        btn21.addActionListener(this::btn21ActionPerformed);
        panelJuegoInteractivo.add(btn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 180, 150));

        btn22.addActionListener(this::btn22ActionPerformed);
        panelJuegoInteractivo.add(btn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 180, 150));

        ventanaJuego.add(panelJuegoInteractivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 540, 450));

        lblTituloTurno.setText("Turno de:");
        ventanaJuego.add(lblTituloTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 80, -1));

        lblNombreJugadorTurnoActual.setText("nombreJugador");
        ventanaJuego.add(lblNombreJugadorTurnoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 140, -1));

        lblTituloVictorias.setText("Victorias");
        ventanaJuego.add(lblTituloVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, -1, -1));

        lblVictoriasNombreJ1.setText("NombreJ1");
        ventanaJuego.add(lblVictoriasNombreJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 180, -1));

        lblVictoriasNombreJ2.setText("NombreJ2");
        ventanaJuego.add(lblVictoriasNombreJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 150, -1));

        lblCantidadVictoriasJ1.setText("0");
        ventanaJuego.add(lblCantidadVictoriasJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, -1, -1));

        lblCantidadVictoriasJ2.setText("0");
        ventanaJuego.add(lblCantidadVictoriasJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, -1, -1));

        btnRevancha.setText("Revancha");
        btnRevancha.addActionListener(this::btnRevanchaActionPerformed);
        ventanaJuego.add(btnRevancha, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        getContentPane().add(ventanaJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Metodo del menu
    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        if (this.tieneNombre == true) {
            this.ventana = 1;
            seleccionarVentana(ventana); 
        }else{
            JOptionPane.showMessageDialog(null, "Debes poner un nombre de jugador");
        }
    }//GEN-LAST:event_btnJugarActionPerformed
  
    // Metodo del juego
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.ventana = 0;
        seleccionarVentana(ventana);
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Metodo del menu
    private void btnSalirJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirJuegoActionPerformed
        var salir = JOptionPane.showConfirmDialog(null, "¿Deseas salir?");
        // si = 0  no = 1  cancelar = 2
        if (salir == 0) {
            dispose();
        }else{
            return;
        }
    }//GEN-LAST:event_btnSalirJuegoActionPerformed

    // Metodo del menu
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.nombreUsuarioTxt.getText().equals("") || this.nombreUsuarioTxt.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Debes poner un nombre del jugador 1");
        }else if(this.nombreRivalTxt.getText().equals("") || this.nombreRivalTxt.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Debes poner un nombre del jugador 2");
        }else{
            JOptionPane.showMessageDialog(null, "Bienvenido " + this.nombreUsuarioTxt.getText() + " y "
            + this.nombreRivalTxt.getText());
            this.tieneNombre = true;
            setNombreUsuario(this.nombreUsuarioTxt.getText().strip());
            setNombreRival(this.nombreRivalTxt.getText().strip());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    // Metodos del juego las X y los O
    private void btn00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00ActionPerformed
        this.btn00.setText(valorMovimiento);
        this.btn00.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[0][0] = this.valorMovimiento;
        verificarVictoria();
        this.btn00.setEnabled(false);
    }//GEN-LAST:event_btn00ActionPerformed

    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01ActionPerformed
        this.btn01.setText(valorMovimiento);
        this.btn01.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[0][1] = this.valorMovimiento;
        verificarVictoria();
        this.btn01.setEnabled(false);
    }//GEN-LAST:event_btn01ActionPerformed

    private void btn02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn02ActionPerformed
        this.btn02.setText(valorMovimiento);
        this.btn02.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[0][2] = this.valorMovimiento;
        verificarVictoria();
        this.btn02.setEnabled(false);
    }//GEN-LAST:event_btn02ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        this.btn10.setText(valorMovimiento);
        this.btn10.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[1][0] = this.valorMovimiento;
        verificarVictoria();
        this.btn10.setEnabled(false);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        this.btn11.setText(valorMovimiento);
        this.btn11.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[1][1] = this.valorMovimiento;
        verificarVictoria();
        this.btn11.setEnabled(false);
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        this.btn12.setText(valorMovimiento);
        this.btn12.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[1][2] = this.valorMovimiento;
        verificarVictoria();
        this.btn12.setEnabled(false);
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        this.btn20.setText(valorMovimiento);
        this.btn20.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[2][0] = this.valorMovimiento;
        verificarVictoria();
        this.btn20.setEnabled(false);
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        this.btn21.setText(valorMovimiento);
        this.btn21.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[2][1] = this.valorMovimiento;
        verificarVictoria();
        this.btn21.setEnabled(false);
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        this.btn22.setText(valorMovimiento);
        this.btn22.setFont(new Font("Arial", Font.BOLD, 100));
        matriz[2][2] = this.valorMovimiento;
        verificarVictoria();
        this.btn22.setEnabled(false);
    }//GEN-LAST:event_btn22ActionPerformed

    private void btnRevanchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevanchaActionPerformed
        this.panelJuegoInteractivo.revalidate();
        this.panelJuegoInteractivo.repaint();
        crearTablero();
    }//GEN-LAST:event_btnRevanchaActionPerformed

    
    
    
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
        java.awt.EventQueue.invokeLater(() -> new JuegoMain().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRevancha;
    private javax.swing.JButton btnSalirJuego;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidadVictoriasJ1;
    private javax.swing.JLabel lblCantidadVictoriasJ2;
    private javax.swing.JLabel lblJugadorRival;
    private javax.swing.JLabel lblListoParaJugar;
    private javax.swing.JLabel lblNombreJugadorTurnoActual;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblNombreUsuarioVSnombreRival;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloTurno;
    private javax.swing.JLabel lblTituloVictorias;
    private javax.swing.JLabel lblVictoriasNombreJ1;
    private javax.swing.JLabel lblVictoriasNombreJ2;
    private javax.swing.JSeparator lineaVictoriaColumnaCero;
    private javax.swing.JSeparator lineaVictoriaColumnaDos;
    private javax.swing.JSeparator lineaVictoriaColumnaUno;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero0;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero1;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero2;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero3;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero4;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero5;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero6;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero7;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero8;
    private javax.swing.JSeparator lineaVictoriaDiagonalCero9;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno0;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno1;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno2;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno3;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno4;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno5;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno6;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno7;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno8;
    private javax.swing.JSeparator lineaVictoriaDiagonalUno9;
    private javax.swing.JSeparator lineaVictoriaFilaCero;
    private javax.swing.JSeparator lineaVictoriaFilaDos;
    private javax.swing.JSeparator lineaVictoriaFilaUno;
    private javax.swing.JTextField nombreRivalTxt;
    private javax.swing.JTextField nombreUsuarioTxt;
    private javax.swing.JPanel panelJuegoInteractivo;
    private javax.swing.JPanel ventanaJuego;
    private javax.swing.JPanel ventanaMenu;
    // End of variables declaration//GEN-END:variables
}

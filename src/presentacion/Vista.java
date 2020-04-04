
package presentacion;

import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Vista extends javax.swing.JFrame {

    private Modelo modelo;
    private Controlador control;
    private int contadorVidas=3;
    
    public Vista(Modelo aThis) {
        modelo = aThis;
        initComponents();
        asignarEventos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new java.awt.Canvas();
        lblTextVidas = new javax.swing.JLabel();
        lblVidas = new javax.swing.JLabel();
        lblTextTiempo = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Frogger");
        setResizable(false);

        lienzo.setMaximumSize(new java.awt.Dimension(270, 360));
        lienzo.setMinimumSize(new java.awt.Dimension(270, 360));

        lblTextVidas.setFont(new java.awt.Font("Charlemagne Std", 1, 24)); // NOI18N
        lblTextVidas.setText("Vidas:");

        lblVidas.setFont(new java.awt.Font("Charlemagne Std", 1, 24)); // NOI18N
        lblVidas.setText("3");

        lblTextTiempo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTextTiempo.setText("Tiempo:");

        lblTiempo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTiempo.setText("40");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTextVidas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTextTiempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTextVidas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVidas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTextTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTextTiempo;
    private javax.swing.JLabel lblTextVidas;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblVidas;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables


    public JLabel getVidas() {
        return lblVidas;
    }

    public void setVidas(JLabel vidas) {
        this.lblVidas = vidas;
    }
    private void asignarEventos() {
        lienzo.addKeyListener(getControl());
        
    }
    public Modelo getModelo() {
        if(modelo == null){
            modelo = new Modelo();
        }
        return modelo;
    }
    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }
    public Canvas getLienzo() {
        return lienzo;
    }

    public int getContadorVidas() {
        return contadorVidas;
    }
    
    public void avisarVidas(boolean evento){
        if(evento==true && contadorVidas>0){
            contadorVidas=contadorVidas-1;
            lblVidas.setText(""+contadorVidas);
        }else{
            if(evento==true && contadorVidas<=0){
                contadorVidas=contadorVidas-1;
                JOptionPane.showMessageDialog(null, "PERDISTE EL JUEGO!!");
            }
        }
    }
    public void victoria (){
        JOptionPane.showMessageDialog(null, "Felicidades, ¡¡GANASTE!!");
    }

    void mostrarTiempoRestante(int tiempoRestante) {
       lblTiempo.setText(""+tiempoRestante);
    }
}

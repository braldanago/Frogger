package logica;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tronco extends Thread{
    private int posX, posY,direccionTronco;
    private Image[] imgTronco;
    private boolean estaVivo=true;

    public Tronco() {
        imgTronco = new Image[1];
        imgTronco[0] = new ImageIcon(getClass().getResource("/imagenes/Tronco.png")).getImage();
    }
    public int getPosX() {
        return ((int)(posX/30));
    }
    public int getPosY() {
        return posY;
    }
    public int getPosXPix() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX*30;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Image getImgTronco() {        
        return imgTronco[0];
    }
    @Override
    public void run(){
        while(estaVivo){
            if(direccionTronco==1){
                avanzarTroncoDerecha();
            }else{
                avanzarTroncoIzquierda();
            }
        }
    }
    public void elegirDireccion(int num){
        direccionTronco = num;
    }
    
     private void avanzarTroncoDerecha() {
        if(posX<=270){
            posX=posX+1;
        }
        if(posX>270){
            posX=0;
        }
        esperar(15);
    }
    private void avanzarTroncoIzquierda(){
        if(posX>=0){
            posX=posX-1;
        }
        if(posX<0){
            posX=270;
        }
        esperar(15);
    }

    private void esperar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
    
    
}

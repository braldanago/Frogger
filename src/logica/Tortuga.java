package logica;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tortuga extends Thread{
    private int posX, posY;
    private Image[] imgTortuga;
    private boolean estaVivo=true;

    public Tortuga() {
        imgTortuga = new Image[1];
        imgTortuga[0] = new ImageIcon(getClass().getResource("/imagenes/Tortuga.PNG")).getImage();
        
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
    public Image getImgTortuga() {        
        return imgTortuga[0];
    }
    
    @Override
    public void run(){
        while(estaVivo){
            avanzarTortugaIzquierda();
        }   
    }
    private void avanzarTortugaIzquierda(){
        if(posX>=-110){
            posX=posX-1;
        }
        if(posX<-110){
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

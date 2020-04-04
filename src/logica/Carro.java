package logica;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Carro extends Thread{
    private int posX, posY,identificadorCarro=1,direccionCarro;
    private Image[] imgCarro;
    private Sistema sistema;
    private boolean estaVivo=true;
    public Carro() {
        imgCarro = new Image[2];
        imgCarro[0] = new ImageIcon(getClass().getResource("/imagenes/CARROD.png")).getImage();
        imgCarro[1] = new ImageIcon(getClass().getResource("/imagenes/CARROI.png")).getImage();
        //posX = 0;
        //posY = 11;
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

    public Image getImgCarro(int direccion) {    
        if (direccion == 1){//derecha
            return imgCarro[0];
        }
        else{//izquierda
            return imgCarro[1];
        }          
    }
    
    @Override
    public void run(){
        while(estaVivo){
            if(direccionCarro==1){
                avanzarCarroDerecha();
            }else{
                avanzarCarroIzquierda();
            }
        }
    }
    
    public void elegirDireccion(int num){
        direccionCarro = num;
    }

    private void avanzarCarroDerecha() {
        if(posX<=270){
            posX=posX+1;
        }
        if(posX>270){
            posX=0;
        }
        esperar(4);
    }
    
    private void avanzarCarroIzquierda(){
        if(posX>=0){
            posX=posX-1;
        }
        if(posX<0){
            posX=270;
        }
        esperar(4);
    }

    private void esperar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
 
}

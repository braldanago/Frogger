package logica;

import java.awt.Image;
import javax.swing.ImageIcon;
import presentacion.Modelo;

public class Frog extends Thread {
    private int posX, posY,num=0;
    private Sistema sistema;
    private Modelo modelo;
    private boolean estaVivo=true;
    private Image[] imgSapo; 
    private int posXPix;
    private boolean noSeMovio;

    public Frog() {
        imgSapo = new Image[4];
        for(int i=0;i<4;i++){
            imgSapo[i] = new ImageIcon(getClass().getResource("/imagenes/Sapo0"+(i+1)+".png")).getImage();
        }
        posXPix =0;
        posX = 4;
        posY = 12;
    }
    
    public Image getImgSapo() {        
        return imgSapo[num];
    }
    public int direccionSapo(int nume){
        this.num = nume;
        return num;
    }
    public Sistema getSistema() {
        if(sistema == null){
            sistema = new Sistema();
        }
        return sistema;
    }

    public int getPosX() {
        return this.posX;
    }
    public int getPosY() {
        return this.posY;
    }
    public void reiniciarPosY(int y){
        this.posY=y;
    }
    public void reiniciarPosX(int x){
        this.posX=x;
        posXPix = x*30;
    }
            
    
    @Override
    public void run() {
        while(estaVivo){
            getPosX();
            getPosY();
            
        }
    }
    
    private void espera(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }

    public void setPosX(int posiX) {
        posX = posX+posiX;
        if(posX==9){
            posX=posX-1; 
        }
        if(posX==-1){
            posX=posX+1;  
        }
        noSeMovio = false;
        espera(1);
    }

    public void setPosY(int posiY) {
        
        posY=posY+posiY;
        if(posY==13){
            posY=posY-1;
        }
        if(posY==-1){
            posY=posY+1;  
        }
        espera(1);
    }
    public void moverEnObjeto(boolean condicion, int objeto){
        if(noSeMovio){
            if((condicion)&&(objeto == 0)){
                posX = (int) (posXPix/30);
                if(posXPix<=270){
                    posXPix=posXPix+1;
                }
                if(posXPix>270){
                    getModelo().getVentanaInicial().avisarVidas(true);
                    reiniciarPosX(4);
                    reiniciarPosY(12);
                }
                espera(13);
            }else{
                if((condicion)&&(objeto == 4)){
                    posX = (int) (posXPix/30);
                    if(posXPix>=-15){
                        posXPix=posXPix-1;
                    }
                    if(posXPix<0){
                        getModelo().getVentanaInicial().avisarVidas(true);
                        reiniciarPosX(4);
                        reiniciarPosY(12);
                    }
                    espera(13);
                }else{
                    posXPix = (posX*30);
                }
            }
        }else{ 
            posXPix = (posX*30);
            noSeMovio = true;
            posXPix = (posX*30)+15;
        }
    }
    public void setPosXPix(int posX){
        posXPix = posX;
    }
    public int getPosXPix(){
        return posXPix;
    }
    private void esperar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
    private Modelo getModelo() {
        if(modelo == null){
            modelo = new Modelo();
        }
        return modelo;
    }
    public Image getImgPosGanada() {
       Image imgFrogGanada = new ImageIcon(getClass().getResource("/imagenes/WinFrog.png")).getImage();
       return imgFrogGanada;
    }
}

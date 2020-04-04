package presentacion;

import java.awt.Canvas;
import logica.Sistema;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import logica.Carro;
import logica.Frog;
import logica.Mapa;
import logica.Tortuga;
import logica.Tronco;

public class Modelo implements Runnable{
    
    private Thread hiloDibujo;
    private Sistema sistema;
    private Vista ventanaInicial;
    private Frog sapo;
    private Carro carro1, carro2,carro3,carro4;
    private Tronco tronco1,tronco2,tronco3;
    private Tortuga tortuga1,tortuga2;
    private Canvas lienzo;
    private BufferedImage dobleBuffer;
    private Mapa mapa;
    private boolean estaVivo=true, condicionMeta=false;
    private int [][] banderas = new int[9][2];
    private int contadorBanderas=0;
    private int lugar;
    public Modelo() {
        lienzo = getVentanaInicial().getLienzo();
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        //hiloDibujo = new Thread(this);
    }
     public Vista getVentanaInicial() {
        if(ventanaInicial == null){
            ventanaInicial = new Vista(this);
        }
        return ventanaInicial;
    }
    
    public void perderVidas(){//VERIFICA CUANDO SE PIERDE ALGUNA VIDA, EN CASO DE SER VERDADERO SE ENVIA A LA VISTA Y SE MODIFICAN VALORES
        if(getSistema().verificarColision()|| getSistema().tiempoAgotado()){
            getVentanaInicial().avisarVidas(true);
            getFrog().reiniciarPosX(4);
            getFrog().reiniciarPosY(12); 
            getSistema().setTiempoRestante(40);
        }
        lugar = getSistema().verificarPosAgua();
        if(lugar!=1){
            if(lugar==3){
                getFrog().reiniciarPosX(4);
                getFrog().reiniciarPosY(12); 
                getSistema().setTiempoRestante(40);
                getVentanaInicial().avisarVidas(true);
            }else{
                if(lugar==2){
                    
                }else{
                    if((lugar==4)||(lugar==0))
                        getFrog().moverEnObjeto(true,lugar);
                }
            }
        }else{
            getFrog().moverEnObjeto(true,lugar);
        }
        if(getVentanaInicial().getContadorVidas()<0){//ACA SE VALIDA CUANDO YA NO HAY MAS VIDAS Y EL JUEGO ACABA
            setEstaVivo(false);
        }
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }
     
    public void iniciar() {
        getVentanaInicial().setVisible(true);
        getCarro1().start();
        esperar(4);
        getCarro2().start();
        esperar(4);
        getCarro3().start();
        esperar(4);
        getCarro4().start();
        esperar(4);
        getTronco1().start();
        esperar(4);
        getTronco2().start();
        esperar(4);
        getTronco3().start();
        esperar(4);
        getTortuga1().start();
        esperar(4);
        getTortuga2().start();
        esperar(4);
        getSistema().start();
        esperar(4);
        getFrog().start();
        esperar(4);
        getHiloDibujo().start();
    }
    
    @Override
    public void run() {
        while(estaVivo){
            dibujar();
            enviarTiempoRestante();
            enviarPosiciones();
            perderVidas();
        }
    }
    
    public void enviarPosiciones(){//ENVIA POSICIONES DE LOS OBJETOS AL SISTEMA

        getSistema().posicionCarro1(getCarro1().getPosX(),getCarro1().getPosY());
        getSistema().posicionCarro2(getCarro2().getPosX(),getCarro2().getPosY());
        getSistema().posicionCarro3(getCarro3().getPosX(),getCarro3().getPosY());
        getSistema().posicionCarro4(getCarro4().getPosX(),getCarro4().getPosY());
        getSistema().posicionSapo(getFrog().getPosX(),getFrog().getPosXPix(),getFrog().getPosY());
        
        getSistema().posicionTronco1(getTronco1().getPosX(),getTronco1().getPosXPix(),getTronco1().getPosY());
        getSistema().posicionTronco2(getTronco2().getPosX(),getTronco2().getPosXPix(),getTronco2().getPosY());
        getSistema().posicionTronco3(getTronco3().getPosX(),getTronco3().getPosXPix(),getTronco3().getPosY());
        
        getSistema().posicionTortuga1(getTortuga1().getPosX(),getTortuga1().getPosXPix(),getTortuga1().getPosY());
        getSistema().posicionTortuga2(getTortuga2().getPosX(),getTortuga2().getPosXPix(),getTortuga2().getPosY());
        esperar(1);
    }
    
    public void enviarTiempoRestante(){//ENVIA EL TIEMPO RESTANTE DEL SISTEMA A LA VISTA
        getVentanaInicial().mostrarTiempoRestante(getSistema().getTiempoRestante());
    }
    
    public Thread getHiloDibujo() {
        if(hiloDibujo == null){
            hiloDibujo = new Thread(this);
        }
        return hiloDibujo;
    }
    private void esperar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
    public Frog getFrog() {
        if(sapo == null){
            sapo = new Frog();
        }
        return sapo;
    }
    public Mapa getMapa() {
        if(mapa == null){
            mapa = new Mapa();
        }
        return mapa;
    }
    public Tronco getTronco1() {
        if(tronco1 == null){
            tronco1 = new Tronco();
            tronco1.elegirDireccion(1);
            tronco1.setPosX(-1);
            tronco1.setPosY(2);
        }
        return tronco1;
    }
    public Tronco getTronco2() {
        if(tronco2 == null){
            tronco2 = new Tronco();
            tronco2.elegirDireccion(1);
            tronco2.setPosX(0);
            tronco2.setPosY(6);
        }
        return tronco2;
    }
    public Tronco getTronco3() {
        if(tronco3 == null){
            tronco3 = new Tronco();
            tronco3.elegirDireccion(1);
            tronco3.setPosX(3);
            tronco3.setPosY(4);
        }
        return tronco3;
    }
   
    public Carro getCarro1() {
        if(carro1 == null){
            carro1 = new Carro();
            carro1.elegirDireccion(1);
            carro1.setPosX(0);
            carro1.setPosY(11);
        }
        return carro1;
    }
    public Carro getCarro2() {
        if(carro2 == null){
            carro2 = new Carro();
            carro2.elegirDireccion(-1);
            carro2.setPosX(5);
            carro2.setPosY(10);
        }
        return carro2;
    }
    
    public Carro getCarro3(){
        if(carro3 == null){
            carro3 = new Carro();
            carro3.elegirDireccion(1);
            carro3.setPosX(6);
            carro3.setPosY(9);
        }
        return carro3;
    }
    
    public Carro getCarro4(){
        if(carro4 == null){
            carro4 = new Carro();
            carro4.elegirDireccion(-1);
            carro4.setPosX(1);
            carro4.setPosY(8);
        }
        return carro4;
    }
    public Tortuga getTortuga1(){
        if(tortuga1 == null){
            tortuga1 = new Tortuga();
            tortuga1.setPosX(8);
            tortuga1.setPosY(3);
        }
        return tortuga1;
    }
    public Tortuga getTortuga2(){
        if(tortuga2 == null){
            tortuga2 = new Tortuga();
            tortuga2.setPosX(5);
            tortuga2.setPosY(5);
        }
        return tortuga2;
    }

    public Sistema getSistema() {
        if(sistema == null){
            sistema = new Sistema();
        }
        return sistema;
    }

    public void dibujar(){//AQUI SE DIBUJAN TODOS LOS OBJETOS DEL JUEGO
        Graphics lapizPrincipal = lienzo.getGraphics();
        Graphics lapiz = dobleBuffer.getGraphics();
        dibujarMapa(lapiz);
        dibujarCarro(lapiz);
        dibujarTronco(lapiz);
        dibujarTortuga(lapiz);
        dibujarSapo(lapiz);
        dibujarPosGanada(lapiz);
        lapizPrincipal.drawImage(dobleBuffer, 0, 0, lienzo); 
    }
    public void dibujarSapo(Graphics lapiz){//METODO PARA DIBUJAR SAPO
        int x, y;
        y = getFrog().getPosY();
        if(lugar!=1){
            x=getFrog().getPosXPix();
            lapiz.drawImage(getFrog().getImgSapo(), x, y*30, lienzo);
        }else{
            x = getFrog().getPosX();
            lapiz.drawImage(getFrog().getImgSapo(), (x*30), y*30, lienzo);
        }
        
    }
    public void dibujarMapa(Graphics lapiz){//METODO QUE DIBUJA EL MAPA
        lapiz.drawImage(getMapa().getImgFondoMapa(),getMapa().getPosX(), getMapa().getPosY(), lienzo);
    }
    
    public void dibujarCarro(Graphics lapiz){// METODO QUE DIBUJA TODOS LOS CARROS
        int x,y;
        x=getCarro1().getPosXPix();
        y=getCarro1().getPosY();
        lapiz.drawImage(getCarro1().getImgCarro(1),x-30, y*30, lienzo);
        x=getCarro2().getPosXPix();
        y=getCarro2().getPosY();
        lapiz.drawImage(getCarro2().getImgCarro(-1),x, y*30, lienzo);
        x=getCarro3().getPosXPix();
        y=getCarro3().getPosY();
        lapiz.drawImage(getCarro3().getImgCarro(1),x-30, y*30, lienzo);
        x=getCarro4().getPosXPix();
        y=getCarro4().getPosY();
        lapiz.drawImage(getCarro4().getImgCarro(-1),x, y*30, lienzo);
    }
    public void dibujarTronco(Graphics lapiz){//METODO QUE DIBUJA LOS TRONCOS
        int x,y;
        x=getTronco1().getPosXPix();
        y=getTronco1().getPosY();
        lapiz.drawImage(getTronco1().getImgTronco(),x, y*30, lienzo);
        x=getTronco2().getPosXPix();
        y=getTronco2().getPosY();
        lapiz.drawImage(getTronco2().getImgTronco(),x, y*30, lienzo);
        x=getTronco3().getPosXPix();
        y=getTronco3().getPosY();
        lapiz.drawImage(getTronco3().getImgTronco(),x, y*30, lienzo);
    }
    
    public void dibujarTortuga(Graphics lapiz){//METODO QUE DIBUJA LAS TORTUGAS
        int x,y;
        x=getTortuga1().getPosXPix();
        y=getTortuga1().getPosY();
        lapiz.drawImage(getTortuga1().getImgTortuga(),x, y*30, lienzo);
        x=getTortuga2().getPosXPix();
        y=getTortuga2().getPosY();
        lapiz.drawImage(getTortuga2().getImgTortuga(),x, y*30, lienzo);
    }
    public void dibujarPosGanada(Graphics lapiz) {
        
        if(lugar==2){
            if(banderas[getFrog().getPosX()][0] != 1){
                banderas[getFrog().getPosX()][0] = 1;
                int x;
                if( (getFrog().getPosX()%2) == 0){
                    x = getFrog().getPosX()+1;
                }else{
                    x = getFrog().getPosX();
                }
                banderas[getFrog().getPosX()][1] =x;
                getFrog().reiniciarPosX(4);
                getFrog().reiniciarPosY(12); 
                getSistema().setTiempoRestante(40);
            }else{
                getVentanaInicial().avisarVidas(true);
                getFrog().reiniciarPosX(4);
                getFrog().reiniciarPosY(12); 
                getSistema().setTiempoRestante(40);
            }
        }
        for(int i =0; i<9;i++){
            if(banderas[i][0] == 1)
                lapiz.drawImage(getFrog().getImgPosGanada(),banderas[i][1]*30, 30, lienzo);
            if(banderas[i][0]%2>0){
                contadorBanderas++;
                if(contadorBanderas==4){
                    getVentanaInicial().victoria();
                    setEstaVivo(false);
                }
            }
        }
        contadorBanderas = 0;
    }
    
}

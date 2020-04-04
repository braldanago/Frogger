package logica;


public class Sistema extends Thread{
 
    private int posXSapo, posYSapo,posXCarro1,posYCarro1,posXCarro2,posYCarro2,posXCarro3,posYCarro3,posXCarro4,posYCarro4;
    private int posXTortuga1,posYTortuga1,posXTortuga2,posYTortuga2;
    private int posXTronco1,posYTronco1,posXTronco2,posYTronco2,posXTronco3,posYTronco3;
    private int tiempoRestante;
    private Frog frog;
    private int posXPixTronco1;
    private int posXPixTronco2;
    private int posXPixTronco3;
    private int posXPixTortuga1;
    private int posXPixTortuga2;
    private int posXPixSapo;
    public Sistema() {
        tiempoRestante =40;
    }
    @Override
    public void run(){
        while(true){
            cronometro();
        }
    }
    
    public void cronometro(){//CRONOMETRO DE CUENTA REGRESIVA DE 1 SEGUNDO
        tiempoRestante=tiempoRestante-1;
        esperar(1000);
    }
    
    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {//AQUI SE MODIFICA EL TIEMPO RESTANTE
        this.tiempoRestante = tiempoRestante;
    }
    
    
    public boolean tiempoAgotado(){//EL METODO INDICA CUANDO EL TIEMPO YA SE ACABO
        if(tiempoRestante<=0){
            return true;
        }else{
            return false;
        }
    }
            
    private void esperar(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
  
    public void posicionSapo(int x, int xPix, int y){
        posXSapo=x;
        posXPixSapo=xPix;
        posYSapo=y;
    }
    
    public void posicionCarro1(int x,int y){
        posXCarro1=x;
        posYCarro1=y;
        verificarColision();
    }
    public void posicionCarro2(int x,int y){
        posXCarro2=x;
        posYCarro2=y;
        verificarColision();
    }
    public void posicionCarro3(int x,int y){
        posXCarro3=x;
        posYCarro3=y;
        verificarColision();
    }
    public void posicionCarro4(int x,int y){
        posXCarro4=x;
        posYCarro4=y;
        verificarColision();
    }
    public boolean verificarColision(){//SE VERIFICA CUANDO UN CARRO ATROPELLA AL SAPO
        if(posXSapo==posXCarro1 && posYSapo == posYCarro1){
            return true;//SE RETORNA TRUE AL VALIDAR QUE SI HUBO COLISION
        }else{
            if(posXSapo==posXCarro2 && posYSapo == posYCarro2){
                return true;
            }else{
                if(posXSapo==posXCarro3 && posYSapo == posYCarro3){
                    return true;
                }else{
                    if(posXSapo==posXCarro4 && posYSapo == posYCarro4){
                        return true;
                    }else{
                        return false;
                    }
                }      
            }
        }
    }
    public void posicionTronco1(int x, int xPix, int y){
        posXTronco1=x;
        posXPixTronco1=xPix;
        posYTronco1=y;
    }
    public void posicionTronco2(int x, int xPix, int y){
        posXTronco2=x;
        posXPixTronco2=xPix;
        posYTronco2=y;
    }
    public void posicionTronco3(int x, int xPix, int y){
        posXTronco3=x;
        posXPixTronco3=xPix;
        posYTronco3=y;
    }
    public void posicionTortuga1(int x, int xPix, int y){
        posXTortuga1=x;
        posXPixTortuga1=xPix;
        posYTortuga1=y;
    }
    public void posicionTortuga2(int x, int xPix, int y){
        posXTortuga2=x;
        posXPixTortuga2=xPix;
        posYTortuga2=y;
    }
    public int verificarPosAgua(){//VERIFICA POSICIONES EN EL AGUA
        if(posYSapo<=6 && posYSapo >= 1){
            if((posYSapo == 1)){
                posXPixSapo=posXPixSapo+15;
                if((posXPixSapo>=30)&&(60>=posXPixSapo)){
                    return 2;
                }
                if((posXPixSapo>=90)&&(120>=posXPixSapo)){
                    return 2;
                }
                if((posXPixSapo>=150)&&(180>=posXPixSapo)){
                    return 2;   
                }
                if((posXPixSapo>=210)&&(240>=posXPixSapo)){
                    return 2;
                }
                return 3;
            }
            if((posYSapo == posYTronco1) && ((posXPixSapo+15>=posXPixTronco1)&&(posXPixSapo-15 <= posXPixTronco1+60))&&(posXPixSapo<270)){
                return 0; //Si esta en la tortuga o tronco
            }else{
                if((posYSapo == posYTronco2) && ((posXPixSapo+15 >= posXPixTronco2)&&(posXPixSapo-15 <= posXPixTronco2+60))&&(posXPixSapo<270)){
                    return 0; //Si esta en la tortuga o tronco
                }else{
                    if((posYSapo == posYTronco3) && ((posXPixSapo+15 >= posXPixTronco3)&&(posXPixSapo-15 <= posXPixTronco3+60))&&(posXPixSapo<270)){
                        return 0; //Si esta en la tortuga o tronco
                    }else{
                        if((posYSapo == posYTortuga1) && ((posXPixSapo+15 >= posXPixTortuga1)&&(posXPixSapo <= posXPixTortuga1+120))&&(posXPixSapo-15>0)){
                            return 4; //Si esta en la tortuga o tronco
                        }else{
                            if((posYSapo == posYTortuga2)&& ((posXPixSapo+15 >= posXPixTortuga2)&&((posXPixSapo <= posXPixTortuga2+120)))&&(posXPixSapo-15>0)){
                                return 4; //Si esta en la tortuga o tronco
                            }else{
                                return 3; //Si esta fuera del tronco pero dentro del rango
                            }
                        }
                    }      
                }
            }
        }else{
            return 1; //Esta fuera del rango de agua
        }
        
    }
    
    public Frog getFrog(){
        if(frog == null){
            frog  = new Frog();
        }
        return frog;
    }
}

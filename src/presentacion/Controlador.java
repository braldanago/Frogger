
package presentacion;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlador implements KeyListener {
    private final Vista ventana;
    
    public Controlador(Vista aThis) {
        ventana = aThis;        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            ventana.getModelo().getFrog().direccionSapo(0);
            ventana.getModelo().getFrog().setPosY(-1);
        }else{
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                ventana.getModelo().getFrog().direccionSapo(2);
                ventana.getModelo().getFrog().setPosY(1);
            }else{
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    ventana.getModelo().getFrog().direccionSapo(3);
                    ventana.getModelo().getFrog().setPosX(-1);
                    
                }else{
                    if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                        ventana.getModelo().getFrog().direccionSapo(1);
                        ventana.getModelo().getFrog().setPosX(1);
                    }
                }
            } 
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
  
    
}

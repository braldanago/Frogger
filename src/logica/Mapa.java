
package logica;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Invitado
 */
public class Mapa {
    private int posX, posY;
    private Image[] imgMapa;

    public Mapa() {
        imgMapa = new Image[1];
        imgMapa[0] = new ImageIcon(getClass().getResource("/imagenes/FondoMapa.PNG")).getImage();
        posX = 0;
        posY = 0;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    public Image getImgFondoMapa() {        
        return imgMapa[0];
    }
   
}

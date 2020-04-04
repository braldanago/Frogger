
import presentacion.Modelo;

public class Launcher {

    private Modelo modelo;
    
    public Launcher(){
        modelo = new Modelo();
        modelo.iniciar();  
        
    }
    
    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        
    }
}

package controlador;
import javax.swing.JFrame;
import vista.*;


public class Controlador {
    
    //private final Principal princi;
    //private final Hola ver;
    private final InicioSistema system;
//-----------------------   ** -----------------------------------------------
    public Controlador(JFrame padre) {
        this.system = (InicioSistema) padre;
        //this.princi = (Principal) padre;
        
    }
//-----------------------   **  -----------------------------------------------     
    public void iniciar() { 
       // try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //SwingUtilities.updateComponentTreeUI(system);
            this.system.setLocationRelativeTo(null);
            this.system.setTitle("Control de Motocicletas");
            this.system.setVisible(true);   
        /*} catch( UnsupportedLookAndFeelException | ClassNotFoundException
                | InstantiationException | IllegalAccessException ex) {  }*/
    }
    
}
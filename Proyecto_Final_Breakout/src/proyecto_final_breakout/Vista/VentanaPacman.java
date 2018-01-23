/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import com.panamahitek.ArduinoException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import proyecto_final_breakout.Vista.PanelPacman;

/**
 *
 * @author EstebanRM
 */
public class VentanaPacman extends JFrame implements WindowListener{
    private PanelPacman panelPacman=new PanelPacman();

    public VentanaPacman() {
        super("Pacman");
        this.setSize(500,500);
        this.setResizable(false);
        this.add(this.panelPacman);
        this.setLocationRelativeTo(null);
        this.addWindowListener(this);
        this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            this.panelPacman.getH().getArduino().killArduinoConnection();
            this.panelPacman.getCancionPacman().close();
        this.panelPacman.getWin().close();
        this.panelPacman.getLose().close();
        this.panelPacman.getJump().close();
        this.panelPacman.getBloque().close();
        } catch (ArduinoException ex) {
            Logger.getLogger(VentanaPacman.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}

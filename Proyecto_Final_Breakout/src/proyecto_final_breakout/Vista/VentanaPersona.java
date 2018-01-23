/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import proyecto_final_breakout.Controlador.GestionDato;

/**
 *
 * @author Asus
 */
public class VentanaPersona extends JFrame implements WindowListener {
    
    private PanelPersona panelP;

    public VentanaPersona(int puntos, String nivel,GestionDato gD) {
        super("REGISTRO");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.panelP = new PanelPersona(puntos,nivel,gD);
        this.add(this.panelP);
        this.setVisible(true);
        this.addWindowListener(this);
        //this.setResizable(false);
    }

    public PanelPersona getPanelP() {
        return panelP;
    }

    public void setPanelP(PanelPersona panelP) {
        this.panelP = panelP;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import com.panamahitek.ArduinoException;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
class VentanaMario extends JFrame implements WindowListener {
    
    private PanelMario panelM;

    public VentanaMario(){
        
        super("Breackout");
        this.setSize(500,500);
        this.panelM=new PanelMario();
        this.setResizable(false);
        this.setVisible(true);
        this.add(this.panelM);
        this.setLocationRelativeTo(null);
        this.addWindowListener(this);
        
    }
    
    
    @Override
    public void windowClosing(WindowEvent e) {
        
        try {
            this.panelM.getH().getArduino().killArduinoConnection();
            this.panelM.getJump().close();
            this.panelM.getMoneda().close();
            this.panelM.getWin().close();
            this.panelM.getLose().stop();
            this.panelM.getWin().stop();
            this.panelM.getJump().stop();
            this.panelM.getMoneda().stop();
            this.panelM.getCancionMario().stop();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (ArduinoException ex) {
            //Logger.getLogger(VentanaMario.class.getName()).log(Level.SEVERE, null, ex);
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

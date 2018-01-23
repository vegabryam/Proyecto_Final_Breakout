/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import com.panamahitek.ArduinoException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import proyecto_final_breakout.Controlador.HiloJoker;

/**
 *
 * @author Asus
 */
public class VentanaJoker extends JFrame implements WindowListener{
    
    private PanelJoker panelInicial=new PanelJoker();
    private Clip cancionJoker;
    
    public VentanaJoker(){
        super("Breackout");
        this.setSize(500,500);
        this.setResizable(false);
        this.add(this.panelInicial);
        this.setLocationRelativeTo(null);
        
        this.addWindowListener(this);
        this.setVisible(true);

    }

    public PanelJoker getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(PanelJoker panelInicial) {
        this.panelInicial = panelInicial;
    }

    public Clip getCancionJoker() {
        return cancionJoker;
    }

    public void setCancionJoker(Clip cancionJoker) {
        this.cancionJoker = cancionJoker;
    }
    
    

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("hola1");
            
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            this.panelInicial.getH().getArduino().killArduinoConnection();
        } catch (ArduinoException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.panelInicial.getRebotaJoker().close();
        this.panelInicial.getCancionJoker().stop();
        this.panelInicial.getPerderJoker().stop();
        this.panelInicial.getGanarJoker().stop();
        this.panelInicial.getRebotaJoker().stop();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}

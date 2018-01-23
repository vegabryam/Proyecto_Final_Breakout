/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import proyecto_final_breakout.Vista.PanelWindows10;
import proyecto_final_breakout.Vista.PanelWindowsXP;
import proyecto_final_breakout.Vista.VentanaWindowsXP;
import proyecto_final_breakout.Vista.VentanasWindows10;

/**
 *
 * @author Asus
 */
public class HiloVentanaWindowsXP extends Thread {
    
    private Clip cancionInicio;
    
    public void crearVentana(){
        
        VentanaWindowsXP v1 = new VentanaWindowsXP(new PanelWindowsXP());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloVentanaWindowsXP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                this.cancionInicio = AudioSystem.getClip();
                this.cancionInicio.open(AudioSystem.getAudioInputStream(getClass().getResource("sonidowin.wav")));
                this.cancionInicio.start();
               
        } catch (Exception ex) {
                Logger.getLogger(HiloVentanaWindowsXP.class.getName()).log(Level.SEVERE, null, ex);
        }
        v1.dispose();
        
       
        PanelWindows10 panel = new PanelWindows10();
        VentanasWindows10 v2 = new VentanasWindows10(panel);
        
    }

    @Override
    public void run() {
        super.run();
        this.crearVentana();
    }
    
    
    
      
}

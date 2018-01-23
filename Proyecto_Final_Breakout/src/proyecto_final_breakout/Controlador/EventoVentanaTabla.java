/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyecto_final_breakout.Vista.PanelWindows10;
import proyecto_final_breakout.Vista.VentanaTabla;

/**
 *
 * @author Asus
 */
public class EventoVentanaTabla implements ActionListener {

    private PanelWindows10 panelW; 

    public EventoVentanaTabla(PanelWindows10 panelW) {
        this.panelW = panelW;
    }

    public PanelWindows10 getPanelW() {
        return panelW;
    }

    public void setPanelW(PanelWindows10 panelW) {
        this.panelW = panelW;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        VentanaTabla v=new VentanaTabla();
    
    }
    
}

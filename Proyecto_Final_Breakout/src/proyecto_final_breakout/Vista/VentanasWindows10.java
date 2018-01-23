/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class VentanasWindows10 extends JFrame {
    
    private PanelWindows10 panelW10;

    public VentanasWindows10(PanelWindows10 panelW10) {
        this.setTitle("Ventana Inicial");
        this.setSize(1000, 590);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.panelW10 = panelW10;
        this.add(panelW10);
        this.setVisible(true);
        this.setResizable(false);
        
    }

    public PanelWindows10 getPanelW10() {
        return panelW10;
    }

    public void setPanelW10(PanelWindows10 panelW10) {
        this.panelW10 = panelW10;
    }
    
    
    
    
    
}

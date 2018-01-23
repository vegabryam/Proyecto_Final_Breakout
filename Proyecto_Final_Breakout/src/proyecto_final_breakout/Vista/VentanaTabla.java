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
public class VentanaTabla extends JFrame {
    
    private PanelTabla panelT;

    public VentanaTabla() {
    
        super("REGISTRO");
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.panelT = new PanelTabla();
        this.add(this.panelT);
        this.setVisible(true);
        
    }
    
    
}

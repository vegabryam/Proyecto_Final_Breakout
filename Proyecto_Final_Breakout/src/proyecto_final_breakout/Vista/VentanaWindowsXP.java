/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class VentanaWindowsXP extends JFrame {
    
    private JLabel fondo;
    private PanelWindowsXP panelW;

    public VentanaWindowsXP(PanelWindowsXP panelW) {
        
       this.setTitle("Iniciando WindowsBreakOut");
       this.setSize(1000,590);
       this.setDefaultCloseOperation(3);
       this.setResizable(false);
       this.panelW = panelW;
       this.add(panelW);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }

    public JLabel getFondo() {
        return fondo;
    }

    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    public PanelWindowsXP getPanelW() {
        return panelW;
    }

    public void setPanelW(PanelWindowsXP panelW) {
        this.panelW = panelW;
    }
    
    
    
    
    
}

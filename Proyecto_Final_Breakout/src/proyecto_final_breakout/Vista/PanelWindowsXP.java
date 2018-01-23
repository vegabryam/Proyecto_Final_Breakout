/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class PanelWindowsXP extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        ImageIcon img = new ImageIcon(getClass().getResource("windows.gif"));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
        this.setOpaque(false);
    }
    
    
    
}

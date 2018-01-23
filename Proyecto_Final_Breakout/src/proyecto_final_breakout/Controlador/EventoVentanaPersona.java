/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyecto_final_breakout.Modelo.Persona;
import proyecto_final_breakout.Vista.PanelPersona;

/**
 *
 * @author Asus
 */
public class EventoVentanaPersona implements ActionListener{

    private PanelPersona p;

    public EventoVentanaPersona(PanelPersona p) {
        this.p = p;
    }

    public PanelPersona getP() {
        return p;
    }

    public void setP(PanelPersona p) {
        this.p = p;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int id=Integer.parseInt(this.p.getTxtList().get(0).getText());
        String nombre=this.p.getTxtList().get(1).getText();
        String apellido=this.p.getTxtList().get(2).getText();
        int edad=Integer.parseInt(this.p.getTxtList().get(3).getText());
        int puntos=this.p.getPuntos();
        String nivel=this.p.getNivel();
        
        this.p.getgD().persistirPersona(new Persona(id,nombre,apellido,edad,puntos,nivel));
        JOptionPane.showMessageDialog(null,"USUARIO REGISTRADO","EXITO",JOptionPane.DEFAULT_OPTION);
    }
    
}

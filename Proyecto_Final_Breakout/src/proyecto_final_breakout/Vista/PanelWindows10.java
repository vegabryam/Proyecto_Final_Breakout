/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyecto_final_breakout.Controlador.EventoVentanaTabla;

/**
 *
 * @author Asus
 */
public class PanelWindows10 extends JPanel {
    
    private JLabel breakout,mario,pacman,joker,ups;
    private JButton tabla;

    public PanelWindows10() {
        this.iniciaComponente();
    }

    public JButton getTabla() {
        return tabla;
    }

    public void setTabla(JButton tabla) {
        this.tabla = tabla;
    }
    
    

    public JLabel getBreakout() {
        return breakout;
    }

    public void setBreakout(JLabel breakout) {
        this.breakout = breakout;
    }

    public JLabel getMario() {
        return mario;
    }

    public void setMario(JLabel mario) {
        this.mario = mario;
    }

    public JLabel getPacman() {
        return pacman;
    }

    public void setPacman(JLabel pacman) {
        this.pacman = pacman;
    }

    public JLabel getJoker() {
        return joker;
    }

    public void setJoker(JLabel joker) {
        this.joker = joker;
    }

    public JLabel getUps() {
        return ups;
    }

    public void setUps(JLabel ups) {
        this.ups = ups;
    }
    
    
    
    public void iniciaComponente(){
        
        //inicia Label y boton
        
        this.tabla=new JButton(" RANKING DE PARTICIPANTES ");
        this.tabla.setFont(new Font("Aquaduct",Font.BOLD,20));
        this.tabla.setForeground(Color.WHITE);
        this.tabla.setBorder(BorderFactory.createBevelBorder(0));
        this.tabla.setBackground(new Color(0,191,255));
        
        this.breakout = new JLabel(new ImageIcon(getClass().getResource("break.png")));
        this.mario = new JLabel(new ImageIcon(getClass().getResource("mario.png")));
        this.joker = new JLabel(new ImageIcon(getClass().getResource("joker.png")));
        this.pacman = new JLabel(new ImageIcon(getClass().getResource("Pacman.png")));
        this.ups = new JLabel(new ImageIcon(getClass().getResource("ups.png")));
        
        //Insetar al Panel
        
        this.setLayout(new BorderLayout());
        
        
        
        JPanel panelCentral =new JPanel(new BorderLayout());
        JPanel panelBoton=new JPanel(new FlowLayout());
        JPanel panelNombre=new JPanel(new FlowLayout());
        panelNombre.setBackground(new Color(255,255,255,0));
        panelBoton.setBackground(new Color(255,255,255,0));
        panelCentral.setBackground(new Color(255,255,255,0));
        panelBoton.add(this.tabla);
        JLabel labelNombres=new JLabel("<html><body>Proyecto Realizado por:<br>BRYAM VEGA<br>ANGEL RUIZ<br>ESTEBAN ROSERO<br>RENE PANJON<br>  <br></body></html>");
        labelNombres.setForeground(Color.ORANGE);
        labelNombres.setFont(new Font("Century",Font.BOLD,20));
        panelNombre.add(labelNombres);
        JLabel labelGif=new JLabel();
        labelGif.setSize(100,100);
        ImageIcon imagen=new ImageIcon(getClass().getResource("break.gif"));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelGif.getWidth(),labelGif.getHeight(), Image.SCALE_DEFAULT));
        JLabel labelGif1=new JLabel();
        labelGif1.setSize(100,100);
        ImageIcon imagen1=new ImageIcon(getClass().getResource("break2gif.gif"));
        Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(labelGif1.getWidth(),labelGif1.getHeight(), Image.SCALE_DEFAULT));
        
        labelGif.setIcon(icono);
        labelGif1.setIcon(icono1);
        panelCentral.add(panelNombre,BorderLayout.NORTH);
        panelCentral.add(panelBoton,BorderLayout.CENTER);

        JPanel panelSur=new JPanel(new GridLayout(2,4));
        panelSur.setBackground(new Color(255,255,255,0));
        panelSur.add(this.mario);
        panelSur.add(this.joker);
        panelSur.add(this.pacman);
        panelSur.add(this.ups);
        panelSur.add(new JLabel(""));
        panelSur.add(new JLabel(""));
        panelSur.add(new JLabel(""));
        panelSur.add(new JLabel(""));
        
        JPanel panelSup=new JPanel(new FlowLayout());
        panelSup.setBackground(new Color(255,255,255,0));
        panelSup.add(labelGif1);
        panelSup.add(this.breakout);
        panelSup.add(labelGif);

        
        this.add(panelSup,BorderLayout.NORTH);
        this.add(panelCentral,BorderLayout.CENTER);
        this.add(panelSur,BorderLayout.SOUTH);
        
        this.tabla.addActionListener(new EventoVentanaTabla(this));
        
        this.pacman.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    VentanaPacman v=new VentanaPacman();
                } catch (Exception ex) {
                }
            }
        });
        
        this.joker.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    VentanaJoker v2 = new VentanaJoker();
                } catch (Exception ex) {
                }
            }
        });
        
         this.ups.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    VentanaUPS v3 = new VentanaUPS();
                } catch (Exception ex) {
                }
            }
        });
         
        this.mario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    VentanaMario v4 = new VentanaMario();
                } catch (Exception ex) {
                }
            }
        });  
        
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon(getClass().getResource("windows10.jpg"));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
    }
    
    
    
    
}

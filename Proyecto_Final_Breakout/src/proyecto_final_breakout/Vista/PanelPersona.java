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
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyecto_final_breakout.Controlador.EventoVentanaPersona;
import proyecto_final_breakout.Controlador.GestionDato;

/**
 *
 * @author Asus
 */
public class PanelPersona extends JPanel {
    
    private JPanel panelNorte;
    private JPanel panelCentral;
    private JPanel panelSur;
    private List<JLabel> etiquetaList;
    private List<JTextField> txtList;
    private JButton botonAceptar;
    private int puntos;
    private String nivel;
    private GestionDato gD;

    public PanelPersona(int puntos,String nivel,GestionDato gD) {
        this.puntos=puntos;
        this.nivel=nivel;
        this.gD=gD;
        this.iniciaComponente();
       
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    
    public JPanel getPanelNorte() {
        return panelNorte;
    }

    public void setPanelNorte(JPanel panelNorte) {
        this.panelNorte = panelNorte;
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public void setPanelCentral(JPanel panelCentral) {
        this.panelCentral = panelCentral;
    }

    public JPanel getPanelSur() {
        return panelSur;
    }

    public void setPanelSur(JPanel panelSur) {
        this.panelSur = panelSur;
    }

    public List<JLabel> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<JLabel> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JButton getBotonAceptar() {
        return botonAceptar;
    }

    public void setBotonAceptar(JButton botonAceptar) {
        this.botonAceptar = botonAceptar;
    }
    
    
    
    public void iniciaComponente(){
        this.setLayout(new BorderLayout());
        this.panelNorte=new JPanel(new FlowLayout());
        this.panelSur=new JPanel(new FlowLayout());
        this.panelSur.setBackground(new Color(255,255,255,0));
        this.panelNorte.setBackground(new Color(255,255,255,0));
        this.panelCentral=new JPanel(new GridLayout(4,2));
        this.panelCentral.setBackground(new Color(255,255,255,0));
        this.etiquetaList=new ArrayList<JLabel>();
        this.txtList=new ArrayList<JTextField>();
        
        this.botonAceptar=new JButton("Guadar Datos");
        this.botonAceptar.setFont(new Font("Aquaduct",Font.BOLD,20));
        this.botonAceptar.setForeground(Color.WHITE);
        this.botonAceptar.setBorder(BorderFactory.createBevelBorder(0));
        this.botonAceptar.setBackground(new Color(0,191,255));
        
        this.etiquetaList.add(new JLabel("ID: "));
        this.etiquetaList.add(new JLabel("NOMBRE: "));
        this.etiquetaList.add(new JLabel("APELLIDO: "));
        this.etiquetaList.add(new JLabel("EDAD: "));

        
        this.etiquetaList.get(0).setForeground(Color.WHITE);
        this.etiquetaList.get(1).setForeground(Color.WHITE);
        this.etiquetaList.get(2).setForeground(Color.WHITE);
        this.etiquetaList.get(3).setForeground(Color.WHITE);
        
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        
        this.panelCentral.add(this.etiquetaList.get(0));
        this.panelCentral.add(this.txtList.get(0));
        this.panelCentral.add(this.etiquetaList.get(1));
        this.panelCentral.add(this.txtList.get(1));
        this.panelCentral.add(this.etiquetaList.get(2));
        this.panelCentral.add(this.txtList.get(2));
        this.panelCentral.add(this.etiquetaList.get(3));
        this.panelCentral.add(this.txtList.get(3));
        
        JLabel registro=new JLabel();
        registro.setSize(300,100);
        ImageIcon imagen=new ImageIcon(getClass().getResource("registro.png"));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(registro.getWidth(),registro.getHeight(), Image.SCALE_DEFAULT));
        registro.setIcon(icono);
        
        this.panelNorte.add(registro);
        
        this.panelSur.add(this.botonAceptar);
        
        this.add(this.panelNorte,BorderLayout.NORTH);
        this.add(this.panelCentral,BorderLayout.CENTER);
        this.add(this.panelSur,BorderLayout.SOUTH);
        
        this.botonAceptar.addActionListener(new EventoVentanaPersona(this));
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon(getClass().getResource("windows7.jpg"));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
    }
}

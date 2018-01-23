/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_final_breakout.Controlador.GestionDato;
import proyecto_final_breakout.Modelo.Persona;

/**
 *
 * @author Asus
 */
public class PanelTabla extends JPanel {
    
    private JPanel panelSuperior;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private GestionDato gD=new GestionDato();

    public PanelTabla() {
       this.iniciaComponente();
    }
    
    public void iniciaComponente(){
        
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255,255,255,0));
        
        this.encabezado=new Object[6];
        this.encabezado[0] = "Codigo";
        this.encabezado[1] = "Nombre";
        this.encabezado[2] = "Apellido";
        this.encabezado[3] = "Edad";
        this.encabezado[4]="Nivel";
        this.encabezado[5]="Puntaje";
        
        
        this.panelSuperior=new JPanel(new FlowLayout());
        this.panelSuperior.setBackground(new Color(255,255,255,0));
        
        this.datos=new Object[this.gD.leerPersona().size()][6];
        this.setDatos(this.cargarDatosTabla(this.gD.leerPersona().size(),6));
        this.modeloTabla = new DefaultTableModel(this.datos,this.encabezado);
        this.tabla = new JTable(modeloTabla);
        this.scroll = new JScrollPane(tabla);
        this.scroll.getViewport().setBackground(Color.black);
        
        
        JLabel labelGif=new JLabel();
        labelGif.setSize(300,60);
        ImageIcon imagen=new ImageIcon(getClass().getResource("ranking.png"));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelGif.getWidth(),labelGif.getHeight(), Image.SCALE_DEFAULT));
        labelGif.setIcon(icono);
        this.panelSuperior.add(labelGif);
        
        this.add(this.panelSuperior,BorderLayout.NORTH);
        this.add(this.scroll,BorderLayout.CENTER);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        super.paintComponent(g);
        ImageIcon img = new ImageIcon(getClass().getResource("fondotabla.jpg"));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
    }
    
    

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }
    
    
    
    public Object[][] cargarDatosTabla(int h, int w){
        Object[][] retorno=new Object[h][w];
	int i=0;
	for(Persona e:this.gD.leerPersona()){
            retorno[i][0]=e.getId();
            retorno[i][1]=e.getNombre();
            retorno[i][2]=e.getApellido();
            retorno[i][3]=e.getEdad();
            retorno[i][4]=e.getNivel();
            retorno[i][5]=e.getPuntos();
            i++;
	}
    return retorno;
    }
    
    
}

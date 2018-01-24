/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import proyecto_final_breakout.Controlador.GestionDato;
import proyecto_final_breakout.Controlador.HiloMario;
import proyecto_final_breakout.Controlador.HiloUPS;
import proyecto_final_breakout.Modelo.MapaMario;
import proyecto_final_breakout.Modelo.MapaUPS;

/**
 *
 * @author Asus
 */
public class PanelUPS extends JPanel {
    
    private int posX=10;
    private int posY=425;
    private int bolaposX=10;
    private int bolaposY=400;
    private int boladirX=-1;
    private int boladirY=-2;
    private int puntos=0;
    private int numeroBloques=0;
    private MapaUPS mapaU;
    private HiloUPS h;
    private Clip cancionUPS;
    private int contador=0;
    private GestionDato gD=new GestionDato();

    public PanelUPS() {
     this.mapaU=new MapaUPS(7,16);
     this.numeroBloques=75;
     try {
            this.cancionUPS = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                this.cancionUPS.open(AudioSystem.getAudioInputStream(getClass().getResource("upsmusica.wav")));
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cancionUPS.start();

      h=new HiloUPS(this);
      h.start();
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getBolaposX() {
        return bolaposX;
    }

    public void setBolaposX(int bolaposX) {
        this.bolaposX = bolaposX;
    }

    public int getBolaposY() {
        return bolaposY;
    }

    public void setBolaposY(int bolaposY) {
        this.bolaposY = bolaposY;
    }

    public int getBoladirX() {
        return boladirX;
    }

    public void setBoladirX(int boladirX) {
        this.boladirX = boladirX;
    }

    public int getBoladirY() {
        return boladirY;
    }

    public void setBoladirY(int boladirY) {
        this.boladirY = boladirY;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNumeroBloques() {
        return numeroBloques;
    }

    public void setNumeroBloques(int numeroBloques) {
        this.numeroBloques = numeroBloques;
    }

    public MapaUPS getMapaU() {
        return mapaU;
    }

    public void setMapaU(MapaUPS mapaU) {
        this.mapaU = mapaU;
    }

    public HiloUPS getH() {
        return h;
    }

    public void setH(HiloUPS h) {
        this.h = h;
    }

    public Clip getCancionUPS() {
        return cancionUPS;
    }

    public void setCancionUPS(Clip cancionUPS) {
        this.cancionUPS = cancionUPS;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img=new ImageIcon(getClass().getResource("upsfonjpg.jpg"));
        g.drawImage(img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
        g.setFont(new Font("century",Font.BOLD,15));
        g.setColor(Color.RED);
        g.drawString("Puntos: "+puntos,400, 20);
        this.mapaU.dibujar((Graphics2D)g);
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, 100, 10);
        g.setColor(Color.ORANGE);
        g.fillOval(bolaposX, bolaposY, 20, 20);
        if(this.bolaposY>473){
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"UPS",gD);
              this.contador++;
            }
            this.cancionUPS.stop();
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Usted Perdio",150, 250);
            g.drawString("  Puntos: "+this.puntos,150, 280);
        }
        if(this.numeroBloques==0){
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"UPS",gD);
              this.contador++;
            }
            this.cancionUPS.stop();
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Usted Gano",150, 250);
            g.drawString("  Puntos: "+this.puntos,150, 280);
        }
        this.setOpaque(false);
        super.paintComponent(g);
    }
    
    
}

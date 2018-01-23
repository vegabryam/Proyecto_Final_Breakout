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
import proyecto_final_breakout.Controlador.HiloJoker;
import proyecto_final_breakout.Modelo.MapaGuason;

/**
 *
 * @author Asus
 */
public class PanelJoker extends JPanel {
    
    private int posX=10;
    private int posY=425;
    private int bolaposX=10;
    private int bolaposY=400;
    private int boladirX=-1;
    private int boladirY=-2;
    private int puntos=0;
    private int numeroBloques=0;
    private MapaGuason mapaG;
    private HiloJoker h;
    private int contador=0;
    private Clip cancionJoker,ganarJoker,perderJoker,rebotaJoker;
    private GestionDato gD=new GestionDato();


    public PanelJoker() {
     this.mapaG=new MapaGuason(14,7);
     this.numeroBloques=76;
     try {
            this.cancionJoker = AudioSystem.getClip();
            this.perderJoker = AudioSystem.getClip();
            this.ganarJoker = AudioSystem.getClip();
            this.rebotaJoker = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                this.cancionJoker.open(AudioSystem.getAudioInputStream(getClass().getResource("joker.wav")));
                this.perderJoker.open(AudioSystem.getAudioInputStream(getClass().getResource("PerderJoker.wav")));
                this.ganarJoker.open(AudioSystem.getAudioInputStream(getClass().getResource("GanarJoker.wav")));
                this.rebotaJoker.open(AudioSystem.getAudioInputStream(getClass().getResource("RebotarPaletaJoker.wav")));
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cancionJoker.start();

      h=new HiloJoker(this);
      h.start();
    }

    public HiloJoker getH() {
        return h;
    }

    public void setH(HiloJoker h) {
        this.h = h;
    }
    
    
    public int getNumeroBloques() {
        return numeroBloques;
    }

    public void setNumeroBloques(int numeroBloques) {
        this.numeroBloques = numeroBloques;
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

    public MapaGuason getMapaG() {
        return mapaG;
    }

    public void setMapaG(MapaGuason mapaG) {
        this.mapaG = mapaG;
    }

    public Clip getCancionJoker() {
        return cancionJoker;
    }

    public void setCancionJoker(Clip cancionJoker) {
        this.cancionJoker = cancionJoker;
    }

    public Clip getGanarJoker() {
        return ganarJoker;
    }

    public void setGanarJoker(Clip ganarJoker) {
        this.ganarJoker = ganarJoker;
    }

    public Clip getPerderJoker() {
        return perderJoker;
    }

    public void setPerderJoker(Clip perderJoker) {
        this.perderJoker = perderJoker;
    }

    public Clip getRebotaJoker() {
        return rebotaJoker;
    }

    public void setRebotaJoker(Clip rebotaJoker) {
        this.rebotaJoker = rebotaJoker;
    }
    
    
    
    
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img=new ImageIcon(getClass().getResource("dc.jpg"));
        g.drawImage(img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
        g.setFont(new Font("century",Font.BOLD,15));
        g.setColor(Color.green);
        g.drawString("Puntos: "+puntos,400, 20);
        this.mapaG.dibujar((Graphics2D)g);
        g.setColor(new Color(205,0,0));
        g.fillRect(posX, posY, 100, 10);
        g.setColor(Color.ORANGE);
        g.fillOval(bolaposX, bolaposY, 20, 20);
        if(this.bolaposY>473){
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"Joker",gD);
              this.contador++;
            }
            this.cancionJoker.stop();
            this.perderJoker.start();
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Usted Perdio",150, 250);
            g.drawString("  Puntos: "+this.puntos,150, 280);
        }
        if(this.numeroBloques==0){
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"Joker",gD);
              this.contador++;
            }
            this.cancionJoker.stop();
            this.ganarJoker.start();
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Usted Gano",150, 250);
            g.drawString("  Puntos: "+this.puntos,150, 280);
        }
        this.setOpaque(false);
        super.paintComponent(g);
    }
    
}

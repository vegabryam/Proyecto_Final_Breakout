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
import proyecto_final_breakout.Controlador.HiloMario;
import proyecto_final_breakout.Modelo.MapaMario;

/**
 *
 * @author Asus
 */
public class PanelMario extends JPanel {
    
    private int posX=10;
    private int posY=425;
    private int bolaposX=10;
    private int bolaposY=400;
    private int boladirX=-1;
    private int boladirY=-2;
    private int puntos=0;
    private int numeroBloques=0;
    private MapaMario mapaM;
    private HiloMario h;
    private Clip cancionMario;
    private Clip jump;
    private Clip lose;
    private Clip win;
    private Clip moneda;
    private int contador=0;
    private GestionDato gD=new GestionDato();

    public PanelMario() {
        try {
            this.mapaM=new MapaMario(17,12);
            this.numeroBloques=142;
            this.cancionMario = AudioSystem.getClip();
            this.jump=AudioSystem.getClip();
            this.moneda=AudioSystem.getClip();
            this.lose=AudioSystem.getClip();
            this.win=AudioSystem.getClip();
            this.cancionMario.open(AudioSystem.getAudioInputStream(getClass().getResource("Mario.wav")));
            this.jump.open(AudioSystem.getAudioInputStream(getClass().getResource("jump.wav")));
            this.moneda.open(AudioSystem.getAudioInputStream(getClass().getResource("moneda.wav")));
            this.lose.open(AudioSystem.getAudioInputStream(getClass().getResource("marioLose.wav")));
            this.win.open(AudioSystem.getAudioInputStream(getClass().getResource("marioWin.wav")));
            this.cancionMario.start();
            h=new HiloMario(this);
            h.start();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(PanelMario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(PanelMario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelMario.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }

    

    public Clip getJump() {
        return jump;
    }

    public void setJump(Clip jump) {
        this.jump = jump;
    }

    public Clip getLose() {
        return lose;
    }

    public void setLose(Clip lose) {
        this.lose = lose;
    }

    public Clip getWin() {
        return win;
    }

    public void setWin(Clip win) {
        this.win = win;
    }

    public Clip getMoneda() {
        return moneda;
    }

    public void setMoneda(Clip moneda) {
        this.moneda = moneda;
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

    public MapaMario getMapaM() {
        return mapaM;
    }

    public void setMapaM(MapaMario mapaM) {
        this.mapaM = mapaM;
    }

    public HiloMario getH() {
        return h;
    }

    public void setH(HiloMario h) {
        this.h = h;
    }

    public Clip getCancionMario() {
        return cancionMario;
    }

    public void setCancionMario(Clip cancionMario) {
        this.cancionMario = cancionMario;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img=new ImageIcon(getClass().getResource("mariofon.jpg"));
        g.drawImage(img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
        g.setFont(new Font("century",Font.BOLD,15));
        g.setColor(Color.ORANGE);
        g.drawString("Puntos: "+puntos,400, 20);
        this.mapaM.dibujar((Graphics2D)g);
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, 100, 10);
        g.setColor(Color.WHITE);
        g.fillOval(bolaposX, bolaposY, 20, 20);
        if(this.bolaposY>473){
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"Mario",gD);
              this.contador++;
            }
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Usted Perdio",150, 250);
            g.drawString("  Puntos: "+this.puntos,150, 280);
            this.cancionMario.stop();
            this.lose.start();
        }
        if(this.numeroBloques==0){
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"Mario",gD);
              this.contador++;
            }
            this.cancionMario.stop();
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Usted Gano",150, 250);
            g.drawString("  Puntos: "+this.puntos,150, 280);
            this.win.start();
        }
        this.setOpaque(false);
    }
    
    
    
    
    
}

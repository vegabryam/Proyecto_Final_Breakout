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
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyecto_final_breakout.Controlador.GestionDato;
import proyecto_final_breakout.Controlador.HiloPacman;
import proyecto_final_breakout.Modelo.MapaPacman;
import proyecto_final_breakout.Vista.VentanaJoker;
import proyecto_final_breakout.Vista.VentanaJoker;
import sun.audio.*;

/**
 *
 * @author Asus
 */
public class PanelPacman extends JPanel {

    private int posX = 10;
    private int posY = 430;
    private int bolaposX = 10;
    private int bolaposY = 380;
    private int boladirX = -1;
    private int boladirY = -2;
    private int puntos = 0;
    private int numeroBloques = 0;
    private int xBarra = 100;
    private int yBarra = 10;
    private MapaPacman mapaPacman;
    private Clip cancionPacman;
    private Clip win;
    private Clip lose;
    private Clip jump;
    private Clip bloque;
    private HiloPacman h;
    private int contador=0;
    private GestionDato gD=new GestionDato();

    public PanelPacman() {
        this.mapaPacman = new MapaPacman(14, 8);
        this.numeroBloques = 68;
        System.out.println("si");
        try {
            this.cancionPacman = AudioSystem.getClip();
            this.jump = AudioSystem.getClip();
            this.lose = AudioSystem.getClip();
            this.win = AudioSystem.getClip();
            this.bloque = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                this.cancionPacman.open(AudioSystem.getAudioInputStream(getClass().getResource("pacman.wav")));
                this.jump.open(AudioSystem.getAudioInputStream(getClass().getResource("pacmanrebote.wav")));
                 this.lose.open(AudioSystem.getAudioInputStream(getClass().getResource("pacmanlose.wav")));
                this.win.open(AudioSystem.getAudioInputStream(getClass().getResource("pacmanWin.wav")));
                this.bloque.open(AudioSystem.getAudioInputStream(getClass().getResource("bloque.wav")));
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VentanaJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.h= new HiloPacman(this);
        h.start();
        this.cancionPacman.start();
    }

    public HiloPacman getH() {
        return h;
    }

    public void setH(HiloPacman h) {
        this.h = h;
    }

    
    public MapaPacman getMapaPacman() {
        return mapaPacman;
    }

    public void setMapaPacman(MapaPacman mapaPacman) {
        this.mapaPacman = mapaPacman;
    }

    public int getNumeroBloques() {
        return numeroBloques;
    }

    public void setNumeroBloques(int numeroBloques) {
        this.numeroBloques = numeroBloques;
    }

    public Clip getCancionPacman() {
        return cancionPacman;
    }

    public void setCancionPacman(Clip cancionPacman) {
        this.cancionPacman = cancionPacman;
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

    public int getxBarra() {
        return xBarra;
    }

    public void setxBarra(int xBarra) {
        this.xBarra = xBarra;
    }

    public int getyBarra() {
        return yBarra;
    }

    public void setyBarra(int yBarra) {
        this.yBarra = yBarra;
    }

    public Clip getWin() {
        return win;
    }

    public void setWin(Clip win) {
        this.win = win;
    }

    public Clip getLose() {
        return lose;
    }

    public void setLose(Clip lose) {
        this.lose = lose;
    }

    public Clip getJump() {
        return jump;
    }

    public void setJump(Clip jump) {
        this.jump = jump;
    }

    public Clip getBloque() {
        return bloque;
    }

    public void setBloque(Clip bloque) {
        this.bloque = bloque;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img =new ImageIcon(getClass().getResource("pac.jpg"));
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        g.setFont(new Font("century", Font.BOLD, 15));
        g.setColor(Color.orange);
        g.drawString("Puntos: " + puntos, 380, 25);
        this.mapaPacman.dibujar((Graphics2D) g);
        g.setColor(Color.orange);
        g.fillRect(posX, posY, this.xBarra, this.yBarra);
        g.setColor(Color.red);
        g.fillOval(bolaposX, bolaposY, 20, 20);
        if (this.bolaposY > 473) {
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"Pacman",gD);
              this.contador++;
            }
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Usted Perdio", 150, 200);
            g.drawString("  Puntos: " + this.puntos, 150, 230);
            this.cancionPacman.stop();
            this.lose.start();
        }
        if (this.numeroBloques == 0) {
            if(contador==0){
              VentanaPersona v=new VentanaPersona(this.puntos,"Pacman",gD);
              this.contador++;
            }
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Usted Gano", 150, 200);
            g.drawString("  Puntos: " + this.puntos, 150, 230);
            this.win.start();
        }
        this.setOpaque(false);
        super.paintComponent(g);
    }

}

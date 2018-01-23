/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final_breakout.Modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author EstebanRM
 */
public class MapaPacman {
    private int mapa[][];
    private int bloqueancho;
    private int bloquealto;
    private int[][] arreglo;
    
    public MapaPacman(int fila, int columna) {
        this.mapa =new int[fila][columna];
        this.arreglo = new int[fila][columna];
        
        for (int i = 0; i < this.arreglo.length; i++) {
            for (int j = 0; j < this.arreglo[i].length; j++) {
                this.arreglo[i][j] = 1;
            }
        }
        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[i].length; j++) {
                if((i==0 || i==12 ) && (j>1 && j<5)){
                    this.mapa[i][j] = 2;
                }
                if((i==1 || i==11)&&(j>0 && j<6)){
                     this.mapa[i][j] = 2;
                }
                if((i==2 || i==10)&&(j>0 && j<7)){
                     this.mapa[i][j] = 2;
                }
                if((i==3 || i==9)&&(j>=0 && j<7)){
                     this.mapa[i][j] = 2;
                }
                if((i==4 || i==8)&&(j>=0 && j<6)){
                     this.mapa[i][j] = 2;
                }
                if((i==5 || i==7)&&(j>=0 && j<5)){
                     this.mapa[i][j] = 2;
                }
                if(i==6 && (j>=0 && j<4)){
                     this.mapa[i][j] = 2;
                }
                
            }
        }
        
        
       
        this.bloqueancho=40;
        this.bloquealto=20;
    }
    
    
    

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int[][] mapa) {
        this.mapa = mapa;
    }

    public int getBloqueancho() {
        return bloqueancho;
    }

    public void setBloqueancho(int bloqueancho) {
        this.bloqueancho = bloqueancho;
    }

    public int getBloquealto() {
        return bloquealto;
    }

    public void setBloquealto(int bloquealto) {
        this.bloquealto = bloquealto;
    }
    
    public boolean setBloqueValor(int valor, int fila, int columna) {
        if (this.arreglo[fila][columna] == valor) {
            this.mapa[fila][columna] = 0;
            return true;
        } else {
            this.arreglo[fila][columna] = this.arreglo[fila][columna] + 1;
            return false;
        }

    }
      
     public void dibujar(Graphics2D g){
        
        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[0].length; j++) {
             if (this.mapa[i][j] == 2) {
                    if (this.arreglo[i][j] == 1) {
                        g.setColor(new Color(255,239,63,200));
                    } else if (this.arreglo[i][j] == 2) {
                        g.setColor(new Color(255,239,63,100));
                    } else if (this.arreglo[i][j] == 3) {
                        g.setColor(new Color(255,239,63,50));
                    }
                    g.fillRect(j * this.bloqueancho + 110, i * this.bloquealto + 40, this.bloqueancho, this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(new Color(255,239,63));
                    g.drawRect(j * this.bloqueancho + 110, i * this.bloquealto + 40, this.bloqueancho, this.bloquealto);

                }   
                
            }
        }
        
        
    }
}

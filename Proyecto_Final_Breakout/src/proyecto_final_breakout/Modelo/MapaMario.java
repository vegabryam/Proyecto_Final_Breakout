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
 * @author Asus
 */
public class MapaMario {
    
    private int mapa[][];
    private int bloqueancho;
    private int bloquealto;
    private int[][] arreglo;

    public MapaMario(int fila, int columna) {
        this.arreglo = new int[fila][columna];
        this.mapa = new int[fila][columna];

        for (int i = 0; i < this.arreglo.length; i++) {
            for (int j = 0; j < this.arreglo[i].length; j++) {
                this.arreglo[i][j] = 1;
            }
        }

        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[i].length; j++) {
                if (i == 0 && (j > 2 && j < 8)) {
                    this.mapa[i][j] = 2;
                }
                if (i == 1 && (j > 1 && j < 11)) {
                    this.mapa[i][j] = 2;
                }
                if(i==2 && ((j>1 && j<5) || j==7)){
                    this.mapa[i][j]=3;
                }
                if(i==2 && ((j>4 && j<7) || j==8)){
                    this.mapa[i][j]=4;
                }
                if(i==3 && (j==1 || j==3 || j==7)){
                    this.mapa[i][j]=3;
                }
                if(i==3 && ((j>3 && j<7) || (j>7 && j<11))){
                     this.mapa[i][j]=4;
                }
                if(i==4 && (j==1 || j==3 || j==4 || j==8)){
                    this.mapa[i][j]=3;
                }
                if(i==4 && (j==2 || (j>4 && j<8) || (j>8 && j<12))){
                    this.mapa[i][j]=4;
                }
                if(i==5 && ((j>0 && j<3)||(j>6 && j<12))){
                    this.mapa[i][j]=3;
                }
                if(i==5 && (j>2 && j<7)){
                    this.mapa[i][j]=4;
                }
                if(i==6 && (j>2 && j<10)){
                    this.mapa[i][j]=4;
                }
                if (i == 7 && j == 4) {
                    this.mapa[i][j] = 2;
                }               
                if (i == 7 && ((j>1 && j<4) || (j>4 && j<8))) {
                    this.mapa[i][j] = 5;
                }
                if (i == 8 && ((j>0 && j<4) || (j>7 && j<11))) {
                    this.mapa[i][j] = 5;
                }
                if ((i == 8 || i == 9) && (j == 4 || j == 7)) {
                    this.mapa[i][j] = 2;
                }
                if ((i == 8 || i == 9) && (j == 5 || j == 6)) {
                    this.mapa[i][j] = 5;
                }
                if (i == 9 && ((j>=0 && j<4) || (j>7 && j<12))) {
                    this.mapa[i][j] = 5;
                }
                if (i == 10 && (j > 3 && j < 8)) {
                    this.mapa[i][j] = 2;
                }
                if (i == 10 && ((j >= 0 && j < 2) || (j>9 && j<12))) {
                    this.mapa[i][j] = 4;
                }
                if (i == 10 && ((j>1 && j<4) || (j>7 && j<10))) {
                    this.mapa[i][j] = 5;
                }
                if (i == 11 && (j == 3 || (j > 4 && j < 7) || j == 8)) {
                    this.mapa[i][j] = 2;
                }
                if (i == 11 && ((j >= 0 && j < 3) || (j>8 && j<12))) {
                    this.mapa[i][j] = 4;
                }
                if (i==11 && (j==4 || j==7)) {
                    this.mapa[i][j] = 6;
                }
                if (i == 12 && (j > 1 && j < 10)) {
                    this.mapa[i][j] = 2;
                }
                if (i == 12 && ((j >= 0 && j < 2) || (j>9 && j<12))) {
                    this.mapa[i][j] = 4;
                }
                if (i == 13 && ((j > 1 && j < 5) || (j > 7 && j < 10))) {
                    this.mapa[i][j] = 2;
                }
                if (i == 14 && ((j > 0 && j < 4) || (j > 7 && j < 11))) {
                    this.mapa[i][j] = 7;
                }
                if (i == 15 && ((j >=0 && j < 4) || (j > 7 && j < 12))) {
                    this.mapa[i][j] = 7;
                }
            }
        }

        this.bloqueancho = 38;
        this.bloquealto = 18;
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

    public void dibujar(Graphics2D g) {

        for (int i = 0; i < this.mapa.length; i++) {
            for (int j = 0; j < this.mapa[0].length; j++) {
                if (this.mapa[i][j] == 2) {
                    if (this.arreglo[i][j] == 1) {
                        g.setColor(new Color(255, 30, 23, 200));
                    } else if (this.arreglo[i][j] == 2) {
                        g.setColor(new Color(255, 30, 23, 100));
                    } else if (this.arreglo[i][j] == 3) {
                        g.setColor(new Color(255, 30, 23, 50));
                    }
                    g.fillRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);

                }
                else if (this.mapa[i][j] == 3) {
                    if (this.arreglo[i][j] == 1) {
                        g.setColor(new Color(6,6,6,200));
                    } else if (this.arreglo[i][j] == 2) {
                        g.setColor(new Color(6,6,6,100));
                    } else if (this.arreglo[i][j] == 3) {
                        g.setColor(new Color(6,6,6,50));
                    }
                    g.fillRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);

                }
                else if (this.mapa[i][j] == 4) {
                    if (this.arreglo[i][j] == 1) {
                       g.setColor(new Color(254,161,125,200));
                    } else if (this.arreglo[i][j] == 2) {
                       g.setColor(new Color(254,161,125,100));
                    } else if (this.arreglo[i][j] == 3) {
                      g.setColor(new Color(254,161,125,50));
                    }
                    g.fillRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                   g.setColor(Color.black);
                    g.drawRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);
                }
                
                else if (this.mapa[i][j] == 5) {
                    if (this.arreglo[i][j] == 1) {
                       g.setColor(new Color(0,22,248,200));
                    } else if (this.arreglo[i][j] == 2) {
                       g.setColor(new Color(0,22,248,100));
                    } else if (this.arreglo[i][j] == 3) {
                      g.setColor(new Color(0,22,248,50));
                    }
                    g.fillRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);

                }
                else if (this.mapa[i][j] == 6) {
                    if (this.arreglo[i][j] == 1) {
                       g.setColor(new Color(231,189,16,200));
                    } else if (this.arreglo[i][j] == 2) {
                       g.setColor(new Color(231,189,16,100));
                    } else if (this.arreglo[i][j] == 3) {
                       g.setColor(new Color(231,189,16,50));
                    }
                    g.fillRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);

                }
                else if (this.mapa[i][j] == 7) {
                    if (this.arreglo[i][j] == 1) {
                       g.setColor(new Color(141,110,89,200));
                    } else if (this.arreglo[i][j] == 2) {
                       g.setColor(new Color(141,110,89,100));
                    } else if (this.arreglo[i][j] == 3) {
                       g.setColor(new Color(141,110,89,50));
                    }
                    g.fillRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * this.bloqueancho + 25, i * this.bloquealto + 29, this.bloqueancho, this.bloquealto);

                }

            

            }
        }

    }

    
}

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
public class MapaUPS {
    private int[][] mapa;
    private int bloqueancho;
    private int bloquealto;

    public MapaUPS(int fila, int columna) {
        this.mapa=new int[fila][columna];
        
        for(int i=0; i<this.mapa.length;i++){
            for(int j=0; j<this.mapa[0].length;j++){
                if(i==0){
                    this.mapa[i][j]=1;
                }
                if(i==1 &&(j==0 || j==15)){
                    this.mapa[i][j]=1;
                }else if(i==1 && (j==2||j==5 || j==7 || j==8 || j==9 ||j==11 || j==12 || j==13)){
                    this.mapa[i][j]=2;
                }
                if(i==2 &&(j==0||j==15)){
                    this.mapa[i][j]=1;
                }else if( i==2 && (j==2||j==5 || j==7 || j==9 ||j==11 )){
                    this.mapa[i][j]=2;
                }
                if(i==3 && (j==0 || j==15)){
                    this.mapa[i][j]=1;
                }else if(i==3 &&(j==2||j==5 || j==7 || j==8 || j==9 ||j==11 || j==12 || j==13)){
                    this.mapa[i][j]=2;
                }
                if(i==4 && (j==2||j==5 || j==7 || j==13)){
                    this.mapa[i][j]=2;
                }else if(i==4 && (j==0 || j==15)){
                    this.mapa[i][j]=1;
                }
                if(i==5 && (j==2 || j==3 || j==4 || j==5 || j==7 ||j==11 || j==12 || j==13)){
                    this.mapa[i][j]=2;
                }else if(i==5 &&(j==0||j==15)){
                    this.mapa[i][j]=1;
                }
                if(i==6){
                    this.mapa[i][j]=1;
                }
            }
        }
        
        this.bloqueancho=28;
        this.bloquealto=30;
        
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

    
    public void setBloqueValor(int valor,int fila, int columna){
        this.mapa[fila][columna]=valor;
    }
    
    public void dibujar(Graphics2D g){
        for(int i=0; i<this.mapa.length;i++){
            for(int j=0; j<this.mapa[0].length;j++){
                if(this.mapa[i][j]==1){
                    g.setColor(new Color(0 ,191 ,255,200));
                    g.fillRect(j*this.bloqueancho+20,i*this.bloquealto+35,this.bloqueancho,this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*this.bloqueancho+20,i*this.bloquealto+35,this.bloqueancho,this.bloquealto);
                }else if(this.mapa[i][j]==2){
                    g.setColor(new Color(255,255,0,200));
                    g.fillRect(j*this.bloqueancho+20,i*this.bloquealto+35,this.bloqueancho,this.bloquealto);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*this.bloqueancho+20,i*this.bloquealto+35,this.bloqueancho,this.bloquealto);
                }
            }
        }
    }
    
    
    
}
